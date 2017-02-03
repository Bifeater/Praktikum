package bankkonto;

/** Unsynchronisiertes Konto.
 * Macht Fehler, wenn mehrere Threads gleichzeitig buchen.
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2016-12-03
 */
public class UnsyncedAccount implements Account {
    /** Kontostand. Niemals negativ. */
    private long balance;

    @Override public long getBalance() {
        return balance;
    }

    @Override public void deposit(final long amount) {
        System.out.printf("%s: depositing %d",
                          Thread.currentThread().getName(),
                          amount);
        balance += amount;
        System.out.printf(", balance %d%n", balance);
    }

    @Override public void withdraw(final long amount) {
        if(amount > balance) // Nichts tun, wenn zu wenig Geld auf dem Konto ist
            return;
        System.out.printf("%s: withdraawing %d",
                          Thread.currentThread().getName(),
                          amount);

        balance -= amount;      // Abbuchen
        if(balance < 0) // Sicherstellen, dass das Konto intakt ist
            throw new AssertionError("broken account: " + balance);
        System.out.printf(", balance %d%n", balance);
    }

}

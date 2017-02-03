package bankkonto;

/** Methoden von Account-Klassen.
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2016-12-03
 */
public interface Account {

    /** Betrag einzahlen.
     * @param amount Betrag, der eingezahlt wird. Nicht negativ.
     */
    void deposit(long amount);

    /** Auskunft �ber Kontostand.
     * @return Kontostand. Niemals negativ.
     */
    long getBalance();

    /** Betrag abheben..
     * @param amount Betrag, der abgehoben wird. Nicht negativ.
     * Wenn das Konto zu wenig Geld hat, geschieht nichts.
     */
    void withdraw(long amount);

}

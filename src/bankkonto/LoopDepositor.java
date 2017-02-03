package bankkonto;

/**
 * Created by Philipp on 14.12.2016.
 */
public class LoopDepositor extends Thread {

    private final Account konto;

    public LoopDepositor(Account konto){
        this.konto = konto;
    }

    public void run() {

        synchronized (konto) {
            while (!isInterrupted()) {
                synchronized (konto) {
                    konto.deposit(100);
                }
            }
        }

    }


}

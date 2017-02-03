package bankkonto;

/**
 * Created by Philipp on 14.12.2016.
 */
public class LoopWithDrawer extends Thread {

    Account konto;

    public LoopWithDrawer(Account konto) {
        this.konto = konto;
    }


    public void run() {


        while (!isInterrupted()) {
            synchronized (konto) {
                konto.withdraw(100);
            }
        }

    }


}

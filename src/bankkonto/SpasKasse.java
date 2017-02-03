package bankkonto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philipp on 14.12.2016.
 */
public class SpasKasse {

    public static void main(String[] args) throws InterruptedException {

        Account konto = new UnsyncedAccount();


        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            if(i%2==0) {
                threads.add(new LoopDepositor(konto));
            }
            threads.add( new LoopWithDrawer(konto));
        }

        threads.forEach(Thread::start);
        Thread.sleep(500);
        threads.forEach(Thread::interrupt);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println("ghnsrfg");





    }
}

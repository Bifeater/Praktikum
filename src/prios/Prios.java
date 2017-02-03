package prios;

import java.util.Random;


/**
 * Created by Philipp on 30.11.2016.
 */
public class Prios {
    public static void main(String[] args) {



        int min = new Random().ints(0, 100).distinct().limit(10).peek(System.out::println).min().orElseThrow( AssertionError::new );
        System.out.println("Min = " + min);



    }
}

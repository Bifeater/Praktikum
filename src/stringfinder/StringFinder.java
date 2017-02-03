package stringfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Philipp on 30.11.2016.
 */
public class StringFinder {
    public static void main(String[] args) {

        String gesucht = "bra";
        String bla[] = new String[]{"abra" ,"kada", "bra", "", "sim", "sala", "bim"};
        List<String> spells = Arrays.asList(bla);



        //System.out.println( spells.stream().filter( name -> name.equals(gesucht) ).findAny().orElse(null) );
        String erg = spells.stream().filter( name -> name.equals(gesucht) ).findAny().orElse(null);




        System.out.println(erg);



    }
}

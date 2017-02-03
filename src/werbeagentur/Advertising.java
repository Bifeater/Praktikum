package werbeagentur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Advertising {

    private static Map< Corporation, List<String> > products = new HashMap<>();

    public static void main(String[] args) {

        try( BufferedReader br = new BufferedReader(new FileReader("corporations.txt")) ) {
            System.out.println("gelesen");

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);


                products.put( generateCorporation(line), generateProductList(line) );
                System.out.println("Mapeintrag hinzugefügt");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Corporation generateCorporation(String csv){

        System.out.println("Erzeuge Corporation");
        List<String> parts = Arrays.asList( csv.split(", ") );
        return new Corporation(parts.get(0), parts.get(1));

    }

    private static List<String> generateProductList(String csv){
        System.out.println("Erzeuge Produktliste");
        List<String> parts = Arrays.asList( csv.split(", ") );
        return parts.subList(2, parts.size()-1);
    }





}

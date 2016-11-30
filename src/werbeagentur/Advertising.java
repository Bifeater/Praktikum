package werbeagentur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Philipp on 26.10.2016.
 */
public class Advertising {

    private Map<String, List<String>> companies;

    public static void main(String[] args) {

        FileReader fr = null;
        try( BufferedReader br = new BufferedReader(new FileReader("corporations.txt")) ) {
            //System.out.println("gelesen");

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}

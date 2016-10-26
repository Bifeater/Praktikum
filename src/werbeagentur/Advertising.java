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

    // TODO: 26.10.2016 bla
    private Map<String, List<String>> companies;

    public static void main(String[] args) {

        FileReader fr = null;
        try( BufferedReader br = new BufferedReader(new FileReader("corporations.txt")) ) {

            String line = br.readLine();
            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}

package werbeagentur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AdvertisingStreams {

    private static Map<Corporation, List<String>> products;

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("corporations.txt"));
        products = br.lines()
                .map(line -> line.split(", "))
                .collect(Collectors.toMap(AdvertisingStreams::genCorp, AdvertisingStreams::genProd));
    }

    private static Corporation genCorp(String[] parts) {
        return new Corporation(parts[0], parts[1]);
    }

    private static List<String> genProd(String[] parts) {
        return Stream.of(parts).skip(2).collect(Collectors.toList());
    }


}

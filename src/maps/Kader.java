package maps;

import java.util.*;

/**
 * Created by Philipp on 14.10.2016.
 */
public class Kader{

    private static Map<String, Integer> kader = new TreeMap<>();

    public static void main(String[] args){
        initializeMap();

        //erster versuch:
        //Set<String> keys = kader.keySet();
        //Collection<Integer> values = kader.values();
        //printMap(keys, values);

        //ab hier alles über keyset
        Set<Map.Entry<String, Integer>> spieler = kader.entrySet();
        printByEntry(spieler);

        List<Integer> duplikate = findDuplicate(kader);
        kader.put("Bauer Hans", 16);

        printKeeper(spieler);

        deleteByNumber(3, spieler);
        printByEntry(spieler);

        kader.remove("Sabe");
        printByEntry(spieler);










    }

    private static void initializeMap(){
        kader.put("Bambal Mane", 1);
        kader.put("Sabe", 20);
        kader.put("Ascher Lugge", 3);
        kader.put("Bauer Hans", 4);
        kader.put("Raiffeisen Wast", 4);
        kader.put("Bäda Hans", 5);
    }

    private static void printByEntry(Set<Map.Entry<String, Integer>> entries) {
        System.out.println("Spieler:");
        String namen = "";
        for(Map.Entry<String, Integer> entry: entries){
            namen += entry.getKey();
            namen += ", ";
        }
        System.out.println(namen.substring(0, namen.length()-2));

        System.out.println("Nummern:");
        String nummern = "";
        for(Map.Entry<String, Integer> entry: entries){
            nummern += entry.getValue();
            nummern += ", ";
        }
        System.out.println(   nummern.substring(0, nummern.length()-2)     );

    }

    private static List findDuplicate( Map<String, Integer> kader){

        List<Integer> duplikate = new ArrayList<>();

        Collection<Integer> values = kader.values();
        int highestNumber = Collections.max(values);
        int[] numberArray = new int[highestNumber+1];

        //zähle an stelle der nummer eins hoch
        for(Integer number: values){
            numberArray[number]++;
        }

        //finde indizes wo mehr als 1 spieler sind und füg zur liste hinzu
        for(int i = 0; i < numberArray.length; i++){
            if(numberArray[i] > 1){
                duplikate.add(i);
            }
        }

          return duplikate;
    }

    private static void printKeeper(Set<Map.Entry<String, Integer>> spieler){

        for (Map.Entry<String, Integer> pair: spieler){
            if(pair.getValue() == 1){
                System.out.println("Keeper: " + pair.getKey());
            }
        }

    }

    private static void deleteByNumber(int toDelete, Set<Map.Entry<String, Integer>> spieler){




    }






    /**
     * auch nur in variante 1 gebraucht
     * @param entries Set mit den einzelnen Einträgen der Map
     * @return ArrayList mit den duplikaten als int
     */
    private static ArrayList<Integer> printDuplicate(Collection<Integer> entries){

        //Array on 0 bis höchste Spielernummer
        //an index i steht wie oft die nummer im kader or kommt
        int highestNumber = Collections.max(entries);
        int[] numberArray = new int[highestNumber+1];
        for(Integer number: entries){
            numberArray[number]++;
        }



        //füg duplikate zu Liste hinzu
        ArrayList<Integer> duplikate = new ArrayList<>();
        for(int i = 0; i < numberArray.length; i++){
            if(numberArray[i] > 1){
                duplikate.add(i);
            }
        }

        if(duplikate.size() < 1){
            System.out.println("Keine Duplikate orhanden");
        }
        else{
            String doppelte = "";
            for (int i: duplikate){
                doppelte += i;
                doppelte += ", ";
            }
            doppelte = doppelte.substring(0, doppelte.length()-2);
            System.out.println("Folgende Nummern sind doppelt ergeben: " + doppelte);
        }

        return duplikate;


    }



}

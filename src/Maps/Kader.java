package Maps;

import java.util.*;

/**
 * Created by Philipp on 14.10.2016.
 */
public class Kader{

    private static Map<String, Integer> kader = new TreeMap<>();

    public static void main(String[] args){
        initializeMap();

        Set<String> keys = kader.keySet();
        Collection<Integer> values = kader.values();

        printMap(keys, values);

        ArrayList<Integer> duplikate = printDuplicate(values);

        // TODO: 17.10.2016 eintrag ändern 




    }

    private static void printMap(Set<String> keys, Collection<Integer> values){
        String players = "";
        for(String name: keys){
            players += name;
            players += ", ";
        }
        players = players.substring(0, players.length()-2);

        System.out.println("Spielernamen:");
        System.out.println(players);

        String numbers = "";
        for(Integer number: values){
            numbers += number;
            numbers += ", ";
        }
        numbers = numbers.substring(0, numbers.length()-2);

        System.out.println("Nummern:");
        System.out.println(numbers);
    }

    private static void initializeMap(){
        kader.put("Bambal Mane", 1);
        kader.put("Sabe", 20);
        kader.put("Ascher Lugge", 3);
        kader.put("Bauer Hans", 4);
        kader.put("Raiffeisen Wast", 4);
        kader.put("Bäda Hans", 5);
    }

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

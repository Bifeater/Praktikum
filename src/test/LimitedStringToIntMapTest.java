import limited_map.LimitedStringToIntMap;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Philipp on 09.11.2016.
 */
public class LimitedStringToIntMapTest {

    private LimitedStringToIntMap generateFullMap(){
        LimitedStringToIntMap map = new LimitedStringToIntMap(5);
        map.put("eins", 1);
        map.put("zwei", 2);
        map.put("drei", 3);
        map.put("vier", 4);
        map.put("fuenf", 5);

        return map;
    }
    private LimitedStringToIntMap generateEmptyMap(){
        LimitedStringToIntMap map = new LimitedStringToIntMap(5);

        return map;
    }
    private LimitedStringToIntMap generateFilledMap(){
        LimitedStringToIntMap map = new LimitedStringToIntMap(5);
        map.put("eins", 1);
        map.put("zwei", 2);
        map.put("drei", 3);

        return map;
    }
    private String getLastKey(LimitedStringToIntMap map){
        int last = map.getController().size()-1;
        return map.getController().get(last);
    }



    @Test(expected = IllegalArgumentException.class)
    public void constructorGetsIllegalParam(){
        LimitedStringToIntMap map;
        map = new LimitedStringToIntMap(-3);
        map = new LimitedStringToIntMap(0);
    }

    @Test
    public void clearMapIsEmpty(){

        int sizeWanted = 0;
        LimitedStringToIntMap map = generateEmptyMap();

        map.clear();
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
    }

    @Test
    public void clearMapIsFull(){

        int sizeWanted = 0;
        LimitedStringToIntMap map = generateFullMap();

        map.clear();
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
    }

    @Test
    public void clearMapIsFilled(){

        int sizeWanted = 0;
        LimitedStringToIntMap map = generateFilledMap();

        map.clear();
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
    }

    @Test
    public void putMapIsEmpty(){

        LimitedStringToIntMap map = generateEmptyMap();
        int sizeWanted = 1;

        map.put("eins", 1);
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
        assertEquals(getLastKey(map), "eins");
    }

    @Test
    public void putNewElementMapIsFilled(){

        LimitedStringToIntMap map = generateFilledMap();
        int sizeWanted = map.size()+1;

        map.put("dreisig", 30);
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
        assertEquals(getLastKey(map), "dreisig");
    }

    @Test
    public void putOldElementMapIsFilled(){

        LimitedStringToIntMap map = generateFilledMap();
        int sizeWanted = map.size();

        map.put("zwei", 2);
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
        assertEquals(getLastKey(map), "zwei");
    }

    @Test
    public void putNewElementMapIsFull(){

        LimitedStringToIntMap map = generateFullMap();
        int sizeWanted = map.getLimit();

        map.put("dreisig", 30);
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
        assertEquals(getLastKey(map), "dreisig");
    }

    @Test
    public void putOldElementMapIsFull(){

        LimitedStringToIntMap map = generateFullMap();
        int sizeWanted = map.getLimit();

        map.put("zwei", 30);
        int sizeActualMap = map.size();
        int sizeActualController = map.getController().size();

        assertEquals(sizeWanted, sizeActualMap);
        assertEquals(sizeWanted, sizeActualController);
        assertEquals(getLastKey(map), "zwei");
    }

    @Test
    public void getBestCase(){

        LimitedStringToIntMap map = generateFullMap();
        Integer want = new Integer(4);

        Integer i = map.get("vier");

        assertEquals(want, i);
        assertEquals(getLastKey(map), "vier");
    }

    @Test
    public void getNotInMap(){

        LimitedStringToIntMap map = generateFullMap();

        Integer i = map.get("dreisig");

        assertNull(i);
    }

    @Test
    public void removeBestCase(){

        LimitedStringToIntMap map = generateFullMap();
        int wantedSize = map.size()-1;

        int have = map.remove("drei");
        int haveSizeMap = map.size();
        int haveSizeController = map.getController().size();

        assertEquals(have, 3);
        assertEquals(wantedSize, haveSizeMap);
        assertEquals(wantedSize, haveSizeController);


    }










}

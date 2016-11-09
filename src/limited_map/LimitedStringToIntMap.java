package limited_map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Philipp on 26.10.2016.
 */

public class LimitedStringToIntMap extends HashMap<String, Integer> implements LimitedMap {

    //Attribute
    private final int LIMIT;
    private List<String> controller = new LinkedList<>();

    //Konstruktor + Getter
    public LimitedStringToIntMap(int limit){
        if(limit < 1){
            throw new IllegalArgumentException();
        }
        this.LIMIT = limit;
    }
    public List<String> getController() {
        return controller;
    }


    //Methoden
    @Override
    public int getLimit() {
        return LIMIT;
    }

    @Override
    public void clear(){
        super.clear();
        controller.clear();
    }

    @Override
    public Integer put(String key, Integer value){


        if(controller.contains(key)){
            controller.remove(key);
            controller.add(key);
            super.put(key, value);
        }
        else if(controller.size() < LIMIT) {
            super.put(key, value);
            controller.add(key);
        }
        else{
            remove(controller.get(0));
            controller.remove(0);

            put(key, value);
            controller.add(key);
        }

        return value;
    }

    @Override
    public Integer remove(Object key){

        if( key instanceof String ){
            controller.remove(key);
        }

        return super.remove(key);
    }

    @Override
    public Integer get(Object o){


        if(o instanceof String){
            controller.remove(o);
            controller.add( (String)o );
        }

        return super.get(o);
    }

    @Override
    public boolean containsKey(Object key){
        boolean isContained = false;
        if(key instanceof String){
            isContained = super.containsKey(key);
            controller.remove(key);
            controller.add( (String)key );
        }

        return isContained;
    }


}

package limited_map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Philipp on 26.10.2016.
 */

public class LimitedStringToIntMap extends HashMap<String, Integer> implements LimitedMap {

    private final int LIMIT;

    //keys SPeichern in reihenfolge wie hinzugefügt
    private List<String> controller = new LinkedList<>();

    public LimitedStringToIntMap(int limit){
        this.LIMIT = limit;
    }


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
        Integer ka = null;

        if(! (key instanceof String) ){
            return null;
        }

        remove(key);
        controller.remove(key);


        return super.remove(key);
    }

    @Override
    public Integer get(Object o){


        if(o instanceof String){
            controller.remove(o);
            controller.add( (String)o );
        }

        //falls parameter kein string -> exception über super.get()
        return super.get(o);
    }


}

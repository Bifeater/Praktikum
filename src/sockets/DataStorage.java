package sockets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by Philipp on 18.01.2017.
 */
public class DataStorage implements DataStore{

    private Map<String, Map<String, String>> idsToMap = new HashMap<>();

    @Override
    public void clear(String id) throws IOException {

        idsToMap.get(id).clear();
    }

    @Override
    public void deleteEntry(String id, String key) throws IOException {

        idsToMap.get(id).remove(key);
    }

    @Override
    public void deleteMap(String id) throws IOException {

        idsToMap.remove(id);
    }

    @Override
    public String getValue(String id, String key) {

        return idsToMap.get(id).get(key);
    }

    @Override
    public void newMap(String id) throws IOException {

        idsToMap.put( id, new HashMap<String, String>() );
    }

    @Override
    public void putValue(String id, String key, String value) throws IOException {

        idsToMap.get(id).put(key, value);

    }

    @Override
    public void save() throws IOException {

    }
}

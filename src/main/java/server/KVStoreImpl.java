package server;

import api.KVStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KVStoreImpl implements KVStore<String, String> {

    private final Map<String, String> store = new ConcurrentHashMap<>();


    @Override
    public String put(String key, String value) {
        System.err.printf("%s->%s stored%n", key, value);
        return store.put(key, value);
    }

    @Override
    public String delete(String key) {
        System.err.printf("%s removed%n", key);
        return store.remove(key);
    }

    @Override
    public String get(String key) {
        String value = store.get(key);
        System.err.printf("%s fetched: %s %n", key, value);
        return value;
    }
}

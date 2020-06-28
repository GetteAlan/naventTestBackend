package com.navent.backend.pedidos.cache;

import java.util.HashMap;

public class BumexMemcached {
    private static BumexMemcached instance;
    
    private HashMap<String, Object> cacheMock;

    public static BumexMemcached getInstance(){
        if(instance == null){
            instance = new BumexMemcached();
        }
        return instance;
    }

    private BumexMemcached(){
        cacheMock = new HashMap<String, Object>();
    }

    public void set(String key, Object value){
        cacheMock.put(key, value);
    }

    public Object get(String key){
        return cacheMock.get(key);
    }

    public void delete(String key){
        cacheMock.remove(key);
    }
}
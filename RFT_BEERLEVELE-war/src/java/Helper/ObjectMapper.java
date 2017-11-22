/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dnovak
 */
public abstract class ObjectMapper <T> {
    
    
    private Map<Integer,T> map= new HashMap<>();
    
    
    public ObjectMapper(T o) {
        map.put(1, o);
    }

    public ObjectMapper(List<T> objects) {
        for (int i = 0; i<objects.size();i++){
         
            map.put(i, objects.get(i));
        }
    }

    public Map<Integer, T> getMap() {
        return map;
    }
     public T getEntry() {
         
        return map.get(1);
    }
    
}

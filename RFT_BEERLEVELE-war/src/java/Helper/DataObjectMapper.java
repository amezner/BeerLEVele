/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.List;


public class DataObjectMapper<Object> extends ObjectMapper {

    public DataObjectMapper(Object o) {
        super(o);
    }

    public DataObjectMapper(List<Object> objects) {
        super(objects);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author danida
 */
public interface FacadeInterface <T> {
    
    public void create(T t);
    public void remove(T t);
    public void edit(T t);
    
    
}

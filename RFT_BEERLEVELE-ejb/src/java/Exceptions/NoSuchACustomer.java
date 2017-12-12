/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author dnovak
 */
public class NoSuchACustomer extends Exception {

    /**
     * Creates a new instance of <code>NoSuchACustomer</code> without detail
     * message.
     */
    public NoSuchACustomer() {
    }

    /**
     * Constructs an instance of <code>NoSuchACustomer</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchACustomer(String msg) {
        super(msg);
    }
}

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
public class NoSuchAUserException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchAUserException</code> without
     * detail message.
     */
    public NoSuchAUserException() {
    }

    /**
     * Constructs an instance of <code>NoSuchAUserException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchAUserException(String msg) {
        super(msg);
    }
}

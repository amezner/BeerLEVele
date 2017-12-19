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
public class NoSuchATokenException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchATokenException</code> without
     * detail message.
     */
    public NoSuchATokenException() {
    }

    /**
     * Constructs an instance of <code>NoSuchATokenException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchATokenException(String msg) {
        super(msg);
    }
}

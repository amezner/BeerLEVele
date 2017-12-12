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
public class AuthorizationFailedException extends Exception {

    /**
     * Creates a new instance of <code>AuthorizationFailedException</code>
     * without detail message.
     */
    public AuthorizationFailedException() {
    }

    /**
     * Constructs an instance of <code>AuthorizationFailedException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public AuthorizationFailedException(String msg) {
        super(msg);
    }
}

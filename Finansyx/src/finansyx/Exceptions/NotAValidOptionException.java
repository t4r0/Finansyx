/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.Exceptions;

/**
 *
 * @author t4r0
 */
public class NotAValidOptionException extends Exception {

    /**
     * Creates a new instance of <code>NotAValidOptionException</code> without
     * detail message.
     */
    public NotAValidOptionException() {
    }

    /**
     * Constructs an instance of <code>NotAValidOptionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotAValidOptionException(String msg) {
        super(msg);
    }
}

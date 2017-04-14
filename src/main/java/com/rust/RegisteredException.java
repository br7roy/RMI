/*
* Package com.fth 
* FileName: RegistException
* Author:   fth
* Date:     2017/4/11 14:01
*/
package com.rust;

import java.rmi.AccessException;

/**
 * FileName:    RegisteredException
 * Author:      Br7roy
 * Date:        2017/4/11
 * Description:
 */
public class RegisteredException extends AccessException {
    private static final long serialVersionUID = -2068170079332359062L;

    public RegisteredException(String s) {
        super(s);
    }

    public RegisteredException(String s, Exception ex) {
        super(s, ex);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public Throwable getCause() {
        return super.getCause();
    }
}

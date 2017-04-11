/*
* Package com.fth 
* FileName: InvokeException
* Author:   fth
* Date:     2017/4/11 13:48
*/
package com.fth;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * FileName:    InvokeException
 * Author:      Br7roy
 * Date:        2017/4/11
 * Description:
 */
public class InvokeException extends RuntimeException {
    private static final long serialVersionUID = -2038335857672838826L;

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public Throwable getCause() {
        return super.getCause();
    }

    public InvokeException() {
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }

    public InvokeException(String s) {
        super(s);
    }

    public InvokeException(String s, Throwable cause) {
        super(s, cause);
    }

    public InvokeException(Throwable cause) {
        super(cause);
    }

    protected InvokeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

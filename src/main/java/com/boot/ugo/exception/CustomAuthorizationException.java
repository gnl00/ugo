package com.boot.ugo.exception;

/**
 * CustomAuthorizationException
 *
 * @author gnl
 */

public class CustomAuthorizationException extends RuntimeException {

    public CustomAuthorizationException() {
    }

    public CustomAuthorizationException(String message) {
        super(message);
    }
}

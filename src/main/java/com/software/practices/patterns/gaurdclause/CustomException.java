package com.software.practices.patterns.gaurdclause;

/**
 * @author Sagar Kanojia
 */
public class CustomException extends Exception {

    public CustomException(String argumentName) {
        super(argumentName);
    }
}

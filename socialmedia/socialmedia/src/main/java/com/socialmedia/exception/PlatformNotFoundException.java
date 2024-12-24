package com.socialmedia.exception;

public class PlatformNotFoundException extends RuntimeException{
    public PlatformNotFoundException(String message){
        super(message);
    }
}

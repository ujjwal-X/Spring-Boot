package com.socialmedia.exception;

public class CelebrityNotFoundException extends RuntimeException{
    public CelebrityNotFoundException(String message){
        super(message);
    }
}

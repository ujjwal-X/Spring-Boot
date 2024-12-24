package com.socialmedia.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
     super(message);
   }
}

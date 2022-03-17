package jmp.dto;

public class CloudServiceException extends RuntimeException{

    public CloudServiceException(String message) {
        super(message);
    }
}

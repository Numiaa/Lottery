package com.example.nexignlottery.exception;

public class NotEnoughParticipantsException extends Exception {
    public NotEnoughParticipantsException(String errorMessage) {
        super(errorMessage);
    }
}

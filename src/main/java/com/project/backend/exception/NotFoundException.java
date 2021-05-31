package com.project.backend.exception;

import com.project.backend.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}

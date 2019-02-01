package com.horse.racing.input.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OnlineBetTest {

    @Test
    void notImplemented(){
        assertThrows(UnsupportedOperationException.class,
                () -> new OnlineBet("", 0.00, "")
        );
    }
}
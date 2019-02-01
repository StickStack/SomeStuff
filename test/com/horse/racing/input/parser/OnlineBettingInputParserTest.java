package com.horse.racing.input.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlineBettingInputParserTest {

    private OnlineBettingInputParser parser;

    @BeforeEach
    void setUp() {
        parser = OnlineBettingInputParser.getInstance();
    }

    @Test
    void getInstance() {
        assertTrue(parser instanceof OnlineBettingInputParser);
    }

    @Test
    void parseInputForBets() {
        assertThrows(UnsupportedOperationException.class,
                () -> parser.parseInputForBets("")
        );
    }
}
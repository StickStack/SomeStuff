package com.horse.racing.input.parser;

import com.horse.racing.input.dto.Bet;
import com.horse.racing.input.BettingInputParser;

import java.util.List;

public class OnlineBettingInputParser implements BettingInputParser {

    private static final OnlineBettingInputParser INSTANCE = new OnlineBettingInputParser();

    private OnlineBettingInputParser(){

    }

    public static OnlineBettingInputParser getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Bet> parseInputForBets(Object input) {
        throw new UnsupportedOperationException("Online betting is not implemented yet");
    }
}

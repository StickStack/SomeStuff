package com.horse.racing.input;

import com.horse.racing.input.dto.Bet;

import java.io.IOException;
import java.util.List;

public interface BettingInputParser {

    List<Bet> parseInputForBets(Object input)  throws IOException;

}


package com.horse.racing.input.parser;

import com.horse.racing.input.BettingInputParser;
import com.horse.racing.input.dto.Bet;
import com.horse.racing.input.dto.PaperBet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVTextBettingInputParser implements BettingInputParser {
    private static final CSVTextBettingInputParser INSTANCE = new CSVTextBettingInputParser();

    private CSVTextBettingInputParser() {

    }

    @Override
    public List<Bet> parseInputForBets(final Object input) throws IOException {
        if (!(input instanceof String)) {
            throw new IllegalArgumentException("CSVTextBettingInputParser expects an input String of file location to parse");
        }
        final List<Bet> parsedBets = new ArrayList<>();
        String fileLocation = (String) input;
        Path path = Paths.get(fileLocation);

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> parsedBets.add(parseLine(line)));
        }
        return parsedBets;
    }

    private PaperBet parseLine(String line) {
        String[] splitted = line.split(",");
        final String customer = splitted[0];
        final String horse = splitted[1];
        final double amount = Double.valueOf(splitted[2]);

        return new PaperBet(customer, amount, horse);
    }

    public static BettingInputParser getInstance() {
        return INSTANCE;
    }
}

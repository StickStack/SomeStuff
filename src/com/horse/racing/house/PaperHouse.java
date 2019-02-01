package com.horse.racing.house;


import com.horse.racing.input.BettingInputParser;
import com.horse.racing.input.dto.Bet;
import com.horse.racing.input.parser.CSVTextBettingInputParser;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PaperHouse implements House {

    private static PaperHouse INSTANCE = new PaperHouse();

    private PaperHouse() {

    }

    @Override
    public void startGambling(String input) {
        BettingInputParser inputParser = CSVTextBettingInputParser.getInstance();
        final List<Bet> bets;
        try {
            bets = inputParser.parseInputForBets(input);
        } catch (IOException e) {
            System.out.println("Paper house died trying to read bets.");
            //TODO Log Error
            return;
        }

        Map<String, List<Bet>> betsByHorse = bets.stream().collect(Collectors.groupingBy(Bet::getHorse));
        Set<String> horses = betsByHorse.keySet();
        String winningHorse = horses.iterator().next();
        List<Bet> winningBets = betsByHorse.get(winningHorse);
        Bet winningBet = new HashSet<>(winningBets).iterator().next();

        String output = "Winning horse is %s, winner is %s with bet amount of %d and winnings of %s";
        BigDecimal winnings = BigDecimal.valueOf(winningBet.getAmount()).multiply(BigDecimal.ONE.add(BigDecimal.valueOf(winningBet.getTaxPercentage())));
        System.out.println(String.format(
                output,
                winningHorse,
                winningBet.getCustomer(),
                winningBet.getAmount(),
                winnings.toPlainString()));
    }

    public static PaperHouse getInstance() {
        return INSTANCE;
    }
}

package com.horse.racing.input.dto;

public class OnlineBet implements Bet {

    private final String customer;
    private final double amount;
    private final String horse;

    public OnlineBet(String customer, double amount, String horse) {
        this.customer = customer;
        this.amount = amount;
        this.horse = horse;
        throw new UnsupportedOperationException("Online bets are not implement yet.");
    }

    @Override
    public String getCustomer() {
        return customer;
    }

    @Override
    public String getHorse() {
        return horse;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public double getTaxPercentage() {
        return 0.00;
    }
}

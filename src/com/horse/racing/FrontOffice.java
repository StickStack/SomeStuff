package com.horse.racing;


import com.horse.racing.house.PaperHouse;

public class FrontOffice {

    public static void main(String[] args) {
        String inputFileLocation = args[0];
        PaperHouse.getInstance().startGambling(inputFileLocation);
    }
}

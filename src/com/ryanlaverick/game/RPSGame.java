package com.ryanlaverick.game;

import java.util.concurrent.ThreadLocalRandom;

public class RPSGame {
    private RPS generatedResult;
    private GameResult result;

    public RPSGame() {
        this.generatedResult = RPS.values()[ThreadLocalRandom.current().nextInt(RPS.values().length)];
    }

    public RPS getGeneratedResult() {
        return generatedResult;
    }

    public GameResult getResult(String userInput) {
        RPS user = RPS.lookup(userInput);

        if (user.getBeats().equalsIgnoreCase(generatedResult.getLosesTo())) {
            return GameResult.LOSS;
        } else if (user.getDrawsTo().equalsIgnoreCase(generatedResult.getDrawsTo())) {
            return GameResult.DRAW;
        } else if (user.getLosesTo().equalsIgnoreCase(generatedResult.getBeats())) {
            return GameResult.WIN;
        }

        return GameResult.INPROGRESS;
    }

    public boolean isChoice(String userInput) {
        return RPS.isRegistered(userInput);
    }
}

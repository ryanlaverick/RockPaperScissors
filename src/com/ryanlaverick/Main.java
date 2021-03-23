package com.ryanlaverick;

import com.ryanlaverick.game.GameResult;
import com.ryanlaverick.game.RPS;
import com.ryanlaverick.game.RPSGame;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int wins = 0, losses = 0, draws = 0;
        do {
            Scanner inp = new Scanner(System.in);
            print("Please enter your choice: ");

            String userChoice = inp.nextLine();

            RPSGame rpsGame = new RPSGame();

            if (rpsGame.isChoice(userChoice)) {
                GameResult gameResult = rpsGame.getResult(userChoice);
                String toPrint = "";

                if (gameResult == GameResult.WIN) {
                    wins += 1;
                    print(" ");
                    toPrint = "Congratulations! You have won this round of Rock Paper Scissors, you selected " + userChoice + " while the Computer chose " + rpsGame.getGeneratedResult() + "!";
                    print("You have won " + wins + " rounds!");
                    print(" ");
                }

                else if (gameResult == GameResult.DRAW) {
                    draws += 1;
                    print(" ");
                    toPrint = "Draw! You have drawn this round of Rock Paper Scissors, you selected " + userChoice + " while the Computer also chose " + rpsGame.getGeneratedResult() + "!";
                    print("You have drawn " + draws + " rounds!");
                    print(" ");
                }

                else if (gameResult == GameResult.LOSS) {
                    losses += 1;
                    print(" ");
                    toPrint = "Better luck next time! You have lost this round of Rock Paper Scissors, you selected " + userChoice + " while the Computer chose " + rpsGame.getGeneratedResult() + "!";
                    print("You have lost " + losses + " rounds!");
                    print(" ");
                }


                print(toPrint);
            }

            if (userChoice.equalsIgnoreCase("stats")) {
                int gamesPlayed = wins + draws + losses;
                DecimalFormat decimalFormat = new DecimalFormat();
                double winPercentage = ((double) wins / gamesPlayed) * 100;
                print(" ");
                print("------- Rock Paper Scissors Statistics -------");
                print("Games played: " + gamesPlayed);
                print("Wins: " + wins);
                print("Draws: " + draws);
                print("Losses: " + losses);
                print("Win rate: " + decimalFormat.format(winPercentage) + "%");
                print("----------------------------------------------");
                print(" ");
            }

            if(!rpsGame.isChoice(userChoice)) {
                print(userChoice + " is not a registered input choice! Recognised inputs: " + Arrays.asList(RPS.values()));
            }

        } while (true);

    }

    private static void print(String string) {
        System.out.println(string);
    }
}

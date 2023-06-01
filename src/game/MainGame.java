/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.util.ArrayList;


/**
 *
 * @author aletive
 */
public class MainGame {
    public static void main(String[] args) {
        Game match = new Game();
        ArrayList<Player> players;
        boolean gameNotEnded = true;
        match.initGame();
        

        players = match.getPlayerList();

        do {
            for (Player currentPlayer : players) {
                if (match.turn(currentPlayer)) {
                    gameNotEnded = false;

                }
            }
            
        } while (gameNotEnded);
        players = match.rankings();
        for (Player currentPlayer : players) {
            System.out.println("The player " + currentPlayer.getName() + " with a score of " + currentPlayer.totalPoints());
        }
        
        System.out.println("The winner is " + players.get(0).getName() + " with a score of " + players.get(0).totalPoints());


    }
}

package club;

import java.util.ArrayList;

import players.Player;

public abstract class ContractPlayers {
    int a = 0; 

    public static ArrayList<Player> buyPlayers (ArrayList<Player> watchedPlayers){
        ArrayList<Player> players = new ArrayList<Player>();
        for(Player player : players){
            System.out.println(player.getName());
        }

        return players;
    }
}

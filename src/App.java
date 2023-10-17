import java.util.ArrayList;
import java.util.Scanner;

import club.ContractPlayers;
import exceptions.ParametrosInvalidosException;
import players.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int coins = 0;
        int vezes = 0;
        ArrayList<Player> allPlayers = new ArrayList<Player>();
        ArrayList<Player> toBuyPlayers = new ArrayList<Player>();

        System.out.println("digite o valor de moedas do clube: ");

        coins = scan.nextInt();

        ContractPlayers.setClubCoins(coins);

        //criar lista de jogadores, vamos perguntar quantos jogadores o usuário deseja criar e ele automaticamente recebera um preço aleatorio ate 15000000

        while(vezes <= 0){
            System.out.println("quantos jogadores voce deseja ter? o valor deve ser maior que 0.");
            vezes = scan.nextInt();
        }

        scan.nextLine();

        for(int i = 0; i < vezes; i++){
            System.out.println("digite um nome para o jogador " + (i+1));
            String playerName = scan.nextLine();
            allPlayers.add(new Player(playerName));
        }

        toBuyPlayers = ContractPlayers.setPlayersToBuy(allPlayers);


        System.out.println("jogadores que PODEM ser comprados: ");
        toBuyPlayers.forEach(player -> System.out.print(player.getName() + ", ")); // isso satisfaz o case 3

        System.out.print("\n\n");

        try {
            ContractPlayers.buyPlayer(toBuyPlayers); // isso satisfaz o case 4
        } catch (ParametrosInvalidosException e) {
           e.printStackTrace();
        }    
        
        System.out.println("jogadores contratados: " + ContractPlayers.getSignedPlayers() + " moedas restantes: " + ContractPlayers.getClubCoins());






        scan.close();
    }
}

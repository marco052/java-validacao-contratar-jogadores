package club;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.ParametrosInvalidosException;
import players.Player;

public abstract class ContractPlayers {

    private static int clubCoins; 
    private static ArrayList<String> signedPlayers = new ArrayList<String>(); 

    public static ArrayList<Player> setPlayersToBuy (ArrayList<Player> watchedPlayers){ // lógica semelhante ao case 1
        ArrayList<Player> palyersToBuy = new ArrayList<Player>();
        for(Player player : watchedPlayers){
            if(player.getBuyNowPrice() <= clubCoins){
                palyersToBuy.add(player);
                System.out.println("O jogador " + player.getName() + " custa " + player.getBuyNowPrice() + " e foi adicionado a lista de jogadores para serem comprados");
            }
            else{
                System.out.println("O jogador " + player.getName() + " custa " + player.getBuyNowPrice() + " e não pode ser comprado porque faltam moedas");
            }
        }

        return palyersToBuy;
    }

    public static void buyPlayer(ArrayList<Player> playersToBuy) throws ParametrosInvalidosException{
        Scanner scan = new Scanner(System.in);
        System.out.println("digite o valor de A: "); //desafio do contador, ultimo video do projeto
        int numA = scan.nextInt();
        System.out.println("digite o valor de B: "); //desafio do contador, ultimo video do projeto
        int numB = scan.nextInt();

        ArrayList<Player> playersToBuyCopy = playersToBuy;

        

        int count = numB - numA;

        if(count <= 0 || count > playersToBuy.size()){
            throw new ParametrosInvalidosException();
        } 
        while(count > 0 && playersToBuyCopy.size() > 0){
            for (Player playerToBuy : playersToBuy){
                if (playerToBuy.getBuyNowPrice() <= clubCoins){
                clubCoins -= playerToBuy.getBuyNowPrice();
                signedPlayers.add(playerToBuy.getName());
                System.out.println(playerToBuy.getName() + " custa " + playerToBuy.getBuyNowPrice() + " e foi contratado");
                playersToBuyCopy.remove(playerToBuy);

                count --;
                break;
                }
                else{
                    System.out.println(playerToBuy.getName() + " custa " + playerToBuy.getBuyNowPrice() + " e não pode ser comprado porque acabaram as moedas");
                    playersToBuyCopy.remove(playerToBuy);
                }
            }
        }  

        if(count > 0){
            System.out.println("contratacoes encerradas " + count + " atletas ainda disponiveis no mercado: ");
            playersToBuyCopy.forEach(player -> System.out.println(player.getName()));
        }
        else{
            System.out.println("todos contratados com sucesso");
        }
    
    }
    

    public static void setClubCoins(int coins) {
        clubCoins = coins;
    }

    public static int getClubCoins() {
        return clubCoins;
    }

    public static ArrayList<String> getSignedPlayers() {
        return signedPlayers;
    }

    
}

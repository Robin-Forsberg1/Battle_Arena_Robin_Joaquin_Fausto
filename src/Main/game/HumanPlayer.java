package Main.game;
import Main.characters.Fighter;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scan = new Scanner(System.in);

    public HumanPlayer(String myName) {super(myName);}

    @Override
    public void selectMove(Fighter target) {
        while (true) {
            System.out.print("1: Attack | 2: " + getFighter().getSpecialAction() +  "\nVälj nummer: ");
            if(useMove(scan.nextLine(), target)) break;
            else System.out.println("Okänd move...\n");
        }
    }

    @Override
    public void pickFighter() {
        while(true){
            System.out.print("1: Archer | 2: Mage | 3: Warrior\nVälj nummer: ");
            if (fighterList(scan.nextLine()) != null) break;
            else System.out.println("Okänd fighter...\n");
        }
    }
}

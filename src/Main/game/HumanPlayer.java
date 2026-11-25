package Main.game;
import Main.characters.Fighter;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scan = new Scanner(System.in);

    public HumanPlayer(String myName) {super(myName);}

    @Override
    public void selectMove(Fighter target) {
        while (true) {
            System.out.print(TextList.HUMAN_SELECT_MOVE.putInBetween(
                    getFighter().getSpecialAction().toString()));
            if(useMove(scan.nextLine(), target)) break;
            else System.out.println(TextList.UNKNOWN_MOVE);
        }
    }

    @Override
    public void pickFighter() {
        while(true){
            System.out.print(TextList.HUMAN_PICK_FIGHTER);
            if (fighterList(scan.nextLine()) != null) break;
            else System.out.println(TextList.UNKNOWN_FIGHTER);
        }
    }
}

package Main.game;
import Main.characters.*;

public abstract class Player {
    private String myName;
    private Fighter myFighter;

    protected Player(String myName) {this.myName = myName;}

    protected int getFightersHP(boolean withText) {
        if (withText) {
            System.out.println(getMyName() + "'s HP: " + myFighter.getHp());
        }
        return myFighter.getHp();
    }
    protected Fighter getFighter() {return myFighter;}
    public String getMyName() {return myName;}

    protected boolean useMove(String choice, Fighter target){
        boolean moveFound = true;
        switch (choice){
            case "1":
                int damage = myFighter.attack(target);
                System.out.println(getMyName() + " gör " + damage + " skada");
                break;
            case "2":
                System.out.println(getMyName() + myFighter.specialAbility(target));
                break;
            case "3": break;
            case "4": break;
            default: moveFound = false; break;
        } return moveFound;
    }

    protected Fighter fighterList(String choice){
        myFighter = switch (choice) {
            case "1" -> new Archer();
            case "2" -> new Mage();
            case "3" -> new Warrior();
            default -> null;
        }; return myFighter;
    }
}

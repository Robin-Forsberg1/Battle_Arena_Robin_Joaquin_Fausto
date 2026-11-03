package Main.characters;

public class Archer extends Fighter {


    public Archer() {
        super(100, 5, 15);
    }

    @Override
    public String getName() {
        return "Archer";
    }

    @Override
    public Actions getSpecialAction() {
        return Actions.EXTRA_ATTACK;
    }

    @Override
    public String specialAbility(Fighter target) {
        int firstHit = attack(target);
        int secondHit = attack(target);

        return "Archer attackerar två gånger och gör " + firstHit + " och " + secondHit + " skada";
    }
}

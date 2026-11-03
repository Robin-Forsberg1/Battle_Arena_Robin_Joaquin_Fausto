package Main.characters;

public class Mage extends Fighter {

    public Mage() {
        super(100,5,15);
    }

    @Override
    public String getName() {
        return "Mage";
    }

    @Override
    public Actions getSpecialAction() {
        return Actions.HEAL;
    }

    @Override
    public String specialAbility(Fighter target) {
        int healed = heal(10);
        return "Mage läker med " + healed + " HP.";
    }

}

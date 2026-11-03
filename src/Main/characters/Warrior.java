package Main.characters;

public class Warrior extends Fighter {

    public Warrior() {
        super(100, 5, 15);
    }

    @Override
    public String getName() {
        return "Warrior";
    }

    @Override
    public Actions getSpecialAction() {
        return Actions.DEFEND;
    }

    @Override
    public String specialAbility(Fighter target) {
        defend();

        return " försvarar sig själv och halverar nästa skada";
    }


}

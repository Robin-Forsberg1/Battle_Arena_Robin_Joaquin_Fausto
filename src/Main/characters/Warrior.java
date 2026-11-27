package Main.characters;

public class Warrior extends Fighter {

    public Warrior() {
        FighterStats warrior = FighterStats.WARRIOR;
        super(warrior.getHP(), warrior.getMinDamage(), warrior.getMaxDamage(), warrior.getSpecialPoints());
    }

    @Override
    public String getName() {return "Krigare";}

    @Override
    public String getSpecialAction() {return "Försvar";}

    @Override
    public String specialAbility(Fighter target) {
        defend();
        return "s "+ getName()+" försvarar sig själv då nästa skada från motståndarens "
                + target.getName()+" blir 1/"+specialPoints;
    }
}

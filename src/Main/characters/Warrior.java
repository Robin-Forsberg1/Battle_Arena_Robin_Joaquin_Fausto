package Main.characters;

public class Warrior extends Fighter {

    public Warrior() {
        FighterStats stats = FighterStats.WARRIOR;
        super(stats.getHP(), stats.getMinDamage(),
                stats.getMaxDamage(), stats.getSpecialPoints());
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

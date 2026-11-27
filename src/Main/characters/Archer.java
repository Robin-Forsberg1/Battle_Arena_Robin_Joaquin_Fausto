package Main.characters;

public class Archer extends Fighter {

    public Archer() {
        FighterStats stats = FighterStats.ARCHER;
        super(stats.getHP(), stats.getMinDamage(),
                stats.getMaxDamage(), stats.getSpecialPoints());
    }

    @Override
    public String getName() {
        return "Bågskytte";
    }

    @Override
    public String getSpecialAction() {
        return "Extra Attack";
    }

    @Override
    public String specialAbility(Fighter target) {
        int totalDamage = 0;
        for (int i = 0; i < specialPoints; i++) {
            totalDamage += attack(target);}
        return "s "+ getName()+" attackerar "+ specialPoints +" gånger och gör totalt " +
                totalDamage + " skada på motståndarens "+target.getName();
    }
}

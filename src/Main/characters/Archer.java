package Main.characters;

public class Archer extends Fighter {

    public Archer() {
        FighterStats archer = FighterStats.ARCHER;
        super(archer.getHP(), archer.getMinDamage(), archer.getMaxDamage());
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
        int firstHit = attack(target);
        int secondHit = attack(target);
        return "s "+ getName()+" attackerar två gånger och gör " + firstHit + " och " +
                secondHit + " skada på motståndarens "+target.getName();
    }
}

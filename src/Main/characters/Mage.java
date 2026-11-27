package Main.characters;

public class Mage extends Fighter {

    public Mage() {
        FighterStats stats = FighterStats.MAGE;
        super(stats.getHP(), stats.getMinDamage(),
                stats.getMaxDamage(), stats.getSpecialPoints());
    }

    @Override
    public String getName() {return "Magiker";}

    @Override
    public String getSpecialAction() {return "Läka";}

    @Override
    public String specialAbility(Fighter target) {
        if (specialPoints < 0)
            throw new IllegalArgumentException(TextList.NO_NEGATIVE_HEALS.toString());
        int oldHp = hp;
        hp = Math.min(maxHp, hp + specialPoints);
        return "s "+getName()+" läker sig sljälv från " +
                oldHp + " HP till " + getHp() + " HP";
    }

}

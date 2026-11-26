package Main.characters;

public class Mage extends Fighter {

    public Mage() {
        FighterStats mage = FighterStats.MAGE;
        super(mage.getHP(), mage.getMinDamage(), mage.getMaxDamage());
    }

    @Override
    public String getName() {
        return "Magiker";
    }

    @Override
    public String getSpecialAction() {
        return "Läka";
    }

    @Override
    public String specialAbility(Fighter target) {
        int healed = heal(10);
        return "s "+getName()+" läkes sig sljälv från " +
                healed + " HP till " + getHp() + " HP";
    }

}

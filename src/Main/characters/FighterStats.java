package Main.characters;

public enum FighterStats {
    ARCHER(90,8,18),
    MAGE(100,5,15),
    WARRIOR(110, 5, 15);


    private final int maxHp,minDamage,maxDamage;
    FighterStats(int maxHp, int minDamage, int maxDamage) {
        this.maxHp = maxHp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getHP() {return maxHp;}
    public int getMinDamage() {return minDamage;}
    public int getMaxDamage() {return maxDamage;}
}

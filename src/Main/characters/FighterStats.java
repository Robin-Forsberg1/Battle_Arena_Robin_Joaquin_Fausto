package Main.characters;

public enum FighterStats {
    ARCHER(90,8,18,2),
    MAGE(100,5,15,10),
    WARRIOR(110, 5, 15,2);


    private final int maxHp,minDamage,maxDamage, specialPoints;
    FighterStats(int maxHp, int minDamage, int maxDamage, int specialPoints) {
        this.maxHp = maxHp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.specialPoints = specialPoints;
    }

    public int getHP() {return maxHp;}
    public int getMinDamage() {return minDamage;}
    public int getMaxDamage() {return maxDamage;}
    public int getSpecialPoints() {return specialPoints;}
}

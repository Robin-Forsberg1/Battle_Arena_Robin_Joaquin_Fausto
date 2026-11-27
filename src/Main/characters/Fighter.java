package Main.characters;


import java.util.Random;

public abstract class Fighter implements Moves {
    protected final int maxHp,minDamage, maxDamage,specialPoints;
    protected int hp;
    private boolean defending = false;
    private final Random random = new Random();

    public Fighter(int maxHp, int minDamage, int maxDamage, int specialPoints) {
        if (maxHp <= 0 || minDamage <= 0 || maxDamage < minDamage)
            throw new IllegalArgumentException(TextList.INVALID_STATS.toString());
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.specialPoints = specialPoints;
    }

    public int attack(Fighter target) {
        defending = false;
        int damage = random.nextInt(minDamage, maxDamage + 1);
        int actualDamage = target.takeDamage(damage);
        return actualDamage;
    }

    public int takeDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException(TextList.NO_NEGATIVE_DAMAGE.toString());
        if (defending) damage = Math.round((damage + 1) / specialPoints);
        int oldHp = hp;
        hp = Math.max(0, hp -damage);
        return oldHp - hp;
    }

    public int getHp(){return hp;}
    protected void defend() {defending = true;}
    public int getMaxHp() {return maxHp;}
    public abstract String getName();
}
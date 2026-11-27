package Main.characters;

import org.w3c.dom.Text;

import java.util.Random;

public abstract class Fighter implements Moves {
    private final int maxHp,minDamage, maxDamage;
    private int hp;
    private boolean defending;
    private final Random random = new Random();

    public Fighter(int maxHp, int minDamage, int maxDamage) {
        if (maxHp <= 0 || minDamage <= 0 || maxDamage < minDamage)
            throw new IllegalArgumentException(TextList.INVALID_STATS.toString());
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int attack(Fighter target) {
        int damage = random.nextInt(minDamage, maxDamage + 1);
        int actualDamage = target.takeDamage(damage);
        return actualDamage;
    }

    public int takeDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException(TextList.NO_NEGATIVE_DAMAGE.toString());
        if (defending) {
            int originalDamage = damage;
            damage = (damage + 1) / 2;
            defending = false;

            System.out.println(getName() + " " + TextList.DEFENSE_HALVES_DAMAGE.withDamage(originalDamage, damage));
        }

        int oldHp = hp;
        hp = Math.max(0, hp -damage);
        return oldHp - hp;
    }

    public int heal (int amount) {
        if (amount < 0) throw new IllegalArgumentException(TextList.NO_NEGATIVE_HEALS.toString());
        int oldHp = hp;
        hp = Math.min(maxHp, hp + amount);
        return hp - oldHp;
    }

    public int getHp(){return hp;}
    public void defend() {defending = true;}
    public int getMaxHp() {return maxHp;}
    public boolean isDefending() {return defending;}
    public abstract String getName();

    @Override
    public abstract String getSpecialAction();

    @Override
    public abstract String specialAbility(Fighter target);
}
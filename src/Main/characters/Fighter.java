package Main.characters;

import java.util.Random;

public abstract class Fighter implements Moves {
    private final int maxHp;
    private int hp;
    private final int minDamage;
    private final int maxDamage;
    private boolean defending;

    private final Random random = new Random();

    public Fighter(int maxHp, int minDamage, int maxDamage) {
        if (maxHp <= 0 || minDamage <= 0 || maxDamage < minDamage) {
            throw new IllegalArgumentException("Ogiltiga karaktärsvärden");
        }

        this.maxHp = maxHp;
        this.hp = maxHp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int attack(Fighter target) {
        int damage = random.nextInt(minDamage, maxDamage + 1);
        int actualDamage = target.takeDamage(damage);

        System.out.println(getName()
        + " gör " + actualDamage + " skada mot " + target.getName());
        return actualDamage;
    }

    public int takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Skada kan inte vara negativ");
        }

        if (defending) {
            damage = (damage + 1) / 2;
            defending = false;
        }

        int oldHp = hp;
        hp = Math.max(0, hp -damage);

        return oldHp - hp;
    }

    public int heal (int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Läkningen kan inte vara negativ");
        }

        int oldHp = hp;
        hp = Math.min(maxHp, hp + amount);
        return hp - oldHp;
    }

    public int getHp(){
        return hp;
    }

    public int getHp(boolean withText) {
        if (withText) {
            System.out.println(getName() + "s HP: " + hp);
        }
        return hp;
    }

    public void defend() {
        defending = true;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public boolean isDefending() {
        return defending;
    }

    public abstract String getName();

    @Override
    public abstract Actions getSpecialAction();

    @Override
    public abstract String specialAbility(Fighter target);
}

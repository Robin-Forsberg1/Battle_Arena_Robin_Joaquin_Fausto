package Test;

import Main.characters.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    Warrior warrior;
    Archer archer;
    Mage mage;

    @BeforeEach
    void setUp() {
        warrior = new Warrior();
        archer = new Archer();
        mage = new Mage();
    }

    @Test
    void warriorAttacksArcher() {
        int damage = warrior.attack(archer);
        assertTrue(damage >=5 && damage <= 15);
    }

    @Test
    void archerLoseHPToZero() {
        archer.takeDamage(1000);
        assertEquals(0, archer.getHp());
    }

    @Test
    void archerHealsThemselves() {

       mage.takeDamage(20);
       int afterDamageHP = mage.getHp();

       mage.specialAbility(null);
       int healedHP = mage.getHp();

       assertEquals(afterDamageHP+10, archer.getHp());

    }

    /*@Test
    void healingCannotExceedMaxHP() {
        mage.takeDamage(10);

        mage.specialAbility(null);
        mage.heal(1000);

        assertEquals(mage.getMaxHp(), mage.getHp());
    }*/

    @Test
    void warriorDefendsAndReducesDamage() {
        warrior.defend();

        int damage = warrior.takeDamage(10);

        assertEquals(5, damage);
        assertEquals(105, warrior.getHp());
    }

    @Test
    void archerSpecialAbilityAttacksTwice() {
        int initialHP = mage.getHp();

        archer.specialAbility(mage);

        int damage = initialHP - mage.getHp();

        assertTrue(damage >10 && damage <= 36 );
    }

    @Test
    void mageSpecialAbilityHealsItself() {
        mage.takeDamage(20);

        int initialHP =  mage.getHp();

        mage.specialAbility(warrior);

        assertEquals(initialHP + 10, mage.getHp());
    }
}
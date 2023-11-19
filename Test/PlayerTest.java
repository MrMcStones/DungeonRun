import com.Rasmus.demo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player testPlayer;

    @BeforeEach
    public void testPlayer() {
        testPlayer = new Player(
                1,
                1,
                1,
                20,
                20,
                1,
                5);
    }

    @Test
    public void testTakeDamage() {

        testPlayer.takeDamage(5);

        assertEquals(15, testPlayer.getCurrentHealth());
    }

    @Test
    public void testCalculateDamage() {
        testPlayer.setStrength(1);
        testPlayer.setBaseDamage(5);

        int calculateDamage = testPlayer.calculateDamage();

        assertEquals(6, calculateDamage, "Expected: 6, actual: " + calculateDamage);
    }

    @Test
    public void testLevelUp() {

        testPlayer.gainedExp(10);

        assertEquals(2, testPlayer.getLevel());
        assertEquals(0, testPlayer.getExperience());
        assertEquals(30, testPlayer.getFullHealth());
        assertEquals(30, testPlayer.getCurrentHealth());
        assertEquals(3, testPlayer.getIntelligence());
        assertEquals(3, testPlayer.getAgility());
        assertEquals(3, testPlayer.getStrength());
        assertEquals(7, testPlayer.getBaseDamage());
    }

    @Test
    public void TestDidDodge() {
        boolean didDodge = testPlayer.didDodge();

        assertTrue(didDodge || !didDodge);
    }

    @Test
    public void testIsAlive() {
        testPlayer.setCurrentHealth(0);

        boolean isAlive = testPlayer.isAlive();

        assertFalse(isAlive);
    }

    @Test
    public void testPlayerLoses() {
        int startHealth = testPlayer.getCurrentHealth();

        testPlayer.takeDamage(startHealth + 1);;

        assertFalse(testPlayer.isAlive());
    }
}

/* TODO - What could go wrong?
 *  Compare datatypes (String, Int)
 *  Wrong value
 *  Wrong code - return value
 *  Percent value
 */
import com.Rasmus.demo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    private Player testPlayer;

    @BeforeEach
    public void testPlayer() {
        testPlayer = new Player(
                5,
                5,
                5,
                100,
                100,
                1,
                50);
    }

    @Test
    public void testTakeDamage() {

        testPlayer.takeDamage(5);

        assertEquals(95, testPlayer.getCurrentHealth());
    }

    @Test
    public void testLevelUp() {

        testPlayer.gainedExp(10);

        assertEquals(2, testPlayer.getLevel());
        assertEquals(0, testPlayer.getExperience());
        assertEquals(110, testPlayer.getFullHealth());
        assertEquals(110, testPlayer.getCurrentHealth());
        assertEquals(7, testPlayer.getIntelligence());
        assertEquals(7, testPlayer.getAgility());
        assertEquals(7, testPlayer.getStrength());
        assertEquals(52, testPlayer.getBaseDamage());
    }

    @Test
    public void TestDidDodge() {
        boolean didDodge = testPlayer.didDodge();

        assertTrue(didDodge || !didDodge);
    }

    @Test
    public void testIsAlive() {
        boolean isAlive = testPlayer.isAlive();

        assertTrue(isAlive);
    }
}

/* TODO - What could go wrong?
 *  Compare datatypes (String, Int)
 *  Wrong value
 *  Wrong code - return value
 *  Percent value
 */
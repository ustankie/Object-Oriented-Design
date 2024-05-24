package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.data.Prisoner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrisonerTest {
    @Test
    public void testPrisonerIsInJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 2011, 13);
        assertTrue(news.isInJail());
    }

    @Test
    public void testPrisonerHasBeenReleasedFromJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 2008, 5);
        assertFalse(news.isInJail());
    }
}

package pl.edu.agh.to.lab4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrisonerTest {
    @Test
    public void testPrisonerIsInJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 2011, 5);
        assertTrue(news.czyMoglbyEwentualnieBycPodejrzany());
    }

    @Test
    public void testPrisonerHasBeenReleasedFromJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 2008, 5);
        assertFalse(news.czyMoglbyEwentualnieBycPodejrzany());
    }
}

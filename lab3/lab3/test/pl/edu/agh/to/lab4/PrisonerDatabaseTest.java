package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.providers.PrisonerDataProvider;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private PrisonerDataProvider prisonersDatabase = new PrisonerDataProvider();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.getAllPrisons().size());
    }
}

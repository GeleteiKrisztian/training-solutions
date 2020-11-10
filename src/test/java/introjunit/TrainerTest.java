package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    void testCreate() {
        Trainer trainer = new Trainer("John Wick");

        String name = trainer.getName();

        assertEquals("John Wick",name);
    }
}

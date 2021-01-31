package week09d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {

    private List<Person> personList = List.of(new Person("John Doe", 15), new Person("Jack Doe", 13));
    SantaClaus santaClaus = new SantaClaus(personList);

    @Test
    void personPresentIsNullTest() {
        assertEquals(null, santaClaus.getPersons().get(0).getPresent());

    }

    @Test
    void personPresentTest() {
        assertEquals(null, santaClaus.getPersons().get(0).getPresent());
        santaClaus.getThroughChimneys();
        assertEquals(true ,santaClaus.getPersons().get(1).getPresent().ordinal() < 5);
    }
}
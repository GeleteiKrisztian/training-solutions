package week13d02;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class QuestionManagerTest {

    private String inputStream = "/results.txt";


    @Test
    void isCorrectTest() {
        QuestionManager questionManager = new QuestionManager(inputStream);


        assertTrue(questionManager.isCorrectAnswer("AB123", 1));
        assertTrue(questionManager.isCorrectAnswer("GH1234", 2));
        assertFalse(questionManager.isCorrectAnswer("BD452", 3));

    }

    @Test
    void mostXTest() {
        QuestionManager questionManager = new QuestionManager(inputStream);

        assertEquals("BD452", questionManager.mostXAnswer());

    }

    @Test
    void winnerTest() {
        QuestionManager questionManager = new QuestionManager(inputStream);

        assertEquals("GH1234", questionManager.mostPoints());
    }
}
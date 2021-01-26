package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionManager {

    private String correctAnswers = null;
    private List<Question> questions = new ArrayList<>();
    private Map<String, String> questionsHelper;

    public QuestionManager(String path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(QuestionManager.class.getResourceAsStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (correctAnswers == null) {
                    correctAnswers = br.readLine();
                    continue;
                }
                String[] split = line.split(" ");
                questions.add(new Question(split[0], Answer.valueOf(split[1])));
            }
            questionsHelper = ListToMap();
            System.out.println(correctAnswers);
            System.out.println(questions.size());
            System.out.println(questionsHelper.size());
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public Map<String, String> ListToMap() {
        Map<String, String> answers = new HashMap<>();
        for (Question item : questions) {
            answers.put(item.getId(), answers.get(item.getId()) + item.getAnswer().name());
        }
        return answers;
    }

    public boolean isCorrectAnswer(String id, int num) {
        String ans = questionsHelper.get(id);
        if (correctAnswers.charAt(num - 1) == ans.charAt(num - 1)) {
            return true;
        }
        return false;
    }

    public String mostXAnswer() {
        String id = null;
        int xCounter = 0;
        for (String item : questionsHelper.values()) {
            int counter = 0;
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) == 'X') {
                    ++counter;
                }
            }
            if (counter > xCounter) {
                id = item;
                xCounter = counter;
            }
        }
        return id;
    }

    public String mostPoints() {
        String id = null;
        int pointsCounter = 0;
        for (String item : questionsHelper.values()) {
            int counter = 0;
            for (int i = 0; i < item.length(); i++) {
                    counter += i + 1;
            }
            if (counter > pointsCounter) {
                id = item;
                pointsCounter = counter;
            }
        }
        return id;
    }

}

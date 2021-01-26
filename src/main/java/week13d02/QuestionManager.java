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
                    correctAnswers = line;
                    continue;
                }
                String[] split = line.split(" ");
                questions.add(new Question(split[0], Answer.valueOf(split[1])));
            }
            questionsHelper = ListToMap();
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public Map<String, String> ListToMap() {
        Map<String, String> answers = new HashMap<>();
        for (Question item : questions) {
            //Ha még nincs benne,akkor a null-t is hozzáfűzi
            answers.put(item.getId(), !answers.containsKey(item.getId()) ? item.getAnswer().name() : answers.get(item.getId()) + item.getAnswer().name());
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
        String id = "";
        int xCounter = 0;
        for (String keyId : questionsHelper.keySet()) {
            String answerValue = questionsHelper.get(keyId);
            int counter = 0;
            for (int i = 0; i < answerValue.length(); i++) {
                if (answerValue.charAt(i) == 'X') {
                    ++counter;
                }
            }
            if (counter > xCounter) {
                id = keyId;
                xCounter = counter;
            }
        }
        return id;
    }

    public String mostPoints() {
        String id = "";
        int pointsCounter = 0;
        for (String keyId : questionsHelper.keySet()) {
            String answerValue = questionsHelper.get(keyId);
            int counter = 0;
            for (int i = 0; i < answerValue.length(); i++) {
                if (answerValue.charAt(i) == 'X') {
                    continue;
                }
                    counter += i + 1;
            }
            if (counter > pointsCounter) {
                id = keyId;
                pointsCounter = counter;
            }
        }
        return id;
    }

}

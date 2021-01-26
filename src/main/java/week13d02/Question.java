package week13d02;

public class Question {

    private String id;
    private Answer answer;

    public Question(String id, Answer answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public Answer getAnswer() {
        return answer;
    }

}

package lambdaintro;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private List<String> skills;
    private Sex gender;
    private List<String> messages = new ArrayList<>();

    public void sendMessage(String message) {
        messages.add(message);
    }

    public Member(String name, List<String> skills, Sex gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    public Sex getGender() {
        return gender;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}

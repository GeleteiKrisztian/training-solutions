package week05d03;

import java.util.List;

public class UserValidator {

    public boolean validate(List<User> users) {
        for (User item : users) {
            if (isEmpty(item.getName())) {
                throw new IllegalArgumentException("Argument null or empty!");
            }
            if (item.getAge() < 0 || item.getAge() > 120) {
                throw new IllegalArgumentException("Invalid argument(s)!");
            }
        }
        return true;
    }

    private boolean isEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }
}

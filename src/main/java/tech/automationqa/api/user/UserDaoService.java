package tech.automationqa.api.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int idCounter = 1;

    static {
        users.add(new User(1, "Jorge", "Desilvestro", "ortsevlised", "13/06/1986", "jorge@automationqa.tech"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++idCounter);
        }
        users.add(user);
        return user;
    }

    public User deleteUser(int id) {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == id) {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
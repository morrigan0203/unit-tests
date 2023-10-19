package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if(!user.isAuthenticate) return;
       data.add(user);
    }

    public User findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean logout(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User should not be NULL");
        }
        User byName = findByName(user.name);
        if (byName == null) {
            throw new IllegalStateException("User " + user.name + " is not logged");
        }
        boolean logout = byName.logout();
        if (logout) {
            this.data.remove(byName);
            return true;
        }
        return false;
    }
}
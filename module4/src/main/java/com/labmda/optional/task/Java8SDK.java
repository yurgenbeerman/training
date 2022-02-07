package com.labmda.optional.task;

import java.util.List;
import java.util.Optional;

public class Java8SDK {

    protected final UserDao userDao;

    public Java8SDK(UserDao userDao) {
        this.userDao = userDao;
    }

    /** TODO - Реализовать метод с использованием Optional & Lambda
     * return User middle name if exists and user exists. Otherwise return current time.
     */
    public String getMiddleNameOrCurrentTimestamp(String name) {
        // return userDao.findUserByName(name);
        return null;
    }

    /** TODO - Реализовать метод с использованием Optional & Lambda
     * Get List of hobbies without duplicates that exist for users
     * whose name starts with "A" and middle name exists.
     */
    public List<String> getHobbies() {
        //        return userDao.findAll();
        return null;
    }

    public interface UserDao {

        Optional<User> findUserByName(String name);

        List<User> findAll();

        List<User> findAll(int offset, int count);
    }

    public static class User {

        private final String name;
        private final String middleName;
        private final List<String> hobbies;

        public User(String name, String middleName, List<String> hobbies) {
            this.name = name;
            this.middleName = middleName;
            this.hobbies = hobbies;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getMiddleName() {
            return Optional.ofNullable(middleName);
        }

        public List<String> getHobbies() {
            return hobbies;
        }

        @Override
        public String toString() {
            return "User{" +
                   "name='" + name + '\'' +
                   ", middleName='" + middleName + '\'' +
                   ", hobbies=" + hobbies +
                   '}';
        }
    }
}

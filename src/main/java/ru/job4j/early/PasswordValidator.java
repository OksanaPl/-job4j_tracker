package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        String[] substring = {"qwerty", "12345", "password", "admin", "user"};
        for (String s : substring) {
            if (password.toLowerCase().contains(s)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings:"
                        + " qwerty, 12345, password, admin, user");
            }
        }
        boolean digit = false;
        boolean special = false;
        char[] array = password.toCharArray();
        for (char ch : array) {
            if (Character.isDigit(ch)) {
                digit = true;
            }
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                special = true;
            }
            if (digit && special) {
                break;
            }
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!special) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}


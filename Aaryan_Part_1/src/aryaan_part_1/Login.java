package aryaan_part_1;

public class Login {

    // Instance variables
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor to initialize the login object with username, password, first name, and last name
    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check if the username is correctly formatted
    public boolean checkUsername() {
        return username.contains("_") && username.length() >= 5;
    }

    // Method to check if the password meets complexity requirements
    public boolean checkPasswordComplexity() {
        return password.length() >= 8 && hasNumber() && hasUpperCase() && hasSpecialCharacter();
    }

    /**
     * Code Attribution This method was taken from Tutorialspoint:
     * https://www.tutorialspoint.com/java/lang/character_isuppercase.htm
     * Author: Twinkl Bajaj
     */
    private boolean hasUpperCase() {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Code Attribution This method was taken from GeeksforGeeks:
     * https://www.geeksforgeeks.org/character-isletterordigit-in-java-with-examples/
     */
    private boolean hasLetter() {
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Code Attribution This method was taken from Tutorialspoint:
     * https://www.tutorialspoint.com/java/character_isdigit.htm
     */
    private boolean hasNumber() {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Code Attribution This method was taken from Tutorialspoint:
     * https://www.geeksforgeeks.org/character-isletterordigit-in-java-with-examples/
     * Helper method to check if the password contains at least one special
     * character
     */
    private boolean hasSpecialCharacter() {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Method to register a user with the provided credentials
    public String registerUser() {
        if (!checkUsername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is at least 5 characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            return "You are now registered.";
        }
    }

    // Method to authenticate a user with the provided credentials
    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(this.username) && inputPassword.equals(this.password);
    }

    // Method to return the login status message based on the login status
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName ;
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Static method to check if a character is a special character
    public static boolean isSpecialCharacter(char c) {
        return !Character.isLetterOrDigit(c);
    }
}

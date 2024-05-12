/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package aryaan_part_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uthac
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testValidUsername() {
        Login login = new Login("kyl_1", "StrongPassw0rd!", "Aryaan", "Patel");
        assertTrue(login.checkUsername(), "Valid username should be accepted");
    }

    @Test
    public void testUsernameMissingUnderscore() {
        Login login = new Login("kyle!!!@", "StrongPassw0rd!", "Aryaan", "Patel");
        assertFalse(login.checkUsername(), "Username missing underscore should be rejected");
    }

    @Test
    public void testUsernameExceedsLimit() {
        Login login = new Login("ThisNameIsTooLong", "StrongPassw0rd!", "Aryaan", "Patel");
        assertFalse(login.checkUsername(), "Username exceeding character limit should be rejected");
    }

    @Test
    public void testEmptyUsername() {
        Login login = new Login("", "StrongPassw0rd!", "Aryaan", "Patel");
        assertFalse(login.checkUsername(), "Empty username should be rejected");
    }

    @Test
    public void testValidPassword() {
        Login login = new Login("arya_123", "StrongPassw0rd!", "Aryaan", "Patel");
        assertTrue(login.checkPasswordComplexity(), "Valid password should be accepted");
    }

    @Test
    public void testPasswordTooShort() {
        Login login = new Login("arya_123", "pass", "Aryaan", "Patel");
        assertFalse(login.checkPasswordComplexity(), "Password too short should be rejected");
    }

    @Test
    public void testPasswordMissingCapitalLetter() {
        Login login = new Login("arya_123", "password123!@", "Aryaan", "Patel");
        assertFalse(login.checkPasswordComplexity(), "Password missing capital letter should be rejected");
    }

    @Test
    public void testPasswordMissingNumber() {
        Login login = new Login("arya_123", "PasswordComplex!", "Aryaan", "Patel");
        assertFalse(login.checkPasswordComplexity(), "Password missing number should be rejected");
    }

    @Test
    public void testPasswordMissingSpecialCharacter() {
        Login login = new Login("arya_123", "Password123Capital", "Aryaan", "Patel");
        assertFalse(login.checkPasswordComplexity(), "Password missing special character should be rejected");
    }

    @Test
    public void testSuccessfulRegistration() {
        Login login = new Login("arya_123", "StrongPassw0rd!", "Aryaan", "Patel");
        String result = login.registerUser();
        assertEquals("You are now registered.", result, "Valid registration should be successful");
    }

    @Test
    public void testRegistrationInvalidUsername() {
        Login login = new Login("kyle!!!@", "StrongPassw0rd!", "Aryaan", "Patel");
        String result = login.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is at least 5 characters in length.", result, "Registration with invalid username should return appropriate message");
    }

    @Test
    public void testRegistrationInvalidPassword() {
        Login login = new Login("arya_123", "pass", "Aryaan", "Patel");
        String result = login.registerUser();
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result, "Registration with invalid password should return appropriate message");
    }

    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("arya_123", "StrongPassw0rd!", "Aryaan", "Patel");
        boolean loginStatus = login.loginUser("arya_123", "StrongPassw0rd!");
        assertTrue(loginStatus, "Valid login credentials should be successful");
    }

    @Test
    public void testFailedLoginIncorrectUsername() {
        Login login = new Login("arya_123", "StrongPassw0rd!", "Aryaan", "Patel");
        boolean loginStatus = login.loginUser("incorrectUsername", "StrongPassw0rd!");
        assertFalse(loginStatus);
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aryaan_part_1;

import java.util.Scanner;

/**
 *
 * @author uthac
 */
public class Aaryan_Poe_Part1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        Login login = new Login(username, password, firstName, lastName);

        String registrationStatus = login.registerUser();
        System.out.println(registrationStatus);

        if (registrationStatus.equals("You are now registered.")) {
            System.out.println("Now, let's try logging in.");

            System.out.print("Enter your username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String inputPassword = scanner.nextLine();

            boolean loginStatus = login.loginUser(inputUsername, inputPassword);
            String loginMessage = login.returnLoginStatus(loginStatus);
            System.out.println(loginMessage);
        }

        scanner.close();
    }
}

package aryaan_part_2;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
    boolean loginStatus = registerAndLogin();
    if (loginStatus) {
        System.out.println("Minimize Netbeans to see JOptionPanel");
        Task.setIsLoggedIn(loginStatus);
        runTaskManagement(); // Call the task management method if login is successful
    } else {
        System.out.println("Login failed. Exiting application.");
    }
}



    public static boolean registerAndLogin() {
        boolean loginStatus;
        try (Scanner scanner = new Scanner(System.in)) {
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

                loginStatus = login.loginUser(inputUsername, inputPassword);
                String loginMessage = login.returnLoginStatus(loginStatus);
                System.out.println(loginMessage);
            } else {
                loginStatus = false;
                System.out.print(registrationStatus);
            }
        }
        return loginStatus;
    }

   public static void runTaskManagement() {
    Task task = new Task(); // Initialize Task object with 0 tasks

    // Run the task management loop while isLoggedIn is true
    while (true) {
        boolean boolBreak = false;
        // Display welcome message and menu options
        String welcomeMessage = task.getStrWelcomeMessage();
        String[] welcomeMenuOptions = task.getStrWelcomeMenuOptions();
        int option = JOptionPane.showOptionDialog(null, welcomeMessage, "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, welcomeMenuOptions, welcomeMenuOptions[0]);

        switch (option) {
            case 0 -> {
                // Add Tasks
                // Capture number of tasks
                int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of tasks:", "Input", JOptionPane.PLAIN_MESSAGE));
                while (numberOfTasks <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid Number of Tasks");
                    numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of tasks:", "Input", JOptionPane.PLAIN_MESSAGE));
                }

                task.setNumberOfTasks(numberOfTasks);

                // Add tasks
                for (int i = 0; i < numberOfTasks; i++) {
                    addTask(task, i + 1);
                    JOptionPane.showMessageDialog(null, task.printTaskDetails(i));
                }
                
                // show Total Hours
                int totalHours = task.returnTotalHours(task.getIntUserTasks());
                JOptionPane.showMessageDialog(null, "Total hours: " + totalHours + "hrs");
            }

            case 1 -> {
                // Show Report
                if (task.getStrTaskName() == null || task.getStrTaskName().length == 0) {
                    JOptionPane.showMessageDialog(null, "Coming soon...");
                } else {
                    // show report
                    int count = 0;
                    while(count < (task.getIntUserTasks() + 1)){
                        JOptionPane.showMessageDialog(null, task.printTaskDetails(count));
                        count++;
                    }
                }

            }

            case 2 -> // Quit
                boolBreak = true; // Set isLoggedIn to false
        }
        
        if(boolBreak){
            break;
        }
    }
}


    public static void addTask(Task task, int taskNumber) {
        String taskName = JOptionPane.showInputDialog(null, "Enter Task Name:", "Input", JOptionPane.PLAIN_MESSAGE);
        String taskDescription = JOptionPane.showInputDialog(null, "Enter Task Description:", "Input", JOptionPane.PLAIN_MESSAGE);
        while (!task.checkTaskDescription(taskDescription)) {
            JOptionPane.showMessageDialog(null, "Description text is longer than 50 characters.");
            taskDescription = JOptionPane.showInputDialog(null, "Enter Task Description:", "Input", JOptionPane.PLAIN_MESSAGE);
        }

        String firstName = JOptionPane.showInputDialog(null, "Enter Developer First Name:", "Input", JOptionPane.PLAIN_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Enter Developer Last Name:", "Input", JOptionPane.PLAIN_MESSAGE);
        
        String taskDuration = JOptionPane.showInputDialog(null, "Enter Task Duration (in hours):", "Input", JOptionPane.PLAIN_MESSAGE);

        String[] taskStatuses = task.getStrTaskStatuses();
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, null, taskStatuses, taskStatuses[0]);
        
        task.resizeArrays(taskNumber);
        
        task.getStrTaskName()[taskNumber - 1] = taskName;
        task.getStrTaskDescription()[taskNumber - 1] = taskDescription;
        task.getStrDevelopFirstName()[taskNumber - 1] = firstName;
        task.getStrDeveloperLastName()[taskNumber - 1] = lastName;
        task.getIntTaskDuration()[taskNumber - 1] = Integer.parseInt(taskDuration);
        task.getStrTaskStatus()[taskNumber - 1] = taskStatus;
        task.createTaskID(taskNumber - 1); // Adjusting for 0-based index
    }
}

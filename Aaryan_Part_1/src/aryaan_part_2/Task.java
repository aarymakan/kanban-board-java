package aryaan_part_2;

public class Task {
    // declare global variables
    private static boolean isLoggedIn = false;

    private String strWelcomeMessage = "Welcome To EasyKanban";
    private String[] strWelcomeMenuOptions = {"1. Add Tasks", "2. Show Report", "3. Quit"};

    private boolean boolIsAppRunning = true;
    private int intUserTasks = 0;

    // task information
    private String[] strTaskName;
    private int[] intCurrTaskNumber;
    private String[] strTaskDescription;

    // developer details
    private String[] strDevelopFirstName;
    private String[] strDeveloperLastName;

    // task info continued...
    private int[] intTaskDuration;
    private String[] strTaskId;

    // task status
    private String[] strTaskStatuses = {"1. To Do", "2. Done", "3. Doing"};
    private String[] strTaskStatus;

    // Getter and setter methods
    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getStrWelcomeMessage() {
        return strWelcomeMessage;
    }

    public String[] getStrWelcomeMenuOptions() {
        return strWelcomeMenuOptions;
    }

    public boolean isBoolIsAppRunning() {
        return boolIsAppRunning;
    }

    public int getIntUserTasks() {
        return intUserTasks;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.intUserTasks = numberOfTasks - 1;
        this.strTaskName = new String[intUserTasks];
        this.intCurrTaskNumber = new int[intUserTasks];
        this.strTaskDescription = new String[intUserTasks];
        this.strDevelopFirstName = new String[intUserTasks];
        this.strDeveloperLastName = new String[intUserTasks];
        this.intTaskDuration = new int[intUserTasks];
        this.strTaskId = new String[intUserTasks];
        this.strTaskStatus = new String[intUserTasks];
    }
    
    public void resizeArrays(int newLength) {
        // Resize strTaskName array
        String[] newStrTaskName = new String[newLength];
        System.arraycopy(strTaskName, 0, newStrTaskName, 0, Math.min(strTaskName.length, newLength));
        strTaskName = newStrTaskName;

        // Resize intCurrTaskNumber array
        int[] newIntCurrTaskNumber = new int[newLength];
        System.arraycopy(intCurrTaskNumber, 0, newIntCurrTaskNumber, 0, Math.min(intCurrTaskNumber.length, newLength));
        intCurrTaskNumber = newIntCurrTaskNumber;

        // Resize strTaskDescription array
        String[] newStrTaskDescription = new String[newLength];
        System.arraycopy(strTaskDescription, 0, newStrTaskDescription, 0, Math.min(strTaskDescription.length, newLength));
        strTaskDescription = newStrTaskDescription;

        // Resize strDevelopFirstName array
        String[] newStrDevelopFirstName = new String[newLength];
        System.arraycopy(strDevelopFirstName, 0, newStrDevelopFirstName, 0, Math.min(strDevelopFirstName.length, newLength));
        strDevelopFirstName = newStrDevelopFirstName;

        // Resize strDeveloperLastName array
        String[] newStrDeveloperLastName = new String[newLength];
        System.arraycopy(strDeveloperLastName, 0, newStrDeveloperLastName, 0, Math.min(strDeveloperLastName.length, newLength));
        strDeveloperLastName = newStrDeveloperLastName;

        // Resize intTaskDuration array
        int[] newIntTaskDuration = new int[newLength];
        System.arraycopy(intTaskDuration, 0, newIntTaskDuration, 0, Math.min(intTaskDuration.length, newLength));
        intTaskDuration = newIntTaskDuration;

        // Resize strTaskId array
        String[] newStrTaskId = new String[newLength];
        System.arraycopy(strTaskId, 0, newStrTaskId, 0, Math.min(strTaskId.length, newLength));
        strTaskId = newStrTaskId;

        // Resize strTaskStatus array
        String[] newStrTaskStatus = new String[newLength];
        System.arraycopy(strTaskStatus, 0, newStrTaskStatus, 0, Math.min(strTaskStatus.length, newLength));
        strTaskStatus = newStrTaskStatus;
    }


    public String[] getStrTaskName() {
        return strTaskName;
    }

    public String[] getStrTaskDescription() {
        return strTaskDescription;
    }

    public String[] getStrDevelopFirstName() {
        return strDevelopFirstName;
    }

    public String[] getStrDeveloperLastName() {
        return strDeveloperLastName;
    }
    
    public int[] getIntTaskDuration() {
        return intTaskDuration;
    }

    public String[] getStrTaskStatuses() {
        return strTaskStatuses;
    }

    public String[] getStrTaskStatus() {
        return strTaskStatus;
    }

    // check if user is logged in
    public static boolean Class(boolean isLoggedIn) {
        return isLoggedIn;
    }

    // Task description is not more than 50 chars
    public boolean checkTaskDescription(String strTaskDescription) {
        return strTaskDescription.length() <= 50;
    }

    // Create TaskID
    public String createTaskID(int intTaskIteration) {
        this.strTaskId[intTaskIteration] = this.strTaskName[intTaskIteration].substring(0, 1).toUpperCase()  +
                this.strTaskName[intTaskIteration].substring(1, 2).toUpperCase() + ":" +
                (intTaskIteration + 1) + ":" +
                this.strDevelopFirstName[intTaskIteration].substring(strDevelopFirstName[intTaskIteration].length() - 3).toUpperCase();

        return strTaskId[intTaskIteration];
    }

    // Print Task Details for each task
    public String printTaskDetails(int intTaskIteration) {
        return ("Task Status: " + strTaskStatuses[intTaskIteration] + "\n\n" +
                "Developer Details \n" +
                "First Name: " + strDevelopFirstName[intTaskIteration] + "\n" +
                "Last Name: " + strDeveloperLastName[intTaskIteration] + "\n\n" +
                "Task Number: " + intTaskIteration + "\n" +
                "Task Name: " + strTaskName[intTaskIteration] + "\n" +
                "Task ID: " + strTaskId[intTaskIteration] + "\n" +
                "Task Description: " + strTaskDescription[intTaskIteration] + "\n" +
                "Task Duration: " + intTaskDuration[intTaskIteration] + "hrs \n");

    }

    // Total combined hours for all tasks
    public int returnTotalHours(int intTaskIteration) {
        int intHours = 0;
        for (int i = 0; i < intTaskIteration + 1; i++) {
            intHours += intTaskDuration[i];
        }
        return intHours;
    }

    // Reset task data
    public void resetTaskData() {
        this.strTaskName = new String[intUserTasks];
        this.intCurrTaskNumber = new int[intUserTasks];
        this.strTaskDescription = new String[intUserTasks];
        this.strDevelopFirstName = new String[intUserTasks];
        this.strDeveloperLastName = new String[intUserTasks];
        this.intTaskDuration = new int[intUserTasks];
        this.strTaskId = new String[intUserTasks];
        this.strTaskStatus = new String[intUserTasks];
    }
}

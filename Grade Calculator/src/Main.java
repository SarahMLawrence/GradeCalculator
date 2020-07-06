import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Declarations
    private static String fName;
    private static String lName;
    private static String ans;
    private static int choice;
    static float gradenum, numassigngrades, midterm, fingrade, FinalExamGrade;
    static boolean contloop = true;
    static boolean continueloop = true;
    static Scanner sc = new Scanner(System.in);
    static UnderGrad myGrad = new UnderGrad();

    // --------------//
    // MAIN METHOD //
    // --------------//

    public static void main(String[] args) {
        // Welcome msg
        System.out.println("*****Welcome to the Student Grade Calculator*****");

        do {// begin do...while
            // Get Students First/Last name
            GetFirstLastName();
            // Get main menu options
            choice = GetMainMenuOptions();
            // Process the Menu options
            ProcessMenuOptions(choice);
            // Process Another Grade
            ProcessAnotherGrade();
        } while (ans.equalsIgnoreCase("y")); // end do...while
        // Goodbye msg
        System.out.print("Thank you for using the Student Grade Calculator!" + "\nGoodbye.");
    }// END MAIN METHOD

    // ------------------------------------//
    // GET Students First/Last Name
    // ------------------------------------//
    public static void GetFirstLastName() {
        do {// begin do..while
            try {// begin try
                 // Ask for input from user
                System.out.print("\nEnter Student's First Name: ");
                fName = sc.next();// save user input
                myGrad.setFirstName(fName);
                System.out.print("Enter Student's Last Name: ");
                lName = sc.next();// save user input
                myGrad.setLastName(lName);
                contloop = false;
            } // end try
            catch (InputMismatchException exception) {// begin catch
                System.err.print("Exception: " + exception + "\nPlease enter a valid name!");
                contloop = true;
                sc.nextLine();

            } // end catch
        } while (contloop); // end do...while
    }// end of method

    // ---------------------//
    // GetMainMenuOptions //
    // ---------------------//
    public static int GetMainMenuOptions() {
        do {// begin do..while
            try {// begin try
                System.out.print("\nPlease choose Student Type: " + "\n1. Under-Grad Student" + "\n2. Grad Student");
                System.out.print("\nChoice: ");
                choice = sc.nextInt();
                continueloop = false;
                // Checks for a number entered that is greate than 5
                if (choice > 3) {
                    System.err.print("You have entered incorrectly! \nPlease enter a number 1 thru 5. \n");
                    continueloop = true;
                } // end if
            } // end try
            catch (InputMismatchException exception) {
                System.err.println("Exception: " + exception + "\nPlease enter a valud number");
                continueloop = true;
                sc.nextLine();
            } // end catch
        } while (continueloop); // end do..while
        return choice;
    }// end method

    // -----------------------//
    // Process Meno Options //
    // -----------------------//

    public static void ProcessMenuOptions(int choice) {
        switch (choice) {
            case 1:
                GetNumberOfGrades();
                CalculateMidtermGrades();
                CalculateAverageFinalGradesUnderGrad();
                break;
            case 2:
                GetNumberOfGrades();
                CalculateFinalGrades();
                CalculateAverageFinalGradesGrad();
                break;
        }// end switch
    }// end method

    // -----------------------------------//
    // Get Number of Assignment Grades //
    // -----------------------------------//

    public static void GetNumberOfGrades() {
        do {// begin do loop
            try {
                // Ask for grades from user
                System.out.printf("Enter the number of assignment grades for %s %s: ", myGrad.getFirstName(),
                        myGrad.getLastName(), ":");
                numassigngrades = sc.nextInt(); // save input
                contloop = false;
            } // end try
            catch (InputMismatchException exception) {// begin catch
                System.err.print("Exception: " + exception + "\nPlease enter a valid number!");
                contloop = true;
                sc.nextLine();// save input
            } // end catch
        } while (contloop);// end do..while
        do { // begin do loop
            try { // begin try
                for (int i = 1; i <= numassigngrades; i++) {
                    // begin for loop
                    System.out.printf("Enter grade number %d: ", i);
                    gradenum = sc.nextInt(); // save input
                    contloop = false;
                    // Set the grades into the list array
                    myGrad.setStudentGrade(gradenum);
                } // end for loop
            } // end try
            catch (InputMismatchException exception) {
                // begin catch
                System.err.print("Exception: " + exception + "\nPlease enter a valid number!");
                contloop = true;
                sc.nextLine();

            } // end catch
        } while (contloop); // end do while
    }// end method

    // --------------------------//
    // Calculate Midterm Grades //
    // --------------------------//
    public static void CalculateMidtermGrades() {// begin method
        do {// begin do...while
            try {// begin try
                System.out.printf("Enter the Midterm grade for %s %s:", myGrad.getFirstName(), myGrad.getLastName());
                midterm = sc.nextInt();
                myGrad.setMidTerm(midterm);
                contloop = false;
            } // end try
            catch (InputMismatchException exception) {
                System.err.print("Exception: " + exception + "\nPlease enter a valid number!");
                contloop = true;
                sc.nextLine();
            } // end catch
        } while (contloop); // end do...while
    }// end method

    // -------------------------//
    // Calculate Final Grades //
    // -------------------------//
    public static void CalculateFinalGrades() {
        do {// begin do
            try {// begin try
                System.out.printf("Enter the Final Exam grade for %s %s: ", myGrad.getFirstName(),
                        myGrad.getLastName());
                FinalExamGrade = sc.nextInt();
                myGrad.setFin(FinalExamGrade);
                contloop = false;
            } // end try
            catch (InputMismatchException exception) {
                // begin catch
                System.err.print("Exception:" + exception + "\nPlease enter a valud number!");
                contloop = true;
                sc.nextLine();
            } // end catch
        } while (contloop);// end do..while
    }// end method

    // ----------------------------------------//
    // CalculateAverageFinalGradesUnderGrad //
    // ----------------------------------------//
    public static void CalculateAverageFinalGradesUnderGrad() {
        System.out.printf("\nThe average for %s %s is: %.2f\n", myGrad.getFirstName(), myGrad.getLastName(),
                myGrad.getAverage());

    }

    // ----------------------------------------//
    // CalculateAverageFinalGradesGrad //
    // ----------------------------------------//
    public static void CalculateAverageFinalGradesGrad() {
        System.out.printf("\nThe average for %s %s is: %.2f\n", myGrad.getFirstName(), myGrad.getLastName(),
                myGrad.getAverage());
        System.out.printf("\nThe final gradefor %s %s is: %.2f\n", myGrad.getFirstName(), myGrad.getLastName(),
                myGrad.getFin());

    }

    // -----------------------------------------//
    // Process Another Grade Calculation?? //
    // -----------------------------------------//

    public static void ProcessAnotherGrade() {
        do {
            try {
                System.out.print("\nEnter another student's grades? (Y for Yes, N for No):");
                ans = sc.next();
                contloop = false;

                if ((!ans.equalsIgnoreCase("y")) && (!ans.equalsIgnoreCase("n"))) {
                    System.err.print("Please enter a 'Y' to continue or 'N' to exit: ");
                    contloop = true;

                } // end if
            } // end try

            catch (InputMismatchException exception) {// begin catch
                System.err.print("Exception: " + exception + "\nPlease enter a Y or N!");
                contloop = true;
                sc.nextLine();
            } // end catch
        } while (contloop); // end do...while
    }
}// end main class
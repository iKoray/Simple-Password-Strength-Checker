import java.util.Scanner;

public class PasswordStrength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (password.contains(" ")) { //checks for space in user input
                System.out.println("Password should not contain spaces.");
                continue;
            }

            if (password.length() < 8) { // Check password length of at least 8
                System.out.println("Password should be at least 8 characters long.");
            } else {
                boolean hasUpper = false;
                boolean hasLower = false;
                boolean hasDigit = false;
                boolean hasSpecial = false;
                boolean hasSpace = false;


                // Defines the allowed special characters
                String specialCharacters = "~!#@$%^&*_-+=`|\\(){}[]:;\"'<>,.?/";

                for (int i = 0; i < password.length(); i++) { //Loop through the password to check each char
                    char c = password.charAt(i);

                    if (Character.isUpperCase(c)) {
                        hasUpper = true;
                    } else if (Character.isLowerCase(c)) {
                        hasLower = true;
                    } else if (Character.isDigit(c)) {
                        hasDigit = true;
                    } else if (specialCharacters.contains(Character.toString(c))) {
                        hasSpecial = true;
                    }
                }

                //Checks all requirements
                if (!hasUpper) {
                    System.out.println("Password should contain at least one uppercase letter (A-Z).");
                } else if (!hasLower) {
                    System.out.println("Password should contain at least one lowercase letter (a-z).");
                } else if (!hasDigit) {
                    System.out.println("Password should contain at least one number (0-9).");
                } else if (!hasSpecial) {
                    System.out.println("Password should contain at least one special character (~!#@$%^&*_-+=`|\\(){}[]:;\"'<>,.?/).");
                } else {
                    System.out.println("Password is strong!");
                    break; // Exit the loop if password meets all criteria
                }

                System.out.println("Please try again.\n");
            }
        }
        sc.close();
    }
}

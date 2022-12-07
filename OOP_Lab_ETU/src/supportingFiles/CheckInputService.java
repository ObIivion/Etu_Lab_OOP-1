package supportingFiles;

import java.util.Scanner;

public class CheckInputService {

    public static int inputInteger(int checkIntTo, String messageOfIncorrectInput) {

        int checkedInput = 1;
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            try {
                checkedInput = Integer.parseInt(input);
            } catch (Exception E) {
                System.out.println("Incorrect input of number (int)");
            }

            if ((checkedInput < 1) || (checkedInput > checkIntTo)) {
                System.out.println(messageOfIncorrectInput);
            } else {
                return checkedInput;
            }
        }
    }
}

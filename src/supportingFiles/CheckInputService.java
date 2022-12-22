package supportingFiles;

import java.util.Scanner;

/**
 * 	\brief Сервисный класс для проверки вводимых пользователем символов при взаимодействии с игрой (меню)
 * 	\version 1.0
 * 	\date Ноябрь 2022
 *
 * 	Сервисный класс для проверки вводимых пользователем символов при взаимодействии с игрой (меню)
 *
 */
public class CheckInputService {

    /**
     * 	Функция, которая проверяет введённое число
     * @param checkIntTo - максимально возможное число, которое может ввести пользователь (по сути - ограничение,
     *                   если введённое пользователем число больше - выведет ошибку)
     */
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

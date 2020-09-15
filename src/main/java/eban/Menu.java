package eban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private String[] args;

    public Menu(Scanner scanner) { this.scanner = scanner;
        args = new String[0];
    }

    public Menu(Scanner scanner, String[] args){

        this.scanner = scanner;

        this.args = new String[args.length];

        System.arraycopy(args, 0, this.args, 0, args.length);
    }


    private void printMenu(){
        System.out.println("1.Приветствовать любого пользователя при вводе его имени через командную строку.");
        System.out.println("2.Отобразить в окне консоли аргументы командной строки в обратном порядке.");
        System.out.println("3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.");
        System.out.println("4.Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.");
        System.out.println("5.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.");
        System.out.println("6.Выход");
    }

    public void start() throws IOException {
        if (this.scanner != null) {
            int key;
            do {
                printMenu();
                System.out.print("Введите номер меню: ");
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:

                        System.out.print("Введите свое имя: ");
                        String username = new Scanner(System.in).nextLine();
                        System.out.println("\nПривет " + username + "!\n");
                        break;

                    case 2:

                        System.out.println("Reverse : ");
                        for( int i = args.length - 1 ; i >= 0 ; i--)
                            System.out.print(args[i] + " ");
                        System.out.println("\n");

                        break;
                    case 3:

                        System.out.println("Введите количество элементов: ");
                        int count = new Scanner(System.in).nextInt();
                        System.out.println("\n");

                        RandomNumbers randomNumbers = new RandomNumbers(count);

                        System.out.println("без перехода на новую строку: ");
                        randomNumbers.printArray(); System.out.println("\n");

                        System.out.println("c переходом на новую строку: ");
                        randomNumbers.printlnArray(); System.out.println("\n");

                        break;
                    case 4:

                        try
                        {
                            int[] argsInt = new int[args.length];
                            for(int i = 0; i < args.length; i++)
                                argsInt[i] = Integer.parseInt(args[i]);

                            int sum = 0;
                            int pctOfNum = 1;
                            for (int j : argsInt) {
                                sum += j;
                                pctOfNum *= j;
                            }

                            System.out.println("Сумма : " + sum);
                            System.out.println("Произведение : " + pctOfNum);

                        }
                        catch (NumberFormatException nfe)
                        {
                            System.out.println("NumberFormatException: " + nfe.getMessage());
                        }

                        break;
                    case 5:

                        System.out.print("Введите номер месяца: ");
                        int num = new Scanner(System.in).nextInt();
                        System.out.print("\n");

                        while(num < 1 || num > 12){
                            System.out.println("Некорректное число!");
                            System.out.print("Введите номер месяца: ");
                            num = new Scanner(System.in).nextInt();
                            System.out.print("\n");
                        }

                        System.out.println(new Month(num).getMonth());

                        break;
                    case 6:

                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }

                System.out.print("1.Продолжить ? Y: ");
                String proceed = new BufferedReader(new InputStreamReader(System.in)).readLine();

                if(!proceed.toUpperCase().equals("Y")) key = 6;

                System.out.print("\n");

            } while (key != 6);
        }
    }
}


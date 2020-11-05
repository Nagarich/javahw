import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {


        do{
          guessTheNumberGame();
            System.out.println();
            int startNewGame;
            do {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                startNewGame=takeNumberFromConsole();
            } while (startNewGame!=0 && startNewGame!=1);

            if (startNewGame!=1)
                break;

        }while (true);

        guessTheWordGame();
    }

    public static int takeNumberFromConsole()
    {
        do {
            int inputedNumber;
            try
            {
                Scanner scanner = new Scanner(System.in);
                inputedNumber = scanner.nextInt();
                return inputedNumber;
            } catch (Exception ex) {
                System.out.println("Допустим ввод только числа");
            }

        } while (true);
    }

    public static void guessTheNumberGame()
    {

        int inputedNumber=0;
        int randomNumber = (int) (Math.random() * 10);
        for (int tryNumber=1;tryNumber<=3;tryNumber++)
        {
            System.out.println("Попытка "+tryNumber+" из 3. Угадайте число от 0 до 9");

            inputedNumber =takeNumberFromConsole();
            if (inputedNumber == randomNumber)
            {
                System.out.println("Поздравляю! Вы угадали число!");
                break;
            }
            else if (inputedNumber > randomNumber)
                System.out.println("Загаданное число меньше "+inputedNumber);
            else
                System.out.println("Загаданное число больше "+inputedNumber);

        }
        System.out.println("Игра завершена");
    }

    public static void guessTheWordGame()
    {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        String randomWord = words[(int) (Math.random() * 25)];
        System.out.println();
        System.out.println("Мы загодали секретное слово! Попробуй угадать!");
        String inputWord;
        do {
            System.out.println("Введите загаданное слово");
            inputWord=scanner.nextLine();
            inputWord.toLowerCase();

            if (randomWord.equals(inputWord))
            {
                System.out.println("Слово угадано!");
                break;
            }

            String showString = "";
            int minLenght = Math.min(inputWord.length(), randomWord.length());
            for (int indexOfChar=0; indexOfChar < minLenght; indexOfChar++)
                showString = showString + ((inputWord.charAt(indexOfChar) == randomWord.charAt(indexOfChar)) ? inputWord.charAt(indexOfChar) : '!') ;

            for (int i=minLenght; i < 15; i++)
                showString += "!";

            System.out.println("Вы не угадали слово "+showString);

        } while (true);

       System.out.println("Игра завершена");
    }

}

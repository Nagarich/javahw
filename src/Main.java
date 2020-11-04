import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        boolean startNewGame = true;
        Scanner scanner = new Scanner(System.in);
        while (startNewGame)
        {
            guessTheNumberGame();
            System.out.println();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

            int inputedNumber = scanner.nextInt();
            startNewGame = (inputedNumber==1) ? startNewGame : false;
        }

        guessTheWordGame();
    }
    public static void guessTheNumberGame()
    {

        int inputedNumber=0;
        int randomNumber = (int) (Math.random() * 10);
        for (int tryNumber=1;tryNumber<=3;tryNumber++)
        {
            System.out.println("Попытка "+tryNumber+" из 3. Угадайте число от 0 до 9");

            try
            {
                Scanner scanner = new Scanner(System.in);
                inputedNumber = scanner.nextInt();
            } catch (Exception ex)
            {
                System.out.println("Допустим ввод только числа");
                tryNumber--;
                continue;
            }

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
        //System.out.println("Выводим слово для отладки " + randomWord);
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

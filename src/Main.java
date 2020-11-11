import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static int MAP_SIZE = 7;
    public static int CHAR_TO_WIN = 3;
    public static char CHAR_X = 'X';
    public static char CHAR_O = 'O';
    public static char CHAR_EMPTY = '•';
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

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

    public static void newMap()
    {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++)
            for (int y = 0; y < MAP_SIZE; y++)
                map[i][y] = CHAR_EMPTY;
    }
    public static void showMap()
    {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < MAP_SIZE; i++)
            System.out.print(i+" ");
        System.out.println();

        for (int v = 0; v < MAP_SIZE; v++)
        {
            System.out.print(v+" ");
            for (int h = 0; h < MAP_SIZE; h++)
               System.out.print(map[v][h]+"|");
            System.out.println();
        }
   }
    public static void getPlayerTurn()
    {
        int x, y;
        do {
            System.out.println("Введите координаты поля в формате XY");
            String xy = scanner.nextLine();

            if (xy.length()==2)
            {
                x = Character.getNumericValue(xy.charAt(0));
                y = Character.getNumericValue(xy.charAt(1));
                if (x >= 0 && x < MAP_SIZE && y >= 0 && y < MAP_SIZE)
                    if (map[x][y]==CHAR_EMPTY)
                        break;
            }
        } while (true);
        map[x][y] = CHAR_X;
    }
    public static boolean itIsWin(char WIN_CHAR)
    {
        int charCount;
        //проверим по горизонтали
        for (int x = 0; x < MAP_SIZE; x++)
        {
            charCount =0;

            for (int y = 0; y < MAP_SIZE; y++)
                if (map[x][y]==WIN_CHAR) {
                    charCount++;
                    if (charCount==CHAR_TO_WIN)
                        return true;
                }
                else
                    charCount=0;
        }
        //провери по вертикали
        for (int x = 0; x < MAP_SIZE; x++)
        {
            charCount =0;

            for (int y = 0; y < MAP_SIZE; y++)
                if (map[y][x]==WIN_CHAR) {
                    charCount++;
                    if (charCount==CHAR_TO_WIN)
                        return true;
                }
                else
                    charCount=0;
        }


        int maxIndex=MAP_SIZE-1;

        //первая диагональ
        for (int n = maxIndex; n >=-maxIndex ; n--)
        {
            //System.out.println();
            charCount =0;
            if (n>=0)
            {
                int y=0;
                for (int x = n; x <= maxIndex; x++)
                {

                    if (map[x][y]==WIN_CHAR)
                    {
                        charCount++;
                        if (charCount==CHAR_TO_WIN)
                            return true;
                    }
                        else
                            charCount=0;

                    y++;
                }
            } else
            {
                int y=0;
                for (int x = -n; x <= maxIndex; x++)
                {

                    if (map[y][x]==WIN_CHAR)
                    {
                        charCount++;
                        if (charCount==CHAR_TO_WIN)
                            return true;
                    }
                    else
                        charCount=0;

                    y++;
                }
            }

        }

        //вторая диагональ
        for (int n=0;n<=MAP_SIZE*2-1;n++)
        {
            //System.out.println();
            charCount =0;
            if (n<=maxIndex)
            {
                int y=0;
                for (int x=n;x>=0;x--)
                {
                    if (map[x][y]==WIN_CHAR)
                    {
                        charCount++;
                        if (charCount==CHAR_TO_WIN)
                            return true;
                    }
                    else
                        charCount=0;

                    y++;
                }
            }else
            {
                int x=maxIndex;
                for (int y=n-maxIndex;y<=maxIndex;y++)
                {
                    if (map[x][y]==WIN_CHAR)
                    {
                        charCount++;
                        if (charCount==CHAR_TO_WIN)
                            return true;
                    }
                    else
                        charCount=0;

                    x--;
                }
            }
        }

        return false;
    }

    public static int[] canWinInTurn(char WIN_CHAR) {
        int[] winIndex = new int[2];
        int numberOfPhases = MAP_SIZE - CHAR_TO_WIN + 1;

        for (int x = 0; x < MAP_SIZE; x++)
        {

            for (int i = 1; i <= numberOfPhases; i++)
            {
                //посчитаем символы
                int countWinChar = 0;
                int countEmptyChar = 0;
                int indexEmptyChar = 0;
                for (int z = 0; z < CHAR_TO_WIN; z++) {
                    int charIndex = i + z - 1;
                    char curChar = map[x][charIndex];
                    if (curChar == WIN_CHAR)
                        countWinChar++;

                    else if (curChar == CHAR_EMPTY) {
                        countEmptyChar++;
                        indexEmptyChar = charIndex;
                    }
                }
                if (countWinChar == CHAR_TO_WIN - 1 && countEmptyChar == 1) {
                    winIndex[0] = x;
                    winIndex[1] = indexEmptyChar;
                    return winIndex;
                }

            }
        }
            for (int x = 0; x < MAP_SIZE; x++)
            {

                for (int i = 1; i <= numberOfPhases; i++)
                {
                    //посчитаем символы
                    int countWinChar = 0;
                    int countEmptyChar = 0;
                    int indexEmptyChar = 0;
                    for (int z = 0; z < CHAR_TO_WIN; z++) {
                        int charIndex=i + z - 1;
                        char curChar = map[charIndex][x];
                        if (curChar == WIN_CHAR)
                            countWinChar++;

                        else if (curChar == CHAR_EMPTY) {
                            countEmptyChar++;
                            indexEmptyChar = charIndex;
                        }
                    }
                    if (countWinChar == CHAR_TO_WIN - 1 && countEmptyChar == 1)
                    {

                        winIndex[0]=indexEmptyChar;
                        winIndex[1]=x;

                        return winIndex;
                    }

                }

            }

        //первая диагональ
        int maxIndex = MAP_SIZE-1;
        for (int n = maxIndex-CHAR_TO_WIN+1; n >=-(maxIndex-CHAR_TO_WIN+1) ; n--)
        {

            //System.out.println();

            if (n>=0)
            {
                numberOfPhases=MAP_SIZE-n-CHAR_TO_WIN;

                for (int nop = 0; nop<=numberOfPhases;nop++)
                {

                    //System.out.println();
                    //посчитаем символы
                    int countWinChar = 0;
                    int countEmptyChar = 0;
                    int indexEmptyChar = 0;

                    int z=0;
                    int y = 0+nop;
                    for (int x = n+nop; x <= maxIndex; x++)
                    {


                        //System.out.println(""+x+" "+y);
                        char curChar = map[x][y];
                        if (curChar == WIN_CHAR)
                            countWinChar++;

                        else if (curChar == CHAR_EMPTY) {
                            countEmptyChar++;
                            winIndex[0]=x;
                            winIndex[1]=y;

                        }


                        y++;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countWinChar == CHAR_TO_WIN - 1 && countEmptyChar == 1)
                    {


                        return winIndex;
                    }

                }
            } else
            {
                numberOfPhases=MAP_SIZE+n-CHAR_TO_WIN;
                for (int nop = 0; nop<=numberOfPhases;nop++)
                {

                    //System.out.println();
                    //посчитаем символы
                    int countWinChar = 0;
                    int countEmptyChar = 0;
                    int indexEmptyChar = 0;

                    int z=0;
                int x=0+nop;
                for (int y = -n+nop; y <= maxIndex; y++)
                {

                    //if (map[x][y]==CHAR_X)
                    //System.out.println(""+x+" "+y);
                    char curChar = map[x][y];
                    if (curChar == WIN_CHAR)
                        countWinChar++;

                    else if (curChar == CHAR_EMPTY) {
                        countEmptyChar++;
                        winIndex[0]=x;
                        winIndex[1]=y;

                    }



                    x++;
                    z++;
                    if (z==CHAR_TO_WIN)
                        break;
                }
                    if (countWinChar == CHAR_TO_WIN - 1 && countEmptyChar == 1)
                    {


                        return winIndex;
                    }

                }
            }

        }
        //вторая диагональ
        for (int n=CHAR_TO_WIN-1;n<=MAP_SIZE*2-1-CHAR_TO_WIN;n++)
        {
            //System.out.println();

            if (n<=maxIndex)
            {
                numberOfPhases=n-CHAR_TO_WIN+1;
                for (int nop = 0; nop<=numberOfPhases;nop++)
                {
                    int countWinChar = 0;
                    int countEmptyChar = 0;
                    int indexEmptyChar = 0;
                    int z=0;
                    int y = 0+nop;
                    for (int x = n-nop; x >= 0; x--) {
                        //System.out.println(""+x+" "+y);
                        char curChar = map[x][y];
                        if (curChar == WIN_CHAR)
                            countWinChar++;

                        else if (curChar == CHAR_EMPTY) {
                            countEmptyChar++;
                            winIndex[0]=x;
                            winIndex[1]=y;

                        }

                        y++;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countWinChar == CHAR_TO_WIN - 1 && countEmptyChar == 1)
                    {


                        return winIndex;
                    }

                }
            }else
            {
                numberOfPhases=n-MAP_SIZE;
                for (int nop = 0; nop<=numberOfPhases;nop++)
                {
                    int countWinChar = 0;
                    int countEmptyChar = 0;
                    int indexEmptyChar = 0;
                    int z=0;

                    int x = maxIndex-nop;
                    for (int y = n - maxIndex+nop; y <= maxIndex; y++) {
                        char curChar = map[x][y];
                        if (curChar == WIN_CHAR)
                            countWinChar++;

                        else if (curChar == CHAR_EMPTY) {
                            countEmptyChar++;
                            winIndex[0]=x;
                            winIndex[1]=y;

                        }

                        x--;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countWinChar == CHAR_TO_WIN - 1 && countEmptyChar == 1)
                    {


                        return winIndex;
                    }

                }
            }
        }

        return new int[] {-1,-1};
    }

    public static boolean getUITurn()
    {
        int[] winDotindex;

        //проверим может ли компьютер выиграть следующим ходом
        winDotindex = canWinInTurn(CHAR_O);
        if (winDotindex[0]!=-1)
        {
            map[winDotindex[0]][winDotindex[1]] = CHAR_O;
            return true;
        }

        //проверим может ли игрок выиграть следующим ходом
        winDotindex = canWinInTurn(CHAR_X);
        if (winDotindex[0]!=-1)
        {
            map[winDotindex[0]][winDotindex[1]] = CHAR_O;
            return true;
        }



        //просчитаем ход компьютера
        boolean movesDone=calculateUITorn();
        return movesDone;


    }
    public static boolean calculateUITorn()
    {

        int[][] possibleMoves = new int[MAP_SIZE*MAP_SIZE*CHAR_TO_WIN][2];
        int countOfMoves = 0;
        int weightOfMoves = 0;
        String savedMoves ="";

        int numberOfPhases = MAP_SIZE - CHAR_TO_WIN + 1;

        //по горизонтали
        for (int x = 0; x < MAP_SIZE; x++)
        {

            for (int i = 1; i <= numberOfPhases; i++)
            {
                //посчитаем символы
                int countCharX = 0;
                int countCharO = 0;
                int countCharEmpty = 0;

                for (int z = 0; z < CHAR_TO_WIN; z++)
                {
                    int charIndex = i + z - 1;
                    char curChar = map[x][charIndex];
                    if (curChar == CHAR_X) countCharX++;
                    else if (curChar == CHAR_O) countCharO++;
                    else if (curChar == CHAR_EMPTY) countCharEmpty++;
                }

                if (countCharX == 0 && countCharEmpty != 0 && weightOfMoves<=countCharO)
                {
                    if (weightOfMoves<countCharO)
                    {
                        countOfMoves=0;
                        weightOfMoves=countCharO;
                        savedMoves="";
                    }
                    for (int z = 0; z < CHAR_TO_WIN; z++)
                    {
                        int charIndex = i + z - 1;
                        char curChar = map[x][charIndex];
                        if (curChar == CHAR_EMPTY)
                        {
                            String patt="!"+x+"_"+charIndex+"!";

                            if (savedMoves.contains(patt)==false)
                            {
                                savedMoves = savedMoves +patt;
                                possibleMoves[countOfMoves][0] = x;
                                possibleMoves[countOfMoves][1] = charIndex;
                                countOfMoves++;
                                //System.out.println("weightOfMoves "+weightOfMoves+" x "+x+" y "+charIndex);
                            }
                        }
                    }
                }

            }
        }
        //по вертикали
        for (int y = 0; y < MAP_SIZE; y++)
        {

            for (int i = 1; i <= numberOfPhases; i++)
            {
                //посчитаем символы
                int countCharX = 0;
                int countCharO = 0;
                int countCharEmpty = 0;

                for (int z = 0; z < CHAR_TO_WIN; z++)
                {
                    int charIndex = i + z - 1;
                    char curChar = map[charIndex][y];
                    if (curChar == CHAR_X) countCharX++;
                    else if (curChar == CHAR_O) countCharO++;
                    else if (curChar == CHAR_EMPTY) countCharEmpty++;
                }

                if (countCharX == 0 && countCharEmpty != 0 && weightOfMoves<=countCharO)
                {
                    if (weightOfMoves<countCharO)
                    {
                        countOfMoves=0;
                        weightOfMoves=countCharO;
                        savedMoves="";
                    }
                    for (int z = 0; z < CHAR_TO_WIN; z++)
                    {
                        int charIndex = i + z - 1;
                        char curChar = map[charIndex][y];
                        if (curChar == CHAR_EMPTY)
                        {
                            String patt="!"+charIndex+"_"+y+"!";

                            if (savedMoves.contains(patt)==false)
                            {
                                savedMoves = savedMoves +patt;
                                possibleMoves[countOfMoves][0] = charIndex;
                                possibleMoves[countOfMoves][1] = y;
                                countOfMoves++;
                                //System.out.println("weightOfMoves "+weightOfMoves+" x "+charIndex+" y "+y);
                            }
                        }
                    }
                }

            }
        }

        //первая диагональ
        int maxIndex = MAP_SIZE-1;
        for (int n = maxIndex-CHAR_TO_WIN+1; n >=-(maxIndex-CHAR_TO_WIN+1) ; n--)
        {
            if (n>=0)
            {
                numberOfPhases=MAP_SIZE-n-CHAR_TO_WIN;

                for (int nop = 0; nop<=numberOfPhases;nop++)
                {

                    //посчитаем символы
                    int countCharX = 0;
                    int countCharO = 0;
                    int countCharEmpty = 0;

                    int z=0;
                    int y = 0+nop;
                    for (int x = n+nop; x <= maxIndex; x++)
                    {
                        char curChar = map[x][y];
                        if (curChar == CHAR_X) countCharX++;
                        else if (curChar == CHAR_O) countCharO++;
                        else if (curChar == CHAR_EMPTY) countCharEmpty++;

                        y++;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countCharX == 0 && countCharEmpty != 0 && weightOfMoves<=countCharO)
                    {
                        if (weightOfMoves<countCharO)
                        {
                            countOfMoves=0;
                            weightOfMoves=countCharO;
                            savedMoves="";
                        }
                        z=0;
                        y = 0+nop;
                        for (int x = n+nop; x <= maxIndex; x++)
                        {
                            char curChar = map[x][y];
                            if (curChar == CHAR_EMPTY)
                            {
                                String patt="!"+x+"_"+y+"!";

                                if (savedMoves.contains(patt)==false)
                                {
                                    savedMoves = savedMoves +patt;
                                    possibleMoves[countOfMoves][0] = x;
                                    possibleMoves[countOfMoves][1] = y;
                                    countOfMoves++;
                                    //System.out.println("weightOfMoves "+weightOfMoves+" x "+x+" y "+y);
                                }
                            }
                            y++;
                            z++;
                            if (z==CHAR_TO_WIN)
                                break;

                        }
                    }

                }
            } else
            {
                numberOfPhases=MAP_SIZE+n-CHAR_TO_WIN;
                for (int nop = 0; nop<=numberOfPhases;nop++)
                {
                    //посчитаем символы
                    int countCharX = 0;
                    int countCharO = 0;
                    int countCharEmpty = 0;

                    int z=0;
                    int x=0+nop;
                    for (int y = -n+nop; y <= maxIndex; y++)
                    {

                        char curChar = map[x][y];
                        if (curChar == CHAR_X) countCharX++;
                        else if (curChar == CHAR_O) countCharO++;
                        else if (curChar == CHAR_EMPTY) countCharEmpty++;

                        x++;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countCharX == 0 && countCharEmpty != 0 && weightOfMoves<=countCharO)
                    {
                        if (weightOfMoves<countCharO)
                        {
                            countOfMoves=0;
                            weightOfMoves=countCharO;
                            savedMoves="";
                        }
                        z=0;
                        x=0+nop;
                        for (int y = -n+nop; y <= maxIndex; y++)
                        {
                            char curChar = map[x][y];
                            if (curChar == CHAR_EMPTY)
                            {
                                String patt="!"+x+"_"+y+"!";

                                if (savedMoves.contains(patt)==false)
                                {
                                    savedMoves = savedMoves +patt;
                                    possibleMoves[countOfMoves][0] = x;
                                    possibleMoves[countOfMoves][1] = y;
                                    countOfMoves++;
                                    //System.out.println("weightOfMoves "+weightOfMoves+" x "+x+" y "+y);
                                }
                            }
                            x++;
                            z++;
                            if (z==CHAR_TO_WIN)
                                break;

                        }
                    }

                }
            }

        }

        //вторая диагональ
        for (int n=CHAR_TO_WIN-1;n<=MAP_SIZE*2-1-CHAR_TO_WIN;n++)
        {
            //System.out.println();

            if (n<=maxIndex)
            {
                numberOfPhases=n-CHAR_TO_WIN+1;
                for (int nop = 0; nop<=numberOfPhases;nop++)
                {
                    //посчитаем символы
                    int countCharX = 0;
                    int countCharO = 0;
                    int countCharEmpty = 0;

                    int z=0;
                    int y = 0+nop;
                    for (int x = n-nop; x >= 0; x--)
                    {
                        char curChar = map[x][y];
                        if (curChar == CHAR_X) countCharX++;
                        else if (curChar == CHAR_O) countCharO++;
                        else if (curChar == CHAR_EMPTY) countCharEmpty++;

                        y++;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countCharX == 0 && countCharEmpty != 0 && weightOfMoves<=countCharO)
                    {
                        if (weightOfMoves<countCharO)
                        {
                            countOfMoves=0;
                            weightOfMoves=countCharO;
                            savedMoves="";
                        }
                        z=0;
                        y = 0+nop;
                        for (int x = n-nop; x >= 0; x--)
                        {
                            char curChar = map[x][y];
                            if (curChar == CHAR_EMPTY)
                            {
                                String patt="!"+x+"_"+y+"!";

                                if (savedMoves.contains(patt)==false)
                                {
                                    savedMoves = savedMoves +patt;
                                    possibleMoves[countOfMoves][0] = x;
                                    possibleMoves[countOfMoves][1] = y;
                                    countOfMoves++;
                                    //System.out.println("weightOfMoves "+weightOfMoves+" x "+x+" y "+y);
                                }
                            }
                            y++;
                            z++;
                            if (z==CHAR_TO_WIN)
                                break;

                        }
                    }

                }
            }else
            {
                numberOfPhases=n-MAP_SIZE;
                for (int nop = 0; nop<=numberOfPhases;nop++)
                {
                    //посчитаем символы
                    int countCharX = 0;
                    int countCharO = 0;
                    int countCharEmpty = 0;

                    int z=0;
                    int x = maxIndex-nop;
                    for (int y = n - maxIndex+nop; y <= maxIndex; y++) {
                        char curChar = map[x][y];
                        if (curChar == CHAR_X) countCharX++;
                        else if (curChar == CHAR_O) countCharO++;
                        else if (curChar == CHAR_EMPTY) countCharEmpty++;

                        x--;
                        z++;
                        if (z==CHAR_TO_WIN)
                            break;
                    }
                    if (countCharX == 0 && countCharEmpty != 0 && weightOfMoves<=countCharO)
                    {
                        if (weightOfMoves<countCharO)
                        {
                            countOfMoves=0;
                            weightOfMoves=countCharO;
                            savedMoves="";
                        }
                        z=0;
                        x = maxIndex-nop;
                        for (int y = n - maxIndex+nop; y <= maxIndex; y++)
                        {
                            char curChar = map[x][y];
                            if (curChar == CHAR_EMPTY)
                            {
                                String patt="!"+x+"_"+y+"!";

                                if (savedMoves.contains(patt)==false)
                                {
                                    savedMoves = savedMoves +patt;
                                    possibleMoves[countOfMoves][0] = x;
                                    possibleMoves[countOfMoves][1] = y;
                                    countOfMoves++;
                                    //System.out.println("weightOfMoves "+weightOfMoves+" x "+x+" y "+y);
                                }
                            }
                            x--;
                            z++;
                            if (z==CHAR_TO_WIN)
                                break;

                        }
                    }

                }
            }
        }

        countOfMoves--;
        if (countOfMoves==-1) return false;
        //System.out.println("countOfMoves "+countOfMoves);
        //System.out.println("weightOfMoves "+weightOfMoves);
        int indexRandomMoves=rand.nextInt(countOfMoves);
        map[possibleMoves[indexRandomMoves][0]][possibleMoves[indexRandomMoves][1]]=CHAR_O;
        return true;
    }

    public static void setMAP_SIZE()
    {
        while (true)
        {
            System.out.println("Введите размер игрового поля от 1 до 9");
            int mp=takeNumberFromConsole();
            if (mp>=1 & mp<=9)
            {
                MAP_SIZE=mp;
                break;
            }
        }

    }
    public static void setCHAR_TO_WIN()
    {
        while (true)
        {
            System.out.println("Введите размер победного ряда от 3 до 9");
            int mp=takeNumberFromConsole();
            if (mp>=3 & mp<=9)
            {
                CHAR_TO_WIN=mp;
                break;
            }
        }

    }

    public static void main(String[] args)
        {
            setMAP_SIZE();
            setCHAR_TO_WIN();

            //Создадим пустую карту
            newMap();

            //начинаем игру
            while (true)
            {
                //Покажем карту
                showMap();

                //получим ход игрока
                getPlayerTurn();

                //проверим выиграл ли игрок
                if (itIsWin(CHAR_X))
                {
                    showMap();
                    System.out.println("Поздравляем вы выиграли!");
                    break;
                }

                //теперь ход компьютера
                boolean movesDone=getUITurn();
                if (movesDone==false)
                {
                    showMap();
                    System.out.println("Ничья!");
                    break;
                }

                //проверим выиграл ли компьютер
                if (itIsWin(CHAR_O))
                {
                    showMap();
                    System.out.println("Ты проиграл, жалкий человечишка!");
                    break;
                }
            }


      }
}


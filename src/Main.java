import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 1 задание
        // Задать целочисленный массив, состоящий из элементов 0 и 1.
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("1 задание");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив             " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++)
            array[i] = (array[i] == 1) ? 0 : 1;
        System.out.println("Массив после замены 0 и 1   " + Arrays.toString(array));


        // 2 задание
        //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
        System.out.println();
        System.out.println("2 задание");
        int[] arrayToFill = new int[8];
        System.out.println("Массив до    заполнения " + Arrays.toString(arrayToFill));
        for (int i = 0; i < arrayToFill.length; i++)
            arrayToFill[i] = i * 3;
        System.out.println("Массив после заполнения " + Arrays.toString(arrayToFill));

        // 3 задание
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
        System.out.println();
        System.out.println("3 задание");
        int[] arrayToMultiply = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Массив до умножения чисел < 6 на 2    " + Arrays.toString(arrayToMultiply));
        for (int i = 0; i < arrayToMultiply.length; i++)
            if (arrayToMultiply[i] < 6)
                arrayToMultiply[i] *= 2;
        System.out.println("Массив после умножения чисел < 6 на 2 " + Arrays.toString(arrayToMultiply));

        //4 задание
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        //и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        System.out.println();
        System.out.println("4 задание");
        int[][] arraySquare = new int[7][7];
        int arraySize = arraySquare.length - 1;
        for (int i = 0; i < arraySquare.length; i++)
            for (int y = 0; y < arraySquare.length; y++)
                if (i == y || i + y == arraySize)
                    arraySquare[i][y] = 1;
        System.out.println("Массив с заполненными диагональными элементами");
        for (int i = 0; i < arraySquare.length; i++)
            System.out.println(Arrays.toString(arraySquare[i]));

        //5 задание
        //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
        System.out.println();
        System.out.println("5 задание");
        int[] arrayMinMax = {1, 5, 3, 2, 11, 4, 5, -2, 4, 8, 9, 1};
        System.out.println("Массив для поиска минимального и максимального значения " + Arrays.toString(arrayMinMax));
        int minValue = 0, maxValue = 0;
        for (int i = 0; i < arrayMinMax.length; i++) {
            minValue = (i == 0 || arrayMinMax[i] < minValue) ? arrayMinMax[i] : minValue;
            maxValue = (i == 0 || arrayMinMax[i] > maxValue) ? arrayMinMax[i] : maxValue;
        }
        System.out.println("Минимальное значение в массиве:  " + minValue);
        System.out.println("Максимальное значение в массиве: " + maxValue);

        //6 задание
        //Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        System.out.println();
        System.out.println("6 задание");
        int[] arrayCheck1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arrayCheck2 = {2, 7, -2,};
        int[] arrayCheck3 = {1, 1, 1, 2, 1};

        System.out.println("В массиве " + Arrays.toString(arrayCheck1) + " равнозначные части " + (checkEqualPartsInArray(arrayCheck1) ? "найдены" : " не найдены"));
        System.out.println("В массиве " + Arrays.toString(arrayCheck2) + " равнозначные части " + (checkEqualPartsInArray(arrayCheck2) ? "найдены" : " не найдены"));
        System.out.println("В массиве " + Arrays.toString(arrayCheck3) + " равнозначные части " + (checkEqualPartsInArray(arrayCheck3) ? "найдены" : " не найдены"));

        //7 задание
        //Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        //при этом метод должен сместить все элементы массива на n позиций.
        //Для усложнения задачи нельзя пользоваться вспомогательными массивами

        //Самый простой способ сделать это было через последовательный сдвиг элементов в цикле.
        //Но это не интересно.
        //Решил придумать алгоритм, в котором каждый элемент переносится только один раз.


        System.out.println();
        System.out.println("7 задание");
        {
            int[] arrayForShift = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            System.out.println("Исходный массив до сдвига              " + Arrays.toString(arrayForShift));
        }
        for (int i = 0; i <= 12; i++) {
            int[] arrayForShift = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            arrayShift(arrayForShift, i);
            System.out.println("Сдвинули исходный массив на " + i + " элемента " + Arrays.toString(arrayForShift));
        }
        for (int i = 0; i >= -12; i--) {
            int[] arrayForShift = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            arrayShift(arrayForShift, i);
            System.out.println("Сдвинули исходный массив на " + i + " элемента " + Arrays.toString(arrayForShift));
        }

    }

    static void arrayShift(int[] array, int shift) {
        int arraySize = array.length;
        shift = shift % arraySize;
        if (shift == 0)
            return;

        int nod = arraySize;

        while (nod % shift != 0)
            nod = nod + arraySize;
        nod = (nod < 0) ? -nod : nod;

        int elemPerCicle = nod / shift;
        int accCicle = arraySize / elemPerCicle;
        elemPerCicle = (elemPerCicle < 0) ? -elemPerCicle : elemPerCicle;
        accCicle = (accCicle < 0) ? -accCicle : accCicle;

        for (int i = 1; i <= accCicle; i++) {
            int fromIndex = i - 1;
            int tempValue = array[fromIndex];
            for (int y = 1; y <= elemPerCicle; y++) {
                int toIndex = fromIndex + shift;
                if (toIndex > (arraySize - 1))
                    toIndex = toIndex - arraySize;
                else if (toIndex < 0)
                    toIndex = arraySize + toIndex;

                int teckValue = array[toIndex];
                array[toIndex] = tempValue;
                fromIndex = toIndex;
                tempValue = teckValue;
            }
        }
    }

    static boolean checkEqualPartsInArray(int[] array) {
        int arraySum = 0;
        int leftSum = 0;
        for (int i = 0; i < array.length; i++)
            arraySum += array[i];

        //Если сумма массива не делится надвое без остатка, значит нет точки равновесия в массие
        if (arraySum % 2 != 0)
            return false;

        int halfOfArraySum = arraySum / 2;

        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];

            if (leftSum == halfOfArraySum)
                return true;
        }
        return false;
    }


}

public class Main
{
    public static void main(String[] args)
    {
        //Возьмем тарелку, заполним ее едой
        Plate plate = new Plate(75);

        //Заведем 10 кошек
        Cat[] arrayOfCats = new Cat[10];
        for (int i=0;i<arrayOfCats.length;i++)
            arrayOfCats[i]=new Cat(10);

        //Покормим кошек
        feedTheCats(arrayOfCats,plate);

        //Проверим все ли кошки сыты
        //Если не все кошки сыты, то наполним тарелку и снова покормим кошек
        while (checkAllCatsSatiety(arrayOfCats)==false)
        {
            System.out.println("");
            System.out.println("Подкинем еды в тарелку");
            plate.increaseFood(10);
            System.out.println("Опять кормим кошек");
            feedTheCats(arrayOfCats,plate);
        }


    }

    static void feedTheCats(Cat[] arrayOfCats, Plate plate)
    {
        for (int i=0;i<arrayOfCats.length;i++)
            arrayOfCats[i].eat(plate);
    }
    static boolean checkAllCatsSatiety(Cat[] arrayOfCats)
    {
        boolean allCatsSatiety=true;
        for (int i=0;i<arrayOfCats.length;i++)
            if (arrayOfCats[i].checkSatiety()==true)
                System.out.println("Кошка сыта");
            else
            {
                System.out.println("Кошка голодна");
                allCatsSatiety=false;
            }
        return allCatsSatiety;
    }


}

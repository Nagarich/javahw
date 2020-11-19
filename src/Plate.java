public class Plate {
    private int amountOfFood;
    Plate(int amountOfFood)
    {
        this.amountOfFood=amountOfFood;
    }
    void increaseFood(int amountOfFood)
    {
        this.amountOfFood+=amountOfFood;
    }

    void reduceFood(int amountOfFood)
    {
        this.amountOfFood-=amountOfFood;
    }

    boolean enoughFood(int needFood)
    {
        return (needFood<=amountOfFood) ? true : false;
    }


}

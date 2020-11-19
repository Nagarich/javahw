public class Cat {

    private int appetite;
    private boolean satiety;

    Cat(int appetite)
    {
        this.appetite=appetite;
    }

    void eat(Plate plate)
    {
        if (satiety==false)
        {
            if (plate.enoughFood(appetite))
            {
                plate.reduceFood(appetite);
                satiety=true;
            }
        }
    }

    boolean checkSatiety()
    {
        return satiety;
    }

}

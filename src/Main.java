
public class Main
{
    public static void main(String[] args)
    {
        Dog dog1 = new Dog(400,100,0.5);
        Dog dog2 = new Dog(600,50,2);
        Cat cat = new Cat(100,2);


        dog1.run(300);
        dog1.swim(100);
        dog1.jump(5);

        dog2.run(300);
        dog2.swim(100);
        dog2.jump(1);

        cat.run(50);
        cat.swim(1);
        cat.jump(1);


    }


}

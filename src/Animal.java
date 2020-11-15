public class Animal {
    double run_limit;
    double swim_limit;
    double jump_limit;
    Animal(double run_limit,double swim_limit,double jump_limit)
    {
        this.run_limit=run_limit;
        this.swim_limit=swim_limit;
        this.jump_limit=jump_limit;
    }
    void run(double value)
    {
        System.out.println("run:"+((value<=run_limit) ? true : false));
    }
    void swim(double value)
    {
        System.out.println("swim:"+((value<=swim_limit) ? true : false));
    }
    void jump(double value)
    {
        System.out.println("jump:"+((value<=jump_limit) ? true : false));
    }
}

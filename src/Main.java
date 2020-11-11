public class Main
{
    public static void main(String[] args)
    {
        Employee[] EmployeeArray = new Employee[5];

        EmployeeArray[0] = new Employee("Иванов Иван Иванович","Скрипач","skripka@gg.ru","123123123",100000,20);
        EmployeeArray[1] = new Employee("Петров Петр Иванович","Гитарист","gitara@gg.ru","544565",110000,25);
        EmployeeArray[2] = new Employee("Сидоров Иван Петрович","Барабанщик","baraban@gg.ru","1123331",120000,40);
        EmployeeArray[3] = new Employee("Петров Сидор Иванович","Трубач","truba@gg.ru","5555555",130000,45);
        EmployeeArray[4] = new Employee("Сидоров Сидор Сидорович","Пианист","piano@gg.ru","999999",140000,50);

        for (int i=0;i<EmployeeArray.length;i++)
            if (EmployeeArray[i].age>40)
                EmployeeArray[i].showEmployee();
    }
}


class Employee
{
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    Employee(String name,String position,String email,String phone,int salary,int age)
    {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void showEmployee()
    {
        System.out.println("-------------------------------------");
        System.out.println("ФИО: "+name);
        System.out.println("Должность: "+position);
        System.out.println("email: "+email);
        System.out.println("Телефон: "+phone);
        System.out.println("Зарплата: "+salary);
        System.out.println("Возраст: "+age);
    }

}

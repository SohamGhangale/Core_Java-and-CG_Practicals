import java.util.Scanner;

class Person {
    String name;
    int age;

    // Input person details
    void getPersonData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
    }

    // Display person details
    void displayPersonData() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    int id;

    // Input employee details
    void getEmployeeData() {
        getPersonData();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Employee ID: ");
        id = sc.nextInt();
    }

    // Display employee details
    void displayEmployeeData() {
        displayPersonData();
        System.out.println("Employee ID: " + id);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.getEmployeeData();
        System.out.println("\n--- Employee Details ---");
        emp.displayEmployeeData();
    }
}

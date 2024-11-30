import java.util.Scanner;

class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

class Father {
    int age;

    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}

class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);
        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age");
        }
        this.sonAge = sonAge;
    }

    public int getSonAge() {
        return this.sonAge;
    }
}

public class exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter father's age: ");
            int fatherAge = scanner.nextInt();

            System.out.print("Enter son's age: ");
            int sonAge = scanner.nextInt();

            Son son1 = new Son(fatherAge, sonAge);
            System.out.println("Father's Age: " + son1.getAge());
            System.out.println("Son's Age: " + son1.getSonAge());

        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.print("Enter father's age: ");
            int fatherAge = scanner.nextInt();

            System.out.print("Enter son's age: ");
            int sonAge = scanner.nextInt();

            Son son2 = new Son(fatherAge, sonAge);

        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.print("Enter father's age: ");
            int fatherAge = scanner.nextInt();

            System.out.print("Enter son's age: ");
            int sonAge = scanner.nextInt();

            Son son3 = new Son(fatherAge, sonAge);

        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

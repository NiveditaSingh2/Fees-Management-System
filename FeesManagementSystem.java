import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String studentName;
    private double feesPaid;
    private double totalFees;

    public Student(String name, double totalFees) {
        this.studentName = name;
        this.totalFees = totalFees;
        this.feesPaid = 0;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees() {
        return totalFees - feesPaid;
    }
}

public class FeesManagementSystem {
    private static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFees Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fees");
            System.out.println("3. Check Fees Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    payFees(scanner);
                    break;
                case 3:
                    checkFeesStatus(scanner);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter total fees: ");
        double totalFees = scanner.nextDouble();

        if (students.containsKey(name)) {
            System.out.println("Student already exists.");
        } else {
            students.put(name, new Student(name, totalFees));
            System.out.println("Student added successfully.");
        }
    }

    private static void payFees(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        if (students.containsKey(name)) {
            Student student = students.get(name);
            System.out.print("Enter the amount to pay: ");
            double amount = scanner.nextDouble();
            student.payFees(amount);
            System.out.println("Payment successful.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void checkFeesStatus(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        if (students.containsKey(name)) {
            Student student = students.get(name);
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Total Fees: " + student.getTotalFees());
            System.out.println("Fees Paid: " + student.getFeesPaid());
            System.out.println("Remaining Fees: " + student.getRemainingFees());
        } else {
            System.out.println("Student not found.");
        }
    }
}
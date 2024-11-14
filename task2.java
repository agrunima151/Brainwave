import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int age;
    String address;
    String phoneNumber;
    String patientId;

    public Patient(String name, int age, String address, String phoneNumber, String patientId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.patientId = patientId;
    }
}

class PatientManagement {
    ArrayList<Patient> patients = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void registerPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        String patientId = "PAT" + (patients.size() + 1);

        Patient newPatient = new Patient(name, age, address, phoneNumber, patientId);
        patients.add(newPatient);
        System.out.println("Patient Registered with ID: " + patientId);
    }
}

class Appointment {
    String patientId;
    String date;
    String time;

    public Appointment(String patientId, String date, String time) {
        this.patientId = patientId;
        this.date = date;
        this.time = time;
    }
}

class AppointmentScheduler {
    ArrayList<Appointment> appointments = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Appointment Time (HH:MM): ");
        String time = scanner.nextLine();

        Appointment appointment = new Appointment(patientId, date, time);
        appointments.add(appointment);
        System.out.println("Appointment Scheduled for Patient ID " + patientId);
    }
}

class ElectronicHealthRecord {
    ArrayList<String> records = new ArrayList<>();

    public void viewEHR() {
        if (records.isEmpty()) {
            System.out.println("No records available.");
        } else {
            for (String record : records) {
                System.out.println("Record: " + record);
            }
        }
    }

    public void addRecord(String record) {
        records.add(record);
    }
}
class BillingSystem {
    Scanner scanner = new Scanner(System.in);

    public void generateBill() {
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Treatment Cost: ");
        double cost = scanner.nextDouble();
        System.out.print("Enter Additional Charges: ");
        double additionalCharges = scanner.nextDouble();

        double total = cost + additionalCharges;
        System.out.println("Generated Bill for Patient ID " + patientId + ": $" + total);
    }
}
class InventoryItem {
    String itemName;
    int quantity;

    public InventoryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
}

class InventoryManagement {
    ArrayList<InventoryItem> inventory = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void manageInventory() {
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        InventoryItem item = new InventoryItem(itemName, quantity);
        inventory.add(item);
        System.out.println("Inventory Updated for Item: " + itemName);
    }
}
class Staff {
    String name;
    String role;
    String staffId;

    public Staff(String name, String role, String staffId) {
        this.name = name;
        this.role = role;
        this.staffId = staffId;
    }
}

class StaffManagement {
    ArrayList<Staff> staffMembers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void manageStaff() {
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();
        String staffId = "STAFF" + (staffMembers.size() + 1);

        Staff staff = new Staff(name, role, staffId);
        staffMembers.add(staff);
        System.out.println("Staff Added with ID: " + staffId);
    }
}




public class task2 {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Management System!");

        PatientManagement patientManagement = new PatientManagement();
        AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
        ElectronicHealthRecord ehr = new ElectronicHealthRecord();
        BillingSystem billingSystem = new BillingSystem();
        InventoryManagement inventory = new InventoryManagement();
        StaffManagement staff = new StaffManagement();

        // Sample interaction loop
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View EHR");
            System.out.println("4. Process Billing");
            System.out.println("5. Manage Inventory");
            System.out.println("6. Manage Staff");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> patientManagement.registerPatient();
                case 2 -> appointmentScheduler.scheduleAppointment();
                case 3 -> ehr.viewEHR();
                case 4 -> billingSystem.generateBill();
                case 5 -> inventory.manageInventory();
                case 6 -> staff.manageStaff();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting system. Goodbye!");
        scanner.close();
    }
}

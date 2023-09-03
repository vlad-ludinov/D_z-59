package view;

import java.util.Scanner;

import controller.Controller;
import exception.InvalidDataFormatException;

public class View {
    
    Controller controller = new Controller();

    public void setProfile(String userData) {
        try {
            controller.setProfile(userData);
        } catch (InvalidDataFormatException e) {
            System.out.println(e.getClass().getSimpleName() + e.getMessage());
        }
    }

    public void saveIntoFile() {
        try {
            controller.saveIntoFile();
        } catch (Exception e) {
            System.out.println("Save exception: " + e.getClass().getSimpleName() + e.getMessage());
        }
    }

    public String inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data separated by a space (Surname, Name, FatherName, Date, PhoneNumber, Gender)");
        String result = scanner.nextLine();
        scanner.close();
        return result;
    }
}

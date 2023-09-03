package view;

import java.io.IOException;
import java.util.Scanner;

import controller.Controller;
import exception.InvalidDataFormatException;

public class View {
    
    Controller controller = new Controller();

    public String inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data separated by a space (Surname, Name, FatherName, Date, PhoneNumber, Gender)");
        String result = scanner.nextLine();
        scanner.close();
        return result;
    }

    public void start() {
        try {
            controller.setProfile(inputData());
            controller.saveIntoFile();
        } catch (InvalidDataFormatException e) {
            System.out.println(e.getClass().getSimpleName() + e.getMessage());
        } catch (IOException e) {
            System.out.println("Save exception: " + e.getClass().getSimpleName() + e.getMessage());
        }
    }
}

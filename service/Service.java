package service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import model.ProfileFormat;
import exception.InvalidDataFormatException;

public class Service {

    ProfileFormat profile = new ProfileFormat();

    public String getName() {
        return profile.getName();
    }
    
    public String getSurName() {
        return profile.getSurName();
    }
    
    public String getFatherName() {
        return profile.getFatherName();
    }
    
    public String getDate() {
        return profile.getDate();
    }
    
    public Long getPhone() {
        return profile.getPhone();
    }
    
    public Character getGender() {
        return profile.getGender();
    }
    
    public void setProfile(String userData) throws InvalidDataFormatException {
        String[] dataArr = userData.split("\\s+");
        if (dataArr.length != 6) {
            throw new InvalidDataFormatException("Invalid input format: user data format expected 6 elements(SurName, Name, FatherName, Date, PhoneNumber, Gender)");
        }
        profile.setSurName(dataArr[0]);
        profile.setName(dataArr[1]);
        profile.setFatherName(dataArr[2]);
        profile.setDate(dataArr[3]);
        profile.setPhone(dataArr[4]);
        profile.setGender(dataArr[5]);
    }

    public void saveIntoFile() throws IOException, FileNotFoundException {
        FileReader fileReader;
        FileWriter fileWriter;
        String file = "";
        if (Files.exists(new File(getSurName()).toPath())) {
            fileReader = new FileReader(new File(getSurName()));
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                file += scanner.nextLine();
                file += "\n";
            }
            System.out.println(file);
            fileWriter = new FileWriter(getSurName());
            fileWriter.write(file);
            fileWriter.write(   String.format("<%s><%s><%s><%s><%s><%s>",
                                getSurName(), getName(), getFatherName(),
                                getDate(), getPhone(), getGender()));
            fileReader.close();
            fileWriter.close();
        } else {
            fileWriter = new FileWriter(getSurName());
            fileWriter.write(   String.format("<%s><%s><%s><%s><%s><%s>",
                                getSurName(), getName(), getFatherName(),
                                getDate(), getPhone(), getGender()));
            fileWriter.close();
        }
    }
} 
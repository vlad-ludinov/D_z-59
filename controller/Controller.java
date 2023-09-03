package controller;
import java.io.FileNotFoundException;
import java.io.IOException;

import exception.InvalidDataFormatException;
import service.Service;

public class Controller {
    
    Service service = new Service();
    
    public void setProfile(String userData) throws InvalidDataFormatException {
        service.setProfile(userData);
    }

    public void saveIntoFile() throws IOException, FileNotFoundException {
        service.saveIntoFile();
    }
}

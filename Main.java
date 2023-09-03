import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.time.LocalDate;

public class Main {
    
    public static void main(String[] args) {
        
        
        try {
            if (Files.notExists(new File("test").toPath())) {
                System.out.println("yes");
            }
            FileWriter fileWriter = new FileWriter("test");
        } catch (Exception e) {

        }
    }
}

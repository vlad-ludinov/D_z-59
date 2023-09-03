package Exception;
public class InvalidDataFormatException extends RuntimeException {
    

    public InvalidDataFormatException(String message, Exception e) {
        super(message, e);
    }

    public InvalidDataFormatException(String message) {
        super(message);
    }

    public InvalidDataFormatException() {
        super();
    }



}

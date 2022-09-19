package userdefinedExceptions;

public class InvalidBrowserNameException extends RuntimeException{
    public InvalidBrowserNameException(String message){
        super(message);
    }
}

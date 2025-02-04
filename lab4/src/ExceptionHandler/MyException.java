package ExceptionHandler;

public class MyException extends Exception{
    public MyException() {  
        super("this is exception message"); 
    }

    public MyException(String message) {  
        super(message);
    }
}

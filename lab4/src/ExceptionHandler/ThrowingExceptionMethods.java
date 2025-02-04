package ExceptionHandler;

public class ThrowingExceptionMethods {
    public void One() throws MyException {
        throw new MyException("Exception from One()");
    }
    public void Two() throws MyException {
        throw new MyException("Exception from Two()");
    }
     public void Three() throws MyException {
        throw new MyException("Exception from Three()");
    }
}

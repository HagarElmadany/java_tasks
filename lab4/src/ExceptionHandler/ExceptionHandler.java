package ExceptionHandler;

public class ExceptionHandler {
     public static void main(String[] args) {
       ThrowingExceptionMethods EXC = new ThrowingExceptionMethods();
        try {
            EXC.One(); 
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        } 
        finally {
            System.out.println("executed after One()");
        }

        try {
            EXC.Two();
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("executed after Two()");
        }

        try {
            EXC.Three();
        } 
        catch (MyException e) {
            System.out.println(e.getMessage());
        } 
        finally {
            System.out.println("executed after Three()");
        }
     }
    
}


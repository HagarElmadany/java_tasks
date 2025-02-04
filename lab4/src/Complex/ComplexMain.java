package Complex;

public class ComplexMain {
    public static void main(String[] args) {
        ComplexOpertions c1 = new  ComplexOpertions(1.0,2.0);  
        ComplexOpertions c2 = new  ComplexOpertions(3.0,4.0);
        c1.add(c2);
        c1.subtract(c2);
        c1.product(c2);
        c1.div(c2);
    }
}

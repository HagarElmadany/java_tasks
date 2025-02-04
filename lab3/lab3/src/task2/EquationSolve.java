package task2;
import java.util.function.Function;

public class EquationSolve implements Function <double[],Double>{
@Override
    public Double apply (double[]coeffs){
        double a = coeffs[0];
        double b = coeffs[1];
        double c = coeffs[2];
        double discriminant =b*b - 4*a*c;
        return discriminant;
    };
    public double[] calcRoots(double a, double b, double disc) {
        double sqrtDisc = Math.sqrt(disc); 
        double root1 = (-b + sqrtDisc) / (2*a);  
        double root2 = (-b - sqrtDisc) / (2*a); 
        double[] roots = new double[]{root1, root2};
        return roots;
    };
    public void twoRealRoots(double[] coeffs, double disc) {
        double[] tworeal =calcRoots(coeffs[0],coeffs[1],disc); 
        System.out.println("Two Real Roots are "+tworeal[0]+" and "+tworeal[1]);
    };
    public void OneRoot(double a, double b) {
                double oneroot = (-b / 2*a);  
                System.out.println("One Root = "+oneroot);
    };
    public void complexRoots(double[] coeffs, double disc) {
        double real= -coeffs[1]/(2*coeffs[0]);
        double img= Math.sqrt(Math.abs(disc));
        System.out.println("Complex roots are "+real+"+i" +img +" and "+real+"-i" +img);
    };
    
    
}

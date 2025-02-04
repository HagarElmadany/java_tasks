package task2;

public class Equation {
    public static void main(String[]args){
        //double a=1,b=5,c=2;
        //double a=1,b=-2,c=1; 
        double a=1,b=1,c=1; 
        double[] coeffs2 = {a,b,c};
        EquationSolve obj = new EquationSolve();
        double disc2 = obj.apply(coeffs2);
        if(disc2>0)
        {
            obj.twoRealRoots(coeffs2,disc2);  
        }
        else if(disc2==0) {
               obj.OneRoot(a,b);  
        }
        else 
        {
            obj.complexRoots(coeffs2,disc2); 
        }
    }
}

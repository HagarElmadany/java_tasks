package Complex;

public class ComplexOpertions implements ComplexInterface<Double> {
    public Double real;
    public Double imag;

    public ComplexOpertions(Double real, Double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public Double getReal() {
        return real;
    }
    @Override
    public Double getImaginary() {
        return imag;
    }
    public void print() {
    if (imag >= 0) {
        System.out.println(real + " + " + imag + "i");
    } else {
        System.out.println(real + " - " + Math.abs(imag) + "i");
    }
    }
    @Override
    public ComplexOpertions add(ComplexInterface<Double> z) {
        ComplexOpertions result = new ComplexOpertions(real + z.getReal(),imag + z.getImaginary());
        System.out.print("c1+c2 = ");
        result.print(); 
        return result;
    }
    @Override
    public ComplexOpertions subtract(ComplexInterface<Double> z) {
       ComplexOpertions result = new ComplexOpertions(real - z.getReal(),imag - z.getImaginary());
        System.out.print("c1-c2 = ");
        result.print(); 
        return result;
    }
    @Override
    public ComplexOpertions product(ComplexInterface<Double> z) {
        double realPro = (real * z.getReal())-(imag * z.getImaginary());
        double imagPro = (real * z.getImaginary())+(imag * z.getReal());
        ComplexOpertions result = new ComplexOpertions(realPro, imagPro);
        System.out.print("c1*c2 = ");
        result.print();
        return result;
    }
    @Override
    public ComplexOpertions div(ComplexInterface<Double> z) {
        double denominator = (z.getReal() * z.getReal())+(z.getImaginary() * z.getImaginary());
        double realDiv = ((real * z.getReal())+(imag * z.getImaginary())) / denominator;
        double imagDiv = ((imag * z.getReal())-(real * z.getImaginary())) / denominator;
        ComplexOpertions result = new ComplexOpertions(realDiv, imagDiv);
        System.out.print("c1/c2 = ");
        result.print();
        return result;
    }

    
}

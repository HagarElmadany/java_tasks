package Complex;

public interface ComplexInterface <T>{
    T getReal();
    T getImaginary();
    
    ComplexInterface<T> add(ComplexInterface<T> z);
    ComplexInterface<T> subtract(ComplexInterface<T> z);
    ComplexInterface<T> product(ComplexInterface<T> z);
    ComplexInterface<T> div(ComplexInterface<T> z);
    
}

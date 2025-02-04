package temperature;
import java.util.function.Function;

public class Temperature {
    public static void main(String[] args) {
        float x= 24;
        float out = new Function<Float, Float>() {
            @Override
            public Float apply(Float t) {
                return (t*1.8f)+32; 
            }
        }.apply(x);
      System.out.println("Temp is ="+x+"c or "+out+"F");
    
    }
}

/* public class TemperatureConvert implements Function <Float,Float> {
    @Override
    public Float apply (Float t){
        float fahrenheit =(t*1.8f)+32;
        return fahrenheit;
    }
*/
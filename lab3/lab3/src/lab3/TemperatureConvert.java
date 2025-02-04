package lab3;
import java.util.function.Function;

public class TemperatureConvert implements Function <Float,Float> {
    @Override
    public Float apply (Float t){
        float fahrenheit =(t*1.8f)+32;
        return fahrenheit;
    }
}

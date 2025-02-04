package StreamApi;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Country{
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    //ctor
    public Country(String code,String name,String continent,double surfaceArea,int population,double gnp,int capital)
    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }
    //getter
    public String getCode()
    { 
        return code;
    }
    public String getName()
    { 
        return name;
    }
    public String getContinent()
    {
        return continent; 
    }
    public double getSurfaceArea()
    {
        return surfaceArea;
    }
    public int getPopulation()
    { 
        return population;
    }
    public double getGnp()
    {
        return gnp;
    }
    public int getCapital() 
    {
        return capital;
    }

}
class City{
    private int id;
    private String name;
    private int population;
    private String countryCode;
    //ctor
    public City(int id,String name,int population,String countryCode) 
    {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }
    //getter
    public int getId()
    {
        return id;
    }
    public String getName() 
    {
        return name; 
    }
    public int getPopulation() 
    {
        return population; 
    }
    public String getCountryCode()
    {
        return countryCode;
    }
    
}
public class CountriesCities{ 
    public static void main(String args[]){
        List<Country> countries = readCountries("countries.csv");
        List<City> cities = readCities("cities.csv");
        
        System.out.println("\nthe highest populated city of each country is:");
        HighestPopulatedCity(countries,cities);

        System.out.println("\nthe most populated country of each continentis:");
        PopulatedCountryContinent(countries);

        System.out.println("\nthe highest populated capital city is:");
        HighestPopulatedCapital(countries,cities);
    }
    //method to read data from countries.csv and add them to country list
    public static List<Country> readCountries(String filename) {
        List<Country> countries = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    String code = data[0].trim();
                    String name = data[1].trim();
                    String continent = data[2].trim();
                    double surfaceArea = Double.parseDouble(data[3].trim()); 
                    int population = Integer.parseInt(data[4].trim()); 
                    double gnp = Double.parseDouble(data[5].trim()); 
                    int capital = Integer.parseInt(data[6].trim());
                    countries.add(new Country(code,name,continent,surfaceArea,population,gnp,capital));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing record: " + line);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
    //method to read data from cities.csv and add them to city list
   public static List<City> readCities(String filename) {
        List<City> cities = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                cities.add(new City(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),data[3]));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return cities;
    }
    
    //method to Find the highest populated city of each country
   public static void HighestPopulatedCity(List<Country> countries,List<City> cities) {
    countries.forEach(country -> {
            cities.stream()
                .filter(city -> city.getCountryCode().equals(country.getCode()))
                .max(Comparator.comparingInt(City::getPopulation))
                .ifPresent(city -> System.out.println(country.getName()+ " => " +city.getName()));
        });
    }

    //method to Find the most populated country of each continent
    public static void PopulatedCountryContinent(List<Country> countries) {
        countries.stream()
            .collect(Collectors.groupingBy(Country::getContinent, 
                    Collectors.maxBy(Comparator.comparingInt(Country::getPopulation))))
            .forEach((continent,countrymax) -> countrymax.ifPresent(country ->
                    System.out.println(country.getName())));
    }
    
    //method to Find the highest populated capital city
    public static void HighestPopulatedCapital(List<Country> countries, List<City> cities) {
        countries.stream()
            .filter(country -> country.getCapital() != 0)
            .map(country -> cities.stream()
                    .filter(city -> city.getId() == country.getCapital())
                    .findFirst())
            .flatMap(Optional::stream)
            .max(Comparator.comparingInt(City::getPopulation))
            .ifPresent(city -> System.out.println(city.getName()));
    }    

    
    
}

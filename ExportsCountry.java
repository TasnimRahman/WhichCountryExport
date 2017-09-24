


import edu.duke.*;
import org.apache.commons.csv.*;


public class ExportsCountry
{
    public String countryInfo(CSVParser parser, String country) {
        String result = "";

        for (CSVRecord record : parser) {
            
            String countryName = record.get("Country");
            
            if (countryName.contains(country)) {
                
                String export = record.get("Exports");
                System.out.println(export);
                
                String value = record.get("Value (dollars)");
                System.out.println(value);
                
                result = country+" :"+export+" :"+value;
                
             }
         }
        return result;
     }
       
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
    }
}

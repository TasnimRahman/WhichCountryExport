


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
     
    public void listExportsTwoProducts(CSVParser parser , String exportItem1 , String exportItem2){
          
        for (CSVRecord record : parser) {
            
            String countryName = record.get("Exports");
            
            if (countryName.contains(exportItem1) && countryName.contains(exportItem2) ) {
                
                String export = record.get("Country");
                System.out.println(export);
                  }
            }
    }
    
    public int numberOfExports(CSVParser parser , String  exportItem){
                
        int count = 0;
        for (CSVRecord record : parser) {
            
            String countryName = record.get("Exports");
            
            if(countryName.contains(exportItem)){
              String export = record.get("Country");
              count = count + 1;
             
               }
            
            }
            return count;
      }
       
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
        parser = fr.getCSVParser();
        listExportsTwoProducts(parser ,"gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExports(parser , "gold"));
      }
}

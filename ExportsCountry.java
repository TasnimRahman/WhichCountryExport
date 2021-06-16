
import java.io.*;

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
      
    public void bigExporters(CSVParser parser , String amount){
            
            
          String amount1 = "";
          String amount2 = "";
          String amount3 = "";
            
          String value1 = "";
          String value2 = "";
          String value3 = "";
             
          for (CSVRecord record : parser) {
            
              String countryName = record.get("Value (dollars)");
            
              if(countryName.charAt(0) == '$'){
                
                  String export = record.get("Country");
                
                  amount1  = amount.replace("$" , "");
                  amount2  = amount1.replaceAll("," , "");
                  amount3 = amount2.trim();
                  String value = record.get("Value (dollars)");
              
              
                  value1  = value.replace("$" , "");
                  value2  = value1.replaceAll("," , "");
                  value3 = value2.trim();
              
              
              
                  long dollarAmount  = 0;
                  dollarAmount = Long.parseLong(amount3);
              
                  if(Long.parseLong(value3) >= dollarAmount){
                 
                    System.out.println(record.get("Country") + " :" + record.get("Value (dollars)"));
              
                  }
              }
           
          }
     }
            
       
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
        parser = fr.getCSVParser();
        listExportsTwoProducts(parser ,"gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExports(parser , "gold"));
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,9999,999");
      }
}

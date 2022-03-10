/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void countryInfo (CSVParser parser, String country){
        boolean found = false;
        for (CSVRecord record : parser) {
            String CountryName = record.get("Country");
            if (CountryName.contains(country)) {
                System.out.print((CountryName)+ ": ");
                System.out.print(record.get("Exports")+": ");
                System.out.println(record.get("Value (dollars)")+": ");
                found = true;
            }
        }
        if (!found) System.out.println("NOT FOUND");
    }
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem1) && (export.contains(exportItem2))){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public void numberOfExporters (CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)){
                count +=1;
            }
        }
    System.out.println(count);
    }
     public void bigExporters (CSVParser parser, String Amount){
        String totalAmount = "=$999,999,999,999"; 
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > totalAmount.length()) {
                System.out.print(record.get("Country")+ ": ");
                System.out.println(value);
            }
        }
    }
    
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        parser = fr.getCSVParser();
        numberOfExporters(parser, "sugar");
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
        parser = fr.getCSVParser();
    }
}
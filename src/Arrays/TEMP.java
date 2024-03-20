package Arrays;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class TEMP {

	public static void main(String[] args) {
		
	//	^(0[1-9]|1[0-2])//([012][1-9]|3[01])//(19|20)\d{2}$
		
	//	^(1[0-2]|[1-9])/(3[01]|[12][0-9]|[1-9])/(\d{4})$

	 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	   sdf.setLenient(false);
		
		 String [] searchStrings = new String [] {"2/29/1111" ,"2/29/2001" ,"11/31/2001","2/3/1999" ,"1/11/2001","11/1/2001",
				                                    "0/0/1990" ,"01/01/0001" ,"90/1/2001" ,"13/22/2001" ,"11/33/2009",
				                                    "01/01/2022", "02/14/2023", "12/31/2024", "10/1/2025", "6/30/2026",
				                                    "00/01/2022", "13/14/2023", "02/30/2024", "2/30/2025", "06/30/2026"};
	/*	if ( searchString.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
			System.out.println("works FOr 1");
         }*/
       //  if (searchString.matches("^(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/(?:[0-9]{4}|[1-9][0-9]{3})$")) {
	//	 String searchString = "02/31/1924";
    //         if (searchString.matches("^(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/[0-9]{4}$")) {
		for (String searchString : searchStrings) {
		 if (isValidDate(searchString)) {
        	// System.out.println("works FOr 2");
        	 
        	 DateFormat dd = new SimpleDateFormat("MM/dd/yyyy") ;
             
             try {
    			Date dem = dd.parse(searchString);
    			 System.out.println(searchString + " " + dem);
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
         }else {
        	 System.out.println(searchString +" Nahi chla");
         }
         
		}
   //    why giving ansMon Nov 30 00:00:00 IST 1959
	}
	
	public static boolean isValidDate(String dateString) {
      //  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
     //   sdf.setLenient(true);
        try {
        	 Date sdf = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
            return true;
        } catch (ParseException e) {
        	
            	  return false;
            
          
        }
    }
//why it is giving output as	10/1/2025 Wed Oct 01 00:00:00 IST 2025 it should be 10 Jan 
	
	

}

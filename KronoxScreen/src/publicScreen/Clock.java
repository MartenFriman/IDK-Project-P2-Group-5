package publicScreen;

import java.util.Calendar;
import java.util.Date;

public class Clock {
  private PublicScreenGUI publicScreenGUI;
  Calendar calendar = Calendar.getInstance();
  int day = calendar.get(Calendar.DAY_OF_MONTH);
  int year = calendar.get(Calendar.YEAR);
  int minutes;
  int hours;
  String month = "March";

  private class ClockThread extends Thread {
    	
    @Override
    public void run() {
    	while(true) {
    		calendar = Calendar.getInstance();
    		minutes = calendar.get(Calendar.MINUTE);
    		hours   = calendar.get(Calendar.HOUR_OF_DAY);
    		
    		//Corrects time display by adding a 0 if each time variable is less than 10
    		String hourCorrection = "";
    		String minuteCorrection ="";
    		
    		if (hours < 10) hourCorrection = "0";
    		if (minutes <10) minuteCorrection = "0";
    			
    		String currentTime = hourCorrection + hours + ":" + minuteCorrection + minutes;
    		
    		if (hours == 24) {
    		
    		switch(calendar.get(Calendar.MONTH)) {
    		case 1: month = "January";
    		case 2: month = "February";
    		case 3: month = "March";
    		case 4: month = "April";
    		case 5: month = "May";
    		case 6: month = "June";
    		case 7: month = "July";
    		case 8: month = "August";
    		case 9: month = "September";
    		case 10: month = "October";
    		case 11: month = "November";
    		case 12: month = "December";
    		}
    		day = calendar.get(Calendar.DAY_OF_MONTH);
    		year = calendar.get(Calendar.YEAR);
    		}
    		
    		String currentDate = day + " " + month + " " + year;
    		
    		publicScreenGUI.setTimeOnLabel(currentTime, currentDate);
    		
    		try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
					
				e.printStackTrace();
			}
    	}
    }
  }
  
  public Clock(PublicScreenGUI publicScreenGUI) {
	  this.publicScreenGUI = publicScreenGUI;
	  
	  new ClockThread().start();
  }
  
  public int getHours() {
	  return hours;
  }
  
  public int getMinutes() {
	  return minutes;
  }
}
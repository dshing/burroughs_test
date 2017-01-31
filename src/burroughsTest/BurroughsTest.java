package burroughsTest;

import java.util.ArrayList;

public class BurroughsTest {

	public static void main(String[] args) {
		// Array to hold the MonthPayDate objects
		ArrayList<MonthPayDate> monthPayList = new ArrayList<>();
		
		// Constructor initialisation
		for (int i = 0; i <= 11; i++){
			monthPayList.add(new MonthPayDate(i));
		}
		
		// Output
		for(MonthPayDate monthPayDate: monthPayList){	
			System.out.println(convertToLowerCase(monthPayDate.getMonthName()) + " " + monthPayDate.getCurrentMonthYear());
			System.out.print("Bonus Pay for the " + convertToLowerCase(monthPayDate.getPreviousMonthName()) + " " + monthPayDate.getPreviousMonthYear() + " is on the " + convertToOrdinal(monthPayDate.getBonusDay().getDayOfMonth()));
			System.out.println(" on a " + convertToLowerCase(monthPayDate.getBonusDay().getDayOfWeek().toString()) + " ");
			System.out.print("Pay Day is on the " + convertToOrdinal(monthPayDate.getPayDay().getDayOfMonth()));
			System.out.println(" on a " + convertToLowerCase(monthPayDate.getPayDay().getDayOfWeek().toString()) + " \n");
		}
	}
	
	// Add a suffix to the end of the day. Only takes into consideration -2 days for this program. 
	public static String convertToOrdinal(int day){
		if (day % 10 == 1){
			return day + "st";
		}else{
			return day + "th";
		}
	}
	
	// Convert the Month and Week from UpperCase to capitalise first letter only.
	public static String convertToLowerCase(String word){
		word = word.substring(0, 1) + word.substring(1).toLowerCase();
		return word;
	}
}
package burroughsTest;

import java.util.ArrayList;

public class BurroughsTest {

	public static void main(String[] args) {
		ArrayList<MonthPayDate> monthPayList = new ArrayList<>();
		
		for (int i = 0; i <= 11; i++){
			monthPayList.add(new MonthPayDate(i));
		}
		
		for(MonthPayDate monthPayDate: monthPayList){
			System.out.println(monthPayDate.getMonthName() + " ");
			System.out.print("Pay Day is on day " + monthPayDate.getPayDay().getDayOfMonth());
			System.out.println(" on a " + monthPayDate.getPayDay().getDayOfWeek() + " ");
			System.out.print("Bonus Pay is on day " + monthPayDate.getBonusDay().getDayOfMonth());
			System.out.println(" on a " + monthPayDate.getBonusDay().getDayOfWeek() + " ");
		}
	}

}
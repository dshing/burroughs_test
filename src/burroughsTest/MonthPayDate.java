package burroughsTest;

import java.time.LocalDate;

public class MonthPayDate {
	private String monthName;
	private String previousMonthName;
	private int currentMonthYear;
	private int previousMonthYear;
	private LocalDate payDay;
	private LocalDate bonusDay;
	private LocalDate ld = LocalDate.now();
	
	// Constructor
	public MonthPayDate(int numberOfMonth){
		// Shortening the ld variable
		LocalDate fullDate = ld.plusMonths(numberOfMonth);
		
		this.monthName = fullDate.getMonth().toString();
		this.previousMonthName = fullDate.minusMonths(1).getMonth().toString();
		
		this.currentMonthYear = fullDate.getYear();
		this.previousMonthYear = fullDate.minusMonths(1).getYear();
		
		// Get the last day of the month, which is equivalent to the length of the month
		LocalDate endMonth = fullDate.withDayOfMonth(fullDate.lengthOfMonth());
		this.payDay = adjustDayOfWeek(endMonth);
		
		// Get the 15th of the month.
		LocalDate middleMonth = fullDate.withDayOfMonth(15);
		this.bonusDay = adjustDayOfWeek(middleMonth);
	}
		
	public String getMonthName(){
		return this.monthName;
	}
	
	public String getPreviousMonthName(){
		return this.previousMonthName;
	}
	
	public int getCurrentMonthYear(){
		return this.currentMonthYear;
	}
	
	public int getPreviousMonthYear(){
		return this.previousMonthYear;
	}
	
	public LocalDate getPayDay(){
		return this.payDay;
	}
	
	public LocalDate getBonusDay(){
		return this.bonusDay;
	}
	
	// Method to adjust the payment dates to the closest Friday if they are on a weekend
	private LocalDate adjustDayOfWeek(LocalDate localDate){
		String weekDay = localDate.getDayOfWeek().toString();
		
		if (weekDay.equals("SATURDAY") || weekDay.equals("SUNDAY")){
			while (!localDate.getDayOfWeek().toString().equals("FRIDAY")){
				localDate = localDate.minusDays(1);
			}
		}
		return localDate;
	}
}
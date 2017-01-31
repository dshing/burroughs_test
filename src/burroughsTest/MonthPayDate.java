package burroughsTest;

import java.time.*;

public class MonthPayDate {
	private Month monthName;
	private LocalDate payDay;
	private LocalDate bonusDay;
	private LocalDate ld = LocalDate.now();
	
	// Constructor
	public MonthPayDate(int numberOfMonth){
		LocalDate fullDate = ld.plusMonths(numberOfMonth);
		monthName = fullDate.getMonth();
		
		LocalDate endMonth = fullDate.withDayOfMonth(fullDate.lengthOfMonth());
		this.payDay = adjustDayOfWeek(endMonth);
		
		LocalDate middleMonth = fullDate.withDayOfMonth(15);
		this.bonusDay = adjustDayOfWeek(middleMonth);
	}
	
	public Month getMonthName(){
		return this.monthName;
	}
	
	public LocalDate getPayDay(){
		return this.payDay;
	}
	
	public LocalDate getBonusDay(){
		return this.bonusDay;
	}

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
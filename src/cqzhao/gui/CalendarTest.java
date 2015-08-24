package cqzhao.gui;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarDate;

public class CalendarTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the date in form of yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = new GregorianCalendar();
		Date date;
		try {
			date = df.parse(in.nextLine());
			cal.setTime(date);
			System.out.println(cal.getActualMaximum(cal.DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		String date = in.nextLine();
//		String[] datesplit = date.split("-");
//		int[] idate = new int[3];
//		if (datesplit.length == 3) {
//			for (int i = 0; i < 3; i++) {
//				idate[i] = Integer.parseInt(datesplit[i]);
////				System.out.println(idate[i]);
//			}
//		} else {
//			System.out.println("Check ur input Infom.");
//			System.exit(-1);
//		}
//		Calendar cal = new GregorianCalendar(idate[0], idate[1]-1, idate[2]);
		print(cal);
//		print2(cal);
	}

	public static void print(final Calendar cal) {
		String head = "Sun\tMon\tTue\tWen\tThu\tFri\tSat";
		GregorianCalendar cal2 = (GregorianCalendar) cal;
		int start = 0;
//		cal2.set(cal2.DAY_OF_MONTH, 1);
		int date = cal2.get(cal2.DATE);
		cal2.set(cal2.DATE, 1);
		start = cal2.get(cal2.DAY_OF_WEEK);
		cal2.set(cal2.DATE,date);
//	    final int MONTH_LENGTH[]
//	            = {31,28,31,30,31,30,31,31,30,31,30,31}; // 0-based
//	    final int LEAP_MONTH_LENGTH[]
//	            = {31,29,31,30,31,30,31,31,30,31,30,31}; // 0-based
//		int monthLength = cal2.isLeapYear(cal.get(cal.YEAR))? LEAP_MONTH_LENGTH[cal.get(cal.MONTH)] : MONTH_LENGTH[cal.get(cal.MONTH)];
//				
		int monthLength = cal2.getActualMaximum(cal2.DATE);
		System.out.println(head);
		int jweek = 0;
		for (int j = 1; j < start; j++) {
			System.out.print("\t");
			jweek++;
		}
		for (int i = 0; i < monthLength; i++) {
			if (i == cal.get(cal.DAY_OF_MONTH) - 1) {
				System.out.print((i + 1) + "*\t");
			} else {
				System.out.print((i + 1) + "\t");
			}
			jweek++;
			if (jweek % 7 == 0) {
				System.out.println();
			}
		}

	}
	
	public static void print2(Calendar calendar){
		System.out.println("ERA: " + calendar.get(Calendar.ERA));
		 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		 System.out.println("DATE: " + calendar.get(Calendar.DATE));
		 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		 System.out.println("DAY_OF_WEEK_IN_MONTH: "
		                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
		 System.out.println("ZONE_OFFSET: "
		                    + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		 System.out.println("DST_OFFSET: "
		                    + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));

		 System.out.println("Current Time, with hour reset to 3");
		 	}

}
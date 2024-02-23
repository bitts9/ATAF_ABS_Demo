package com.ABS.ataf.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.testng.Assert;

public class DateFinder {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String startDateTime = getPastDateTime(-20, -3);
//		String endDateTime = getPastDateTime(-20, 0);
//		System.out.println(getPastDateTime(-20, -3));
//		System.out.println(getDayFromFullDateTime("13/07/2023 12:06 AM"));
//		System.out.println(getMonthFromFullDateTime("13/07/2023 12:06 AM"));
		
//		System.out.println(getPastDate(10));
		
		LocalTime s = LocalTime.parse("10:59");
		LocalTime e = LocalTime.parse("16:20");
		getTimeDifference(s,e);
//		System.out.println("Final start:" + startDateTime);
//		System.out.println("Final end:"+endDateTime);

		// System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println(cal.get(Calendar.HOUR));
//		System.out.println(cal.get(Calendar.MINUTE));
//		System.out.println(cal.get(Calendar.AM_PM));// 0ifAM 1ifPM
//		

//		LocalTime localTime = LocalTime.now();
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//		System.out.println("using localtime:" +localTime.format(dateTimeFormatter));

		// 7/07/2023 6:47 PM

	}

	public static String getPastDateTime(int day, int time) {
		String modifiedDateTime;
		TimeZone timeZone = TimeZone.getTimeZone("Australia/Melbourne");
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		dateFormat.setTimeZone(timeZone);
		Date myDate = Calendar.getInstance().getTime();
		System.out.println("Current date result is " + dateFormat.format(myDate).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(myDate);
		cal.add(Calendar.HOUR, time);
		cal.add(Calendar.DATE, day);
		System.out.println("using Calendar modified date:" + dateFormat.format(cal.getTime()));
		modifiedDateTime = dateFormat.format(cal.getTime());
		return modifiedDateTime;
	}

	public static String getPastDate(int day) {
		String modifiedDateTime;
		TimeZone timeZone = TimeZone.getTimeZone("Australia/Melbourne");
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy", new Locale("en", "UK"));
		dateFormat.setTimeZone(timeZone);
		Date myDate = Calendar.getInstance().getTime();
		System.out.println("Current date result is " + dateFormat.format(myDate).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(myDate);
		cal.add(Calendar.DATE, day);
		System.out.println("using Calendar modified date:" + dateFormat.format(cal.getTime()));
		modifiedDateTime = dateFormat.format(cal.getTime());
		return modifiedDateTime;
	}

	public static int getDayFromFullDateTime(String myDateTime) throws Exception {
		int finalDay;
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		Date date1 = dateFormat.parse(myDateTime);
		System.out.println("Date result is " + dateFormat.format(date1).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		finalDay = cal.get(Calendar.DAY_OF_MONTH);
		return finalDay;
	}
	
	public static int getMonthFromFullDateTime(String myDateTime) throws Exception {
		int finalMonth;
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		Date date1 = dateFormat.parse(myDateTime);
		System.out.println("Date result is " + dateFormat.format(date1).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		System.out.println(cal.get(Calendar.MONTH)+1);
		finalMonth = cal.get(Calendar.MONTH)+1;
		return finalMonth;
	}
	
	public static int getYearFromFullDateTime(String myDateTime) throws Exception {
		int finalYear;
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		Date date1 = dateFormat.parse(myDateTime);
		System.out.println("Date result is " + dateFormat.format(date1).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		System.out.println(cal.get(Calendar.YEAR));
		finalYear = cal.get(Calendar.YEAR);
		return finalYear;
	}
	
	public static int getHourFromFullDateTime(String myDateTime) throws Exception {
		int finalHour;
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		Date date1 = dateFormat.parse(myDateTime);
		System.out.println("Date result is " + dateFormat.format(date1).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		System.out.println(cal.get(Calendar.HOUR));
		finalHour = cal.get(Calendar.HOUR);
		return finalHour;
	}
	
	public static int getMinuteFromFullDateTime(String myDateTime) throws Exception {
		int finalMin;
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		Date date1 = dateFormat.parse(myDateTime);
		System.out.println("Date result is " + dateFormat.format(date1).toString());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		System.out.println(cal.get(Calendar.MINUTE));
		finalMin = cal.get(Calendar.MINUTE);
		return finalMin;
	}
	
	public static String getCurrentDateTimeInTimeZone() {
		TimeZone timeZone = TimeZone.getTimeZone("Australia/Melbourne");
		DateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy h:mm a", new Locale("en", "UK"));
		dateFormat.setTimeZone(timeZone);
		String currentFullDate = dateFormat.format(Calendar.getInstance().getTime()).toString();
		System.out.println(currentFullDate);
		return currentFullDate;
	}
	
	public static String getTimeDifference(LocalTime startTime,LocalTime endTime) {
		Duration timeElapsed = Duration.between(startTime,endTime);
		System.out.println(timeElapsed.toString());
		timeElapsed=timeElapsed.plus(timeElapsed);
		System.out.println(timeElapsed.toString());
		return null;
		
	}

}

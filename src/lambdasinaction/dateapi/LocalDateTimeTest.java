package lambdasinaction.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class LocalDateTimeTest {
	
	public static void main(String[] args) {
		//localDate 적용
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate today2 = LocalDate.now();
		System.out.println(today.compareTo(today2)==0);
		
		System.out.println("년/월/일/요일"+today.getYear()
									+"/"+today.getMonth()
									+"/"+today.getMonthValue()
									+"/"+today.getDayOfMonth()
									+"/"+today.getDayOfWeek()
									+"/"+today.getDayOfWeek().getValue());
		
		//특정일을 지정해서 LocalDate 생성
		LocalDate endDay = LocalDate.of(2019, 12, 31);
		System.out.println("남은 일자 : "+today.until(endDay, ChronoUnit.DAYS));
		System.out.println("1개월 이후 날짜 : "+today.plusMonths(1));
		System.out.println("1개월 이전 날짜 : "+today.minusMonths(1));
		//날짜연산 가능
		System.out.println("날짜 연산 : "+DayOfWeek.SATURDAY.plus(1));
		
		//localTime 사용
		LocalTime now = LocalTime.now();
		System.out.println(now);
		System.out.println("시.분.초.나노초 : "+now.getHour()+"."+now.getMinute()+"."+now.getSecond()+"."+now.getNano());
		
		//시간 계산 가능
		LocalTime bedTime = LocalTime.of(23,30);
		LocalTime wakeTime = bedTime.plusHours(7);
		System.out.println("취침시간 : "+bedTime+"\n취침시간 : "+wakeTime);
		
		//LocalDateTime 사용
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		//LocalDate과 LocalTime으로 분리 가능
		LocalDate d = dt.toLocalDate();
		System.out.println(d);
		LocalTime t = dt.toLocalTime();
		System.out.println(t);
		
		LocalDateTime dt2 = LocalDateTime.of(2019, 10, 4, 23, 40, 20);
		System.out.println(dt2);
		
		//Formatting : 지정된 날짜 포멧 형식이 많다
		System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(dt.format(DateTimeFormatter.ISO_DATE));
		System.out.println(dt.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(dt.format(DateTimeFormatter.ISO_WEEK_DATE));
		
		//임의로 시간 직접 포맷터 설정 가능 - 국뽕
		DateTimeFormatter myForm1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.KOREAN);
		DateTimeFormatter myForm2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.CANADA);
		DateTimeFormatter myForm3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.CHINA);
		DateTimeFormatter myForm4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.JAPAN);
		DateTimeFormatter myForm5 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.FRANCE);
		DateTimeFormatter myForm6 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.GERMAN);
		DateTimeFormatter myForm7 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.ROOT);
		DateTimeFormatter myForm8 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.US);
		DateTimeFormatter myForm9 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.ENGLISH);
		DateTimeFormatter myForm10 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a",Locale.ITALY); //이게 끝임 딴 나라는 없음 ㅋㅋ
		System.out.println(dt.format(myForm1));
		System.out.println(dt.format(myForm2));
		System.out.println(dt.format(myForm3));
		System.out.println(dt.format(myForm4));
		System.out.println(dt.format(myForm5));
		System.out.println(dt.format(myForm6));
		System.out.println(dt.format(myForm7));
		System.out.println(dt.format(myForm8));
		System.out.println(dt.format(myForm9));
		System.out.println(dt.format(myForm10));
		
		
		//TemporalAdjusters 사용
		System.out.println("두번째 금요일 ::"+today.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
		System.out.println("두번째 금요일 ::"+firstDayOfMonth());
		System.out.println("두번째 금요일 ::"+today.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
		System.out.println("두번째 금요일 ::"+today.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
		System.out.println("두번째 금요일 ::"+today.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

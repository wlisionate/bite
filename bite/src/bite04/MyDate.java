package bite04;

public class MyDate {
	private int year = 1970;
	private int month = 1;
	private int day = 1;
	
	private final int[] DAY_OF_MONTH = {
		31, 28, 31, 30, 31, 30,
		31, 31, 30, 31, 30, 31
	};
	
	private boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		}
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				return false;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	private int getDayOfMonth(int year, int month) {
		if (month != 2) {
			return DAY_OF_MONTH[month - 1];
		}
		
		if (isLeapYear(year)) {
			return 29;
		} else {
			return 28;
		}
	}
	
	public MyDate() {
	}
	
	public MyDate(int year, int month, int day) {
		if (year < 1970 || year > 2030) {
			System.out.println("不支持的年份");
			return;
		}
		
		if (month < 1 || month > 12) {
			System.out.println("不支持的月份");
			return;
		}
		
		if (day < 1 || day > getDayOfMonth(year, month)) {
			System.out.println("不支持的天数");
			return;
		}
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d", year, month, day);
	}
	
	// 在当前对象上添加多少天
	public void add(int days) {
		if (days < 0) {
			System.out.println("请使用 sub");
			return;
		}
		
		day += days;
		
		while (day > getDayOfMonth(year, month)) {
			day -= getDayOfMonth(year, month);
			month += 1;
			if (month > 12) {
				year += 1;
				month = 1;
			}
		}
	}
	
	// 在当前对象上退后多少天
	// 2019-11-10		退 60 天
	// 2019-11-（-50）
	// 2019-10-（-19）
	// 2019-09-11
	public void sub(int days) {
		day -= days;
		while (day <= 0) {
			month -= 1;
			if (month == 0) {
				year -= 1;
				month = 12;
			}
			day += getDayOfMonth(year, month);
		}
	}
	
	public static void main(String[] args) {
		MyDate date = new MyDate(2019, 11, 10);
		System.out.println(date);
		date.add(89);		// 2020-02-07
		System.out.println(date);
		date.sub(96);		// 2019-11-03
		System.out.println(date);
	}
}







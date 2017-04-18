
public class Course {
	String day, start, ampm;
	int duration = 0;
	
	public Course(String day, String start, int duration, String ampm){
		this.day = day;
		this.start = start;
		this.duration = duration;
		this.ampm = ampm;
	}
	
	public boolean Overlap(Course ct){
		int start1 = calculateStartUnixTime(this);
		int finish1 = start1 + duration;
		int start2 = calculateStartUnixTime(ct);
		int finish2 = start2 + duration;
		return ((start1 <= finish2)&&(start2 <= finish1));
	}
	
	public int calculateStartUnixTime(Course ct){
		int d1 = convertDayToNumber(ct.day);
		int unixtime = 0;
		String[] times = ct.start.split(":");
		if (ct.ampm.equalsIgnoreCase("am")){
			unixtime = (d1-1)*24*60 + (Integer.parseInt(times[0]))*60 + Integer.parseInt(times[1]);
		}else{
			unixtime = (d1-1)*24*60 + 12*60 + (Integer.parseInt(times[0]))*60 + Integer.parseInt(times[1]);
		}
		return unixtime;
	}
	
	public int convertDayToNumber(String day){
		int digitalDay = 0;
		if (day.equalsIgnoreCase("M")){
			digitalDay = 1;
		}else if (day.equalsIgnoreCase("T")){
			digitalDay = 2;
		}else if (day.equalsIgnoreCase("W")){
			digitalDay = 3;
		}else if (day.equalsIgnoreCase("R")){
			digitalDay = 4;
		}else{
			digitalDay = 5;
		}
		return digitalDay;
	}
}

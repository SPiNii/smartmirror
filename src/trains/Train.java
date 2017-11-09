package trains;

import org.json.JSONObject;

public class Train {
	private String direction, number, stopName, fullTime, time, trainInfo;
	private int hour, year, day, minute, month, weekday, delay;

	public Train(JSONObject train) {
		this.time = null;
		this.fullTime = null;
		this.trainInfo = null;
		this.direction = train.getString("direction");
		this.number = train.getString("number");
		this.stopName = train.getString("stopName");
		this.delay = train.getInt("delay");

		// DepartureTime
		JSONObject departure = train.getJSONObject("departureTime");
		this.year = Integer.parseInt(departure.getString("year"));
		this.day = Integer.parseInt(departure.getString("day"));
		this.minute = Integer.parseInt(departure.getString("minute"));
		this.month = Integer.parseInt(departure.getString("month"));
		this.hour = Integer.parseInt(departure.getString("hour"));
		this.weekday = Integer.parseInt(departure.getString("weekday"));

	}

	public String getDirection() {
		return direction;
	}

	public String getNumber() {
		return number;
	}

	public String getStopName() {
		return stopName;
	}

	public int getHour() {
		return hour;
	}

	public int getYear() {
		return year;
	}

	public int getDay() {
		return day;
	}

	public int getMinute() {
		return minute;
	}

	public int getMonth() {
		return month;
	}

	public int getDelay() {
		return delay;
	}

	public String getTime() {
		if (this.time == null) {
			this.time = "";
			if (hour < 10) {
				this.time += "0";
			}
			this.time += hour + ":";
			if (minute < 10) {
				this.time += "0";
			}
			this.time += minute;
		}
		return this.time;
	}

	public String getFullTime() {
		this.fullTime = "";
		switch (weekday) {
		case 1:
			this.fullTime += "So, ";
			break;
		case 2:
			this.fullTime += "Mo, ";
			break;
		case 3:
			this.fullTime += "Di, ";
			break;
		case 4:
			this.fullTime += "Mi, ";
			break;
		case 5:
			this.fullTime += "Do, ";
			break;
		case 6:
			this.fullTime += "Fr, ";
			break;
		case 7:
			this.fullTime += "Sa, ";
			break;
		}

		this.fullTime += this.getDay() + "." + this.getMonth() + "." + this.getYear() + " " + this.getTime();
		if (this.delay > 0) {
			this.fullTime += " +" + this.getDelay();
		}
		return this.fullTime;
	}

	public String getTrainInfo() {
		if (trainInfo == null) {
			trainInfo = getNumber() + " from " + getStopName() + " to " + getDirection() + ":\n";
			trainInfo += "at " + this.getFullTime();
		}
		return trainInfo;
	}

}

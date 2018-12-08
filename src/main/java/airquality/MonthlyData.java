package airquality;

import java.util.List;

import com.scmoure.csvreader.annotations.CSVColumn;
import com.scmoure.csvreader.annotations.CSVObjectList;

public class MonthlyData {

	@CSVColumn(name = "PROVINCIA", column = 0)
	private Integer state;

	@CSVColumn(name = "MUNICIPIO", column = 1)
	private Integer city;

	@CSVColumn(name = "ESTACION", column = 2)
	private Integer station;

	@CSVColumn(name = "MAGNITUD", column = 3)
	private Integer magnitude;

	@CSVColumn(name = "PUNTO_MUESTREO", column = 4)
	private String sampling;

	@CSVColumn(name = "AÑO", column = 5)
	private Integer year;

	@CSVColumn(name = "MES", column = 6)
	private Integer month;

	@CSVObjectList(startingColumn = 7, endingColumn = 67, cycle = 2)
	private List<DayData> days;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getStation() {
		return station;
	}

	public void setStation(Integer station) {
		this.station = station;
	}

	public Integer getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(Integer magnitude) {
		this.magnitude = magnitude;
	}

	public String getSampling() {
		return sampling;
	}

	public void setSampling(String sampling) {
		this.sampling = sampling;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public List<DayData> getDays() {
		return days;
	}

	public void setDays(List<DayData> days) {
		this.days = days;
	}

}

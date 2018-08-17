package rc.demo;

import java.io.Serializable;
import java.util.Date;

public class Trade implements Serializable {
	private static final long serialVersionUID = 8917666980832119713L;
	private Date date;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private int volume;
	
	public Trade() {}

	public Trade(Date date, Double open, Double high, Double low, Double close, int volume) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	
	@Override
	public String toString() {
		return date + " | " + open + " | " + high + " | " + low + " | " +close + " | " +volume;
	}
}

package org.elsys_bg.ex03.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateFormatter {

	private final SimpleDateFormat formatter;
	private Date currentDate;

	public DateFormatter() {
		this.formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.currentDate = new Date();
	}

	public Date formatDateStr(String dateStr) throws ParseException {
		return formatter.parse(dateStr);
	}

	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return (timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1);
	}

	public Date getCurrentDate() {
		return currentDate;
	}

}

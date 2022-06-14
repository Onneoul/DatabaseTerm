package com.teammate.find;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCreate {
	public String dateNow() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(d);
		return now;
	}
}

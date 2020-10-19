package com.example.booksread.controller.utility;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class FormatWithLocale {

	public static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
			.appendPattern("dd/MM/yyyy")
			.toFormatter(Locale.UK);
}

package br.com.orion.formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.orion.utils.DateUtils;

public class LocalDateFormatter implements Formatter<LocalDate> {
	
	public static final String PATTERN = "dd/MM/yyyy";

	@Override
	public String print(LocalDate object, Locale locale) {
		return DateUtils.format(object);
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		return LocalDate.parse(text,  DateTimeFormatter.ofPattern(getPattern(locale)));
	}

	public static String getPattern(Locale locale) {
		return PATTERN;	
	}
}

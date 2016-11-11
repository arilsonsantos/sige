package br.com.orion.utils;

import java.util.Iterator;

import org.springframework.data.util.Pair;

import com.google.common.base.Splitter;


public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

	public static final String BLANK_PARAMETER_MESSAGE = "O valor a ser parseado não pode ser null, vazio (\"\") ou espaço em branco (\" \").";

	public static final String EMPTY_PARAMETER_MESSAGE = "Parâmetro não pode ser nulo.";

	protected NumberUtils() {
		super();
	}

	protected static String getDigits(final String source) {
		if (StringUtils.isEmpty(source)) {
			throw new IllegalArgumentException(BLANK_PARAMETER_MESSAGE);
		}
		return StringUtils.removeNonDigits(source);
	}

	public static Pair<? extends Number, ? extends Number> getRange(final String source) {
		Iterator<String> iterator = Splitter.on("-").omitEmptyStrings().trimResults().split(source).iterator();
		Pair<? extends Number, ? extends Number> range = iterator.hasNext() ? Pair.of(createNumber(iterator.next()), createNumber(iterator.next())) : null;

		return range;
	}

}
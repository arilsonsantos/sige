package br.com.orion.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import org.apache.commons.lang3.ArrayUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static final String NULL = "null";

	/**
	 * <p>
	 * Classe utilitária não deve ter construtor público ou default.
	 * </p>
	 */
	private StringUtils() {
		super();
	}

	/**
	 * <p>
	 * Aplica a máscara no texto passado por parâmetro.
	 * </p>
	 *
	 * @param text
	 *            texto a ser mascarado.
	 * @param mask
	 *            máscara a ser aplicada
	 * @return texto com a máscara aplicada
	 */
	public static String applyMask(String text, String mask) {
		String formattedText = "";

		try {
			MaskFormatter maskFormatter = new MaskFormatter(mask);
			maskFormatter.setValueContainsLiteralCharacters(false);
			formattedText = maskFormatter.valueToString(text);

		} catch (ParseException ex) {
			log.warn(ex.getMessage(), ex);
			formattedText = text;
		}

		return formattedText;
	}

	/**
	 * <p>
	 * Remove todos os caracteres não numéricos da string passada como
	 * parâmetro.
	 * </p>
	 * <h1>Exemplo</h1>
	 * <p>
	 * <code>
	 * String stringWithNonDigits = "61.049.250/0001-00";
	 * StringUtils.removeNonDigits(stringWithNonDigits))
	 * A saída será: 61049250000100
	 * </code>
	 * </p>
	 *
	 * @param str
	 *            string com os símbolos a serem substituídos
	 * @return string sem nenhum carecter não numérico
	 */
	public static String removeNonDigits(String str) {
		return str.replaceAll("\\D", "");
	}

	public static String leftPad(String str, int size, char padChar, boolean defaultString) {
		String string = defaultString ? StringUtils.defaultString(str) : str;
		return org.apache.commons.lang3.StringUtils.leftPad(string, size, padChar);
	}

	public static String leftPad(int value, int size, char padChar, boolean defaultString) {
		return leftPad(String.valueOf(value), size, padChar, defaultString);
	}

	public static String leftPad(int value, int size, char padChar) {
		return leftPad(String.valueOf(value), size, padChar, false);
	}

	public static boolean isBlank(String str) {
		return org.apache.commons.lang3.StringUtils.isBlank(NULL.equalsIgnoreCase(str) ? null : str);
	}

	public static String defaultStringWithPrefix(String str, String prefix) {
		return StringUtils.isNotEmpty(str) ? StringUtils.defaultString(prefix).concat(str) : EMPTY;
	}

	public static String defaultStringWithSufix(String str, String sufix) {
		return StringUtils.isNotEmpty(str) ? str.concat(StringUtils.defaultString(sufix)) : EMPTY;
	}

	public static String defaultStringWithPrefixAndSufix(String str, String prefix, String sufix) {
		return StringUtils.isNotEmpty(str) && !NULL.equals(str)
				? StringUtils.defaultString(prefix).concat(str).concat(StringUtils.defaultString(sufix)) : EMPTY;
	}

	public static String defaultStringWithPrefixIfTrue(String str, String prefix, Boolean condition) {
		return condition ? StringUtils.defaultStringWithPrefix(str, prefix) : StringUtils.EMPTY;
	}

	public static String defaultIfBlank(String str) {
		return defaultIfBlank(str, EMPTY);
	}

	public static String defaultTrimmedIfBlank(String str) {
		String newStr = str != null ? str.trim() : null;
		return defaultIfBlank(newStr, EMPTY);
	}

	public static String defaultTrimmedIfBlank(String str, String defaultStr) {
		String newStr = str != null ? str.trim() : null;
		String newDefaultStr = defaultStr != null ? defaultStr.trim() : null;

		return defaultIfBlank(newStr, newDefaultStr);
	}

	public static String defaultInteger(Integer integerValue) {
		return integerValue == null ? EMPTY : String.valueOf(integerValue);
	}

	public static String defaultLong(Long longValue) {
		return longValue == null ? EMPTY : String.valueOf(longValue);
	}

	public static String defaultBigDecimal(BigDecimal bigDecimalValue) {
		return bigDecimalValue == null ? EMPTY : String.valueOf(bigDecimalValue);
	}

	public static String stripAccents(Object input) {
		return input == null ? EMPTY : stripAccents(String.valueOf(input));
	}

	public static String[] split(final String str, int length) {
		if (StringUtils.isBlank(str)) {
			return ArrayUtils.EMPTY_STRING_ARRAY;
		}

		final int len = str.length();
		final List<String> list = new ArrayList<>();
		int start = 0;
		int end = 0;

		do {
			end = end + length;
			end = str.length() < end ? str.length() : end;

			list.add(str.substring(start, end));

			start = end;
		} while (start < len);

		return list.toArray(new String[list.size()]);
	}

	public static String format(String message, Object... params) {
		Pattern pattern = Pattern.compile("\\{\\}");

		for (Object param : params) {
			message = pattern.matcher(message).replaceFirst(param.toString());
		}

		return message;
	}

}
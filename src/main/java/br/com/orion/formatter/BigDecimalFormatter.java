package br.com.orion.formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import br.com.orion.constant.LocaleConstants;
import br.com.orion.utils.BigDecimalUtils;
import org.springframework.format.Formatter;

public class BigDecimalFormatter implements Formatter<BigDecimal> {


	@Override
	public String print(BigDecimal object, Locale locale) {
		return "R$ " + BigDecimalUtils.format(object, BigDecimalUtils.DEFAULT_DECIMAL_PATTERN);
	}

	@Override
	public BigDecimal parse(String text, Locale locale) throws ParseException {
		text = text.replace("R$ ", "");
		return BigDecimalUtils.parse(text, LocaleConstants.PT_BR);
	}

}

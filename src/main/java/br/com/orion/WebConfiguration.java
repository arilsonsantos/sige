package br.com.orion;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.orion.formatter.BigDecimalFormatter;
import br.com.orion.formatter.LocalDateFormatter;

@Configuration
@EntityScan(basePackageClasses = { Jsr310JpaConverters.class }, basePackages = { "br.com.orion.model" })
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(LocalDate.class, new LocalDateFormatter());
		registry.addFormatterForFieldType(BigDecimal.class, new BigDecimalFormatter());

	}

}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.com.fpportal;

import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter;

/**
 * <p>
 * Standard {@link org.apache.commons.beanutils.locale.LocaleConverter}
 * implementation that converts an incoming locale-sensitive String into a
 * <code>java.math.BigDecimal</code> object, optionally using a default value or
 * throwing a {@link org.apache.commons.beanutils.ConversionException} if a
 * conversion error occurs.
 * </p>
 *
 * @author Yauheny Mikulski
 */

public class FloatLocaleConverter extends DecimalLocaleConverter {

	// ----------------------------------------------------------- Constructors

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will throw a {@link org.apache.commons.beanutils.ConversionException} if
	 * a conversion error occurs. The locale is the default locale for this
	 * instance of the Java Virtual Machine and an unlocalized pattern is used
	 * for the convertion.
	 *
	 */
	public FloatLocaleConverter() {

		this(false);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will throw a {@link org.apache.commons.beanutils.ConversionException} if
	 * a conversion error occurs. The locale is the default locale for this
	 * instance of the Java Virtual Machine.
	 *
	 * @param locPattern
	 *            Indicate whether the pattern is localized or not
	 */
	public FloatLocaleConverter(boolean locPattern) {

		this(Locale.getDefault(), locPattern);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will throw a {@link org.apache.commons.beanutils.ConversionException} if
	 * a conversion error occurs. An unlocalized pattern is used for the
	 * convertion.
	 *
	 * @param locale
	 *            The locale
	 */
	public FloatLocaleConverter(Locale locale) {

		this(locale, false);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will throw a {@link org.apache.commons.beanutils.ConversionException} if
	 * a conversion error occurs.
	 *
	 * @param locale
	 *            The locale
	 * @param locPattern
	 *            Indicate whether the pattern is localized or not
	 */
	public FloatLocaleConverter(Locale locale, boolean locPattern) {

		this(locale, (String) null, locPattern);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will throw a {@link org.apache.commons.beanutils.ConversionException} if
	 * a conversion error occurs. An unlocalized pattern is used for the
	 * convertion.
	 *
	 * @param locale
	 *            The locale
	 * @param pattern
	 *            The convertion pattern
	 */
	public FloatLocaleConverter(Locale locale, String pattern) {

		this(locale, pattern, false);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will throw a {@link org.apache.commons.beanutils.ConversionException} if
	 * a conversion error occurs.
	 *
	 * @param locale
	 *            The locale
	 * @param pattern
	 *            The convertion pattern
	 * @param locPattern
	 *            Indicate whether the pattern is localized or not
	 */
	public FloatLocaleConverter(Locale locale, String pattern, boolean locPattern) {

		super(locale, pattern, locPattern);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will return the specified default value if a conversion error occurs. The
	 * locale is the default locale for this instance of the Java Virtual
	 * Machine and an unlocalized pattern is used for the convertion.
	 *
	 * @param defaultValue
	 *            The default value to be returned
	 */
	public FloatLocaleConverter(Object defaultValue) {

		this(defaultValue, false);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will return the specified default value if a conversion error occurs. The
	 * locale is the default locale for this instance of the Java Virtual
	 * Machine.
	 *
	 * @param defaultValue
	 *            The default value to be returned
	 * @param locPattern
	 *            Indicate whether the pattern is localized or not
	 */
	public FloatLocaleConverter(Object defaultValue, boolean locPattern) {

		this(defaultValue, Locale.getDefault(), locPattern);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will return the specified default value if a conversion error occurs. An
	 * unlocalized pattern is used for the convertion.
	 *
	 * @param defaultValue
	 *            The default value to be returned
	 * @param locale
	 *            The locale
	 */
	public FloatLocaleConverter(Object defaultValue, Locale locale) {

		this(defaultValue, locale, false);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will return the specified default value if a conversion error occurs.
	 *
	 * @param defaultValue
	 *            The default value to be returned
	 * @param locale
	 *            The locale
	 * @param locPattern
	 *            Indicate whether the pattern is localized or not
	 */
	public FloatLocaleConverter(Object defaultValue, Locale locale, boolean locPattern) {

		this(defaultValue, locale, null, locPattern);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will return the specified default value if a conversion error occurs. An
	 * unlocalized pattern is used for the convertion.
	 *
	 * @param defaultValue
	 *            The default value to be returned
	 * @param locale
	 *            The locale
	 * @param pattern
	 *            The convertion pattern
	 */
	public FloatLocaleConverter(Object defaultValue, Locale locale, String pattern) {

		this(defaultValue, locale, pattern, false);
	}

	/**
	 * Create a {@link org.apache.commons.beanutils.locale.LocaleConverter} that
	 * will return the specified default value if a conversion error occurs.
	 *
	 * @param defaultValue
	 *            The default value to be returned
	 * @param locale
	 *            The locale
	 * @param pattern
	 *            The convertion pattern
	 * @param locPattern
	 *            Indicate whether the pattern is localized or not
	 */
	public FloatLocaleConverter(Object defaultValue, Locale locale, String pattern, boolean locPattern) {

		super(defaultValue, locale, pattern, locPattern);
	}

	/**
	 * Convert the specified locale-sensitive input object into an output object
	 * of the specified type. This method will return Float value or throw
	 * exception if value can not be stored in the Float.
	 *
	 * @param value
	 *            The input object to be converted
	 * @param pattern
	 *            The pattern is used for the convertion
	 * @return The converted value
	 *
	 * @exception ConversionException
	 *                if conversion cannot be performed successfully
	 * @throws ParseException
	 *             if an error occurs parsing a String to a Number
	 */
	protected Object parse(Object value, String pattern) throws ParseException {
		final Number parsed = (Number) super.parse(value, pattern);
		double doubleValue = parsed.doubleValue();
		double posDouble = (doubleValue >= (double) 0) ? doubleValue : (doubleValue * (double) -1);
		if (posDouble != 0 && (posDouble < Float.MIN_VALUE || posDouble > Float.MAX_VALUE)) {
			throw new ConversionException("Supplied number is not of type Float: " + parsed);
		}
		return new Float(parsed.floatValue()); // unlike superclass it returns
												// Float type
	}
}

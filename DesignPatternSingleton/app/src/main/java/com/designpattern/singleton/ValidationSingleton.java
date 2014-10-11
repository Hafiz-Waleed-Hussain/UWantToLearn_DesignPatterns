package com.designpattern.singleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationSingleton {

	private static ValidationSingleton mSingletonObj = null;

	private ValidationSingleton() {

	}

	public static ValidationSingleton getInstance() {
		if (mSingletonObj == null) {
			mSingletonObj = new ValidationSingleton();
		}
		return mSingletonObj;
	}



	/**
	 * This is the validation function. It use for empty checking string.
	 * 
	 * @param str
	 *            str is the data string.
	 * @return It give the true if string str is empty otherwise false.
	 */
	public boolean isEmpty(String str) {
		return str.trim().length() > 0 ? false : true;
	}

	/**
	 * This is the validation function. It use for email validation.
	 * 
	 * @param str
	 *            str is the email.
	 * @return It give the true if email is valid otherwise false.
	 */
	public boolean isEmailValid(String str) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * This is the validation function. It use for password length.
	 * 
	 * @param str
	 *            str is the password.
	 * @param length
	 * 			  length is the int value which is the minimum characters required for password
	 * @return It give the true if password character greater than given length otherwise
	 *         false.
	 */
	public boolean isPasswordLengthValid(String str,int length) {
		return str.length() > length ? true : false;
	}
}

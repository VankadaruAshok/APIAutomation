package com.api.utils;

import java.util.Random;

public class Generics {
	/**
	 * Generates Random Email Address
	 *
	 * @param length
	 * @return
	 */
	public static String getRandomEmailAddress(int length) {

		String username = generateRandomString(length);
		String email = username + "@gmail.com";
		return email;
	}

	/**
	 * Generates Random String
	 *
	 * @param length
	 * @return
	 */
	public static String generateRandomString(int length) {
		// Generate a random string of alphanumeric characters
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = new Random().nextInt(characters.length());
			sb.append(characters.charAt(index));
		}

		return sb.toString();

	}

	/**
	 * Generates Random NPI Number
	 *
	 * @return
	 */
	public static String getRandomPracticeNPINumber() { // it should not accept Zero starting itself
		Random random = new Random();
		// long PracticeNPI = random.nextLong(10000000000L)+1;
		long PracticeNPI = (long) (1000000000L + random.nextDouble() * (9000000000L - 1000000000L));
		String randomPracticeNPIString = Long.toString(PracticeNPI);
		return randomPracticeNPIString;
	}

	/**
	 * Generates Random Amount value
	 *
	 * @return
	 */
	public static String getRandomAmount() {
		Random random = new Random();
		int amount = random.nextInt(9999) + 1;
		return String.valueOf(amount);
	}

	/**
	 * Generates Random Device code
	 *
	 * @return
	 */
	public static String getRandomDeviceCode() {
		Random rand = new Random();
		int length = rand.nextInt(27) + 3; // Generates a random integer between 3 and 15(As per Requirement)

		String alphaSpecialNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(alphaSpecialNumeric.length());
			sb.append(alphaSpecialNumeric.charAt(index));
		}

		String randomDeviceCode = sb.toString();
		System.out.println("Random alphanumeric string with special characters: " + randomDeviceCode);
		return randomDeviceCode;
	}

	/**
	 * Generates Random version
	 *
	 * @return
	 */
	public static String getRandomVersion() {
		Random rand = new Random();
		int length = rand.nextInt(7) + 3; // Generates a random integer between 3 and 15(As per Requirement)

		String alphaSpecialNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(alphaSpecialNumeric.length());
			sb.append(alphaSpecialNumeric.charAt(index));
		}

		String randomVersion = sb.toString();
		System.out.println("Random alphanumeric string with special characters: " + randomVersion);
		return randomVersion;
	}

	/**
	 * Generates Random IMEI Number
	 *
	 * @return
	 */
	public static String getRandomIMEINumber() {

		Random rand = new Random();
		int digits = rand.nextInt(18) + 3; // Generates a random number(integer) between 3 and 20(As per Requirement)
		long min = (long) Math.pow(10, digits - 1);
		long max = (long) Math.pow(10, digits) - 1;
		long randomNum = min + (long) (rand.nextDouble() * (max - min + 1));

		return String.valueOf(randomNum);

	}
}
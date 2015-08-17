package com.algorithms.wmatch;

import java.util.Arrays;

/**
 * Encodes strings according to the original Soundex algorithm.
 * 
 */
public final class SoundexPhoneticEncoder implements PhoneticEncoder {
	/** The single instance of the class. */
	public static final SoundexPhoneticEncoder INSTANCE = new SoundexPhoneticEncoder();

	/** ABCDEFGHIJKLMNOPQRSTUVWXYZ */
	private static final char[] CHARACTER_MAP = "01230120022455012623010202"
			.toCharArray();

	public static final int MAX_LENGTH = 4;

	/**
	 * Constructor marked private to prevent instantiation.
	 */
	private SoundexPhoneticEncoder() {
	}

	public String encode(CharSequence string) {
		string = string.toString().toUpperCase();

		char[] data = new char[MAX_LENGTH];
		Arrays.fill(data, '0');

		data[0] = string.charAt(0);
		int j = 1;

		char inLine;
		char former = '0';

		for (int i = 1; i < string.length(); i++) {
			inLine = getMapping(string.charAt(i));
			if (inLine != '0' && inLine != former) {
				data[j++] = inLine;
			}
			if (j == MAX_LENGTH) {
				break;
			}
			former = inLine;
		}

		return new String(data);
	}

	/**
	 * Maps a single character according to the soundex rules.
	 * 
	 * @param c
	 *            The character to map.
	 * @return The encoding; or <code>'0'</code> if the character should be
	 *         ignored.
	 */
	private static char getMapping(char c) {
		// asertion
		char charA = 'A';
		int reduced = (c - charA);

		if (!isValid(reduced)) {
			return '0';
		} else {
			return CHARACTER_MAP[reduced];
		}
	}

	/**
	 * Determins if the specified index is valid for the translate table.
	 * 
	 * @param index
	 *            The index.
	 * @return <code>true</code> if value; otherwise <code>false</code>.
	 */
	private static boolean isValid(int index) {
		return index < CHARACTER_MAP.length && index >= 0;
	}
}

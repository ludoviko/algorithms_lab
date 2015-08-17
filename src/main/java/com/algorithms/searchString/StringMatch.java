package com.algorithms.searchString;

public class StringMatch {
	private final CharSequence pattern;
	private final CharSequence text;
	private final int index;;
	
	public StringMatch(CharSequence pattern, CharSequence text, int index) {
		super();
		
		assert text != null : "text can not be null";
		assert pattern != null : "pattern can not be null";
		assert index >= 0 : "index can not be lesser than 0";
		
		this.pattern = pattern;
		this.text = text;
		this.index = index;
	}

	public CharSequence getPattern() {
		return pattern;
	}

	public CharSequence getText() {
		return text;
	}

	public int getIndex() {
		return index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

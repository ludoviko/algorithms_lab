package com.algorithms.searchString;

public class BruteForceStringSearcher implements StringSearcher {
	private CharSequence pattern;

	public BruteForceStringSearcher(CharSequence pattern) {
		this.pattern = pattern;
	}

	
	// xXXX error delete
	public StringMatch search(CharSequence text, int from) {
		StringMatch stringMatch = null;
        int index = -1; 
		
	 for (int i = from; i < text.length(); i++) {
			for (int j = 0; j < this.pattern.length(); j++) {
				if (text.charAt(i) == this.pattern.charAt(j)) {
					index = i;
				} else {
					index = -1;
					break;
				}
			}
			if (index != -1) {
				stringMatch = new StringMatch(this.pattern, text, index);
				break;
			}
		}

		return stringMatch;
	}
}

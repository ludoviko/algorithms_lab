package com.algorithms.searchString.morse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    List<String> list;
    File file;
    
    public ReadData(List<String> list, String pathToFile) {
    	this.list = list;
		file = new File(pathToFile);
    }

    public ReadData(String pathToFile) {
    	this.list = new ArrayList<String>();
		file = new File(pathToFile);
    }

    public ReadData(File file) {
    	this.list = new ArrayList<String>();
		this.file = file;
    }

    public void loadData() {
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ( (line = reader.readLine()) != null ) {
			  list.add(line);	
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

    public String loadAndGetDataAsString() {
		String line = null;
		String output = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ( (line = reader.readLine()) != null ) {
			  output += line;
			};

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		return output;
	}
	
	public List<String> getList() {
		return this.list;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		ReadData data = new ReadData(list, "source/com/coder/projectEuler/data/SumOneHundred50DigitNumbers");
		data.loadData();
		
		System.out.println(list.size());
		for (String string : list) {
			System.out.println(string);
		}
	}

}

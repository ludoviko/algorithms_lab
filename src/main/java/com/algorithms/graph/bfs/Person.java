package com.algorithms.graph.bfs;

public class Person implements IPerson, Comparable<Person>  {
	private boolean seller;
	private String name;
	
	public Person(String name, boolean seller) {
		this.name = name;
		this.seller = seller;
	}
	
	public Person(String name) {
		this(name, false);
	}

	public void setSeller(boolean seller) {
		this.seller = seller; 
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSeller() {
		return seller;
	}

	public String getName() {
		return this.name;
	}

	public int compareTo(Person other) {
		if (this.name.equals(other.name)) {
			if ( this.seller == other.seller ) {
				return 0;
			} else if ( this.seller ) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return this.name.compareTo(other.name);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (seller ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seller != other.seller)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [seller=" + seller + ", name=" + name + "]";
	}
}

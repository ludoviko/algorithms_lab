package com.algorithms.tree;

public class Node<T> {
	private T value;
	private Node<T> smaller;
	private Node<T> larger;
	private Node<T> parent;

	public Node(T data) {
		this(data, null, null);
	}

	public Node(T data, Node<T> smaller, Node<T> larger) {
		this.setValue(data);
		this.setSmaller(smaller);
		this.setLarger(larger);

		if (smaller != null) {
			smaller.setParent(this);
		}
		if (larger != null) {
			larger.setParent(this);
		}
	}

	public boolean isSmaller() {
		return this.getParent() != null
				&& this.getParent().getSmaller() == this;
	}

	public boolean isLeaf() {
		return this.getLarger() == null
				&& this.getSmaller() == null;
	}

	
	public boolean isLarger() {
		return this.getParent() != null && this.getParent().getLarger() == this;
	}

	public Node<T> minimum() {
		Node<T> child = this;
		while (child.smaller != null) {
			child = child.smaller;
		}
		return child;
	}

	public Node<T> maximum() {
		Node<T> child = this;
		while (child.larger != null) {
			child = child.larger;
		}
		return child;
	}

	public Node<T> successor() {
		if (this.larger != null) {
			return this.getLarger().minimum();
		}

		Node<T> node = this;
		while (node != null && node.isLarger()) {
			node = node.getParent();
		}

		return node.getParent();
	}

	public Node<T> predecessor() {
		if (this.smaller != null) {
			return this.getSmaller().maximum();
		}

		Node<T> node = this;
		while (node != null && node.isSmaller()) {
			node = node.getParent();
		}
		return node.getParent();
	}

	public int size(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.getSmaller()) + size(node.getLarger());
	}

	public int size() {
		return size(this);
	}

	public T getValue() {
		return value;
	}

	public Node<T> getSmaller() {
		return smaller;
	}

	public Node<T> getLarger() {
		return larger;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setSmaller(Node<T> smaller) {
		this.smaller = smaller;
	}

	public void setLarger(Node<T> larger) {
		this.larger = larger;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((larger == null) ? 0 : larger.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((smaller == null) ? 0 : smaller.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object node) {
		if (this == node)
			return true;
		if (node == null)
			return false;
		if (getClass() != node.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Node<T> other = (Node<T>) node;
		if (larger == null) {
			if (other.larger != null)
				return false;
		} else if (!larger.equals(other.larger))
			return false;

		// if (parent == null) {
		// if (other.parent != null)
		// return false;
		// } else if (!parent.equals(other.parent))
		// return false;

		if (smaller == null) {
			if (other.smaller != null)
				return false;
		} else if (!smaller.equals(other.smaller))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

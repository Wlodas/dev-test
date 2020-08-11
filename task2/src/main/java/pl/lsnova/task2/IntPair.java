package pl.lsnova.task2;

final class IntPair {
	private final int left, right;
	
	IntPair(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	int getLeft() {
		return left;
	}
	
	int getRight() {
		return right;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof IntPair)) return false;
		
		IntPair intPair = (IntPair) o;
		
		return left == intPair.left && right == intPair.right;
	}
	
	@Override
	public int hashCode() {
		return 31 * left + right;
	}
	
	@Override
	public String toString() {
		return "(" + left + ", " + right + ")";
	}
}

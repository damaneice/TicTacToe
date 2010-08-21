
public enum Box {
	X('X'), O('O'), EMPTY(0);
	
	private int mark;

	 private Box(int mark) {
	   this.mark = mark;
	 }

	 public int getMark() {
	   return mark;
	 }
}

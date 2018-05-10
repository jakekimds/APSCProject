package project;

public class Vector2 {
	private final int x;
	private final int y;
	
	public Vector2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Vector2 add(Vector2 addend){
		return add(this, addend);
	}
	
	public Vector2 multiply(int scalar){
		return multiply(this, scalar);
	}
	
	public Vector2 withX(int x){
		return new Vector2(x, getY());
	}
	
	public Vector2 withY(int y){
		return new Vector2(getX(), y);
	}
	
	public static Vector2 add(Vector2 vec1, Vector2 vec2){
		return new Vector2(vec1.getX() + vec2.getX(), vec1.getY() + vec2.getY());
	}
	
	public static Vector2 multiply(Vector2 vector, int scalar){
		return new Vector2(vector.getX() * scalar, vector.getY()*scalar);
	}
	
	public static Vector2 up(){
		return new Vector2(0, -1);
	}
	public static Vector2 right(){
		return new Vector2(1, 0);
	}
	
	public static Vector2 zero(){
		return new Vector2(0,0);
	}
	
	public String toString(){
		return "("+getX()+", "+getY()+")";
	}
	
}

package components;

/**
 * 
 * 
 * @author Alan Shields
 * @version 1.0
 */

public class Vector2 {

	private Vector vector;
	
	public Vector2(){ //constructs an empty vector
		this(0, 0);
	}
	
	public Vector2(double i, double j){
		vector = new Vector(i,j);
	}
	
	public void add(Vector2 vector1){
		setComponents((vector.getIComponent()+vector1.getI()),(vector.getJComponent()+vector1.getJ()));
	}
	
	public void setComponents(double i, double j){
		vector.setIComponent(i);
		vector.setJComponent(j);
	}
	
	public double[] getComponents(){
		return vector.getComponents();
	}
	
	public double getI(){
		return vector.getIComponent();
	}
	
	public double getJ(){
		return vector.getJComponent();
	}
	
	public Vector2 scale(double scalar){
		Vector2 thisVector = this;
		
		double newI = (thisVector.getI()*scalar);
		double newJ = (thisVector.getJ()*scalar);
		thisVector.setComponents(newI, newJ);
		
		return thisVector;
	}
	
	public void display(){
		System.out.println("<" + vector.getIComponent() + ",<" + vector.getJComponent() + ">");
	}
	
	public void clear(){
		double[] newComponents = {0,0};
		vector.setComponents(newComponents);
	}
	
	public Vector getVector(){
		return vector;
	}

	private class Vector{
		private double[] components;
		private static final int DEFAULT_SIZE = 2;
		
		private Vector(){
			this(0.0, 0.0);
		}
		
		private Vector(double iComponent, double jComponent){
			System.out.println("constructing new vector");
			components = (double[]) new double[DEFAULT_SIZE];
			components[0] = iComponent;
			components[1] = jComponent;
			
			System.out.println("Vector i: " + components[0]);
			System.out.println("Vector j: " + components[1]);
		}
		
		public double[] getComponents(){
			return components;
		}//end getComponents
		
		public double getIComponent(){
			return components[0];
		}
		
		public double getJComponent(){
			return components[1];
		}
		
		private void setComponents(double[] newComponents){
			System.out.println("newComponents Length: " + newComponents.length);
			if(newComponents.length != 2){
				System.err.println("setComponents requires a [2] array." + 
				" The vector passed contains: " + newComponents.length + " elments."); 
				return;
			}else{
				components[0] = newComponents[0];
				components[1] = newComponents[1];
			}
		}//end setComponents
		
		private void setIComponent(double i){
			components[0] = i;
		}
		
		private void setJComponent(double j){
			components[1] = j;
		}
		
		private Vector add(Vector vector1){
			Vector vector2 = new Vector();
			for(int i=0;i<2;i++){
				vector2.components[i] = (components[i]+vector1.components[i]);
			}
			return vector2;
		}
		
		private void scalar(double d){
			for(int i=0;i<2;i++){
				components[i] = (components[i]*d);
			}
		}
		
		private double dot(Vector vector1, Vector vector2){
			double d = 0;
			d = (vector1.components[0]*vector2.components[0])+(vector1.components[1]*vector2.components[1]);
			
			return d;
		}
	}
}


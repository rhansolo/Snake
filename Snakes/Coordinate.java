public class Coordinate{
    double xcor;
    double ycor;
    //basic coordinate class for the snake segments
    public Coordinate(double x, double y){
	this.xcor = x;
	this.ycor = y;
    }
    //accessors
    public double getXcor(){
	return this.xcor;
    }
    public double getYcor(){
	return this.ycor;
    }
}

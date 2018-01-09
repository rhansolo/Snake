public class Entity{
    private int x,y;

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void setX(int xcor){
	x = xcor;
    }
    public void setY(int ycor){
	y = ycor;
    }
    public void setPostion(int xcor, int ycor){
	x = xcor;
	y = ycor;
    }
    public void move(int xChange, int yChange){
	x += xChange;
	y += yChange;
    }
    public boolean didCollide(Entity other){
	return(this.x = other.x && this.y - other.y);
    }
}


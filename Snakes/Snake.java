import java.util.*;
public class Snake extends Entity{
    int startingLength;
    String[] direction = {"UP","DOWN","LEFT","RIGHT"};
    ArrayList<Segment> segmentList= new ArrayList<Segment>(3);
    public Snake(){
	startingLength = 3;
	segmentList.set(0,new Segment(0,0));
	segmentList.set(1,new Segment(1,0));
	segmentList.set(2,new Segment(2,0));
    }
    
}

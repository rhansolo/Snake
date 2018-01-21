import java.awt.Graphics;

public class GameState extends State{
    public int score;
    private Snake player;
    private Apple food;
    private Game game;
    
    public GameState(Game game,int score){
	super(game);
	this.score = score;
	this.game = game;
	player = new Snake(game, 100, 100);
	food = new Apple(game);
    }
    
    public int getScore(){
	return score;
    }
    public void setScore(int score){
	this.score = score;
    }
    
    @Override
    // updates value of score and lives
    public void tick() {
	player.tick();
	score ++;
	game.getDisplay().getTxtCurrentScore().setText("Current Score:   "+score);
	if (player.eat(food)){
	    for (int i = 0; i < 15; i++){
		player.grow();
	    }
	    score += 100;
	    game.getDisplay().getTxtCurrentScore().setText("Current Score:   "+score);
	    food = new Apple(game);
	}
	
    }
    
    @Override
    //draws both snake and the apple
    public void render(Graphics g) {
		player.render(g);
		food.render(g);
    }
}

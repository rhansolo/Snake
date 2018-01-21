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
	@Override
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
    // System.out.println("Test Begin");
    // System.out.println((int)player.getCoordList().get(0).xcor);
    // System.out.println((int)player.getCoordList().get(0).ycor);
    // System.out.println(food.getXcor() / 10);
    // System.out.println(food.getYcor() / 10);
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
		food.render(g);
	}
}

import java.awt.Graphics;

public class GameState extends State{
        private Snake player;
        private Apple food;

	public GameState(Game game){
		super(game);
		player = new Snake(game, 100.0, 100.0);
    food = new Apple(game);
	}

	@Override
	public void tick() {
		player.tick();
    food.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
    food.render(g);
	}
}

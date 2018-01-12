import java.awt.Graphics;

public class GameState extends State{
        private Snake player;

	public GameState(Game game){
		super(game);
		player = new Snake(game, 100, 100);
	}

	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
}

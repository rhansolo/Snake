import java.awt.Graphics;

public class GameState extends State{
        private Snake player;
        private Apple food;

	public GameState(Game game){
		super(game);
		player = new Snake(game, 100, 100);
		food = new Apple(game);
	}

	@Override
	public void tick() {
		player.tick();
    if (player.eat(food)){
      for (int i = 0; i < 15; i++){
        player.grow();
      }
      food = new Apple(game);
    }
    System.out.println("Test Begin");
    System.out.println((int)player.getCoordList().get(0).xcor);
    System.out.println((int)player.getCoordList().get(0).ycor);
    System.out.println(food.getXcor() / 10);
    System.out.println(food.getYcor() / 10);
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
		food.render(g);
	}
}

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

//didn't work out. class not implemented in our game
 
public class Menu extends State {

	private JFrame frame;

  private boolean start = false;

  private Game game;


  /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  */


	public Menu(Game game) {
    super(game);
	}
  @Override
  public void tick(){
    if (start){
      State.setState(game.getGameState());
    }
  }
  @Override
  public void render(Graphics g){

		JButton btnStart = new JButton("START");
		btnStart.setForeground(Color.LIGHT_GRAY);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        start = true;
			}
		});
		btnStart.setBackground(Color.BLUE);
		btnStart.setFont(new Font("Verdana", Font.PLAIN, 48));
		btnStart.setBounds(451, 241, 230, 105);
		frame.getContentPane().add(btnStart);

		JLabel lblNewLabel = new JLabel("SNAKE ");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 98));
		lblNewLabel.setBounds(395, 82, 364, 97);
		frame.getContentPane().add(lblNewLabel);

		JButton btnDifficulties = new JButton("Difficulty");
		btnDifficulties.setForeground(Color.LIGHT_GRAY);
		btnDifficulties.setFont(new Font("Verdana", Font.PLAIN, 38));
		btnDifficulties.setBackground(Color.BLUE);
		btnDifficulties.setBounds(451, 380, 230, 105);
		frame.getContentPane().add(btnDifficulties);

		JButton btnScores = new JButton("SCORES");
		btnScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScores.setForeground(Color.LIGHT_GRAY);
		btnScores.setFont(new Font("Verdana", Font.PLAIN, 38));
		btnScores.setBackground(Color.BLUE);
		btnScores.setBounds(451, 520, 230, 105);
		frame.getContentPane().add(btnScores);
	}
}

import java.awt.*;

import java.awt.EventQueue;
import javax.swing.*;
public class Display {

	private JFrame frame;
	private Canvas canvas;

	private JTextField txtCurrentScore;
	private JTextField txtLives;

	private String title;
	private int width, height;

	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
    //creates display for game
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Textfield here
		txtCurrentScore = new JTextField();
		txtCurrentScore.setBackground(SystemColor.window);
		txtCurrentScore.setForeground(Color.BLACK);
		txtCurrentScore.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		txtCurrentScore.setText("Current Score:");
		txtCurrentScore.setBounds(0, 0, 726, 49);
		frame.getContentPane().add(txtCurrentScore);
		txtCurrentScore.setColumns(10);

		txtLives = new JTextField();
		txtLives.setForeground(Color.BLACK);
		txtLives.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		txtLives.setBackground(SystemColor.window);
		txtLives.setText("Lives:  3");
		txtLives.setBounds(721, 0, 319, 49);
		frame.getContentPane().add(txtLives);
		txtLives.setColumns(10);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));

		frame.add(canvas);
		frame.pack();
	}
    //accessors
	public Canvas getCanvas(){
		return canvas;
	}

	public JFrame getFrame(){
		return frame;
	}

	public JTextField getTxtLives(){
		return txtLives;
	}

	public JTextField getTxtCurrentScore(){
		return txtCurrentScore;
	}






}

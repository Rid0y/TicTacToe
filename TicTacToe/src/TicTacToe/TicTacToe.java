package TicTacToe;

import java.awt.*;	
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
		
		//instance of random class 
		Random random = new Random();
		
		//Frame
		JFrame frame = new JFrame();
		JPanel title_p = new JPanel();
		JPanel button_p = new JPanel();
		JLabel textfield = new JLabel();
		JButton[] button = new JButton[9];
		boolean p_turn_1;
		
		
		
		//Constructor
		TicTacToe(){
			//Frame Design
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,800);
			frame.getContentPane().setBackground(Color.black);
			frame.setLayout(new BorderLayout());
			frame.setVisible(true);
			
			//Textfield Design
			textfield.setBackground(Color.DARK_GRAY);
			textfield.setForeground(Color.cyan);
			textfield.setFont(new Font("SansSerif", Font.BOLD, 75));
			textfield.setHorizontalAlignment(JLabel.CENTER);
			textfield.setText("Tic Tac Toe");
			textfield.setOpaque(true);
			
			//Title Panel Design
			title_p.setLayout(new BorderLayout());
			title_p.setBounds(0,0,800,100);
			
			//Button Design
			button_p.setLayout(new GridLayout(3,3));
			button_p.setBackground(new Color(150,150,150));
			
			
			
			//For Loop to add Buttons to Frame 
			for(int i=0; i<9; i++) {
				button[i] = new JButton();
				button[i].setBackground(new Color(51,204,255));
				button_p.add(button[i]);
				button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
				button[i].setFocusable(false);
				button[i].addActionListener(this);
			}
			
			//Adding panels and textfields to frame
			title_p.add(textfield);
			frame.add(title_p, BorderLayout.NORTH);
			frame.add(button_p);
			
			
			//Calling first turn method
			f_turn();{
				
			}
		
		}
		
		
		

		//Method for action Performed
		public void actionPerformed(ActionEvent e) {
			
			//for loop foor player button input
			for (int i = 0; i<9; i++) {
				//if statement to check player turn
				if(e.getSource() == button[i]) {
					if(p_turn_1) {
						//if statement to output player decision 
						if(button[i].getText()=="") {
							button[i].setForeground(new Color(102,52,0));
							button[i].setText("X");
							//change turns
							p_turn_1 = false;
							textfield.setText("O turn");
							
							//calling function
							check_win();
						}
					}
					else {
						//if statement to output player decision 
						if(button[i].getText()=="") {
							button[i].setForeground(new Color(102,0,153));
							button[i].setText("O");
							//change turns
							p_turn_1 = true;
							textfield.setText("X turn");
							
							//calling function
							check_win();
						}
					}
				}
			}
		}
		
		
		
		
		//Method to determine turn
		public void f_turn() {
			
			// Two second delay
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//If Statement decide players turns 
			if(random.nextInt(2)==0) {
				p_turn_1 = true;
				textfield.setText("X turn");
			}
			else {
					p_turn_1 = false;
					textfield.setText("O turn");
			}
			
		}
		
	
		
		//Method to check Winner
		public void check_win() {
			//check x win condition
			if(		(button[0].getText()=="X") &&
					(button[1].getText()=="X") &&
					(button[2].getText()=="X")) {
				
				//calling function
				x_win(0,1,2);
			} 
			if(		(button[3].getText()=="X") &&
					(button[4].getText()=="X") &&
					(button[5].getText()=="X")) {
				
				//calling function
				x_win(3,4,5);
			}
			if(		(button[6].getText()=="X") &&
					(button[7].getText()=="X") &&
					(button[8].getText()=="X")) {
				
				//calling function
				x_win(6,7,8);
			}
			if(		(button[0].getText()=="X") &&
					(button[3].getText()=="X") &&
					(button[6].getText()=="X")) {
				
				//calling function
				x_win(0,3,6);
			}
			if(		(button[1].getText()=="X") &&
					(button[4].getText()=="X") &&
					(button[7].getText()=="X")) {
				
				//calling function
				x_win(1,4,7);
			}
			if(		(button[2].getText()=="X") &&
					(button[5].getText()=="X") &&
					(button[8].getText()=="X")) {
				
				//calling function
				x_win(2,5,8);
			}
			if(		(button[0].getText()=="X") &&
					(button[4].getText()=="X") &&
					(button[8].getText()=="X")) {
				
				//calling function
				x_win(0,4,8);
			}
			if(		(button[2].getText()=="X") &&
					(button[4].getText()=="X") &&
					(button[6].getText()=="X")) {
				
				//calling function
				x_win(2,4,6);
			}
			
			//check O win condition
			if(		(button[0].getText()=="O") &&  
					(button[1].getText()=="O") &&
					(button[2].getText()=="O")) {
				
				//calling function
				o_win(0,1,2);
			}
			if(		(button[3].getText()=="O") &&
					(button[4].getText()=="O") &&
					(button[5].getText()=="O")) {
				
				//calling function
				o_win(3,4,5);
			}
			if(		(button[6].getText()=="O") &&
					(button[7].getText()=="O") &&
					(button[8].getText()=="O")) {
				
				//calling function
				o_win(6,7,8);
			}
			if(		(button[0].getText()=="O") &&
					(button[3].getText()=="O") &&
					(button[6].getText()=="O")) {
				
				//calling function
				o_win(0,3,6);
			}
			if(		(button[1].getText()=="O") &&
					(button[4].getText()=="O") &&
					(button[7].getText()=="O")) {
				
				//calling function
				o_win(1,4,7);
			}
			if(		(button[2].getText()=="O") &&
					(button[5].getText()=="O") &&
					(button[8].getText()=="O")) {
				
				//calling function
				o_win(2,5,8);
			}
			if(		(button[0].getText()=="O") &&
					(button[4].getText()=="O") &&
					(button[8].getText()=="O")) {
				
				//calling function
				o_win(0,4,8);
			}
			if(		(button[2].getText()=="O") &&
					(button[4].getText()=="O") &&
					(button[6].getText()=="O")) {
				
				//calling function
				o_win(2,4,6);
			} else {
				
				boolean isTie = true;
			
				//for loop to find a tie
				for (int i = 0; i < button.length; i ++) {
					if (button[i].getText() == "") {
						isTie = false;
					}
				}
				
				if (isTie) {
					textfield.setText("Tie");
				}
			}
			
			
		}
		
		
		
		
		//Method for X Winner
		public void x_win(int a,  int b, int c) {
					//change colour
					button[a].setBackground(Color.green);
					button[b].setBackground(Color.green);
					button[c].setBackground(Color.green);
					
					//turning off buttons
					for(int i=0; i<9; i++){
						button[i].setEnabled(false);
					}
					textfield.setText("X wins");
					
		}
				
				
		//Method for O Winner
		public void o_win(int a,  int b, int c) {
			//change colour
			button[a].setBackground(Color.green);
			button[b].setBackground(Color.green);
			button[c].setBackground(Color.green);
			
			//turning off buttons
			for(int i=0; i<9; i++){
				button[i].setEnabled(false);
			}
			textfield.setText("O wins");
			
					
			
			
		}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class WordleView extends JFrame{

    private WordleController controller = new WordleController(this);
   private JTextField myTextBox;
   private JButton[][] buttons;
   private int rows = 0;

    public WordleView(){
        JFrame jFrame = new JFrame("Wordle Game");
        buttons = new JButton[6][5];
        jFrame.setSize(700,600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myTextBox = new JTextField(50);
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel(new GridLayout(6,5));
        jFrame.add(jPanel);

        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 5; y++){
                JButton jButton1 = new JButton();
                buttons[x][y] = jButton1;
                jPanel.add(jButton1);
            }
        }

        JPanel jPanel2 = new JPanel();
        JButton jButton = new JButton("Submit");
        jPanel2.add(myTextBox);
        jPanel2.add(jButton);
        jFrame.add(jPanel2, BorderLayout.SOUTH);
        jButton.setActionCommand("Submit");
        jButton.addActionListener(controller);


        jFrame.validate();
        jFrame.repaint();
    }

    /**
     * Getting the text that the user entered in the text box and
     * making it lower case.
     *
     * @return user entered text
     * **/
    public String getUserText(){
        return this.myTextBox.getText().toLowerCase();
    }

    /**
     * Updating the view so that the user is able to see the colour changes.
     *
     * @param words
     * @param colours
     ***/
    public void updateView(String words, ArrayList<Color> colours){
        for(int j = 0; j < 5; j++){
            buttons[rows][j].setBackground(colours.get(j));
            buttons[rows][j].setText(String.valueOf(words.charAt(j)));
        }
        if(rows < 5){
            rows++;
        }
    }

    /**
     * Launching the Wordle Game.
     * **/
    public static void main(String[] args){

        new WordleView();

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class WordleController implements ActionListener {
    private ArrayList<Character> text;
    private WordleModel model;
    private WordleView view;
    private int textCounter = 0;


    public WordleController(WordleView view){
        this.text = new ArrayList<Character>();
        this. model = new WordleModel();
        this.view = view;
    }

    /**
     * Doing the actions of word checking after the user clicks the submit button.
     * **/
    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredText = " ";
        if(e.getActionCommand() == "Submit"){
            enteredText = this.view.getUserText();
            textCounter++;
        }
        try {
            if(model.isValid(enteredText)){
                if(enteredText.length() != 5){
                    JOptionPane.showMessageDialog(null,"Please try again the length of the text is not 5 letters!");
                }
                else{
                    ArrayList<Color> colours = new ArrayList<>();
                    colours.addAll(model.getColourArray(enteredText));
                    view.updateView(enteredText,colours);
                    int counter = 0;
                    for(int i = 0; i < 5; i++) {
                        if (colours.get(i) == Color.GREEN) {
                            view.validate();
                            view.repaint();
                            counter++;

                        }
                    }
                    if(counter == 5){
                        JOptionPane.showMessageDialog(null,"Congratulations, You Guessed Correctly !!");
                        System.exit(1);
                    }
                    if (textCounter == 6){
                        JOptionPane.showMessageDialog(null,"You Have Run Out Of Tries");
                        System.exit(1);
                    }

                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please try again the word is not in the dictionary!");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}

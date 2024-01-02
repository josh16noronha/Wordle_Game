import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleModel {

    private String wordOfTheWeek = "House";

    private ArrayList<String> arr;

    public void setWordOfTheWeek(String word){
        this.wordOfTheWeek = word;
    }

    public String getWordOfTheWeek(){
        return wordOfTheWeek.toLowerCase();
    }

    /**
     * Checks to see if the 5-letter word is in the dictionary and
     * if it is a real word.
     *
     * @param wordToCheck
     * @return true or false if the word exists or not
     * **/
    public Boolean isValid(String wordToCheck) throws IOException {
        this.arr = new ArrayList<String>();
        //Instantiating the URL class
        URL url = new URL("https://www.mit.edu/~ecprice/wordlist.10000");
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();

        while(sc.hasNext()) {
            this.arr.add(sc.next());
        }
        for(int i = 0; i < arr.size(); i++){
            if(wordToCheck.equals(arr.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the arrayList of colours that are displayed to the user,
     * to show if their entered word matches the set word to guess.
     *
     * @param compareWord
     * @return colours
     * **/
    public ArrayList<Color> getColourArray(String compareWord){
        ArrayList<Color> colors= new ArrayList<Color>();
        for(int i=0; i <= this.getWordOfTheWeek().length()-1; i++) {
            if(compareWord.charAt(i) == this.getWordOfTheWeek().charAt(i)){
                colors.add(Color.GREEN);
            } else if (0 <= String.valueOf(getWordOfTheWeek()).indexOf(compareWord.charAt(i)) && String.valueOf(getWordOfTheWeek()).indexOf(compareWord.charAt(i)) <= 4) {
                colors.add(Color.YELLOW);
            }else{
                colors.add(Color.RED);
            }
        }
        return colors;
    }
}

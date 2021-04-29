package MainPackage;

//file: Score.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 9/21/19
//purpose: This program is a Hangman game in which players are able to interact with
//clicking buttons and see the visual representation of a hangman being drawn for each 
//mistake the player makes. Also, the score is kept, and users are able to view them 
//from the main menu!
public class Score
{
    private String initials;
    private int score;

    public Score(String initials, int score)
    {
        this.initials = initials;
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

    public String getInitials()
    {
        return initials;
    }
    

    @Override
    public String toString() 
    {
        return this.initials + "\t\t\t" + this.score;
    }
    
    
}

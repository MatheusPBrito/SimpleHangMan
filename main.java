import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main{

  public static void main (String ... args){
    
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String hiddenWord = "", guess = " ";
    boolean won = false;
    int hp = 6;
    ArrayList<Integer> letterPos = new ArrayList<Integer>(); 
    ArrayList<Character> usedLetters = new ArrayList<Character>();

    switch (rand.nextInt(10)) {
      case 0:
        hiddenWord = "outerheaven";
        break;
      case 1:
        hiddenWord = "lion";
        break;
      case 2:
        hiddenWord = "banana";
        break;
      case 3:
        hiddenWord = "helicopter";
        break;
      case 4:
        hiddenWord = "computer";
        break;
      case 5:
        hiddenWord = "football";
        break;
      case 6:
        hiddenWord = "butterfly";
        break;
      case 7:
        hiddenWord = "television";
        break;
      case 8:
        hiddenWord = "restaurant";
        break;
      case 9:
        hiddenWord = "linux";
        break;
    }

    while (true) {
      switch (hp) {
        case 6:
          System.out.println("-------"); 
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          break;
        case 5:
          System.out.println("-------"); 
          System.out.println("|     O");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          break;
        case 4:
          System.out.println("-------"); 
          System.out.println("|     O");
          System.out.println("|     |");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          break;
        case 3:
          System.out.println("-------"); 
          System.out.println("|     O");
          System.out.println("|    /|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          break;
        case 2:
          System.out.println("-------"); 
          System.out.println("|     O");
          System.out.println("|    /|\\");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          break;
        case 1:
          System.out.println("-------"); 
          System.out.println("|     O");
          System.out.println("|    /|\\");
          System.out.println("|    /");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|");
          break;
        default:
          break;
      }
     
      System.out.print("Used letters: ");
      for (int i = 0; i < usedLetters.size(); i++){
        System.out.print(usedLetters.get(i) + " ");
      }
      System.out.println(" ");

      for (int i = 0; i < hiddenWord.length(); i++){
        if(letterPos.contains(i))
          System.out.print(hiddenWord.charAt(i));
        else
          System.out.print("_ ");
      }

      System.out.print("\t");
      while(true){
        System.out.print("Type a letter: ");
        if(input.hasNext()){
          guess = input.next();
          input.nextLine();
          if(guess.length() == 1)
            break;
          else
            System.out.println("Invalid input, only one letter");
        }
        else{
          System.out.println("Invalid input, only one letter");
          input.nextLine();
        }
      }

      boolean letterFound = false;
      for (int i = 0; i < hiddenWord.length(); i++){
        if (hiddenWord.charAt(i) == Character.toLowerCase(guess.charAt(0))){
          letterPos.add(i);
          letterFound = true;
        }
      }

      if(!letterFound){
        hp--;
        usedLetters.add(guess.charAt(0));
      }

      letterFound = false;

      if (hp == 0)
        break;
      if (letterPos.size() == hiddenWord.length()){
        won = true;
        break;
      }
    }
    if (won){
      System.out.println(hiddenWord);
      System.out.println("Gongrats you've saved the old man!");
    }
    else{
          System.out.println("-------"); 
          System.out.println("|     O");
          System.out.println("|    /|\\");
          System.out.println("|    / \\");
          System.out.println("|");
          System.out.println("|");
          System.out.println("|    DEAD");
          System.out.println("Noooooo! the old man is dead, what have you've done?");
    }
  }
} 

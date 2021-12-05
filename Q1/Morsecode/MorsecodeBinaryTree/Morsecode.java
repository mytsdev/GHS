import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @version 1.0, 04.12.2021
 * @author https://github.com/mytsdev 
 */

public class Morsecode extends JFrame {
  // Anfang Attribute
  BinaryTree dictionary = new BinaryTree();
  // Ende Attribute
  
  public Morsecode() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Morsecode");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    // Ende Komponenten
    
    setVisible(true);

    createDictionaryTree();
  } // end of public Morsecode
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Morsecode();
  } // end of main
  
  void createDictionaryTree()
  {
    dictionary.setContent("");
    dictionary.getRightTree().setContent("T");
    dictionary.getRightTree().getLeftTree().setContent("N");
    dictionary.getRightTree().getRightTree().setContent("M");
    dictionary.getRightTree().getLeftTree().getLeftTree().setContent("D");
    dictionary.getRightTree().getLeftTree().getRightTree().setContent("K");
    dictionary.getRightTree().getLeftTree().getLeftTree().getLeftTree().setContent("B");
    dictionary.getRightTree().getLeftTree().getLeftTree().getRightTree().setContent("X");
    dictionary.getRightTree().getLeftTree().getRightTree().getLeftTree().setContent("C");
    dictionary.getRightTree().getLeftTree().getRightTree().getRightTree().setContent("Y");
    dictionary.getRightTree().getRightTree().getLeftTree().setContent("G");
    dictionary.getRightTree().getRightTree().getLeftTree().getLeftTree().setContent("Z");
    dictionary.getRightTree().getRightTree().getLeftTree().getRightTree().setContent("Q");
    dictionary.getRightTree().getRightTree().getRightTree().setContent("O");
    dictionary.getLeftTree().setContent("E");
    dictionary.getLeftTree().getLeftTree().setContent("I");
    dictionary.getLeftTree().getLeftTree().getLeftTree().setContent("S");
    dictionary.getLeftTree().getLeftTree().getLeftTree().getLeftTree().setContent("H");
    dictionary.getLeftTree().getLeftTree().getLeftTree().getRightTree().setContent("V");
    dictionary.getLeftTree().getRightTree().setContent("A");
    dictionary.getLeftTree().getRightTree().getRightTree().setContent("W");
    dictionary.getLeftTree().getRightTree().getRightTree().getRightTree().setContent("J");
    dictionary.getLeftTree().getRightTree().getLeftTree().setContent("R");;
    dictionary.getLeftTree().getRightTree().getLeftTree().getLeftTree().setContent("L");
    dictionary.getLeftTree().getLeftTree().getRightTree().setContent("U");
    dictionary.getLeftTree().getLeftTree().getRightTree().getLeftTree().setContent("F");
    dictionary.getLeftTree().getRightTree().getRightTree().getLeftTree().setContent("P");
    dictionary.getLeftTree().getRightTree().getRightTree().getRightTree().setContent("J");
  }

  // Ende Methoden
} // end of class Morsecode

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
  * @version 1.0, 06.12.2021
  * @author Mats Toncik, Leon Buestgens & Finja Gurski
  *         https://github.com/mytsdev 
  */

public class Morsecode extends JFrame {
  // Anfang Attribute
  private JButton bDecode = new JButton();
  private JTextField taInput = new JTextField();
  private JTextArea taOutput = new JTextArea("");
  private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  // Ende Attribute
  
  public Morsecode() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 325; 
    int frameHeight = 200;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Morsecode | mt, lb & fg");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    taInput.setBounds(10, 10, 130, 40);
    cp.add(taInput);
    bDecode.setBounds(150, 10, 80, 41);
    bDecode.setText("Decode");
    bDecode.setMargin(new Insets(2, 2, 2, 2));
    bDecode.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDecode_ActionPerformed(evt);
      }
    });
    cp.add(bDecode);
    taOutputScrollPane.setBounds(10, 60, 129, 89);
    cp.add(taOutputScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Morsetranslator
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Morsecode();
  } // end of main
  
  public void bDecode_ActionPerformed(ActionEvent evt) {
    taOutput.setText(decode(taInput.getText())); 
  } // end of bDecode_ActionPerformed
  
  String decode(String input) {
    String output = "";
    if (!input.equals("")) {
      String[] arrInput = input.split(" ");
      for (int i = 0; i < arrInput.length; i++) {
        if (arrInput[i].equals("/")) {
          output += " ";  
        } else {
          BinaryTree morseBinaryTree = createNewMorseBinaryTree();
          for(int j = 0; j < arrInput[i].length(); j++) {
            if (arrInput[i].charAt(j) == '.') {
              morseBinaryTree = morseBinaryTree.getLeftTree();  
            } else if(arrInput[i].charAt(j) == '-') {
              morseBinaryTree = morseBinaryTree.getRightTree();
            }
          }
          output += morseBinaryTree.getContent();
        }
      }
    }
    return output;
  }

  public BinaryTree createNewMorseBinaryTree() {
    BinaryTree tempMorseBinaryTree = new BinaryTree<>(' ');
    tempMorseBinaryTree.getLeftTree().setContent('E');
    tempMorseBinaryTree.getLeftTree().getLeftTree().setContent('I');
    tempMorseBinaryTree.getLeftTree().getLeftTree().getLeftTree().setContent('S');
    tempMorseBinaryTree.getLeftTree().getLeftTree().getLeftTree().getLeftTree().setContent('H');
    tempMorseBinaryTree.getLeftTree().getLeftTree().getLeftTree().getRightTree().setContent('V');
    tempMorseBinaryTree.getLeftTree().getLeftTree().getRightTree().setContent('U');
    tempMorseBinaryTree.getLeftTree().getLeftTree().getRightTree().getLeftTree().setContent('F');;
    tempMorseBinaryTree.getLeftTree().getLeftTree().getRightTree().getRightTree().setContent('�');
    tempMorseBinaryTree.getLeftTree().getRightTree().setContent('A');
    tempMorseBinaryTree.getLeftTree().getRightTree().getLeftTree().setContent('R');
    tempMorseBinaryTree.getLeftTree().getRightTree().getLeftTree().getLeftTree().setContent('L');
    tempMorseBinaryTree.getLeftTree().getRightTree().getLeftTree().getRightTree().setContent('�');
    tempMorseBinaryTree.getLeftTree().getRightTree().getRightTree().setContent('W');
    tempMorseBinaryTree.getLeftTree().getRightTree().getRightTree().getLeftTree().setContent('P');
    tempMorseBinaryTree.getLeftTree().getRightTree().getRightTree().getRightTree().setContent('J');
    tempMorseBinaryTree.getRightTree().setContent('T');
    tempMorseBinaryTree.getRightTree().getLeftTree().setContent('N');
    tempMorseBinaryTree.getRightTree().getRightTree().setContent('M');
    tempMorseBinaryTree.getRightTree().getLeftTree().getLeftTree().setContent('D');
    tempMorseBinaryTree.getRightTree().getLeftTree().getRightTree().setContent('K');
    tempMorseBinaryTree.getRightTree().getLeftTree().getLeftTree().getLeftTree().setContent('B');
    tempMorseBinaryTree.getRightTree().getLeftTree().getLeftTree().getRightTree().setContent('X');
    tempMorseBinaryTree.getRightTree().getLeftTree().getRightTree().getLeftTree().setContent('C');
    tempMorseBinaryTree.getRightTree().getLeftTree().getRightTree().getRightTree().setContent('Y');
    tempMorseBinaryTree.getRightTree().getRightTree().getLeftTree().setContent('G');
    tempMorseBinaryTree.getRightTree().getRightTree().getLeftTree().getLeftTree().setContent('Z');
    tempMorseBinaryTree.getRightTree().getRightTree().getLeftTree().getRightTree().setContent('Q');
    tempMorseBinaryTree.getRightTree().getRightTree().getRightTree().setContent('O');
    return tempMorseBinaryTree;
  }

  // Ende Methoden
 }// end of class Morsetranslator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashSet;
import java.math.BigInteger;

/**
 *
 * Simulation of the pen game
 * WARNING! Non-algorithmic solution that is not hardware efficient
 * Returns all possible endings with the resulting winner
 *
 * @version 1.0, 29.11.2021
 * @https://github.com/mytsdev 
 */

public class PGSimulatorBigInteger extends JFrame {
  // Anfang Attribute
  private JNumberField nfInput = new JNumberField();
  private JTextArea taOutput = new JTextArea("");
    private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  private JButton bCalculate = new JButton();
  private JLabel lAmount = new JLabel();
  // Ende Attribute
  
  public PGSimulatorBigInteger() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 400; 
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("PGSimulatorBigInteger | M.T. & L.A.B.");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    nfInput.setBounds(10, 10, 75, 25);
    nfInput.setText("");
    cp.add(nfInput);
    taOutputScrollPane.setBounds(10, 40, 365, 400);
    taOutput.setEditable(false);
    cp.add(taOutputScrollPane);
    bCalculate.setBounds(300, 10, 75, 25);
    bCalculate.setText("Calculate");
    bCalculate.setMargin(new Insets(2, 2, 2, 2));
    bCalculate.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bCalculate_ActionPerformed(evt);
      }
    });
    cp.add(bCalculate);
    lAmount.setBounds(90, 10, 110, 20);
    lAmount.setText("");
    cp.add(lAmount);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public PGSimulatorBigInteger
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new PGSimulatorBigInteger();
  } // end of main
  
  public void bCalculate_ActionPerformed(ActionEvent evt) {
    calculate();
  } // end of bCalculate_ActionPerformed
  
  void calculate(){
    int num = nfInput.getInt();
    int count = num;
    int x = 0;
    int y = 0;
    int z = 1;
    int posSolutions = 0;
    for (int i = 0; i < num; i++) {
      posSolutions = z + y + x;
      x = y;
      y = z;
      z = posSolutions;
    } // end of for                  
    lAmount.setText(posSolutions + "");
    Random rndm = new Random();
    HashSet<BigInteger> hsSolutions = new HashSet();
    taOutput.setText("");
    while (hsSolutions.size() < posSolutions) { 
      String moves = "";
      int tCount = count;
      while (tCount > 0) { 
        do {
          num = rndm.nextInt(3) + 1;
        } while (num > count); // end of do-while
        tCount -= num;
        moves += num;
        if (tCount == 0) {
          BigInteger biNum = new BigInteger(moves);
          hsSolutions.add(biNum);
        } // end of if
      } // end of while
    } // end of while
    List<BigInteger> listSolutions = new ArrayList<>(hsSolutions);
    Collections.sort(listSolutions);
    BigInteger[] arrSolutions = listSolutions.toArray(new BigInteger[0]);
    for (int i = 0; i < arrSolutions.length; i++) {
      if (arrSolutions[i].toString().length() % 2 == 0) {
        taOutput.append("Winner: Player 1 Moves: " + arrSolutions[i] + "\n");
      } else {
        taOutput.append("Winner: Player 2 Moves: " + arrSolutions[i] + "\n");
      } // end of if-else
    } // end of for
  }
  // Ende Methoden
} // end of class PGSimulatorBigInteger

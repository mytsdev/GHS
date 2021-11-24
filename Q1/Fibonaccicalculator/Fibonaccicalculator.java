import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigInteger;

/**
 * @version 1.0 vom 25.11.2021
 * @https://github.com/mytsdev 
 */

public class Fibonaccicalculator extends JFrame {
  // Anfang Attribute  
  private JTextArea taOutput = new JTextArea("");
    private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  private JNumberField nfInput = new JNumberField();
  private JButton bCalculate = new JButton();
  // Ende Attribute
  
  public Fibonaccicalculator() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 250; 
    int frameHeight = 290;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Fibonacci");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    taOutputScrollPane.setBounds(10, 40, 200, 200);
    cp.add(taOutputScrollPane);
    nfInput.setBounds(10, 10, 50, 25);
    nfInput.setText("");
    cp.add(nfInput);
    bCalculate.setBounds(135, 10, 75, 25);
    bCalculate.setText("Calculate");
    bCalculate.setMargin(new Insets(2, 2, 2, 2));
    bCalculate.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bCalculate_ActionPerformed(evt);
      }
    });
    cp.add(bCalculate);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Fibonaccicalculator
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Fibonaccicalculator();
  } // end of main
  
  void calculate(int n){
    BigInteger x = new BigInteger("1");
    BigInteger y = new BigInteger("0");
    BigInteger z = new BigInteger("0");
    taOutput.setText("");
    for (int i = 0; i < n; i++) {
      z = x.add(y);
      x = y;
      y = z;
      taOutput.append((i+1) + ". " + z + "\n");
    } // end of for     
  }
  
  public void bCalculate_ActionPerformed(ActionEvent evt) {
    calculate(nfInput.getInt());
  } // end of bCalculate_ActionPerformed

  // Ende Methoden
} // end of class Fibonaccicalculator

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @version 1.0, 21.11.2021
 * @https://github.com/mytsdev 
 */

public class Palindromechecker extends JFrame {

  private JButton bCheck = new JButton();
  private JTextField tfInput = new JTextField();
  private JTextArea taOutput = new JTextArea("");
    private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  
  public Palindromechecker() { 
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 350; 
    int frameHeight = 145;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Palindromechecker");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    bCheck.setBounds(250, 10, 75, 25);
    bCheck.setText("Check");
    bCheck.setMargin(new Insets(2, 2, 2, 2));
    bCheck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bCheck_ActionPerformed(evt);
      }
    });
    cp.add(bCheck);
    tfInput.setBounds(10, 10, 230, 25);
    cp.add(tfInput);
    taOutputScrollPane.setBounds(10, 40, 315, 55);
    taOutput.setEditable(false);
    cp.add(taOutputScrollPane);
    
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new Palindromechecker();
  }
  
  public void bCheck_ActionPerformed(ActionEvent evt) {
    if (!tfInput.getText().equals("")) {
      Stack s = new Stack();
      String word = tfInput.getText();
      for (int i = 0; i < word.length(); i++) {
        s.push(word.charAt(i));
      }
      tfInput.setText(null);
      String word2 = "";
      while (!s.isEmpty()) { 
        word2 += s.top();
        s.pop();
      }
      if (word.equalsIgnoreCase(word2)) {
        taOutput.setText(word + " is a palindrome. \nForward: " + word + "\nBackward: " + word2);
      }
      else {
        taOutput.setText(word + " is not a palindrome. \nForward: " + word + "\nBackward: " + word2);
      }
    }
  }
}

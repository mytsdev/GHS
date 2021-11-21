import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Stack;

/**
 * @version 1.0, 21.11.2021
 * @https://github.com/mytsdev 
 */

public class Examstack extends JFrame {

  private JTextField tfInput = new JTextField();
  private JButton bUp = new JButton();
  private JButton bDown = new JButton();
  private JLabel lOutput = new JLabel();
  private JLabel lSize = new JLabel();
  
  Stack s = new Stack();
  
  public Examstack() { 
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 350; 
    int frameHeight = 125;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Examstack");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    tfInput.setBounds(10, 10, 225, 25);
    tfInput.setText("");
    cp.add(tfInput);
    bUp.setBounds(240, 10, 75, 25);
    bUp.setText("Up");
    bUp.setMargin(new Insets(2, 2, 2, 2));
    bUp.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bUp_ActionPerformed(evt);
      }
    });
    cp.add(bUp);
    bDown.setBounds(240, 40, 75, 25);
    bDown.setText("Down");
    bDown.setMargin(new Insets(2, 2, 2, 2));
    bDown.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDown_ActionPerformed(evt);
      }
    });
    cp.add(bDown);
    lOutput.setBounds(10, 40, 225, 20);
    lOutput.setText("");
    cp.add(lOutput);
    lSize.setBounds(10, 60, 225, 20);
    lSize.setText("Exams on the stack:");
    cp.add(lSize);
    
    setVisible(true);
  }
    
  public static void main(String[] args) {
    new Examstack();
  }
  
  public void bUp_ActionPerformed(ActionEvent evt) {
    if (!tfInput.getText().equals("")) {
      s.push(tfInput.getText());
      lSize.setText("Exams on the stack: " + s.size());
      tfInput.setText("");
    }
  } 

  public void bDown_ActionPerformed(ActionEvent evt) {
    if (!s.empty()) {
      lOutput.setText("Exam of: " + (String)s.pop());
      lSize.setText("Exams on the stack: " + s.size());
    } 
  }
}

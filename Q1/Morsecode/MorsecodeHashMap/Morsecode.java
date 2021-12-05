import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.HashMap;

/**
 * @version 1.0, 30.11.2021
 * @author https://github.com/mytsdev
 */

public class Morsecode extends JFrame {
  // Anfang Attribute
  private JTextArea taWords = new JTextArea("");
    private JScrollPane taWordsScrollPane = new JScrollPane(taWords);
  private JTextArea taMorse = new JTextArea("");
    private JScrollPane taMorseScrollPane = new JScrollPane(taMorse);
  private JButton bEncode = new JButton();
  private JButton bDecode = new JButton();
  private JButton bClear = new JButton();
  
  HashMap<Character, String> dictionary = new HashMap<Character, String>();
  HashMap<String, Character> dictionaryInverse = new HashMap<String, Character>();
  // Ende Attribute
  
  public Morsecode() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 340; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Morsecode | M.T. & L.A.B.");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    taWordsScrollPane.setBounds(10, 10, 200, 100);
    cp.add(taWordsScrollPane);
    taMorseScrollPane.setBounds(10, 125, 200, 100);
    cp.add(taMorseScrollPane);
    bDecode.setBounds(215, 125, 100, 25);
    bDecode.setText("Decode");
    bDecode.setMargin(new Insets(2, 2, 2, 2));
    bDecode.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDecode_ActionPerformed(evt);
      }
    });
    cp.add(bDecode);
    bEncode.setBounds(215, 10, 100, 25);
    bEncode.setText("Encode");
    bEncode.setMargin(new Insets(2, 2, 2, 2));
    bEncode.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEncode_ActionPerformed(evt);
      }
    });
    cp.add(bEncode);
    bClear.setBounds(10, 230, 100, 25);
    bClear.setText("Clear");
    bClear.setMargin(new Insets(2, 2, 2, 2));
    bClear.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bClear_ActionPerformed(evt);
      }
    });
    cp.add(bClear);
    // Ende Komponenten
    
    createDictionary();
    
    setVisible(true);
  } // end of public Morsecode
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Morsecode();
  } // end of main
  
  String encode(String input)
  {
    String output = "";
    if (!input.equals("")) {
      for (int i = 0; i < input.length(); i++) {
        output += dictionary.get(input.toLowerCase().charAt(i)) + " ";
      }  
    }
    return output;
  }
  
  String decode(String input)
  {
    String output = "";
    if (!input.equals("")) {
      String[] inputSplit = input.split(" ");
      for (int i = 0; i < inputSplit.length; i++) {
        output += dictionaryInverse.get(inputSplit[i]);
      }
    }
    return output;
  }
  
  void createDictionary(){
    //Basic-Alphabet
    dictionary.put('a', ".-");
    dictionary.put('b', "-...");
    dictionary.put('c', "-.-.");
    dictionary.put('d', "-..");
    dictionary.put('e', ".");
    dictionary.put('f', "..-.");
    dictionary.put('g', "--.");
    dictionary.put('h', "....");
    dictionary.put('i', "..");
    dictionary.put('j', ".---");
    dictionary.put('k', "-.-");
    dictionary.put('l', ".-..");
    dictionary.put('m', "--");
    dictionary.put('n', "-.");
    dictionary.put('o', "---");
    dictionary.put('p', ".--.");
    dictionary.put('q', "--.-");
    dictionary.put('r', ".-.");
    dictionary.put('s', "...");
    dictionary.put('t', "-");
    dictionary.put('u', "..-");
    dictionary.put('v', "...-");
    dictionary.put('w', ".--");
    dictionary.put('x', "-..-");
    dictionary.put('y', "-.--");
    dictionary.put('z', "--..");
    
    //Extended-Alphabet
    dictionary.put('�', ".-.-");
    dictionary.put('�', "---.");
    dictionary.put('�', "..--");
    dictionary.put('�', "......");
    
    //Numbers
    dictionary.put('1', ".----");
    dictionary.put('2', "..---");
    dictionary.put('3', "...--");
    dictionary.put('4', "....-");
    dictionary.put('5', ".....");
    dictionary.put('6', "-....");
    dictionary.put('7', "--...");
    dictionary.put('8', "---..");
    dictionary.put('9', "----.");
    dictionary.put('0', "-----");
    
    //Punctuation
    dictionary.put('.', ".-.-.-");
    dictionary.put(',', "--..--");
    dictionary.put('?', "..--..");
    dictionary.put('\'', ".----.");
    dictionary.put('!', "-.-.--");
    dictionary.put('/', "-..-.");
    dictionary.put('(', "-.--.");
    dictionary.put(')', "-.--.-");
    dictionary.put('&', ".-...");
    dictionary.put(':', "---...");
    dictionary.put(';', "-.-.-.");
    dictionary.put('=', "-...-");
    dictionary.put('+', ".-.-.");
    dictionary.put('-', "-....-");
    dictionary.put('_', "..--.-");
    dictionary.put('"', ".-..-.");
    dictionary.put('$', "...-..-");
    dictionary.put('@', ".--.-.");
    dictionary.put('�', "..-.-");
    dictionary.put('�', "--...-");
    
    dictionary.put(' ', "/");
    
    for (HashMap.Entry<Character, String> entry : dictionary.entrySet()) {
      dictionaryInverse.put(entry.getValue(), entry.getKey());
    } // end of for
  }
  
  public void bEncode_ActionPerformed(ActionEvent evt) {
    taMorse.setText(encode(taWords.getText()));
  } // end of bEncode_ActionPerformed
  
  public void bDecode_ActionPerformed(ActionEvent evt) {
    taWords.setText(decode(taMorse.getText()));
  } // end of bDecode_ActionPerformed

  public void bClear_ActionPerformed(ActionEvent evt) {
    taWords.setText("");
    taMorse.setText("");
  } // end of bClear_ActionPerformed

  // Ende Methoden
} // end of class Morsecode

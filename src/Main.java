
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("TPLANGS PROJECT");
        JPanel panel = new JPanel(null);
        JPanel lexicalPanel = new JPanel(null);
        JPanel semanticPanel = new JPanel();
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("Process");
        JTabbedPane tabs = new JTabbedPane();
        JTextArea lexicalArea = new JTextArea();
        
        button.setBounds(175, 240, 150, 30);
        textArea.setBounds(25, 25, 450, 200);
        textArea.setLineWrap(true);
        lexicalArea.setBounds(0, 0, 450, 180);
        lexicalArea.setLineWrap(true);
        lexicalPanel.add(lexicalArea);
        semanticPanel.setBackground(Color.WHITE);
        tabs.setBounds(25, 285, 450, 200);
        tabs.add("Lexical", lexicalPanel);
        tabs.add("Semantic", semanticPanel);
        
        panel.add(textArea);
        panel.add(button);
        panel.add(tabs);
        panel.setPreferredSize(new Dimension(500, 500));
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String scanned = LexicalAnalyzer.scan(textArea.getText());
                lexicalArea.setText(scanned);
            }
        });
    }
}


//    =========================================================================
//                              Sample Program
//    =========================================================================
//#include <iostream>
//using namespace std;
//
//int main() {
//    int i = 2;
//    i = i +3;
//    cout << "This is the result: " + i;
//    return 0;
//}
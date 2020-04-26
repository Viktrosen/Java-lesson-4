import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainClass {
    JFrame  frame;
    JTextField field;
    JButton button;
    JTextArea area;
    JScrollPane pane;

    public void go(){
        frame = new JFrame("Чат");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        area = new JTextArea();
        area.setEditable(false);
        pane = new JScrollPane(area);
        pane.setPreferredSize(new Dimension(100,800));
        field = new JTextField();
        field.addActionListener(new Sender());
        field.grabFocus();
        button = new JButton("Отправить");
        button.addActionListener(new Sender());
        frame.add(pane);
        frame.add(field);
        frame.add(button);
        frame.setVisible(true);
    }
   public class Sender implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e) {
           area.setText(area.getText()+"\n"+field.getText());
           field.setText("");
           field.grabFocus();
       }
   }
    public static void main(String[] args) {
        MainClass gui = new MainClass();
        gui.go();
    }
}

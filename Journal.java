import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Journal extends JFrame{
    private JButton Today;
    private JButton Previous;
    private JButton Back;
    private JTextArea jta;
    private JScrollPane jta_scroller;
    private Listener_journal l;
    Journal() {
        //jfc = new Journal_file_class();
        jta = new JTextArea(Journal_file_class.read_from_journal(),23,28);
        jta_scroller = new JScrollPane(jta);
        Today = new JButton("Today's");
        Previous = new JButton("Previous");
        Back = new JButton("Go back");
        setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        /*JPanel J = new JPanel();
        J.add(Today);
        J.add(Previous);
        J.add(Back);*/
        l = new Listener_journal();
        Today.addActionListener(l);
        Previous.addActionListener(l);
        Back.addActionListener(l);
    }
    public class Listener_journal implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String k = e.getActionCommand();
            switch(k) {
                case "Today's":
                    System.out.println("Today's journal");
                    JFrame f = new JFrame("Today's journal");
                    //f.setLayout(new FlowLayout(/*1,5,50*/));
                    f.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
                    f.getContentPane().setBackground(Color.BLACK);
                    f.setSize(360,500);
                    f.setLocationRelativeTo(null);
                    JPanel p = new JPanel();
                    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                    p.setBackground(Color.LIGHT_GRAY);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDateTime now = LocalDateTime.now();
                    String Title = dtf.format(now);
                    JLabel l = new JLabel(Title);
                    p.add(l);
                    p.add(jta_scroller);
                    JButton Save = new JButton("Done");
                    Listener_todays_journal jtj = new Listener_todays_journal();
                    Save.addActionListener(jtj);
                    JPanel c = new JPanel();
                    c.setLayout(new FlowLayout());
                    c.add(Save);
                    c.setBackground(Color.LIGHT_GRAY);
                    p.add(c);
                    f.add(p);
                    l.setBounds(10, 10, 50, 30);
                    f.setVisible(true);
                    f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    break;
                case "Previous":
                    System.out.println("Previous");
                    break;
                case "Go back":
                    System.out.println("Back button");
                    Background.frame.getContentPane().setVisible(false);
                    Background.frame.getContentPane().removeAll();
                    Background.frame.getContentPane().add(Background.contents());
                    //Background.homepage();
                    //Background.refresh_frame();
                    Background.frame.getContentPane().setVisible(true);
                    break;
            }
        }
    }
    public class Listener_todays_journal implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String k = e.getActionCommand();
            switch(k) {
                case "Done":
                    System.out.println("Saved today's journal");
                    //JFrame f = new JFrame("Today's journal");
                    Journal_file_class.update_journal(jta.getText());
                    break;
            }
        }
    }
    Container contents(){
        JPanel c = new JPanel();
        c.setLayout(new FlowLayout());
        c.add(Back);
        c.add(Today);
        c.add(Previous);
        return c;
    }
}

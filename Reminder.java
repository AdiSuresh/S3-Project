import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Reminder extends JFrame{
    private static JButton Back;
    private static JButton Set;
    private JButton View;
    private JButton Delete;
    private Listener l;
    //private Listener Back_btn;
    private int prev;
    Reminder(){
        Set = new JButton("Set reminder");
        View = new JButton("View reminders");
        Back = new JButton("Go back");
        setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        prev = -1;
        l = new Listener();
        //Set_btn = new Listener();
        Set.addActionListener(l);
        Back.addActionListener(l);
    }
    public static class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String k = e.getActionCommand();
            switch(k) {
                case "Set reminder":
                    System.out.println("Set reminder button");
                    JFrame f = new JFrame("Set reminder");
                    //f.setTitle("Set reminder");
                    f.setSize(360,500);
                    f.setLocationRelativeTo(null);
                    f.getContentPane().setBackground(Color.BLACK);
                    JPanel p = new JPanel();
                    JLabel l = new JLabel("Title: ");
                    p.add(l);
                    f.add(p);
                    l.setBounds(5, 5, 50, 30);
                    f.setVisible(true);
                    f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    Container contents(){
        JPanel c = new JPanel();
        c.setLayout(new FlowLayout());
        c.add(Back);
        c.add(Set);
        c.add(View);
        return c;
    }
}

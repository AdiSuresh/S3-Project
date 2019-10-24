import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Background extends JFrame{
    private static final JButton reminder = new JButton("Reminder");
    private static final JButton journal = new JButton("Journal");
    static Background frame;

    private Reminder r;
    private Journal j;
    Background(){
        r = new Reminder();
        j = new Journal();
        setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        setSize(360,300);
        setTitle("Remind Me!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new GridLayout(3,2,10,10));
        //setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(Color.DARK_GRAY);
        Listener_test l1 = new Listener_test();
        reminder.addActionListener(l1);
        journal.addActionListener(l1);
    }
    public class Listener_test implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String k = e.getActionCommand();
            switch(k) {
                case "Reminder":
                    //frame.add(r.contents());
                    getContentPane().setVisible(false);
                    clear();
                    frame.getContentPane().add(r.contents());
                    frame.getContentPane().setVisible(true);
                    break;
                case "Journal":
                    getContentPane().setVisible(false);
                    clear();
                    frame.getContentPane().add(j.contents());
                    frame.getContentPane().setVisible(true);
                    break;
            }

        }
    }
    static void clear(){
        frame.getContentPane().removeAll();
        //refresh_frame();
    }
    static Container contents(){
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));
        c.add(reminder);
        c.add(journal);
        reminder.setAlignmentX(CENTER_ALIGNMENT);
        journal.setAlignmentX(CENTER_ALIGNMENT);
        c.setAlignmentX(CENTER_ALIGNMENT);
        c.setAlignmentY(CENTER_ALIGNMENT);
        c.setPreferredSize(new Dimension(300,200));
        //refresh_frame();
        return c;
    }
    static void refresh_frame(){
        frame.getContentPane().setBackground(Color.DARK_GRAY);
    }
    static void new_frame(){
        frame = new Background();
        clear();
        frame.getContentPane().add(contents());
        frame.setVisible(true);
    }
    static void homepage(){
        clear();
        frame.add(contents());
        //refresh_frame();
        frame.setVisible(true);
    }
}
/*class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}*/

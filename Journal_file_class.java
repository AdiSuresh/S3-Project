import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Journal_file_class{
    journal_contents jc;
    public static void update_journal(String s) {
        try {
            //jc = new journal_contents();
            String directory = "C:\\Adithya\\OOPS class\\";
            String file_name = directory + "Journal" + new SimpleDateFormat("yyyy MM dd").format(Calendar.getInstance().getTime()) + ".txt";
            FileOutputStream fOut = new FileOutputStream(file_name);
            ObjectOutputStream objectOut = new ObjectOutputStream(fOut);
            journal_contents d = new journal_contents(s);
            objectOut.writeObject(d);
            objectOut.close();
            System.out.println("Journal updated");
        }
        catch (Exception ex) {
            System.out.println("Data does not exist");
        }
    }
    public static String read_from_journal(){
        try {
            String directory = "C:\\Adithya\\OOPS class\\";
            String file_name = directory + "Journal" + new SimpleDateFormat("yyyy MM dd").format(Calendar.getInstance().getTime()) + ".txt";
            FileInputStream fileIn = new FileInputStream(file_name);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            //System.out.println("The Object has been read from the file");
            objectIn.close();
            journal_contents test = (journal_contents)obj;
            System.out.println(test.info);
            return test.info;
        }
        catch (Exception ex) {
            System.out.println("Data does not exist");
            return "No content";
        }
    }
}
class journal_contents implements Serializable {
    String info;
    DateFormat date;
    journal_contents(String s){
        info = s;
        date = new SimpleDateFormat("yyyy MM dd");
    }
}

import javax.swing.*;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MainFrame {
    private JFrame f;
    private MainPanel mainPanel;
    private final static String BASH_PATH="/bin/bash";
    public MainFrame(){
        this.f = new JFrame();
        this.mainPanel = new MainPanel();
        f.add(this.mainPanel);

        f.setSize(850,600);

        this.mainPanel.addImpl(new LsImpl(null));
        this.mainPanel.addImpl(new GrepImpl(null));
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }


    public static void main(String arp[]){
        MainFrame f=new MainFrame();
    }






}

import javax.swing.*;

public class Main
{
    static JFrame window = new JFrame();
    static LoginPanel loginPanel = new LoginPanel();
    static AppPanel appPanel = new AppPanel();

    public static void main(String[] args){
        window.setVisible(true);
        window.setContentPane(loginPanel);
        window.pack();


    }

}

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.MissingFormatArgumentException;

public class Main
{
    static JFrame window = new JFrame();
    static LoginPanel loginPanel ;
    static AppPanel appPanel = new AppPanel();
    static JPanel content;


    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                content = new JPanel(new GridBagLayout());
                //content.setBackground(Color.BLUE);
                content.setBorder(new EmptyBorder(20, 20, 20, 20));
                window.setContentPane(content);

                window.setTitle("TYRAS");
                window.setVisible(true);
                try {
                    window.add(new LoginPanel());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                window.pack();
                window.setLocationRelativeTo(null);
            }
        });
    }

    public static void main(String[] args){
        new Main();

    }

    public static void grantAccess()
    {
        //window.removeAll();
        content = appPanel;
        window.setContentPane(appPanel);
        appPanel.revalidate();
        appPanel.repaint();
        window.revalidate();
        window.repaint();
        System.out.println("switching");
    }
}

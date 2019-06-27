import javax.swing.*;

public class LoginPanel extends JPanel
{
    private JLabel loginLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JButton loginB;
    private JPanel mainP;

    public LoginPanel()
    {
        loginLabel = new JLabel("Enter your JPMChase credentials: ");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        userLabel = new JLabel("ID: ");
        passwordLabel = new JLabel("Pass:");
        loginB = new JButton("login");
        mainP = new JPanel();
    }


}

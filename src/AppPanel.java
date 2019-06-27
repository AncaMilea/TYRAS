import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class AppPanel extends JPanel
{
    private JLabel chooseActionL = new JLabel("Choose an action: ");
    private JLabel emailAction;
    private JLabel excelAction;
    private JLabel fileAction;
    private JLabel cosmoAction;
    private DecisionTreePanel decisionTreePanel = new DecisionTreePanel();
    private JPanel topBarPanel = new JPanel();

    public AppPanel(){
        setupTopBar();
        this.setLayout(new BorderLayout());
        this.add(decisionTreePanel, BorderLayout.CENTER);
        this.add(topBarPanel, BorderLayout.NORTH);

    }

    private void setupTopBar()
    {
        setupLabels();

        topBarPanel.setLayout(new GridLayout(1,5));
        topBarPanel.add(chooseActionL);
        topBarPanel.add(emailAction);
        topBarPanel.add(excelAction);
        topBarPanel.add(fileAction);
        topBarPanel.add(cosmoAction);
    }

    private void setupLabels() {
        ImageIcon emailImg;
        ImageIcon excelImg;
        ImageIcon fileImg;
        ImageIcon cosmicImg;

        try{
            emailImg = new ImageIcon("email.png");
            excelImg = new ImageIcon("excel.png");
            fileImg = new ImageIcon("folder.png");
            cosmicImg = new ImageIcon("cosmic.png");
            emailAction = new JLabel();
            emailAction.setIcon(emailImg);

            excelAction = new JLabel();
            excelAction.setIcon(excelImg);

            fileAction = new JLabel();
            fileAction.setIcon(fileImg);

            cosmoAction = new JLabel();
            cosmoAction.setIcon(cosmicImg);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

}



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class AppPanel extends JPanel
{
    private JLabel chooseActionL = new JLabel("Choose an action: ");
    private JRadioButton emailAction;
    private JRadioButton excelAction;
    private JRadioButton fileAction;
    private JRadioButton cosmoAction;
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

        addListeners();
    }

    private void addListeners() {
        emailAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show popup
                EmailFrame email = new EmailFrame();


                //set visual
                decisionTreePanel.setEmailAction();
            }
        });

        excelAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show popup
                ExcelFrame frame = new ExcelFrame();

                //set visual
                decisionTreePanel.setExcelAction();
            }
        });

        fileAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show popup

                //set visual
                decisionTreePanel.setFileAction();
            }
        });

        cosmoAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show popup

                //set visual
                decisionTreePanel.setCosmicAction();
            }
        });
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
            emailAction = new JRadioButton(emailImg);

            excelAction = new JRadioButton(excelImg);

            fileAction = new JRadioButton(fileImg);

            cosmoAction = new JRadioButton(cosmicImg);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

}



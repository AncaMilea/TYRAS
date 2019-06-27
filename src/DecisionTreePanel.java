import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecisionTreePanel extends JPanel
{
    private JLabel initialMessage = new JLabel("Chosen actions will appear here...");
    private JButton addActionB = new JButton("Add Action");
    private JButton addBranchAction = new JButton("Add Branch");
    private JPanel decisionPanel = new JPanel();
    private JRadioButton[][] decisionTree = new JRadioButton[10][10];
    private int branches = 1;
    private int currentBranch = 0;
    private int currentAction = 0;
    private int maxActions = 0;
    private JPanel buttonsP = new JPanel();


    public DecisionTreePanel(){
        buttonsP = new JPanel();
        buttonsP.setLayout(new FlowLayout());
        buttonsP.add(addActionB);
        buttonsP.add(addBranchAction);

        decisionPanel.add(initialMessage);

        this.setLayout(new BorderLayout());
        this.add(decisionPanel, BorderLayout.CENTER);
        this.add(buttonsP, BorderLayout.SOUTH);

        addListeners();
    }

    private void addListeners() {
        addActionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentAction == 0 && currentBranch == 0)
                {
                    decisionTree[0][0] = new JRadioButton(generateBlankAction());

                    maxActions++;
                    currentAction++;
                    System.out.println("Adding the first blank action");
                }
                else{
                    currentAction++;
                    decisionTree[currentBranch][currentAction] = new JRadioButton("here3",generateBlankAction());
                    if(currentAction>maxActions)
                        maxActions = currentAction;
                }

                drawDecisionTree();
            }
        });

        addBranchAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                branches++;
                currentBranch++;

                currentAction++;
                decisionTree[currentBranch][currentAction-1] = new JRadioButton("here 1",generateDownArrowImg());
                decisionTree[currentBranch][currentAction] = new JRadioButton("here 2",generateBlankAction());

                if(currentAction>maxActions)
                    maxActions = currentAction;
                drawDecisionTree();
            }
        });
    }

    private void drawDecisionTree(){
        decisionPanel.removeAll();

        decisionPanel.setLayout(new GridLayout(branches, 1));


        for(int i = 0; i<branches; i++)
        {
            JPanel row = new JPanel();
            row.setLayout(new FlowLayout());
            for(int j = 0; j<maxActions; j++)
            {
                System.out.println("drawing row");
                JLabel right_arrowLabel = new JLabel();
                right_arrowLabel.setIcon(generateRightArrowImg());

                if(decisionTree[i][j]!=null) {
                    if (j != 0)
                        row.add(right_arrowLabel);

                    row.add(decisionTree[i][j]);
                }
                else{
                    JLabel emptyImgLabel = new JLabel();
                    emptyImgLabel.setIcon(generateEmptyLabel());
                    System.out.println("drawing down empty");
                    row.add(emptyImgLabel);
                }
            }



            decisionPanel.add(row);
            decisionPanel.revalidate();
            decisionPanel.repaint();
        }
    }

    private ImageIcon generateEmptyLabel() {
        try {
            return new ImageIcon("empty.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ImageIcon generateDownArrowImg() {
        try {
            return new ImageIcon("down_arrow.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ImageIcon generateRightArrowImg() {
        try {
            return new ImageIcon("right_arrow.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageIcon generateBlankAction(){
        try {
            return new ImageIcon("blank_action.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageIcon generateEmailAction(){
        try {
            return new ImageIcon("email_action.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageIcon generateExcelAction(){
        try {
            return new ImageIcon("excel_action.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageIcon generateFileAction(){
        try {
            return new ImageIcon("file_action.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageIcon generateCosmicAction(){
        try {
            return new ImageIcon("cosmic_action.png");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}

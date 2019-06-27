import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
import java.util.HashMap;

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
    private int selectedCol;
    private int selectedRow;
    private HashMap<JRadioButton, Position> buttPos = new HashMap<>();

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

                    JRadioButton action = new JRadioButton("here3",generateBlankAction());
                    action.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setSelected(buttPos.get(action).getRow(), buttPos.get(action).getCol());
                            System.out.println("Selected is: " + buttPos.get(action).getRow()+ " " + buttPos.get(action).getCol());
                        }
                    });
                    buttPos.put(action, new Position(currentBranch, currentAction));

                    decisionTree[currentBranch][currentAction] = action;
                    currentAction++;
                    if(currentAction>maxActions)
                        maxActions = currentAction;


                drawDecisionTree();
            }
        });

        addBranchAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                branches++;
                currentBranch++;
                currentAction++;

                JRadioButton action1 = new JRadioButton("here 1",generateDownArrowImg());


                JRadioButton action2 = new JRadioButton("here 2",generateBlankAction());
                action2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setSelected(buttPos.get(action2).getRow(), buttPos.get(action2).getCol());
                        System.out.println("Selected is: " + buttPos.get(action2).getRow()+ " " + buttPos.get(action2).getCol());
                    }
                });

                buttPos.put(action2, new Position(currentBranch, currentAction));

                decisionTree[currentBranch][currentAction-1] = action1;
                decisionTree[currentBranch][currentAction] = action2;

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
                System.out.println("drawing row "+maxActions);
                JLabel right_arrowLabel = new JLabel();
                right_arrowLabel.setIcon(generateRightArrowImg());

                if(decisionTree[i][j]!=null) {
                    if (j != 0)
                        row.add(right_arrowLabel);

                    row.add(decisionTree[i][j]);
                }
                else{
                    if(j!=0) {
                        JLabel emptyImgLabel = new JLabel();
                        emptyImgLabel.setIcon(generateEmptyLabel());
                        System.out.println("drawing down empty");
                        row.add(emptyImgLabel);
                    }
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

    public void setSelected(int row, int col){
        selectedRow = row;
        selectedCol = col;
    }

    class Position{
        int row;
        int col;

        public Position(int nrow, int ncol){
            row=nrow;
            col = ncol;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

}

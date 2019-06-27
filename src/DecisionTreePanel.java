import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DecisionTreePanel extends JPanel
{
    private JLabel initialMessage = new JLabel("Chosen actions will appear here...");
    private JButton addActionB = new JButton("Add Action");
    private JButton addBranchAction = new JButton("Add Branch");
    private JButton start = new JButton("Start automation");
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
        buttonsP.add(start);

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

                    JRadioButton action = new JRadioButton(generateBlankAction());
                    buttPos.put(action, new Position(currentBranch, currentAction));
                    action.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(buttPos.get(action)==null)
                            {
                                System.out.println("Button is not in the array");
                            }
                            else {
                                setSelected(buttPos.get(action).getRow(), buttPos.get(action).getCol());
                                System.out.println("Selected is: " + buttPos.get(action).getRow() + " " + buttPos.get(action).getCol());
                                action.setBackground(Color.gray);
                                resetOtherBackgrounds();
                            }
                        }
                    });

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

                JRadioButton action1 = new JRadioButton(generateDownArrowImg());


                JRadioButton action2 = new JRadioButton(generateBlankAction());
                action2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setSelected(buttPos.get(action2).getRow(), buttPos.get(action2).getCol());
                        System.out.println("Selected is: " + buttPos.get(action2).getRow()+ " " + buttPos.get(action2).getCol());
                        action2.setBackground(Color.gray);
                        resetOtherBackgrounds();
                    }
                });

                buttPos.put(action2, new Position(currentBranch, currentAction));


                    decisionTree[currentBranch][currentAction - 1] = action1;
                    decisionTree[currentBranch][currentAction] = action2;

                if(currentAction>maxActions)
                    maxActions = currentAction;
                drawDecisionTree();
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //start automation
                JOptionPane.showMessageDialog(new JFrame(), "Automation process has started.");
            }
        });
    }

    private void resetOtherBackgrounds()
    {
        Iterator it = buttPos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<JRadioButton, Position> pair = (Map.Entry)it.next();

            if(!(pair.getValue().row==selectedRow && pair.getValue().col == selectedCol))
            {
                System.out.println("reseting a background");
                pair.getKey().setBackground(this.getBackground());
            }

        }
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

    public void setEmailAction()
    {
        int row = selectedRow;
        int col = selectedCol;

        Iterator it = buttPos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<JRadioButton, Position> pair = (Map.Entry)it.next();


            if(pair.getValue().row==row && pair.getValue().col == col)
                pair.getKey().setIcon(generateEmailAction());

        }
    }

    public void setFileAction()
    {
        int row = selectedRow;
        int col = selectedCol;

        Iterator it = buttPos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<JRadioButton, Position> pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            if(pair.getValue().row==row && pair.getValue().col == col)
                pair.getKey().setIcon(generateFileAction());
        }
    }

    public void setCosmicAction()
    {
        int row = selectedRow;
        int col = selectedCol;

        Iterator it = buttPos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<JRadioButton, Position> pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            if(pair.getValue().row==row && pair.getValue().col == col)
                pair.getKey().setIcon(generateCosmicAction());
        }
    }

    public void setExcelAction()
    {
        int row = selectedRow;
        int col = selectedCol;

        Iterator it = buttPos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<JRadioButton, Position> pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            if(pair.getValue().row==row && pair.getValue().col == col)
                pair.getKey().setIcon(generateExcelAction());
        }
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

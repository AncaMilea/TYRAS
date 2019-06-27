import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcelFrame extends JFrame
{
    private JRadioButton selectButton = new JRadioButton("Select");
    private JLabel column = new JLabel("Select Column(s): ");
    private JLabel line = new JLabel("Select Line(s): ");
    private JTextField columnField = new JTextField(15);
    private JTextField lineField = new JTextField(15);

    private JRadioButton deleteButton = new JRadioButton("Delete");
    private JLabel columnDel = new JLabel("Delete Column(s): ");
    private JLabel lineDel = new JLabel("Delete Line(s): ");
    private JTextField columnDelField = new JTextField(15);
    private JTextField lineDelField = new JTextField(15);

    private JRadioButton filterButton = new JRadioButton("Filter");
    private JLabel columnFilter = new JLabel("Filter column: ");
    private JLabel lineFilter = new JLabel("Filter parameter: ");
    private JTextField columnFilterF = new JTextField(15);
    private JTextField lineFilterF = new JTextField(15);

    private JRadioButton saveButton = new JRadioButton("Save file ");
    private JLabel filenameL = new JLabel("Name of file: ");
    private JTextField filenameF = new JTextField(15);

    private JPanel selectP = new JPanel();
    private JPanel deleteP = new JPanel();
    private JPanel filterP = new JPanel();
    private JPanel saveP = new JPanel();

    private ButtonGroup buttonGroup = new ButtonGroup();

    private JButton okB = new JButton("ok");

    public ExcelFrame(){
        buttonGroup.add(selectButton);
        buttonGroup.add(deleteButton);
        buttonGroup.add(filterButton);
        buttonGroup.add(saveButton);

        selectP.setLayout(new GridLayout(5,1));
        selectP.add(selectButton);
        selectP.add(column);
        selectP.add(columnField);
        selectP.add(line);
        selectP.add(lineField);

        deleteP.setLayout(new GridLayout(5,1));
        deleteP.add(deleteButton);
        deleteP.add(columnDel);
        deleteP.add(columnDelField);
        deleteP.add(lineDel);
        deleteP.add(lineDelField);

        filterP.setLayout(new GridLayout(5,1));
        filterP.add(filterButton);
        filterP.add(columnFilter);
        filterP.add(columnFilterF);
        filterP.add(lineFilter);
        filterP.add(lineFilterF);

        saveP.setLayout(new GridLayout(1,3));
        saveP.add(filenameL);
        saveP.add(filenameF);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(selectP);
        mainPanel.add(deleteP);
        mainPanel.add(filterP);
        mainPanel.add(saveP);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(mainPanel, BorderLayout.CENTER);
        panel.add(okB, BorderLayout.SOUTH);


        this.setContentPane(panel);
        this.setVisible(true);
        this.setSize(new Dimension(400,400));

        okB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }


}

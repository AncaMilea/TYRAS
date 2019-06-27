import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.BasicPermission;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EmailFrame{

    JButton search;
    JButton open ;
    JButton attach;
    JButton send;
    JButton ok;

    JPanel emailP;
    JFrame window;

    public EmailFrame(){

        search = new JButton("Search for E-mail");
        open = new JButton("Open Attachement");
        attach = new JButton("New attach");
        send = new JButton("Send");
        ok = new JButton("OK");
        emailP = new JPanel();

        drawEmail();
        window = new JFrame();
        window.setContentPane(emailP);
        window.setTitle("TYRAS");
        window.setVisible(true);
        window.setResizable(false);
        window.setPreferredSize(new Dimension(900,700));
        window.pack();



    }

    public void drawEmail(){
        emailP.setLayout(new BorderLayout());


        JPanel alls = new JPanel();
        alls.setLayout(new BorderLayout());

        JPanel jP = new JPanel();
        jP.setLayout(new GridLayout(4,1));

        alls.add(jP,BorderLayout.NORTH);
        JPanel sP = new JPanel();
        sP.add(search);
        jP.add(sP);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               alls.add( searchEmail(), BorderLayout.CENTER);
               window.revalidate();
            }
        });
        JPanel oP = new JPanel();
        oP.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alls.add(openAttachment(),BorderLayout.CENTER);
                window.revalidate();
            }
        });
        JPanel aP = new JPanel();
        aP.add(attach);
        attach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alls.add(attach(),BorderLayout.CENTER);
                window.revalidate();
            }
        });
        JPanel seP = new JPanel();
        seP.add(send);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alls.add(send(),BorderLayout.CENTER);
                window.revalidate();
            }
        });

        jP.add(oP);
        jP.add(aP);
        jP.add(seP);

        JPanel button = new JPanel();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
            }
        });
        button.add(ok);
        alls.add(button,BorderLayout.SOUTH);

        //emailP.add(title,BorderLayout.NORTH);
        emailP.add(alls,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        new EmailFrame();

    }

    //opens another frame
    public JPanel searchEmail()
    {
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(6,1));
        JLabel subj = new JLabel("Subject");
        JLabel datar = new JLabel("Data received");
        JLabel dataS = new JLabel("Data sent");
        JLabel fr = new JLabel("From");
        JLabel t=  new JLabel("To");
        JLabel p = new JLabel("Path");


        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(6,1));
        JTextField subject = new JTextField();
        JTextField datarec = new JTextField();
        JTextField dataSENT = new JTextField();
        JTextField from = new JTextField();
        JTextField to = new JTextField();
        JFileChooser path = new JFileChooser();

        JPanel s = new JPanel();
        s.setLayout(new GridLayout(2,1));
        s.add(subj);
        s.add(subject);

        JPanel datas = new JPanel();
        datas.setLayout(new GridLayout(2,2));
        datas.add(datar);
        datas.add(dataS);
        datas.add(datarec);
        datas.add(dataSENT);

        JPanel people = new JPanel();
        people.setLayout(new GridLayout(2,2));
        people.add(fr);
        people.add(t);
        people.add(from);
        people.add(to);

        JPanel choose = new JPanel();
        choose.add(path);

        JPanel wr = new JPanel();
        wr.setLayout(new GridLayout(3,1));
        wr.add(s);
        wr.add(datas);
        wr.add(people);

        JPanel all = new JPanel();
        all.setLayout(new BorderLayout());
        all.add(wr,BorderLayout.NORTH);
        all.add(choose,BorderLayout.SOUTH);

        return all;

    }

    //opens another frame
    public JPanel openAttachment(){

        JPanel choose = new JPanel();
        JFileChooser path = new JFileChooser();
        choose.add(path);

        return choose;
    }

    public JPanel attach()
    {
        JPanel choose = new JPanel();
        JFileChooser path_A = new JFileChooser();
        choose.add(path_A);

        return choose;
    }

    public JPanel send()
    {
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(6,1));
        JLabel subj = new JLabel("Subject");
        JLabel to = new JLabel("TO");
        JLabel ccs = new JLabel("CCs");
        JLabel bccs = new JLabel("BCCs");


        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(6,1));
        JTextField subject = new JTextField();
        JTextField datarec = new JTextField();
        JTextField dataSENT = new JTextField();
        JTextField from = new JTextField();
        JFileChooser path = new JFileChooser();

        JPanel s = new JPanel();
        s.setLayout(new GridLayout(2,1));
        s.add(subj);
        s.add(subject);

        JPanel datas = new JPanel();
        datas.setLayout(new GridLayout(2,2));
        datas.add(to);
        datas.add(ccs);
        datas.add(datarec);
        datas.add(dataSENT);

        JPanel people = new JPanel();
        people.setLayout(new GridLayout(2,1));
        people.add(bccs);
        people.add(from);


        JPanel choose = new JPanel();
        choose.add(path);

        JPanel wr = new JPanel();
        wr.setLayout(new GridLayout(3,1));
        wr.add(s);
        wr.add(datas);
        wr.add(people);

        JPanel all = new JPanel();
        all.setLayout(new BorderLayout());
        all.add(wr,BorderLayout.NORTH);
        all.add(choose,BorderLayout.SOUTH);

        return all;
    }


     public void save(){

     }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard implements ActionListener
{
    int count=0;
    Course[] courses = new Course[20];//for storing accounts
    double cgpa;
    double credit;

    //labels
    JLabel cname;
    JLabel cmarks;
    JLabel ccredit;


    //textfields
    JTextField cnametxtf;
    JTextField cmarkstxtf;
    JTextField ccredittxtf;

    //textarea
    JTextArea display;

    //buttons
    JButton proceed;
    JButton Cgpa;

    //imageIcon
    ImageIcon i1;

    //for table(s)
    JTable jt;
    //JScrollPane sp;

    //frame
    JFrame frame;
Dashboard()
{

    for(int i = 0; i < 20; i++){
        courses[i] = new Course();
    }
    frame = new JFrame ("Dashboard");

    //construct components
    cname = new JLabel ("Couse Name:");
    cname.setForeground(new Color(230, 238, 250));

    cmarks = new JLabel ("Marks");
    cmarks.setForeground(new Color (230, 238, 250));

    ccredit = new JLabel ("credit");
    ccredit.setForeground(new Color (230, 238, 250));

    cnametxtf = new JTextField ();
    cmarkstxtf = new JTextField ();
    ccredittxtf = new JTextField ();

    display = new JTextArea (5, 5);

    proceed = new JButton("Proceed");
    Cgpa=new JButton("Cgpa");

    i1 = new ImageIcon("download.png");

    frame.add(cname);
    frame.add(cmarks);
    frame.add(ccredit);
    frame.add(cnametxtf);
    frame.add(cmarkstxtf);
    frame.add(ccredittxtf);
    frame.add(display);
    frame.add(proceed);
    frame.add(Cgpa);

    cname.setBounds (35, 70, 100, 25);
    cmarks.setBounds (35, 100, 100, 25);
    ccredit.setBounds (35, 130, 100, 25);

    cnametxtf.setBounds (155, 70, 100, 25);
    cmarkstxtf.setBounds (155, 100, 100, 25);
    ccredittxtf.setBounds (155, 130, 100, 25);

    display.setBounds (35, 180, 380, 90);

    proceed.setBounds(355, 110, 120, 30);
    Cgpa.setBounds(355, 70, 120, 30);

    //add action listener
    proceed.addActionListener(this);
    Cgpa.addActionListener(this);

    frame.setSize (624, 329);
    frame.setLocationRelativeTo(null);//to center screen gui
    frame.setLayout (null);
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setIconImage(i1.getImage());
    frame.getContentPane().setBackground(new Color (186, 132, 189));//setting a background color
    frame.setResizable(false);
    frame.setVisible (true);






}
public void addCourse(Course c)
{
    if(courses.length > 20) {
        display.setText("Stack overflow.");
    }else{
        courses[count]=c;
        count++;
        display.setText("Courses successfully added.");
    }


}

//procedd button
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==proceed)
        {
            String coursename=cnametxtf.getText();
            String  marks=cmarkstxtf.getText();
            String credit=ccredittxtf.getText();
            if (coursename.isEmpty()==false && marks.isEmpty()==false && credit.isEmpty()==false)
            {
                Course c=new Course(coursename,marks,credit);
                this.addCourse(c);

                cnametxtf.setText("");
                cmarkstxtf.setText("");
                ccredittxtf.setText("");


            }
            else {
                JOptionPane.showMessageDialog(null,"please add your courses");
                display.setText("Marks and Credit cannot be empty.");

            }
        }
        else if (e.getSource()==Cgpa)
        {


//            String mrk=cmarkstxtf.getText();
//            String cr=ccredittxtf.getText();
            for(int i = 0; i < count; i++){
                System.out.println(this.courses[i].getMarks());

                cgpa += (courses[i].mrksTocgpa())*(Double.parseDouble(courses[i].getCredit()));
                credit += Double.parseDouble(courses[i].getCredit());

//                cgpa += Course.convertToDouble(courses[i].getMarks())*Course.convertToDouble(courses[i].getCredit());
//                credit += Course.convertToDouble(courses[i].getCredit());
            }
            double r=cgpa/credit;
            double x= Double.parseDouble(Course.decfor.format(r));
            String  total_cgpa= String.valueOf(x);


           // System.out.println("CGPA is: " + Course.decfor.format((Double) cgpa/credit));
            //Double res = Double.valueOf(Math.round(Double.parseDouble(total_cgpa)*100))/100;
            //display.setText(String.valueOf(res));
            display.setText(total_cgpa);
        }


        }
    }






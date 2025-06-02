
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CheckBalance extends JFrame {
    final private static Font mainFont = new Font("Segoe print", Font.BOLD,18);


    public void Balance() {

        JPanel options = new JPanel();
        options.setLayout(new GridLayout(0,1,10,10));
        options.setFont(mainFont);


        JLabel jlFirstName = new JLabel("First Name");
        jlFirstName.setFont(mainFont);
        JTextField tfFirstName = new JTextField();

        JLabel jlLastName = new JLabel("Last Name");
        jlLastName.setFont(mainFont);
        JTextField tfLastName = new JTextField();

        JLabel jlUser = new JLabel("Enter Username");
        JTextField tfUser = new JTextField();
        jlUser.setFont(mainFont);

        JLabel jlPw = new JLabel("Enter Password");
        JPasswordField pfPw = new JPasswordField();
        jlPw.setFont(mainFont);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4,1,1,5));

        JButton btnCheck= new JButton("Check Balance");
        btnCheck.setFont(mainFont);

        options.add(jlFirstName);
        options.add(tfFirstName);
        options.add(jlLastName);
        options.add(tfLastName);
        options.add(jlUser);
        options.add(tfUser);
        options.add(jlPw);
        options.add(pfPw);
        buttonsPanel.add(btnCheck);
        

        add(options,BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);

        setTitle("Check Balance");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);







    }
    
}

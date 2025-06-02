import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CreateAccount extends JFrame{
    final private static Font mainFont = new Font("Segoe print", Font.BOLD,18);
    
    public void AccountCreatation(){
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(0,1,10,10));
        options.setFont(mainFont);


        JLabel jlFirstName = new JLabel("First Name");
        jlFirstName.setFont(mainFont);
        JTextField tfFirstName = new JTextField();

        JLabel jlLastName = new JLabel("Last Name");
        jlLastName.setFont(mainFont);
        JTextField tfLastName = new JTextField();

        JLabel jlUser = new JLabel("Create Username");
        JTextField tfUser = new JTextField();
        jlUser.setFont(mainFont);

        JLabel jlPw = new JLabel("Create Password");
        JPasswordField pfPw = new JPasswordField();
        jlPw.setFont(mainFont);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4,1,1,5));

        JButton btnCreate = new JButton("Create");
        btnCreate.setFont(mainFont);

        options.add(jlFirstName);
        options.add(tfFirstName);
        options.add(jlLastName);
        options.add(tfLastName);
        options.add(jlUser);
        options.add(tfUser);
        options.add(jlPw);
        options.add(pfPw);
        buttonsPanel.add(btnCreate);
        

        add(options,BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);
        

        



        btnCreate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                String username = tfUser.getText();
                String password = String.valueOf(pfPw.getPassword());

                System.out.println("About to try database insert...");
                try {
                    System.out.println("started.");

                    Connection conn = DatabaseConnector.getConnection();
                    System.out.println("username: " + username);
                    System.out.println("password: " + password);
                    System.out.println("firstName: " + firstName);
                    System.out.println("lastName: " + lastName);
                    String sql = "INSERT INTO normalUsers(normal_user,normal_pw,normal_firstName,normal_lastName)VALUES(?,?,?,?)";
                    
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, firstName);
                    preparedStatement.setString(4, lastName);

                    

                    preparedStatement.executeUpdate();

                    System.out.println("System created successfully");

                    preparedStatement.close();
                    conn.close();

                   
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("exception caugght"+e);
                }

                


                // TODO Auto-generated method stub
                
            }
            
        });

        setTitle("Create Account");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    


    


    public static void main(String[] args){
        CreateAccount nCreateAcc = new CreateAccount();

        nCreateAcc.AccountCreatation();
    }

}

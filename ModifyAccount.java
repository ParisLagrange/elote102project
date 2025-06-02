
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

public class ModifyAccount extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD,18);

    public void modify(){

        JPanel modifyPanel = new JPanel();
        modifyPanel.setLayout(new GridLayout(0,1,10,10));

        JLabel lbChangeFirstName = new JLabel("Change First Name");
        lbChangeFirstName.setFont(mainFont);
        JTextField tfChangeFirstName = new JTextField();

        JLabel lbChangeLastName = new JLabel("Change Last Name");
        lbChangeLastName.setFont(mainFont);
        JTextField tfChangeLastName = new JTextField();

        JLabel lbChangeUser = new JLabel("Change Username");
        lbChangeUser.setFont(mainFont);
        JTextField tfChangeUser = new JTextField();

        JLabel lbChangePw = new JLabel("Change Password");
        lbChangePw.setFont(mainFont);
        JPasswordField pfChangePw = new JPasswordField();

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,5,5));

        JButton btnModify = new JButton("Modify");

        buttonsPanel.setLayout(new GridLayout(2,5,10,10));

        modifyPanel.add(lbChangeFirstName);
        modifyPanel.add(tfChangeFirstName);
        modifyPanel.add(lbChangeLastName);
        modifyPanel.add(tfChangeLastName);
        modifyPanel.add(lbChangeUser);
        modifyPanel.add(tfChangeUser);
        modifyPanel.add(lbChangePw);
        modifyPanel.add(pfChangePw);
        buttonsPanel.add(btnModify);


        add(modifyPanel,BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);


        setTitle("Modify Account");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);



        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfChangeFirstName.getText();
                String lastName = tfChangeLastName.getText();
                String username = tfChangeUser.getText();
                String password = String.valueOf(pfChangePw.getPassword());

                LoginForm loginForm = new LoginForm();
                
                System.out.println("About to try database modify...");
                try {
                    System.out.println("started.");

                    Connection conn = DatabaseConnector.getConnection();
                    System.out.println("username: " + username);
                    System.out.println("password: " + password);
                    System.out.println("firstName: " + firstName);
                    System.out.println("lastName: " + lastName);
                    System.out.println("old user "+loginForm.username);
                    String sql = "UPDATE  normalUsers SET normal_user=?,normal_pw=?,normal_firstName=?,normal_lastName=? WHERE username = ?";
                    
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, firstName);
                    preparedStatement.setString(4, lastName);
                    preparedStatement.setString(5, loginForm.username);

                    

                    preparedStatement.executeUpdate();

                    System.out.println("User Updated successfully");

                    preparedStatement.close();
                    conn.close();

                   
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("exception caugght"+e);
                }



                
            }
            
        });


    }

    public static void main(String[] args) {
        ModifyAccount modifyAccount = new ModifyAccount();

        modifyAccount.modify();
    }
    
}

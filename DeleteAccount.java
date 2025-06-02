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

public class DeleteAccount extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD,18);


    public void delete(){

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

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(mainFont);

        options.add(jlFirstName);
        options.add(tfFirstName);
        options.add(jlLastName);
        options.add(tfLastName);
        options.add(jlUser);
        options.add(tfUser);
        options.add(jlPw);
        options.add(pfPw);
        buttonsPanel.add(btnDelete);
        

        add(options,BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);




        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                String username = tfUser.getText();
                String password = String.valueOf(pfPw.getPassword());

                System.out.println("About to try deleting database...");
                try {
                    System.out.println("started.");

                    Connection conn = DatabaseConnector.getConnection();
                    System.out.println("username: " + username);
                    System.out.println("password: " + password);
                    System.out.println("firstName: " + firstName);
                    System.out.println("lastName: " + lastName);
                    String sql = "DELETE FROM normalUsers WHERE normal_user = ? AND normal_pw = ? AND normal_firstName = ? AND normal_lastName = ?";
                    
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, firstName);
                    preparedStatement.setString(4, lastName);

                    

                    preparedStatement.executeUpdate();

                    System.out.println("User account deleted successfully");

                    preparedStatement.close();
                    conn.close();

                   
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("exception caught"+e);
                }

                
            }
            
        });


        

        

        setTitle("Delete Account");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
        




    }
    public static void main(String[] args) {
        DeleteAccount deleteAccount = new DeleteAccount();

        deleteAccount.delete();
    }
    
}

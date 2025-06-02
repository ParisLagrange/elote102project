import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class LoginForm extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD,18);
    JTextField tfUsername;
    JPasswordField pfPasswordField;
    String username;

    public void initialize(){
        
        
       

        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

       

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        JLabel lbUsername = new JLabel("Username");
        lbUsername.setFont(mainFont);

        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        pfPasswordField = new JPasswordField();
        pfPasswordField.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));

        

        formPanel.add(lbLoginForm);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPasswordField);
        






        /*Button stuff */
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            /*method excutes when click on login button */
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub
                String sUsername = tfUsername.getText();
                String sPassword = String.valueOf(pfPasswordField.getPassword());

                User user = getAuthenticatedUser(sUsername,sPassword);

                if (user != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(LoginForm.this,
                    "Email or Password Invalid",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
                }

                
            }
            
        });


        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
                
            }


        });

        
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);
        

        /* frame */
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);

        

        setTitle("Login Form");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }



    private User getAuthenticatedUser(String username, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "Plagrange21";
// Database details
 
         // Load and register the driver
         
 
        try {
            
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            System.out.println("Success");
            String sql = "SELECT * FROM normalUsers WHERE normal_user=? AND normal_pw=?";
            System.out.println("Username:" + username);
            System.out.println("Password:" + password);
;           PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                
                user = new User();
                user.firstName = resultSet.getString("normal_firstName");
                user.lastName = resultSet.getString("normal_lastName");
                user.username = resultSet.getString("normal_user");
                user.password = resultSet.getString("normal_pw");
            }
            
            preparedStatement.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Database Connection Failed!"+e);

        }

        return user;

    }


    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.initialize();
    }

    
}

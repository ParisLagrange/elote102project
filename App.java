import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App extends JFrame {
    final private static Font mainFont = new Font("Segoe print", Font.BOLD,18);
        public void beginning()  {
        

            JButton btnAdmin = new JButton("Admin Users");
            btnAdmin.setFont(mainFont);

            JButton btnNormal = new JButton("Normal Users");
            btnNormal.setFont(mainFont);
            
            JPanel jpChoicePanel = new JPanel();
            jpChoicePanel.setLayout(new GridLayout(0,1,10,10));

            
            jpChoicePanel.add(btnAdmin);
            jpChoicePanel.add(btnNormal);


            add(jpChoicePanel,BorderLayout.NORTH);

        




            btnAdmin.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub

                    
                    LoginForm lfLogin = new LoginForm();
                    Admin admin = new Admin();
                    ModifyAccount modifyAccount = new ModifyAccount();
                    
                    
                    admin.AdminOptions();
                    
                    lfLogin.initialize();
                    




                   

                    
                }

                
            });

            btnNormal.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    // TODO Auto-generated method stub
                    LoginForm lfLogin = new LoginForm();
                    Normal normal = new Normal();
                    ModifyAccount modifyAccount = new ModifyAccount();
                    
                    
                    normal.normalOptions();
                    
                    lfLogin.initialize();


                }
                
            });



            
            setTitle("Banking System");

            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setSize(400,500);

            setMinimumSize(new Dimension(350,450));

            setLocationRelativeTo(null);
            setVisible(true);
            

            
        



            


            
        }
    public static void main(String[] args) {
        App mdProcess = new App();

        mdProcess.beginning();
    }
}


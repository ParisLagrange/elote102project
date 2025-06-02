import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Admin extends JFrame {


    public void AdminOptions() {
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(0,1,10,10));


        JButton btnCreateAcc = new JButton("create account");

        JButton btnModifyAcc = new JButton("modify account");

        JButton btnDeleteAcc = new JButton("Delete Account");



        adminPanel.add(btnCreateAcc);
        adminPanel.add(btnModifyAcc);
        adminPanel.add(btnDeleteAcc);

        btnCreateAcc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                CreateAccount createAccount = new CreateAccount();
                createAccount.AccountCreatation();
                

                
            }

            
        });

        btnModifyAcc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                ModifyAccount modifyAccount = new ModifyAccount();
                modifyAccount.modify();

            }

            
        });

        btnDeleteAcc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DeleteAccount deleteAccount = new DeleteAccount();

                deleteAccount.delete();
            }
            
        });


        add(adminPanel,BorderLayout.NORTH);

        

        setTitle("Admin Options");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        
        Admin admin = new Admin();

        admin.AdminOptions();
    }

    
    
}

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Normal extends JFrame{


    public void normalOptions() {
        JPanel normalPanel = new JPanel();
        normalPanel.setLayout(new GridLayout(0,1,10,10));


        JButton btnCheckBalance = new JButton("Check Balance");

        JButton btnWithDraw = new JButton("Withdraw");

        JButton btnDeposit = new JButton("Deposit");



        normalPanel.add(btnCheckBalance);
        normalPanel.add(btnWithDraw);
        normalPanel.add(btnDeposit);

        btnCheckBalance.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                CheckBalance checkBalance = new CheckBalance();
                checkBalance.Balance();
            }
            
        });

        


        add(normalPanel,BorderLayout.NORTH);

        

        setTitle("Normal Options");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);

        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        
        Normal normal = new Normal();

        normal.normalOptions();

        
    }

    
    
}



    
    


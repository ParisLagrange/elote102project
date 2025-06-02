
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    public void initialize(User user){
         JPanel infoPanel = new JPanel();
         infoPanel.setLayout(new GridLayout(0,2,5,5));
         infoPanel.add(new JLabel("First Name"));
         infoPanel.add(new JLabel("Last Name"));
         
         add(infoPanel,BorderLayout.NORTH);
         
         







        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    
}

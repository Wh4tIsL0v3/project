package sessionproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrugListFrame extends Container{
    public static JTextArea drugListText;
    
    private JButton backButton;
    private JButton refreshButton;
    
     public DrugListFrame(){
        setSize(600, 400);
        setLayout(null);
        
        drugListText = new JTextArea();
        drugListText.setBounds(50, 50, 200, 200);
        add(drugListText);
        
        backButton = new JButton("Back");
        backButton.setBounds(50, 300, 90, 30);
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminClient.frame.drugListWindow.setVisible(false);
                AdminClient.frame.mainMenuWindow.setVisible(true);
            }
        });
        add(backButton);
        
        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(160, 300, 90, 30);
        refreshButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                DataPackage dp = new DataPackage("list");
                AdminClient.connect(dp);
                
            }
        });
        add(refreshButton);
     }
}

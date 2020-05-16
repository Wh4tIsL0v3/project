package sessionproj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenuForAdmin extends Container{
    private JButton addDrugButton;
    private JButton drugListButton;
    private JButton exitButton;
    
    public MainMenuForAdmin(){
        setSize(600, 400);
        setLayout(null);
        
        addDrugButton = new JButton("Add Drug");
        addDrugButton.setBounds(50, 50, 90, 30);
        addDrugButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminClient.frame.mainMenuWindow.setVisible(false);
                AdminClient.frame.addDrugWindow.setVisible(true);
            }
        });
        add(addDrugButton);
        
        drugListButton = new JButton("Drug List");
        drugListButton.setBounds(50, 100, 90, 30);
        drugListButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminClient.frame.mainMenuWindow.setVisible(false);
                AdminClient.frame.drugListWindow.setVisible(true);
            }
        });
        add(drugListButton);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds(50, 150, 90, 30);
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        add(exitButton);
    }
}

package sessionproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrugFrame extends Container{
    private JButton addDrugButton;
    private JButton backButton;
    
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel countLabel;
    
    private JTextField nameTF;
    private JTextField priceTF;
    private JTextField countTF;
    
    private JLabel error;
    private JButton ok;
    
    public AddDrugFrame(){
        setSize(600, 400);
        setLayout(null);
        
        error = new JLabel("You need to write more correctly!");
        error.setBounds(300,0,300,100);
        error.setVisible(false);
        add(error);
        
        ok = new JButton("Ok");
        ok.setBounds(300, 60, 90, 30);
        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
                ok.setVisible(false);
            }
        });
        ok.setVisible(false);
        add(ok);
                
        nameLabel = new JLabel("Drug Name:");
        nameLabel.setBounds(50, 50, 90, 30);
        add(nameLabel);
        
        nameTF = new JTextField("");
        nameTF.setBounds(170, 50, 90, 30);
        add(nameTF);
        
        priceLabel = new JLabel("Drug Price:");
        priceLabel.setBounds(50, 110, 90, 30);
        add(priceLabel);
        
        priceTF = new JTextField("");
        priceTF.setBounds(170, 110, 90, 30);
        add(priceTF);
        
        countLabel = new JLabel("Drug Count:");
        countLabel.setBounds(50, 170, 90, 30);
        add(countLabel);
        
        countTF = new JTextField("");
        countTF.setBounds(170, 170, 90, 30);
        add(countTF);
        
        backButton = new JButton("Back");
        backButton.setBounds(50, 230, 90, 30);
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminClient.frame.addDrugWindow.setVisible(false);
                AdminClient.frame.mainMenuWindow.setVisible(true);
            }
        });
        add(backButton);
        
        addDrugButton = new JButton("Add Drug");
        addDrugButton.setBounds(170, 230, 90, 30);
        addDrugButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    String name = nameTF.getText();
                    double price = Integer.parseInt(priceTF.getText());
                    int count = Integer.parseInt(countTF.getText());
                    if(name.equals("") || price <= 0 || count <= 0){
                        error.setVisible(true);
                        ok.setVisible(true);
                        nameTF.setText("");
                        priceTF.setText("");
                        countTF.setText("");
                    }
                    else {
                        Drug temp = new Drug(null, name, price, count);
                        DataPackage dp = new DataPackage("add", temp);
                        AdminClient.connect(dp);
                    }
                } catch (Exception ex) {
                    error.setVisible(true);
                    ok.setVisible(true);
                    nameTF.setText("");
                    priceTF.setText("");
                    countTF.setText("");
                }
                
                
                
                nameTF.setText("");
                priceTF.setText("");
                countTF.setText("");
            }
        });
        add(addDrugButton);
    }
}

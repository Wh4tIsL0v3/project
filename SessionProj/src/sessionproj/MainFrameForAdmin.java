package sessionproj;
import javax.swing.*;
public class MainFrameForAdmin extends JFrame{
    public static AddDrugFrame addDrugWindow;
    public static MainMenuForAdmin mainMenuWindow;
    public static DrugListFrame drugListWindow;
    public MainFrameForAdmin(){
        setSize(600, 400);
        setTitle("Admin Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainMenuWindow = new MainMenuForAdmin();
        setLocation(0,0);
        add(mainMenuWindow);
        
        addDrugWindow = new AddDrugFrame();
        setLocation(0,0);
        addDrugWindow.setVisible(false);
        add(addDrugWindow);

        drugListWindow = new DrugListFrame();
        setLocation(0,0);
        drugListWindow.setVisible(false);
        add(drugListWindow);
    }
}

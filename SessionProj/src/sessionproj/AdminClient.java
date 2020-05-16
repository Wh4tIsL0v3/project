package sessionproj;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
public class AdminClient {
    public static MainFrameForAdmin frame;
    public static void connect(DataPackage dp){
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            
            if(dp.getOperationType().equals("add")){
                output.writeObject(dp);
            }
            else if(dp.getOperationType().equals("list")){
                output.writeObject(dp);
                DataPackage infoFromServer = (DataPackage)input.readObject();
                ArrayList<Drug> arrayListFromServer = infoFromServer.getDrugs();
                String s = "";

                for(int i=0;i<arrayListFromServer.size();i++){
                    s+=arrayListFromServer.get(i)+"\n";
                }
                DrugListFrame.drugListText.setText("");
                DrugListFrame.drugListText.append(s);
            }
            input.close();
            output.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        frame = new MainFrameForAdmin();
        frame.setVisible(true);
    }
}

package sessionproj;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();
            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            DataPackage dp = null;
            while ( (dp=(DataPackage)input.readObject())!=null ){
                if(dp.getOperationType().equals("add")){
                    Drug drugFromClient = dp.getDrug();
                    manager.addDrug(drugFromClient);
                }
                else if(dp.getOperationType().equals("list")){
                    ArrayList<Drug> infoForClient = manager.getAllDrugs();
                    DataPackage toClient = new DataPackage(infoForClient);
                    output.writeObject(toClient);

                }
                else if(dp.getOperationType().equals("buy")){
                    ArrayList<Drug> infoForClient = manager.getAllDrugs();
                }
            }

            input.close();
            output.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
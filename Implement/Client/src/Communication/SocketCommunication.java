/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Communication;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bin
 */
public class SocketCommunication extends Thread {
    private int port;
    private boolean stop;

    public void stopCommunication()
    {
        this.stop = true;
    }
    
    public void startCommunication()
    {
        this.start();
    }
    
    public SocketCommunication(int port)
    {
        this.stop = false;
        this.port = port;             
    }

    public void run() {
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            do
            {
                Socket socket = serverSocket.accept();
                //do something

            }
            while(!stop);
        }
        catch(Exception ex)
        {
            System.err.print(ex.getMessage());
        }
    }
}

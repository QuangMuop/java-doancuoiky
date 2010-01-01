/*
 * ClientApp.java
 */

package client;

import Communication.SocketCommunication;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class ClientApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        
        show(new ClientView(this));

        //show(new JMainDialog(null, true));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of ClientApp
     */
    public static ClientApp getApplication() {
        return Application.getInstance(ClientApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        //open socket server to listen
        //SocketCommunication communication = new SocketCommunication(3600);
        //communication.startCommunication();

        launch(ClientApp.class, args);
    }
}

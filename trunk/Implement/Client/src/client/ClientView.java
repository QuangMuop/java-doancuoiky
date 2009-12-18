/*
 * ClientView.java
 */

package client;

import java.awt.CardLayout;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class ClientView extends FrameView {

    public ClientView(SingleFrameApplication app) {
        super(app);

        initComponents();

        //init panels
        panelCauhinh = new JPanelCauHinh();
        panelCauhinh.setName("panelCauhinh");

        panelSubmitXML = new JPanelSubmitXML();
        panelSubmitXML.setName("panelSubmitXML");

        panelThongKe = new JPanelThongKe();
        panelThongKe.setName("panelThongKe");

        panelThuePhong = new JPanelThuePhong();
        panelThuePhong.setName("panelThuePhong");

        panelTimPhong = new JPanelTimPhong();
        panelTimPhong.setName("panelTimPhong");

        panelTraPhong = new JPanelTraPhong();
        panelTraPhong.setName("panelTraPhong");

        panelXemChiTiet = new JPanelXemChiTiet();
        panelXemChiTiet.setName("panelXemChiTiet");

        panelXemPhong = new JPanelXemPhong();
        panelXemPhong.setName("panelXemPhong");

        //load and paint default panel
        jRightPanel.add(panelThuePhong,panelThuePhong.getName());
        jRightPanel.add(panelCauhinh,panelCauhinh.getName());
        jRightPanel.add(panelSubmitXML,panelSubmitXML.getName());
        jRightPanel.add(panelThongKe,panelThongKe.getName());
        jRightPanel.add(panelTimPhong,panelTimPhong.getName());
        jRightPanel.add(panelTraPhong,panelTraPhong.getName());
        jRightPanel.add(panelXemChiTiet,panelXemChiTiet.getName());
        jRightPanel.add(panelXemPhong,panelXemPhong.getName());

        //inti for button with image
        java.net.URL imageURL = ClientView.class.getResource("resources/XemPhongBtnPress.jpg");
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            //icon.paintIcon(jToggleBtnThongKe, jToggleBtnThongKe.getGraphics(), 0, 0);
        }

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = ClientApp.getApplication().getMainFrame();
            aboutBox = new ClientAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        ClientApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jSplitMainPane = new javax.swing.JSplitPane();
        jTopPanel = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTenKhachSan = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelThoiGian = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jLeftPanel = new javax.swing.JPanel();
        jToggleBtnXemPhong = new javax.swing.JToggleButton();
        jToggleBtnTimPhong = new javax.swing.JToggleButton();
        jToggleBtnThuePhong = new javax.swing.JToggleButton();
        jToggleBtnTraPhong = new javax.swing.JToggleButton();
        jToggleBtnThongKe = new javax.swing.JToggleButton();
        jToggleBtnSubmitXML = new javax.swing.JToggleButton();
        jToggleBtnCauHinh = new javax.swing.JToggleButton();
        jRightPanel = new javax.swing.JPanel();
        btnGroupMainController = new javax.swing.ButtonGroup();

        mainPanel.setName("mainPanel"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(ClientView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getActionMap(ClientView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusMessageLabel))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        jSplitMainPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitMainPane.setDoubleBuffered(true);
        jSplitMainPane.setName("jSplitMainPane"); // NOI18N

        jTopPanel.setName("jTopPanel"); // NOI18N
        jTopPanel.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        jLabelLogo.setIcon(resourceMap.getIcon("jLabelLogo.icon")); // NOI18N
        jLabelLogo.setText(resourceMap.getString("jLabelLogo.text")); // NOI18N
        jLabelLogo.setDisabledIcon(resourceMap.getIcon("jLabelLogo.disabledIcon")); // NOI18N
        jLabelLogo.setDoubleBuffered(true);
        jLabelLogo.setEnabled(false);
        jLabelLogo.setName("jLabelLogo"); // NOI18N
        jTopPanel.add(jLabelLogo);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setName("jSeparator2"); // NOI18N
        jTopPanel.add(jSeparator2);

        jLabelTenKhachSan.setBackground(resourceMap.getColor("jLabelTenKhachSan.background")); // NOI18N
        jLabelTenKhachSan.setFont(resourceMap.getFont("jLabelTenKhachSan.font")); // NOI18N
        jLabelTenKhachSan.setForeground(resourceMap.getColor("jLabelTenKhachSan.foreground")); // NOI18N
        jLabelTenKhachSan.setText(resourceMap.getString("jLabelTenKhachSan.text")); // NOI18N
        jLabelTenKhachSan.setName("jLabelTenKhachSan"); // NOI18N
        jTopPanel.add(jLabelTenKhachSan);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setName("jSeparator1"); // NOI18N
        jTopPanel.add(jSeparator1);

        jLabelThoiGian.setText(resourceMap.getString("jLabelThoiGian.text")); // NOI18N
        jLabelThoiGian.setName("jLabelThoiGian"); // NOI18N
        jTopPanel.add(jLabelThoiGian);

        jSplitMainPane.setLeftComponent(jTopPanel);

        jSplitPane2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jLeftPanel.setName("jLeftPanel"); // NOI18N
        jLeftPanel.setLayout(new java.awt.GridLayout(7, 1, 5, 5));

        btnGroupMainController.add(jToggleBtnXemPhong);
        jToggleBtnXemPhong.setIcon(resourceMap.getIcon("jToggleBtnXemPhong.icon")); // NOI18N
        jToggleBtnXemPhong.setSelected(true);
        jToggleBtnXemPhong.setText(resourceMap.getString("jToggleBtnXemPhong.text")); // NOI18N
        jToggleBtnXemPhong.setToolTipText(resourceMap.getString("jToggleBtnXemPhong.toolTipText")); // NOI18N
        jToggleBtnXemPhong.setDoubleBuffered(true);
        jToggleBtnXemPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnXemPhong.setName("jToggleBtnXemPhong"); // NOI18N
        jToggleBtnXemPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnXemPhongMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnXemPhong);

        btnGroupMainController.add(jToggleBtnTimPhong);
        jToggleBtnTimPhong.setText(resourceMap.getString("jToggleBtnTimPhong.text")); // NOI18N
        jToggleBtnTimPhong.setToolTipText(resourceMap.getString("jToggleBtnTimPhong.toolTipText")); // NOI18N
        jToggleBtnTimPhong.setDoubleBuffered(true);
        jToggleBtnTimPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnTimPhong.setName("jToggleBtnTimPhong"); // NOI18N
        jToggleBtnTimPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnTimPhongMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnTimPhong);

        btnGroupMainController.add(jToggleBtnThuePhong);
        jToggleBtnThuePhong.setText(resourceMap.getString("jToggleBtnThuePhong.text")); // NOI18N
        jToggleBtnThuePhong.setToolTipText(resourceMap.getString("jToggleBtnThuePhong.toolTipText")); // NOI18N
        jToggleBtnThuePhong.setDoubleBuffered(true);
        jToggleBtnThuePhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnThuePhong.setName("jToggleBtnThuePhong"); // NOI18N
        jToggleBtnThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnThuePhongMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnThuePhong);

        btnGroupMainController.add(jToggleBtnTraPhong);
        jToggleBtnTraPhong.setText(resourceMap.getString("jToggleBtnTraPhong.text")); // NOI18N
        jToggleBtnTraPhong.setToolTipText(resourceMap.getString("jToggleBtnTraPhong.toolTipText")); // NOI18N
        jToggleBtnTraPhong.setDoubleBuffered(true);
        jToggleBtnTraPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnTraPhong.setName("jToggleBtnTraPhong"); // NOI18N
        jToggleBtnTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnTraPhongMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnTraPhong);

        btnGroupMainController.add(jToggleBtnThongKe);
        jToggleBtnThongKe.setText(resourceMap.getString("jToggleBtnThongKe.text")); // NOI18N
        jToggleBtnThongKe.setToolTipText(resourceMap.getString("jToggleBtnThongKe.toolTipText")); // NOI18N
        jToggleBtnThongKe.setDoubleBuffered(true);
        jToggleBtnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnThongKe.setName("jToggleBtnThongKe"); // NOI18N
        jToggleBtnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnThongKeMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnThongKe);

        btnGroupMainController.add(jToggleBtnSubmitXML);
        jToggleBtnSubmitXML.setText(resourceMap.getString("jToggleBtnSubmitXML.text")); // NOI18N
        jToggleBtnSubmitXML.setToolTipText(resourceMap.getString("jToggleBtnSubmitXML.toolTipText")); // NOI18N
        jToggleBtnSubmitXML.setDoubleBuffered(true);
        jToggleBtnSubmitXML.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnSubmitXML.setName("jToggleBtnSubmitXML"); // NOI18N
        jToggleBtnSubmitXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnSubmitXMLMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnSubmitXML);

        btnGroupMainController.add(jToggleBtnCauHinh);
        jToggleBtnCauHinh.setText(resourceMap.getString("jToggleBtnCauHinh.text")); // NOI18N
        jToggleBtnCauHinh.setToolTipText(resourceMap.getString("jToggleBtnCauHinh.toolTipText")); // NOI18N
        jToggleBtnCauHinh.setDoubleBuffered(true);
        jToggleBtnCauHinh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnCauHinh.setName("jToggleBtnCauHinh"); // NOI18N
        jToggleBtnCauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleBtnCauHinhMouseClicked(evt);
            }
        });
        jLeftPanel.add(jToggleBtnCauHinh);

        jSplitPane2.setLeftComponent(jLeftPanel);

        jRightPanel.setName("jRightPanel"); // NOI18N
        jRightPanel.setLayout(new java.awt.CardLayout());
        jSplitPane2.setRightComponent(jRightPanel);

        jSplitMainPane.setBottomComponent(jSplitPane2);

        setComponent(jSplitMainPane);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    //click on button Xem phong
    private void jToggleBtnXemPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnXemPhongMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnXemPhong.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelXemPhong.getName());
        }
    }//GEN-LAST:event_jToggleBtnXemPhongMouseClicked

    private void jToggleBtnTimPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnTimPhongMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnTimPhong.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelTimPhong.getName());
        }
    }//GEN-LAST:event_jToggleBtnTimPhongMouseClicked

    private void jToggleBtnThuePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnThuePhongMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnThuePhong.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelThuePhong.getName());
        }
    }//GEN-LAST:event_jToggleBtnThuePhongMouseClicked

    @SuppressWarnings("empty-statement")
    private void jToggleBtnTraPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnTraPhongMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnTraPhong.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelTraPhong.getName());                        
        }
    }//GEN-LAST:event_jToggleBtnTraPhongMouseClicked

    private void jToggleBtnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnThongKeMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnThongKe.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelThongKe.getName());            
        }
    }//GEN-LAST:event_jToggleBtnThongKeMouseClicked

    private void jToggleBtnSubmitXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnSubmitXMLMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnSubmitXML.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelSubmitXML.getName());
        }
    }//GEN-LAST:event_jToggleBtnSubmitXMLMouseClicked

    private void jToggleBtnCauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnCauHinhMouseClicked
        // TODO add your handling code here:
        //if(!jToggleBtnCauHinh.isSelected())
        {
            CardLayout cl = (CardLayout)jRightPanel.getLayout();
            cl.show(jRightPanel, panelCauhinh.getName());
        }
    }//GEN-LAST:event_jToggleBtnCauHinhMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupMainController;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTenKhachSan;
    private javax.swing.JLabel jLabelThoiGian;
    private javax.swing.JPanel jLeftPanel;
    private javax.swing.JPanel jRightPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitMainPane;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToggleButton jToggleBtnCauHinh;
    private javax.swing.JToggleButton jToggleBtnSubmitXML;
    private javax.swing.JToggleButton jToggleBtnThongKe;
    private javax.swing.JToggleButton jToggleBtnThuePhong;
    private javax.swing.JToggleButton jToggleBtnTimPhong;
    private javax.swing.JToggleButton jToggleBtnTraPhong;
    private javax.swing.JToggleButton jToggleBtnXemPhong;
    private javax.swing.JPanel jTopPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    //panels
    private JPanelCauHinh panelCauhinh;
    private JPanelSubmitXML panelSubmitXML;
    private JPanelThongKe panelThongKe;
    private JPanelThuePhong panelThuePhong;
    private JPanelTimPhong panelTimPhong;
    private JPanelTraPhong panelTraPhong;
    private JPanelXemChiTiet panelXemChiTiet;
    private JPanelXemPhong panelXemPhong;

    ImageIcon xemPhongIcon;
}

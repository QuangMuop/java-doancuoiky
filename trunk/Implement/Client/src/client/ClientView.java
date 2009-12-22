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
        java.awt.GridBagConstraints gridBagConstraints;

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
        jSplitMainPane = new javax.swing.JSplitPane();
        jTopPanel = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelTenKhachSan = new javax.swing.JLabel();
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
        jToggleBtnHelp = new javax.swing.JToggleButton();
        jToggleBtnAbout = new javax.swing.JToggleButton();
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

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 843, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jSplitMainPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitMainPane.setDoubleBuffered(true);
        jSplitMainPane.setName("jSplitMainPane"); // NOI18N

        jTopPanel.setName("jTopPanel"); // NOI18N

        jLabelLogo.setIcon(resourceMap.getIcon("jLabelLogo.icon")); // NOI18N
        jLabelLogo.setText(resourceMap.getString("jLabelLogo.text")); // NOI18N
        jLabelLogo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, resourceMap.getColor("jLabelLogo.border.highlightOuterColor"), resourceMap.getColor("jLabelLogo.border.highlightInnerColor"), resourceMap.getColor("jLabelLogo.border.shadowOuterColor"), resourceMap.getColor("jLabelLogo.border.shadowInnerColor"))); // NOI18N
        jLabelLogo.setDisabledIcon(resourceMap.getIcon("jLabelLogo.disabledIcon")); // NOI18N
        jLabelLogo.setDoubleBuffered(true);
        jLabelLogo.setEnabled(false);
        jLabelLogo.setName("jLabelLogo"); // NOI18N

        jLabelTenKhachSan.setBackground(resourceMap.getColor("jLabelTenKhachSan.background")); // NOI18N
        jLabelTenKhachSan.setFont(resourceMap.getFont("jLabelTenKhachSan.font")); // NOI18N
        jLabelTenKhachSan.setForeground(resourceMap.getColor("jLabelTenKhachSan.foreground")); // NOI18N
        jLabelTenKhachSan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTenKhachSan.setText(resourceMap.getString("jLabelTenKhachSan.text")); // NOI18N
        jLabelTenKhachSan.setName("jLabelTenKhachSan"); // NOI18N

        jLabelThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThoiGian.setText(resourceMap.getString("jLabelThoiGian.text")); // NOI18N
        jLabelThoiGian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelThoiGian.setName("jLabelThoiGian"); // NOI18N

        javax.swing.GroupLayout jTopPanelLayout = new javax.swing.GroupLayout(jTopPanel);
        jTopPanel.setLayout(jTopPanelLayout);
        jTopPanelLayout.setHorizontalGroup(
            jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTopPanelLayout.createSequentialGroup()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTenKhachSan, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );
        jTopPanelLayout.setVerticalGroup(
            jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTopPanelLayout.createSequentialGroup()
                .addGroup(jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTenKhachSan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelThoiGian, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jSplitMainPane.setLeftComponent(jTopPanel);

        jSplitPane2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jLeftPanel.setName("jLeftPanel"); // NOI18N
        jLeftPanel.setLayout(new java.awt.GridBagLayout());

        btnGroupMainController.add(jToggleBtnXemPhong);
        jToggleBtnXemPhong.setIcon(resourceMap.getIcon("jToggleBtnXemPhong.icon")); // NOI18N
        jToggleBtnXemPhong.setSelected(true);
        jToggleBtnXemPhong.setText(resourceMap.getString("jToggleBtnXemPhong.text")); // NOI18N
        jToggleBtnXemPhong.setIconTextGap(0);
        jToggleBtnXemPhong.setMargin(null);
        jToggleBtnXemPhong.setName("jToggleBtnXemPhong"); // NOI18N
        jToggleBtnXemPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnXemPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnXemPhong, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnTimPhong);
        jToggleBtnTimPhong.setIcon(resourceMap.getIcon("jToggleBtnTimPhong.icon")); // NOI18N
        jToggleBtnTimPhong.setText(resourceMap.getString("jToggleBtnTimPhong.text")); // NOI18N
        jToggleBtnTimPhong.setIconTextGap(0);
        jToggleBtnTimPhong.setMargin(null);
        jToggleBtnTimPhong.setName("jToggleBtnTimPhong"); // NOI18N
        jToggleBtnTimPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnTimPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnTimPhong, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnThuePhong);
        jToggleBtnThuePhong.setIcon(resourceMap.getIcon("jToggleBtnThuePhong.icon")); // NOI18N
        jToggleBtnThuePhong.setText(resourceMap.getString("jToggleBtnThuePhong.text")); // NOI18N
        jToggleBtnThuePhong.setIconTextGap(0);
        jToggleBtnThuePhong.setMargin(null);
        jToggleBtnThuePhong.setName("jToggleBtnThuePhong"); // NOI18N
        jToggleBtnThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnThuePhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnThuePhong, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnTraPhong);
        jToggleBtnTraPhong.setIcon(resourceMap.getIcon("jToggleBtnTraPhong.icon")); // NOI18N
        jToggleBtnTraPhong.setText(resourceMap.getString("jToggleBtnTraPhong.text")); // NOI18N
        jToggleBtnTraPhong.setIconTextGap(0);
        jToggleBtnTraPhong.setMargin(null);
        jToggleBtnTraPhong.setName("jToggleBtnTraPhong"); // NOI18N
        jToggleBtnTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnTraPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnTraPhong, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnThongKe);
        jToggleBtnThongKe.setIcon(resourceMap.getIcon("jToggleBtnThongKe.icon")); // NOI18N
        jToggleBtnThongKe.setText(resourceMap.getString("jToggleBtnThongKe.text")); // NOI18N
        jToggleBtnThongKe.setIconTextGap(0);
        jToggleBtnThongKe.setMargin(null);
        jToggleBtnThongKe.setName("jToggleBtnThongKe"); // NOI18N
        jToggleBtnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnThongKeMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnThongKe, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnSubmitXML);
        jToggleBtnSubmitXML.setIcon(resourceMap.getIcon("jToggleBtnSubmitXML.icon")); // NOI18N
        jToggleBtnSubmitXML.setText(resourceMap.getString("jToggleBtnSubmitXML.text")); // NOI18N
        jToggleBtnSubmitXML.setIconTextGap(0);
        jToggleBtnSubmitXML.setMargin(null);
        jToggleBtnSubmitXML.setName("jToggleBtnSubmitXML"); // NOI18N
        jToggleBtnSubmitXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnSubmitXMLMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnSubmitXML, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnCauHinh);
        jToggleBtnCauHinh.setIcon(resourceMap.getIcon("jToggleBtnCauHinh.icon")); // NOI18N
        jToggleBtnCauHinh.setText(resourceMap.getString("jToggleBtnCauHinh.text")); // NOI18N
        jToggleBtnCauHinh.setIconTextGap(0);
        jToggleBtnCauHinh.setMargin(null);
        jToggleBtnCauHinh.setName("jToggleBtnCauHinh"); // NOI18N
        jToggleBtnCauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnCauHinhMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnCauHinh, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnHelp);
        jToggleBtnHelp.setIcon(resourceMap.getIcon("jToggleBtnHelp.icon")); // NOI18N
        jToggleBtnHelp.setText(resourceMap.getString("jToggleBtnHelp.text")); // NOI18N
        jToggleBtnHelp.setIconTextGap(0);
        jToggleBtnHelp.setMargin(null);
        jToggleBtnHelp.setName("jToggleBtnHelp"); // NOI18N
        jToggleBtnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnHelpMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnHelp, gridBagConstraints);

        btnGroupMainController.add(jToggleBtnAbout);
        jToggleBtnAbout.setIcon(resourceMap.getIcon("jToggleBtnAbout.icon")); // NOI18N
        jToggleBtnAbout.setText(resourceMap.getString("jToggleBtnAbout.text")); // NOI18N
        jToggleBtnAbout.setIconTextGap(0);
        jToggleBtnAbout.setMargin(null);
        jToggleBtnAbout.setName("jToggleBtnAbout"); // NOI18N
        jToggleBtnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnAboutMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jLeftPanel.add(jToggleBtnAbout, gridBagConstraints);

        jSplitPane2.setLeftComponent(jLeftPanel);

        jRightPanel.setName("jRightPanel"); // NOI18N
        jRightPanel.setLayout(new java.awt.CardLayout());
        jSplitPane2.setRightComponent(jRightPanel);

        jSplitMainPane.setBottomComponent(jSplitPane2);

        setComponent(jSplitMainPane);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleBtnXemPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnXemPhongMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelXemPhong.getName());
    }//GEN-LAST:event_jToggleBtnXemPhongMousePressed

    private void jToggleBtnTimPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnTimPhongMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelTimPhong.getName());
    }//GEN-LAST:event_jToggleBtnTimPhongMousePressed

    private void jToggleBtnThuePhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnThuePhongMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelThuePhong.getName());
    }//GEN-LAST:event_jToggleBtnThuePhongMousePressed

    private void jToggleBtnTraPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnTraPhongMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelTraPhong.getName());
    }//GEN-LAST:event_jToggleBtnTraPhongMousePressed

    private void jToggleBtnThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnThongKeMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelThongKe.getName());
    }//GEN-LAST:event_jToggleBtnThongKeMousePressed

    private void jToggleBtnSubmitXMLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnSubmitXMLMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelSubmitXML.getName());
    }//GEN-LAST:event_jToggleBtnSubmitXMLMousePressed

    private void jToggleBtnCauHinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnCauHinhMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelCauhinh.getName());
    }//GEN-LAST:event_jToggleBtnCauHinhMousePressed

    private void jToggleBtnHelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnHelpMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleBtnHelpMousePressed

    private void jToggleBtnAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnAboutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleBtnAboutMousePressed

    //click on button Xem phong
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupMainController;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTenKhachSan;
    private javax.swing.JLabel jLabelThoiGian;
    private javax.swing.JPanel jLeftPanel;
    private javax.swing.JPanel jRightPanel;
    private javax.swing.JSplitPane jSplitMainPane;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToggleButton jToggleBtnAbout;
    private javax.swing.JToggleButton jToggleBtnCauHinh;
    private javax.swing.JToggleButton jToggleBtnHelp;
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

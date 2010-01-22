/*
 * ClientView.java
 */

package client;

import BUS.PhongController;
import DTO.Phong;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;

/**
 * The application's main frame.
 */
public class ClientView extends FrameView {

    public ClientView(SingleFrameApplication app) {
        super(app);
        
        initComponents();

        this.getFrame().setPreferredSize(new Dimension(853, 590));
        this.getFrame().setResizable(false);

        //setsize for components
        Dimension dimensionRight = new Dimension(686, 512);
        jRightPanel.setSize(dimensionRight);
        jRightPanel.setMaximumSize(dimensionRight);
        jRightPanel.setMinimumSize(dimensionRight);

        Dimension dimensionLeft = new Dimension(155, 512);
        jLeftPanel.setSize(dimensionLeft);
        jLeftPanel.setMaximumSize(dimensionLeft);
        jLeftPanel.setMinimumSize(dimensionLeft);

        //Dimension dimensionTop = new Dimension(841, 107);
        //jTopPanel.setMaximumSize(dimensionTop);
        //jTopPanel.setMinimumSize(dimensionTop);
        //jTopPanel.setSize(dimensionTop);

        
        myInit();
                
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
        jSplitPane2 = new javax.swing.JSplitPane();
        jLeftPanel = new javax.swing.JPanel();
        jToggleBtnXemPhong = new javax.swing.JToggleButton();
        jToggleBtnTimPhong = new javax.swing.JToggleButton();
        jToggleBtnThuePhong = new javax.swing.JToggleButton();
        jToggleBtnTraPhong = new javax.swing.JToggleButton();
        jToggleBtnThongKe = new javax.swing.JToggleButton();
        jToggleBtnAbout = new javax.swing.JToggleButton();
        jToggleBtnCauHinh = new javax.swing.JToggleButton();
        jToggleBtnHelp = new javax.swing.JToggleButton();
        jToggleBtnIntro = new javax.swing.JToggleButton();
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
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 564, Short.MAX_VALUE)
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

        jSplitPane2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jLeftPanel.setName("jLeftPanel"); // NOI18N
        jLeftPanel.setLayout(new java.awt.GridBagLayout());

        jToggleBtnXemPhong.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnXemPhong);
        jToggleBtnXemPhong.setFont(resourceMap.getFont("jToggleBtnXemPhong.font")); // NOI18N
        jToggleBtnXemPhong.setIcon(resourceMap.getIcon("jToggleBtnXemPhong.icon")); // NOI18N
        jToggleBtnXemPhong.setText(resourceMap.getString("jToggleBtnXemPhong.text")); // NOI18N
        jToggleBtnXemPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnXemPhong.setIconTextGap(0);
        jToggleBtnXemPhong.setMargin(null);
        jToggleBtnXemPhong.setName("jToggleBtnXemPhong"); // NOI18N
        jToggleBtnXemPhong.setPressedIcon(resourceMap.getIcon("jToggleBtnXemPhong.pressedIcon")); // NOI18N
        jToggleBtnXemPhong.setSelectedIcon(resourceMap.getIcon("jToggleBtnXemPhong.selectedIcon")); // NOI18N
        jToggleBtnXemPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnXemPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnXemPhong, gridBagConstraints);

        jToggleBtnTimPhong.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnTimPhong);
        jToggleBtnTimPhong.setFont(resourceMap.getFont("jToggleBtnTimPhong.font")); // NOI18N
        jToggleBtnTimPhong.setIcon(resourceMap.getIcon("jToggleBtnTimPhong.icon")); // NOI18N
        jToggleBtnTimPhong.setText(resourceMap.getString("jToggleBtnTimPhong.text")); // NOI18N
        jToggleBtnTimPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnTimPhong.setIconTextGap(0);
        jToggleBtnTimPhong.setMargin(null);
        jToggleBtnTimPhong.setName("jToggleBtnTimPhong"); // NOI18N
        jToggleBtnTimPhong.setPressedIcon(resourceMap.getIcon("jToggleBtnTimPhong.pressedIcon")); // NOI18N
        jToggleBtnTimPhong.setSelectedIcon(resourceMap.getIcon("jToggleBtnTimPhong.selectedIcon")); // NOI18N
        jToggleBtnTimPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnTimPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnTimPhong, gridBagConstraints);

        jToggleBtnThuePhong.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnThuePhong);
        jToggleBtnThuePhong.setFont(resourceMap.getFont("jToggleBtnThuePhong.font")); // NOI18N
        jToggleBtnThuePhong.setIcon(resourceMap.getIcon("jToggleBtnThuePhong.icon")); // NOI18N
        jToggleBtnThuePhong.setText(resourceMap.getString("jToggleBtnThuePhong.text")); // NOI18N
        jToggleBtnThuePhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnThuePhong.setIconTextGap(0);
        jToggleBtnThuePhong.setMargin(null);
        jToggleBtnThuePhong.setName("jToggleBtnThuePhong"); // NOI18N
        jToggleBtnThuePhong.setPressedIcon(resourceMap.getIcon("jToggleBtnThuePhong.pressedIcon")); // NOI18N
        jToggleBtnThuePhong.setSelectedIcon(resourceMap.getIcon("jToggleBtnThuePhong.selectedIcon")); // NOI18N
        jToggleBtnThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnThuePhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnThuePhong, gridBagConstraints);

        jToggleBtnTraPhong.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnTraPhong);
        jToggleBtnTraPhong.setFont(resourceMap.getFont("jToggleBtnTraPhong.font")); // NOI18N
        jToggleBtnTraPhong.setIcon(resourceMap.getIcon("jToggleBtnTraPhong.icon")); // NOI18N
        jToggleBtnTraPhong.setText(resourceMap.getString("jToggleBtnTraPhong.text")); // NOI18N
        jToggleBtnTraPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnTraPhong.setIconTextGap(0);
        jToggleBtnTraPhong.setMargin(null);
        jToggleBtnTraPhong.setName("jToggleBtnTraPhong"); // NOI18N
        jToggleBtnTraPhong.setPressedIcon(resourceMap.getIcon("jToggleBtnTraPhong.pressedIcon")); // NOI18N
        jToggleBtnTraPhong.setSelectedIcon(resourceMap.getIcon("jToggleBtnTraPhong.selectedIcon")); // NOI18N
        jToggleBtnTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnTraPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnTraPhong, gridBagConstraints);

        jToggleBtnThongKe.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnThongKe);
        jToggleBtnThongKe.setFont(resourceMap.getFont("jToggleBtnThongKe.font")); // NOI18N
        jToggleBtnThongKe.setIcon(resourceMap.getIcon("jToggleBtnThongKe.icon")); // NOI18N
        jToggleBtnThongKe.setText(resourceMap.getString("jToggleBtnThongKe.text")); // NOI18N
        jToggleBtnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnThongKe.setIconTextGap(0);
        jToggleBtnThongKe.setMargin(null);
        jToggleBtnThongKe.setName("jToggleBtnThongKe"); // NOI18N
        jToggleBtnThongKe.setPressedIcon(resourceMap.getIcon("jToggleBtnThongKe.pressedIcon")); // NOI18N
        jToggleBtnThongKe.setSelectedIcon(resourceMap.getIcon("jToggleBtnThongKe.selectedIcon")); // NOI18N
        jToggleBtnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnThongKeMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnThongKe, gridBagConstraints);

        jToggleBtnAbout.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnAbout);
        jToggleBtnAbout.setFont(resourceMap.getFont("jToggleBtnAbout.font")); // NOI18N
        jToggleBtnAbout.setIcon(resourceMap.getIcon("jToggleBtnAbout.icon")); // NOI18N
        jToggleBtnAbout.setText(resourceMap.getString("jToggleBtnAbout.text")); // NOI18N
        jToggleBtnAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnAbout.setIconTextGap(0);
        jToggleBtnAbout.setMargin(null);
        jToggleBtnAbout.setName("jToggleBtnAbout"); // NOI18N
        jToggleBtnAbout.setPressedIcon(resourceMap.getIcon("jToggleBtnAbout.pressedIcon")); // NOI18N
        jToggleBtnAbout.setSelectedIcon(resourceMap.getIcon("jToggleBtnAbout.selectedIcon")); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnAbout, gridBagConstraints);

        jToggleBtnCauHinh.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnCauHinh);
        jToggleBtnCauHinh.setFont(resourceMap.getFont("jToggleBtnCauHinh.font")); // NOI18N
        jToggleBtnCauHinh.setIcon(resourceMap.getIcon("jToggleBtnCauHinh.icon")); // NOI18N
        jToggleBtnCauHinh.setText(resourceMap.getString("jToggleBtnCauHinh.text")); // NOI18N
        jToggleBtnCauHinh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnCauHinh.setIconTextGap(0);
        jToggleBtnCauHinh.setMargin(null);
        jToggleBtnCauHinh.setName("jToggleBtnCauHinh"); // NOI18N
        jToggleBtnCauHinh.setPressedIcon(resourceMap.getIcon("jToggleBtnCauHinh.pressedIcon")); // NOI18N
        jToggleBtnCauHinh.setSelectedIcon(resourceMap.getIcon("jToggleBtnCauHinh.selectedIcon")); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnCauHinh, gridBagConstraints);

        jToggleBtnHelp.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnHelp);
        jToggleBtnHelp.setFont(resourceMap.getFont("jToggleBtnHelp.font")); // NOI18N
        jToggleBtnHelp.setIcon(resourceMap.getIcon("jToggleBtnHelp.icon")); // NOI18N
        jToggleBtnHelp.setText(resourceMap.getString("jToggleBtnHelp.text")); // NOI18N
        jToggleBtnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnHelp.setIconTextGap(0);
        jToggleBtnHelp.setMargin(null);
        jToggleBtnHelp.setName("jToggleBtnHelp"); // NOI18N
        jToggleBtnHelp.setPressedIcon(resourceMap.getIcon("jToggleBtnHelp.pressedIcon")); // NOI18N
        jToggleBtnHelp.setSelectedIcon(resourceMap.getIcon("jToggleBtnHelp.selectedIcon")); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnHelp, gridBagConstraints);

        jToggleBtnIntro.setBackground(resourceMap.getColor("jToggleBtnXemPhong.background")); // NOI18N
        btnGroupMainController.add(jToggleBtnIntro);
        jToggleBtnIntro.setFont(resourceMap.getFont("jToggleBtnIntro.font")); // NOI18N
        jToggleBtnIntro.setIcon(resourceMap.getIcon("jToggleBtnIntro.icon")); // NOI18N
        jToggleBtnIntro.setSelected(true);
        jToggleBtnIntro.setText(resourceMap.getString("jToggleBtnIntro.text")); // NOI18N
        jToggleBtnIntro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleBtnIntro.setIconTextGap(0);
        jToggleBtnIntro.setMargin(null);
        jToggleBtnIntro.setName("jToggleBtnIntro"); // NOI18N
        jToggleBtnIntro.setPressedIcon(resourceMap.getIcon("jToggleBtnIntro.pressedIcon")); // NOI18N
        jToggleBtnIntro.setSelectedIcon(resourceMap.getIcon("jToggleBtnIntro.selectedIcon")); // NOI18N
        jToggleBtnIntro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleBtnIntroMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jLeftPanel.add(jToggleBtnIntro, gridBagConstraints);

        jSplitPane2.setLeftComponent(jLeftPanel);

        jRightPanel.setName("jRightPanel"); // NOI18N
        jRightPanel.setLayout(new java.awt.CardLayout());
        jSplitPane2.setRightComponent(jRightPanel);

        jSplitMainPane.setBottomComponent(jSplitPane2);

        setComponent(jSplitPane2);
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

    private void jToggleBtnAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnAboutMousePressed
        // TODO add your handling code here:
        jToggleBtnAbout.setSelected(true);
        if(aboutBox == null)
        {
            aboutBox = new ClientAboutBox(null, true);
        }
        aboutBox.setVisible(true);
    }//GEN-LAST:event_jToggleBtnAboutMousePressed

    private void jToggleBtnCauHinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnCauHinhMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelCauhinh.getName());
    }//GEN-LAST:event_jToggleBtnCauHinhMousePressed

    public java.lang.Integer[] getListIdRoomAvailable() {
        //TODO write your implementation code here:

        PhongController phongController = new PhongController();
        ArrayList<Phong> lstPhong = phongController.getDSPhongChuaThue();

        Integer[] arrId = null;

        if(lstPhong!=null)
        {
            arrId = new Integer[lstPhong.size()];
            int i;
            for(i=0;i<lstPhong.size();i++)
            {
                arrId[i] = lstPhong.get(i).getId();
            }

            return arrId;
        }
        else
            return null;
    }

    private void jToggleBtnHelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnHelpMousePressed
//        try {
//            // TODO add your handling code here:
//            Desktop.getDesktop().open(new File("src/client/help/Document.chm"));
//        } catch (IOException ex) {
//            try {
//                Desktop.getDesktop().open(new File("/Help/Document.chm"));
//            } catch (IOException ex1) {
//                try {
//                    Desktop.getDesktop().open(new File("Help/Document.chm"));
//                } catch (IOException ex2) {
//                    Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex2);
//                }
//                Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            // TODO add your handling code here:
            Desktop.getDesktop().open(new File("Document.chm"));
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jToggleBtnHelpMousePressed

    private void jToggleBtnIntroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleBtnIntroMousePressed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)jRightPanel.getLayout();
        cl.show(jRightPanel, panelIntro.getName());
    }//GEN-LAST:event_jToggleBtnIntroMousePressed

    //click on button Xem phong
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupMainController;
    private javax.swing.JPanel jLeftPanel;
    private javax.swing.JPanel jRightPanel;
    private javax.swing.JSplitPane jSplitMainPane;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToggleButton jToggleBtnAbout;
    private javax.swing.JToggleButton jToggleBtnCauHinh;
    private javax.swing.JToggleButton jToggleBtnHelp;
    private javax.swing.JToggleButton jToggleBtnIntro;
    private javax.swing.JToggleButton jToggleBtnThongKe;
    private javax.swing.JToggleButton jToggleBtnThuePhong;
    private javax.swing.JToggleButton jToggleBtnTimPhong;
    private javax.swing.JToggleButton jToggleBtnTraPhong;
    private javax.swing.JToggleButton jToggleBtnXemPhong;
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
    private JPanelThongKe panelThongKe;
    private JPanelThuePhong panelThuePhong;
    private JPanelTimPhong panelTimPhong;
    private JPanelTraPhong panelTraPhong;    
    private JPanelXemPhong panelXemPhong;
    private JPanelIntro panelIntro;

    private void myInit() {
        //init panels
        panelIntro = new JPanelIntro();
        panelIntro.setName("panelIntro");

        panelCauhinh = new JPanelCauHinh();
        panelCauhinh.setName("panelCauhinh");
      
        panelThongKe = new JPanelThongKe();
        panelThongKe.setName("panelThongKe");

        panelThuePhong = new JPanelThuePhong(this.getFrame());
        panelThuePhong.setName("panelThuePhong");

        panelTimPhong = new JPanelTimPhong();
        panelTimPhong.setName("panelTimPhong");

        panelTraPhong = new JPanelTraPhong();
        panelTraPhong.setName("panelTraPhong");

        panelXemPhong = new JPanelXemPhong(this.getFrame());
        panelXemPhong.setName("panelXemPhong");

        //load and paint default panel
        jRightPanel.add(panelIntro,panelIntro.getName());
        jRightPanel.add(panelXemPhong,panelXemPhong.getName()); 
        jRightPanel.add(panelThuePhong,panelThuePhong.getName());
        jRightPanel.add(panelCauhinh,panelCauhinh.getName());        
        jRightPanel.add(panelThongKe,panelThongKe.getName());
        jRightPanel.add(panelTimPhong,panelTimPhong.getName());
        jRightPanel.add(panelTraPhong,panelTraPhong.getName());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelCauHinh.java
 *
 * Created on Dec 18, 2009, 12:40:06 PM
 */

package client;

import BUS.KhachHangController;
import BUS.PhongController;
import BUS.ThamSoController;
import DTO.LoaiKhachHang;
import DTO.LoaiPhong;
import DTO.ThamSo;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author huy
 */
public class JPanelCauHinh extends javax.swing.JPanel {

    /** Creates new form JPanelCauHinh */
    public JPanelCauHinh() {
        initComponents();

        phongController = new PhongController();
        khachController = new KhachHangController();
        thamSoController = new ThamSoController();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHeThong = new javax.swing.JPanel();
        jMainPanelHeThong = new javax.swing.JPanel();
        bgLabel1 = new javax.swing.JLabel();
        jPanelNghiepVu = new javax.swing.JPanel();
        jMainPanelNghiepVu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCbLoaiPhong = new javax.swing.JComboBox();
        jCbLoaiKhach = new javax.swing.JComboBox();
        jBtnChinhSua = new javax.swing.JButton();
        jBtnCapNhat = new javax.swing.JButton();
        imgConfig = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtGiaPhong = new javax.swing.JFormattedTextField();
        jTxtGiaKhach = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLoaiPhong = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLoaiKhachHang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jcbThamSo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTxtGiaTriThamSo = new javax.swing.JFormattedTextField();
        jCheckThamSo = new javax.swing.JCheckBox();
        bgLabel2 = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanelHeThong.setName("jPanelTabHeThong"); // NOI18N
        jPanelHeThong.setLayout(new java.awt.GridBagLayout());

        jMainPanelHeThong.setName("jMainPanelHeThong"); // NOI18N
        jMainPanelHeThong.setOpaque(false);

        javax.swing.GroupLayout jMainPanelHeThongLayout = new javax.swing.GroupLayout(jMainPanelHeThong);
        jMainPanelHeThong.setLayout(jMainPanelHeThongLayout);
        jMainPanelHeThongLayout.setHorizontalGroup(
            jMainPanelHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jMainPanelHeThongLayout.setVerticalGroup(
            jMainPanelHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelHeThong.add(jMainPanelHeThong, gridBagConstraints);

        bgLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JPanelCauHinh.class);
        bgLabel1.setIcon(resourceMap.getIcon("bgLabel1.icon")); // NOI18N
        bgLabel1.setText(resourceMap.getString("bgLabel1.text")); // NOI18N
        bgLabel1.setName("bgLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelHeThong.add(bgLabel1, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelTabHeThong.TabConstraints.tabTitle"), resourceMap.getIcon("jPanelTabHeThong.TabConstraints.tabIcon"), jPanelHeThong); // NOI18N

        jPanelNghiepVu.setName("jPanelTabNghiepVu"); // NOI18N
        jPanelNghiepVu.setLayout(new java.awt.GridBagLayout());

        jMainPanelNghiepVu.setName("jMainPanelNghiepVu"); // NOI18N
        jMainPanelNghiepVu.setOpaque(false);
        jMainPanelNghiepVu.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jMainPanelNghiepVu.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jLabel3, gridBagConstraints);

        jCbLoaiPhong.setBackground(resourceMap.getColor("jCbLoaiKhach.background")); // NOI18N
        jCbLoaiPhong.setName("jCbLoaiPhong"); // NOI18N
        jCbLoaiPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbLoaiPhongItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jCbLoaiPhong, gridBagConstraints);

        jCbLoaiKhach.setBackground(resourceMap.getColor("jCbLoaiKhach.background")); // NOI18N
        jCbLoaiKhach.setName("jCbLoaiKhach"); // NOI18N
        jCbLoaiKhach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbLoaiKhachItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jCbLoaiKhach, gridBagConstraints);

        jBtnChinhSua.setText(resourceMap.getString("jBtnChinhSua.text")); // NOI18N
        jBtnChinhSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnChinhSua.setName("jBtnChinhSua"); // NOI18N
        jBtnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnChinhSuaMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(21, 13, 10, 13);
        jMainPanelNghiepVu.add(jBtnChinhSua, gridBagConstraints);

        jBtnCapNhat.setText(resourceMap.getString("jBtnCapNhat.text")); // NOI18N
        jBtnCapNhat.setEnabled(false);
        jBtnCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnCapNhat.setName("jBtnCapNhat"); // NOI18N
        jBtnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnCapNhatMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 10, 10);
        jMainPanelNghiepVu.add(jBtnCapNhat, gridBagConstraints);

        imgConfig.setIcon(resourceMap.getIcon("imgConfig.icon")); // NOI18N
        imgConfig.setText(resourceMap.getString("imgConfig.text")); // NOI18N
        imgConfig.setName("imgConfig"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 31);
        jMainPanelNghiepVu.add(imgConfig, gridBagConstraints);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 0);
        jMainPanelNghiepVu.add(jLabel4, gridBagConstraints);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 0);
        jMainPanelNghiepVu.add(jLabel5, gridBagConstraints);

        jTxtGiaPhong.setBackground(resourceMap.getColor("jTxtGiaPhong.background")); // NOI18N
        jTxtGiaPhong.setColumns(10);
        jTxtGiaPhong.setEditable(false);
        jTxtGiaPhong.setText(resourceMap.getString("jTxtGiaPhong.text")); // NOI18N
        jTxtGiaPhong.setName("jTxtGiaPhong"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jTxtGiaPhong, gridBagConstraints);

        jTxtGiaKhach.setBackground(resourceMap.getColor("jTxtGiaPhong.background")); // NOI18N
        jTxtGiaKhach.setColumns(10);
        jTxtGiaKhach.setEditable(false);
        jTxtGiaKhach.setText(resourceMap.getString("jTxtGiaKhach.text")); // NOI18N
        jTxtGiaKhach.setName("jTxtGiaKhach"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jTxtGiaKhach, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 80));
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTableLoaiPhong.setBackground(resourceMap.getColor("jTableLoaiPhong.background")); // NOI18N
        jTableLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Loai Phong", "Don Gia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLoaiPhong.setEnabled(false);
        jTableLoaiPhong.setFocusable(false);
        jTableLoaiPhong.setGridColor(resourceMap.getColor("jTableLoaiPhong.gridColor")); // NOI18N
        jTableLoaiPhong.setName("jTableLoaiPhong"); // NOI18N
        jTableLoaiPhong.setPreferredSize(new java.awt.Dimension(150, 100));
        jScrollPane1.setViewportView(jTableLoaiPhong);
        jTableLoaiPhong.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableLoaiPhong.columnModel.title0")); // NOI18N
        jTableLoaiPhong.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableLoaiPhong.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jMainPanelNghiepVu.add(jScrollPane1, gridBagConstraints);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(23, 80));
        jScrollPane2.setName("jScrollPane2"); // NOI18N
        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 80));

        jTableLoaiKhachHang.setBackground(resourceMap.getColor("jTableLoaiPhong.background")); // NOI18N
        jTableLoaiKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Loai Khach Hang", "Don Gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLoaiKhachHang.setEnabled(false);
        jTableLoaiKhachHang.setFocusable(false);
        jTableLoaiKhachHang.setGridColor(resourceMap.getColor("jTableLoaiPhong.gridColor")); // NOI18N
        jTableLoaiKhachHang.setName("jTableLoaiKhachHang"); // NOI18N
        jScrollPane2.setViewportView(jTableLoaiKhachHang);
        jTableLoaiKhachHang.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableLoaiKhachHang.columnModel.title0")); // NOI18N
        jTableLoaiKhachHang.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableLoaiKhachHang.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jMainPanelNghiepVu.add(jScrollPane2, gridBagConstraints);

        jLabel6.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel6.setForeground(resourceMap.getColor("jLabel6.foreground")); // NOI18N
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jLabel6, gridBagConstraints);

        jcbThamSo.setBackground(resourceMap.getColor("jcbThamSo.background")); // NOI18N
        jcbThamSo.setName("jcbThamSo"); // NOI18N
        jcbThamSo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbThamSoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jcbThamSo, gridBagConstraints);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jMainPanelNghiepVu.add(jLabel7, gridBagConstraints);

        jTxtGiaTriThamSo.setBackground(resourceMap.getColor("jTxtGiaTriThamSo.background")); // NOI18N
        jTxtGiaTriThamSo.setEditable(false);
        jTxtGiaTriThamSo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTxtGiaTriThamSo.setName("jTxtGiaTriThamSo"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jTxtGiaTriThamSo, gridBagConstraints);

        jCheckThamSo.setText(resourceMap.getString("jCheckThamSo.text")); // NOI18N
        jCheckThamSo.setEnabled(false);
        jCheckThamSo.setName("jCheckThamSo"); // NOI18N
        jCheckThamSo.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jMainPanelNghiepVu.add(jCheckThamSo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelNghiepVu.add(jMainPanelNghiepVu, gridBagConstraints);

        bgLabel2.setIcon(resourceMap.getIcon("bgLabel2.icon")); // NOI18N
        bgLabel2.setText(resourceMap.getString("bgLabel2.text")); // NOI18N
        bgLabel2.setName("bgLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelNghiepVu.add(bgLabel2, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelTabNghiepVu.TabConstraints.tabTitle"), resourceMap.getIcon("jPanelTabNghiepVu.TabConstraints.tabIcon"), jPanelNghiepVu); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPane1, gridBagConstraints);

        bgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgLabel.setIcon(resourceMap.getIcon("bgLabel.icon")); // NOI18N
        bgLabel.setText(resourceMap.getString("bgLabel.text")); // NOI18N
        bgLabel.setName("bgLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(bgLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnChinhSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnChinhSuaMousePressed
        // TODO add your handling code here:
        if(!this.jBtnChinhSua.isEnabled())
            return;

        int result = JOptionPane.showConfirmDialog(this.getComponent(0),"Ban co muon sua hay khong?" , "Thong bao", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.OK_OPTION)
        {
            //set editable
            this.jBtnCapNhat.setEnabled(true);
            this.jTxtGiaKhach.setEditable(true);
            this.jTxtGiaPhong.setEditable(true);
            this.jTxtGiaTriThamSo.setEditable(true);
            this.jCheckThamSo.setEnabled(true);

            this.jBtnChinhSua.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnChinhSuaMousePressed

    private void jBtnCapNhatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnCapNhatMousePressed
        // TODO add your handling code here:
        if(!this.jBtnCapNhat.isEnabled())
            return;

        int result = JOptionPane.showConfirmDialog(this.getComponent(0),"Ban co muon luu nhung thay doi khong?" , "Thong bao", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.OK_OPTION)
        {
            String s = jTxtGiaKhach.getText();
            if(s.equals(""))
            {
                JOptionPane.showMessageDialog(this.getComponent(0), "Nhap vao don gia khach hang!","Thong bao", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int giaKhach = Integer.parseInt(s);

            s = jTxtGiaPhong.getText();
            if(s.equals(""))
            {
                JOptionPane.showMessageDialog(this.getComponent(0), "Nhap vao don gia phong!","Thong bao", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int giaPhong = Integer.parseInt(s);

            s = jTxtGiaTriThamSo.getText();
            if(s.equals(""))
            {
                JOptionPane.showMessageDialog(this.getComponent(0), "Nhap vao gia tri tham so!","Thong bao", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int giaTriThamSo = Integer.parseInt(s);

            LoaiKhachHang loaiKhachHang = layLoaiKhachHangTheoTen(jCbLoaiKhach.getSelectedItem().toString());
            loaiKhachHang.setGia(giaKhach);
            
            LoaiPhong loaiPhong = layLoaiPhongTheoTen(jCbLoaiPhong.getSelectedItem().toString());
            loaiPhong.setGia(giaPhong);
            
            ThamSo thamSo = layThamSoTheoTen(jcbThamSo.getSelectedItem().toString());
            thamSo.setValue(giaTriThamSo);
            thamSo.setUse(jCheckThamSo.isSelected());

            if(!phongController.capNhatLoaiPhong(loaiPhong))
            {
                JOptionPane.showMessageDialog(this.getComponent(0),"Cap nhat gia tien phong that bai" , "Thong bao", JOptionPane.ERROR_MESSAGE);                
            }else            
            if(!khachController.capNhatLoaiKhachHang(loaiKhachHang))
            {
                JOptionPane.showMessageDialog(this.getComponent(0),"Cap nhat gia tien khach hang that bai" , "Thong bao", JOptionPane.ERROR_MESSAGE);
            }else
                if(!thamSoController.capNhatThamSo(thamSo))
                {
                    JOptionPane.showMessageDialog(this.getComponent(0),"Cap nhat tham so" + thamSo.getName() + "that bai" , "Thong bao", JOptionPane.ERROR_MESSAGE);
                }
                else
                JOptionPane.showMessageDialog(this.getComponent(0),"Cap nhat thanh cong" , "Thong bao", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            //restore old values
            initComboLoaiKhachHang();
            initComboLoaiPhong();
            initComboThamSo();
        }
        
        //disable fields
        this.jBtnCapNhat.setEnabled(false);
        this.jTxtGiaKhach.setEditable(false);
        this.jTxtGiaPhong.setEditable(false);
        this.jTxtGiaTriThamSo.setEditable(false);
        this.jCheckThamSo.setEnabled(false);

        this.jBtnChinhSua.setEnabled(true);
    }//GEN-LAST:event_jBtnCapNhatMousePressed

    private void jCbLoaiPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbLoaiPhongItemStateChanged
        // TODO add your handling code here:
        if(jCbLoaiPhong.getItemCount()>0)
        {
            LoaiPhong loaiPhong = layLoaiPhongTheoTen(jCbLoaiPhong.getSelectedItem().toString());
            jTxtGiaPhong.setText("" + loaiPhong.getGia());
        }
    }//GEN-LAST:event_jCbLoaiPhongItemStateChanged

    private void jCbLoaiKhachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbLoaiKhachItemStateChanged
        // TODO add your handling code here:
        if(jCbLoaiKhach.getItemCount()>0)
        {
            LoaiKhachHang loaiKhach = layLoaiKhachHangTheoTen(jCbLoaiKhach.getSelectedItem().toString());
            jTxtGiaKhach.setText("" + loaiKhach.getGia());
        }
    }//GEN-LAST:event_jCbLoaiKhachItemStateChanged

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        WorkerGetListLoaiKhachHang workerGetLoaiKhach = new WorkerGetListLoaiKhachHang();
        workerGetLoaiKhach.run();

        WorkerGetListLoaiPhong workerGetLoaiPhong = new WorkerGetListLoaiPhong();
        workerGetLoaiPhong.run();

        WorkerGetListThamSo workerGetThamSo = new WorkerGetListThamSo();
        workerGetThamSo.run();

        try {
            lstLoaiKhachHang = workerGetLoaiKhach.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelCauHinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JPanelCauHinh.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            lstLoaiPhong = workerGetLoaiPhong.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelCauHinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JPanelCauHinh.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            lstThamSo = workerGetThamSo.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelCauHinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JPanelCauHinh.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(lstLoaiKhachHang!=null)
        {
            initComboLoaiKhachHang();
            initTableLoaiKhachHang();
        }

        if(lstLoaiPhong!=null)
        {
            initComboLoaiPhong();
            initTableLoaiPhong();
        }

        if(lstThamSo!=null)
        {
            initComboThamSo();
        }
    }//GEN-LAST:event_formComponentShown

    private void jcbThamSoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbThamSoItemStateChanged
        // TODO add your handling code here:
        if(jcbThamSo.getItemCount()>0)
        {
            ThamSo thamSo = layThamSoTheoTen(jcbThamSo.getSelectedItem().toString());
            jTxtGiaTriThamSo.setText("" + thamSo.getValue());
            jCheckThamSo.setSelected(thamSo.isUse());
        }
    }//GEN-LAST:event_jcbThamSoItemStateChanged


    private String[] headerLoaiKhachHang = new String [] {"Loai Khach Hang", "Don Gia" };
    private void initTableLoaiKhachHang()
    {
        jTableLoaiKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            headerLoaiKhachHang,0
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        DefaultTableModel model = (DefaultTableModel) jTableLoaiKhachHang.getModel();
        
        int i;
        for(i=0;i<lstLoaiKhachHang.size();i++)
        {
            Object[] arr = new Object[2];
            
            arr[0] = lstLoaiKhachHang.get(i).getTen();
            arr[1] = lstLoaiKhachHang.get(i).getGia();
            
            model.addRow(arr);
        }
        
        jTableLoaiKhachHang.setEnabled(false);
    }
    
    private String[] headerLoaiPhong = new String [] {"Loai Phong", "Don Gia" };
    private void initTableLoaiPhong()
    {
        jTableLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
            headerLoaiPhong,0
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        DefaultTableModel model = (DefaultTableModel) jTableLoaiPhong.getModel();
        
        int i;
        for(i=0;i<lstLoaiPhong.size();i++)
        {
            Object[] arr = new Object[2];
            
            arr[0] = lstLoaiPhong.get(i).getTen();
            arr[1] = lstLoaiPhong.get(i).getGia();
            
            model.addRow(arr);
        }
        
        jTableLoaiPhong.setEnabled(false);
    }

    private void initComboLoaiPhong() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        int i;
        for(i=0;i<lstLoaiPhong.size();i++)
        {
            model.addElement(lstLoaiPhong.get(i).getTen());
        }

        jCbLoaiPhong.setModel(model);

        jCbLoaiPhong.setSelectedIndex(0);
        jTxtGiaPhong.setText("" + lstLoaiPhong.get(0).getGia());
    }

    private void initComboLoaiKhachHang() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        int i;
        for(i=0;i<lstLoaiKhachHang.size();i++)
        {
            model.addElement(lstLoaiKhachHang.get(i).getTen());
        }

        jCbLoaiKhach.setModel(model);

        jCbLoaiKhach.setSelectedIndex(0);
        jTxtGiaKhach.setText("" + lstLoaiKhachHang.get(0).getGia());
    }

    private void initComboThamSo() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        int i;
        for(i=0;i<lstThamSo.size();i++)
        {
            model.addElement(lstThamSo.get(i).getName());            
        }

        jcbThamSo.setModel(model);
        
        jcbThamSo.setSelectedIndex(0);
        ThamSo ts = lstThamSo.get(0);
        jTxtGiaTriThamSo.setText("" + ts.getValue());
        jCheckThamSo.setSelected(ts.isUse());
    }

    private LoaiKhachHang layLoaiKhachHangTheoTen(String ten)
    {
        int i;
        for(i=0;i<lstLoaiKhachHang.size();i++)
        {
            if(lstLoaiKhachHang.get(i).getTen().equals(ten))
            {
                return lstLoaiKhachHang.get(i);
            }
        }
        return null;
    }

    private ThamSo layThamSoTheoTen(String tenThamSo)
    {
        int i;
        for(i=0;i<lstThamSo.size();i++)
        {
            if(lstThamSo.get(i).getName().equals(tenThamSo))
            {
                return lstThamSo.get(i);
            }
        }
        return null;
    }

    private LoaiPhong layLoaiPhongTheoTen(String ten)
    {
        int i;
        for(i=0;i<lstLoaiPhong.size();i++)
        {
            if(lstLoaiPhong.get(i).getTen().equals(ten))
            {
                return lstLoaiPhong.get(i);
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLabel bgLabel1;
    private javax.swing.JLabel bgLabel2;
    private javax.swing.JLabel imgConfig;
    private javax.swing.JButton jBtnCapNhat;
    private javax.swing.JButton jBtnChinhSua;
    private javax.swing.JComboBox jCbLoaiKhach;
    private javax.swing.JComboBox jCbLoaiPhong;
    private javax.swing.JCheckBox jCheckThamSo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jMainPanelHeThong;
    private javax.swing.JPanel jMainPanelNghiepVu;
    private javax.swing.JPanel jPanelHeThong;
    private javax.swing.JPanel jPanelNghiepVu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableLoaiKhachHang;
    private javax.swing.JTable jTableLoaiPhong;
    private javax.swing.JFormattedTextField jTxtGiaKhach;
    private javax.swing.JFormattedTextField jTxtGiaPhong;
    private javax.swing.JFormattedTextField jTxtGiaTriThamSo;
    private javax.swing.JComboBox jcbThamSo;
    // End of variables declaration//GEN-END:variables

    PhongController phongController;
    KhachHangController khachController;
    ThamSoController thamSoController;
    
    ArrayList<LoaiPhong> lstLoaiPhong;
    ArrayList<LoaiKhachHang> lstLoaiKhachHang;
    ArrayList<ThamSo> lstThamSo;

}
class WorkerGetListThamSo extends SwingWorker<ArrayList<ThamSo>, Void>
{
    private ThamSoController thamSoController;
    @Override
    protected ArrayList<ThamSo> doInBackground() throws Exception {

        thamSoController = new ThamSoController();
        return thamSoController.layDSThamSo();
    }

}
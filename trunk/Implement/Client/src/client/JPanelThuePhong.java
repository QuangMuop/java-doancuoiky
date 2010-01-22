/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelThuePhong.java
 *
 * Created on Dec 18, 2009, 11:47:15 AM
 */

package client;

import BUS.PhongController;
import BUS.ThamSoController;
import BUS.ThuePhongController;
import DTO.KhachHang;
import DTO.LoaiThue;
import DTO.Phong;
import DTO.ThamSo;
import DTO.ThuePhong;
import Utils.MyCompare;
import Utils.MyDateTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huy
 */
public class JPanelThuePhong extends javax.swing.JPanel {
    private JFrame mainFrame;

    private int SoKhachHangToiDa ;
    private int TienDatCocKhiThue;

    private ThamSoController thamSoController;
    /** Creates new form JPanelThuePhong */
    public JPanelThuePhong(JFrame parent) {
        initComponents();        
        
        this.mainFrame = parent;

        thamSoController = new ThamSoController();
        thuePhongController = new ThuePhongController();

        thuePhong = new ThuePhong();
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

        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jCbMaPhong = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jLabelLoaiPhong = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabelGiaTien = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTxtNgayThue = new javax.swing.JFormattedTextField();
        jBtnThuePhong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imgRoom = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lLabelLau = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCbLoaiThue = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhachHang = new javax.swing.JTable();
        jBtnThemKhach = new javax.swing.JButton();
        jBtnXoaKhach = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jlabelTienDatCoc = new javax.swing.JLabel();
        bgLabel3 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.CardLayout());

        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JPanelThuePhong.class);
        jLabel35.setFont(resourceMap.getFont("jLabel35.font")); // NOI18N
        jLabel35.setForeground(resourceMap.getColor("jLabel35.foreground")); // NOI18N
        jLabel35.setText(resourceMap.getString("jLabel35.text")); // NOI18N
        jLabel35.setName("jLabel35"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(32, 0, 2, 0);
        jPanel2.add(jLabel35, gridBagConstraints);

        jLabel37.setText(resourceMap.getString("jLabel37.text")); // NOI18N
        jLabel37.setName("jLabel37"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 40);
        jPanel2.add(jLabel37, gridBagConstraints);

        jCbMaPhong.setBackground(resourceMap.getColor("jCbMaPhong.background")); // NOI18N
        jCbMaPhong.setToolTipText(resourceMap.getString("jCbMaPhong.toolTipText")); // NOI18N
        jCbMaPhong.setName("jCbMaPhong"); // NOI18N
        jCbMaPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbMaPhongItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jCbMaPhong, gridBagConstraints);

        jLabel38.setText(resourceMap.getString("jLabel38.text")); // NOI18N
        jLabel38.setName("jLabel38"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 36);
        jPanel2.add(jLabel38, gridBagConstraints);

        jLabelLoaiPhong.setText(resourceMap.getString("jLabelLoaiPhong.text")); // NOI18N
        jLabelLoaiPhong.setName("jLabelLoaiPhong"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jLabelLoaiPhong, gridBagConstraints);

        jLabel40.setText(resourceMap.getString("jLabel40.text")); // NOI18N
        jLabel40.setName("jLabel40"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 52);
        jPanel2.add(jLabel40, gridBagConstraints);

        jLabelGiaTien.setText(resourceMap.getString("jLabelGiaTien.text")); // NOI18N
        jLabelGiaTien.setName("jLabelGiaTien"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jLabelGiaTien, gridBagConstraints);

        jLabel42.setText(resourceMap.getString("jLabel42.text")); // NOI18N
        jLabel42.setName("jLabel42"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 37);
        jPanel2.add(jLabel42, gridBagConstraints);

        jTxtNgayThue.setBackground(resourceMap.getColor("jTxtNgayThue.background")); // NOI18N
        jTxtNgayThue.setEditable(false);
        jTxtNgayThue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jTxtNgayThue.setToolTipText(resourceMap.getString("jTxtNgayThue.toolTipText")); // NOI18N
        jTxtNgayThue.setName("jTxtNgayThue"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jTxtNgayThue, gridBagConstraints);

        jBtnThuePhong.setText(resourceMap.getString("jBtnThuePhong.text")); // NOI18N
        jBtnThuePhong.setToolTipText(resourceMap.getString("jBtnThuePhong.toolTipText")); // NOI18N
        jBtnThuePhong.setName("jBtnThuePhong"); // NOI18N
        jBtnThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnThuePhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        jPanel2.add(jBtnThuePhong, gridBagConstraints);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 36;
        jPanel2.add(jLabel1, gridBagConstraints);

        imgRoom.setIcon(resourceMap.getIcon("imgRoom.icon")); // NOI18N
        imgRoom.setText(resourceMap.getString("imgRoom.text")); // NOI18N
        imgRoom.setName("imgRoom"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 28);
        jPanel2.add(imgRoom, gridBagConstraints);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        lLabelLau.setText(resourceMap.getString("lLabelLau.text")); // NOI18N
        lLabelLau.setName("lLabelLau"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(lLabelLau, gridBagConstraints);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 16);
        jPanel2.add(jLabel2, gridBagConstraints);

        jCbLoaiThue.setBackground(resourceMap.getColor("jCbLoaiThue.background")); // NOI18N
        jCbLoaiThue.setName("jCbLoaiThue"); // NOI18N
        jCbLoaiThue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbLoaiThueItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jCbLoaiThue, gridBagConstraints);

        jLabel36.setFont(resourceMap.getFont("jLabel36.font")); // NOI18N
        jLabel36.setForeground(resourceMap.getColor("jLabel36.foreground")); // NOI18N
        jLabel36.setText(resourceMap.getString("jLabel36.text")); // NOI18N
        jLabel36.setName("jLabel36"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel2.add(jLabel36, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 90));
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTableKhachHang.setBackground(resourceMap.getColor("jTableKhachHang.background")); // NOI18N
        jTableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên Khách Hàng", "Ngày Sinh", "CMND", "Giới Tính", "Địa Chỉ", "Điện Thoại", "Loại Khách Hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhachHang.setToolTipText(resourceMap.getString("jTableKhachHang.toolTipText")); // NOI18N
        jTableKhachHang.setDoubleBuffered(true);
        jTableKhachHang.setFocusable(false);
        jTableKhachHang.setGridColor(resourceMap.getColor("jTableKhachHang.gridColor")); // NOI18N
        jTableKhachHang.setName("jTableKhachHang"); // NOI18N
        jTableKhachHang.setOpaque(false);
        jTableKhachHang.setSelectionBackground(resourceMap.getColor("jTableKhachHang.selectionBackground")); // NOI18N
        jTableKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKhachHangKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhachHang);
        jTableKhachHang.getColumnModel().getColumn(0).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title0")); // NOI18N
        jTableKhachHang.getColumnModel().getColumn(1).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title1")); // NOI18N
        jTableKhachHang.getColumnModel().getColumn(2).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title2")); // NOI18N
        jTableKhachHang.getColumnModel().getColumn(3).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title3")); // NOI18N
        jTableKhachHang.getColumnModel().getColumn(4).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title4")); // NOI18N
        jTableKhachHang.getColumnModel().getColumn(5).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title5")); // NOI18N
        jTableKhachHang.getColumnModel().getColumn(6).setResizable(false);
        jTableKhachHang.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTableKhachHang.columnModel.title6")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jBtnThemKhach.setText(resourceMap.getString("jBtnThemKhach.text")); // NOI18N
        jBtnThemKhach.setName("jBtnThemKhach"); // NOI18N
        jBtnThemKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnThemKhachMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        jPanel2.add(jBtnThemKhach, gridBagConstraints);

        jBtnXoaKhach.setText(resourceMap.getString("jBtnXoaKhach.text")); // NOI18N
        jBtnXoaKhach.setEnabled(false);
        jBtnXoaKhach.setName("jBtnXoaKhach"); // NOI18N
        jBtnXoaKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnXoaKhachMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        jPanel2.add(jBtnXoaKhach, gridBagConstraints);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jlabelTienDatCoc.setText(resourceMap.getString("jlabelTienDatCoc.text")); // NOI18N
        jlabelTienDatCoc.setName("jlabelTienDatCoc"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jlabelTienDatCoc, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jPanel2, gridBagConstraints);

        bgLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgLabel3.setIcon(resourceMap.getIcon("bgLabel3.icon")); // NOI18N
        bgLabel3.setName("bgLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(bgLabel3, gridBagConstraints);

        add(jPanel7, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void initData()
    {
        //lay danh sach phong chua thue va add vao combobox
        WorkerGetListPhong workerPhong = new WorkerGetListPhong();
        workerPhong.execute();

        ThamSo thamSo = thamSoController.layThamSo("SoKhachHangToiDa");
        if(thamSo!=null && thamSo.isUse())
            this.SoKhachHangToiDa = thamSo.getValue();
        else
            this.SoKhachHangToiDa = -1;
        
        thamSo = thamSoController.layThamSo("TienDatCocKhiThue");
        if(thamSo!=null && thamSo.isUse())
            this.TienDatCocKhiThue = thamSo.getValue();
        else
            this.TienDatCocKhiThue = -1;

        //remove old data on table
        clearTableData();

        try {
            lstPhong = workerPhong.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelThuePhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JPanelThuePhong.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lstPhong = phongController.getDSPhongChuaThue();
        if(lstPhong!=null && lstPhong.size()>0)
        {
            initComboBoxMaPhong();
            this.jBtnThuePhong.setEnabled(true);
            this.jBtnThemKhach.setEnabled(true);
        }
        else
        {
            this.jBtnThuePhong.setEnabled(false);
            this.jBtnThemKhach.setEnabled(false);
        }

        //lay loai thue va add vao combobox
        //lstLoaiThue = thuePhongController.layDSLoaiThue();
        WorkerGetListLoaiThue workerLoaiThue = new WorkerGetListLoaiThue();
        workerLoaiThue.execute();
        try {
            lstLoaiThue = workerLoaiThue.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelThuePhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JPanelThuePhong.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(lstLoaiThue!=null && lstLoaiThue.size()>0)
        {
            initComboBoxLoaiThue();
        }

        //khoi tao gia tri cho ngay thue bang voi ngay hien tai
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jTxtNgayThue.setText(sdf.format(cal.getTime()));

        if(TienDatCocKhiThue!=-1)
            this.jlabelTienDatCoc.setText("" + this.lstPhong.get(0).tinhTienDatCoc(TienDatCocKhiThue));
        else
            this.jlabelTienDatCoc.setText("0");

        this.thuePhong = null;
        thuePhong = new ThuePhong();
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        initData();
        
    }//GEN-LAST:event_formComponentShown

    private void initComboBoxLoaiThue()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        int i;
        //add item to combobox
        for(i=0;i<lstLoaiThue.size();i++)
        {
            model.addElement(lstLoaiThue.get(i).getLoai());
        }

        jCbLoaiThue.setModel(model);

        if(MyCompare.compareString(lstLoaiThue.get(0).getLoai(), "Đặt Phòng") == 0)
        //if(lstLoaiThue.get(0).getLoai().toLowerCase().equals("dat phong"))
        {
            this.jTxtNgayThue.setEditable(true);
        }
        else
            this.jTxtNgayThue.setEditable(false);
    }
    
    private void initComboBoxMaPhong()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        int i;
        for(i=0;i<lstPhong.size();i++)
        {
            model.addElement(lstPhong.get(i).getId());
        }

        jCbMaPhong.setModel(model);

        jCbMaPhong.setSelectedIndex(0);
        hienThiThongTinPhong(lstPhong.get(0));
    }

    private void hienThiThongTinPhong(Phong phong)
    {
        this.jLabelLoaiPhong.setText(phong.getTenLoaiPhong());//.getIdLoaiPhong().getTen());
        int giaTien = phong.getGia() + phong.getDonGiaPhong();//.getIdLoaiPhong().getGia();
        this.jLabelGiaTien.setText("" + giaTien);
        this.lLabelLau.setText("" + phong.getLau());
        if(TienDatCocKhiThue!=-1)
            this.jlabelTienDatCoc.setText("" + phong.tinhTienDatCoc(TienDatCocKhiThue));
        else
            this.jlabelTienDatCoc.setText("0");
    }

    private void jBtnThuePhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThuePhongMousePressed
        // TODO add your handling code here:
        try
        {
            if(!this.jBtnThuePhong.isEnabled())
                return;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");            

            thuePhong.setIdLoaiThue(layLoaiThueTheoTen(jCbLoaiThue.getSelectedItem().toString()));
            
            Date ngayThue = sdf.parse(jTxtNgayThue.getText());
            Date now = MyDateTime.getNow();

            Calendar cNgayThue = Calendar.getInstance();
            cNgayThue.setTime(ngayThue);

            Calendar cNow = Calendar.getInstance();
            cNow.setTime(now);

            cNgayThue.set(cNgayThue.get(Calendar.YEAR), cNgayThue.get(Calendar.MONTH), cNgayThue.get(Calendar.DAY_OF_MONTH), cNow.get(Calendar.HOUR_OF_DAY), cNow.get(Calendar.MINUTE), cNow.get(Calendar.SECOND));

            thuePhong.setNgayThue(cNgayThue.getTime());

            Phong phong = layPhongTheoId(Integer.parseInt(jCbMaPhong.getSelectedItem().toString()));
            thuePhong.setPhong(phong);

            if(this.TienDatCocKhiThue == -1)
                thuePhong.setTongGia(0);
            else
                thuePhong.setTongGia(phong.tinhTienDatCoc(this.TienDatCocKhiThue));

            String error = thuePhongController.kiemTraNghiepVuThuePhong(thuePhong);
            if(error.equals(""))
            {
                String secutiryCode = thuePhongController.tiepNhanViecThuePhong(thuePhong);
                if(secutiryCode.equals(""))
                {
                    JOptionPane.showMessageDialog(this.getComponent(0),"Thuê phòng thất bại" , "Thông Báo", JOptionPane.ERROR_MESSAGE);
                    initData();                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this.getComponent(0),"Thuê phòng thành công!" , "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    initData();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this.getComponent(0),error , "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this.getComponent(0),"Thuê phòng thất bại" , "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnThuePhongMousePressed

    private void jCbMaPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbMaPhongItemStateChanged
        // TODO add your handling code here:
        if(jCbMaPhong.getItemCount()>0)
        {
            Phong phong = layPhongTheoId(Integer.parseInt(jCbMaPhong.getSelectedItem().toString()));
            hienThiThongTinPhong(phong);
        }
    }//GEN-LAST:event_jCbMaPhongItemStateChanged

    private void jBtnThemKhachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemKhachMousePressed
        // TODO add your handling code here:
        if(this.SoKhachHangToiDa == -1 || thuePhong.getLstKhachHang().size()<this.SoKhachHangToiDa)
        {
            JDialogThemKhachHang themKhachDlg = new JDialogThemKhachHang(thuePhong.getLstKhachHang(), mainFrame, true);
            themKhachDlg.setVisible(true);

            if(themKhachDlg.IsValid())
            {
                thuePhong.addKhachHang(themKhachDlg.getKhachHang());
                updateTableKhachHang();
                this.jBtnXoaKhach.setEnabled(true);
                this.jBtnXoaKhach.setEnabled(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this.getComponent(0),"Chú  ý: Số người thuê tối đa là " + this.SoKhachHangToiDa + " người!" , "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnThemKhachMousePressed

    private void jTableKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKhachHangKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableKhachHangKeyReleased

    private void jBtnXoaKhachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXoaKhachMousePressed
        // TODO add your handling code here:
        if(!this.jBtnXoaKhach.isEnabled())
            return;

        int index = jTableKhachHang.getSelectedRow();
        if(index!=-1)
        {
            ArrayList<KhachHang> arr = thuePhong.getLstKhachHang();
            arr.remove(index);
            updateTableKhachHang();
            if(arr.size()==0)
                jBtnXoaKhach.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnXoaKhachMousePressed

    private void jCbLoaiThueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbLoaiThueItemStateChanged
        // TODO add your handling code here:
        LoaiThue loaiThue = layLoaiThueTheoTen(jCbLoaiThue.getSelectedItem().toString());
        
        if(MyCompare.compareString(loaiThue.getLoai(), "Đặt Phòng") == 0)
        //if(loaiThue.getLoai().toLowerCase().equals("dat phong"))
        {
            this.jTxtNgayThue.setEditable(true);
        }
        else
        {
            this.jTxtNgayThue.setEditable(false);
        }
    }//GEN-LAST:event_jCbLoaiThueItemStateChanged

    private void clearTableData()
    {       
        DefaultTableModel model = new DefaultTableModel(header, 4);

        jTableKhachHang.setModel(model);

        jTableKhachHang.getSelectedRow();
    }

    private void updateTableKhachHang()
    {
        //update table khach hang
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<KhachHang> arr = thuePhong.getLstKhachHang();

        jTableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            header,0
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        DefaultTableModel model = (DefaultTableModel) jTableKhachHang.getModel();

        int i;
        for(i=0;i<arr.size();i++)
        {
            Object[] arrObj = new Object[7];

            arrObj[0] = arr.get(i).getTen();
            arrObj[1] = sdf.format(arr.get(i).getNgaySinh());
            arrObj[2] = arr.get(i).getId();
            arrObj[3] = arr.get(i).getGioiTinh();
            arrObj[4] = arr.get(i).getDiaChi();
            arrObj[5] = arr.get(i).getDienThoai();
            arrObj[6] = arr.get(i).getTenLoaiKhachHang();//.getIdLoaiKhachHang().getTen();

            model.addRow(arrObj);
        }
    }

    private LoaiThue layLoaiThueTheoTen(String ten)
    {
        int i;
        for(i=0;i<lstLoaiThue.size();i++)
        {
            if(lstLoaiThue.get(i).getLoai().equals(ten))
            {
                return lstLoaiThue.get(i);
            }
        }
        return null;
    }
    
    private Phong layPhongTheoId(int id)
    {
        int i;
        for(i=0;i<lstPhong.size();i++)
        {
            if(lstPhong.get(i).getId() == id)
            {
                return lstPhong.get(i);
            }
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel3;
    private javax.swing.JLabel imgRoom;
    private javax.swing.JButton jBtnThemKhach;
    private javax.swing.JButton jBtnThuePhong;
    private javax.swing.JButton jBtnXoaKhach;
    private javax.swing.JComboBox jCbLoaiThue;
    private javax.swing.JComboBox jCbMaPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabelGiaTien;
    private javax.swing.JLabel jLabelLoaiPhong;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKhachHang;
    private javax.swing.JFormattedTextField jTxtNgayThue;
    private javax.swing.JLabel jlabelTienDatCoc;
    private javax.swing.JLabel lLabelLau;
    // End of variables declaration//GEN-END:variables
    
    private ThuePhongController thuePhongController;
        
    private ArrayList<Phong> lstPhong;
    private ArrayList<LoaiThue> lstLoaiThue;
    private ThuePhong thuePhong;

    String[] header = new String[] {"Tên Khách Hàng","Ngày Sinh", "CMND", "Giới Tính", "Địa Chỉ", "Điện Thoại", "Loại Khách Hàng"};
}

class WorkerGetListPhong extends SwingWorker<ArrayList<Phong>, Void>
{
    private PhongController phongController;

    @Override
    protected ArrayList<Phong> doInBackground() throws Exception {

        phongController = new PhongController();
        return phongController.getDSPhongChuaThue();

    }

}
class WorkerGetListLoaiThue extends SwingWorker<ArrayList<LoaiThue>, Void>
{
    private ThuePhongController thuePhongController;

    @Override
    protected ArrayList<LoaiThue> doInBackground() throws Exception {
         thuePhongController = new ThuePhongController();
         return thuePhongController.layDSLoaiThue();
    }

}

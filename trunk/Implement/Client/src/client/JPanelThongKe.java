/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelThongKe.java
 *
 * Created on Dec 18, 2009, 12:39:51 PM
 */

package client;

import BUS.ThuePhongController;
import Utils.MyDateTime;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huy
 */
public class JPanelThongKe extends javax.swing.JPanel {

    /** Creates new form JPanelThongKe */
    public JPanelThongKe() {
        initComponents();
        
        thuePhongController = new ThuePhongController();
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

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabelThang2 = new javax.swing.JLabel();
        jLabelNam1 = new javax.swing.JLabel();
        jFTxtNam = new javax.swing.JFormattedTextField();
        jBtnThongKe = new javax.swing.JButton();
        imgThongKe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePhong = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCbDenThang = new javax.swing.JComboBox();
        jCbTuThang = new javax.swing.JComboBox();
        bgLabel2 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.CardLayout());

        jPanel9.setName("jPanel9"); // NOI18N
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jPanel10.setName("jPanel10"); // NOI18N
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JPanelThongKe.class);
        jLabelThang2.setText(resourceMap.getString("jLabelThang2.text")); // NOI18N
        jLabelThang2.setName("jLabelThang2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 8, 9, 10);
        jPanel10.add(jLabelThang2, gridBagConstraints);

        jLabelNam1.setText(resourceMap.getString("jLabelNam1.text")); // NOI18N
        jLabelNam1.setName("jLabelNam1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel10.add(jLabelNam1, gridBagConstraints);

        jFTxtNam.setBackground(resourceMap.getColor("jFTxtNam.background")); // NOI18N
        jFTxtNam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFTxtNam.setName("jFTxtNam"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel10.add(jFTxtNam, gridBagConstraints);

        jBtnThongKe.setBackground(resourceMap.getColor("jBtnThongKe.background")); // NOI18N
        jBtnThongKe.setText(resourceMap.getString("jBtnThongKe.text")); // NOI18N
        jBtnThongKe.setName("jBtnThongKe"); // NOI18N
        jBtnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnThongKeMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel10.add(jBtnThongKe, gridBagConstraints);

        imgThongKe.setIcon(resourceMap.getIcon("imgThongKe.icon")); // NOI18N
        imgThongKe.setName("imgThongKe"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 19, 41, 19);
        jPanel10.add(imgThongKe, gridBagConstraints);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 28, 0);
        jPanel10.add(jLabel2, gridBagConstraints);

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setForeground(resourceMap.getColor("jLabel4.foreground")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 18, 20, 22);
        jPanel10.add(jLabel4, gridBagConstraints);

        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(23, 50));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 50));
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 150));

        jTablePhong.setBackground(resourceMap.getColor("jTablePhong.background")); // NOI18N
        jTablePhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Loại Phòng", "Đơn Giá", "Tổng Số Ngày Mượn", "Tổng Số Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePhong.setToolTipText(resourceMap.getString("jTablePhong.toolTipText")); // NOI18N
        jTablePhong.setDoubleBuffered(true);
        jTablePhong.setFocusable(false);
        jTablePhong.setGridColor(resourceMap.getColor("jTablePhong.gridColor")); // NOI18N
        jTablePhong.setName("jTablePhong"); // NOI18N
        jTablePhong.setOpaque(false);
        jTablePhong.setSelectionBackground(resourceMap.getColor("jTablePhong.selectionBackground")); // NOI18N
        jScrollPane1.setViewportView(jTablePhong);
        jTablePhong.getColumnModel().getColumn(0).setResizable(false);
        jTablePhong.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTablePhong.columnModel.title0")); // NOI18N
        jTablePhong.getColumnModel().getColumn(1).setResizable(false);
        jTablePhong.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTablePhong.columnModel.title1")); // NOI18N
        jTablePhong.getColumnModel().getColumn(2).setResizable(false);
        jTablePhong.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTablePhong.columnModel.title2")); // NOI18N
        jTablePhong.getColumnModel().getColumn(3).setResizable(false);
        jTablePhong.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTablePhong.columnModel.title3")); // NOI18N
        jTablePhong.getColumnModel().getColumn(4).setResizable(false);
        jTablePhong.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTablePhong.columnModel.title4")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel10.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel10.add(jLabel1, gridBagConstraints);

        jCbDenThang.setBackground(resourceMap.getColor("jCbDenThang.background")); // NOI18N
        jCbDenThang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jCbDenThang.setName("jCbDenThang"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel10.add(jCbDenThang, gridBagConstraints);

        jCbTuThang.setBackground(resourceMap.getColor("jCbDenThang.background")); // NOI18N
        jCbTuThang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jCbTuThang.setName("jCbTuThang"); // NOI18N
        jCbTuThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbTuThangItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        jPanel10.add(jCbTuThang, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel9.add(jPanel10, gridBagConstraints);

        bgLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgLabel2.setIcon(resourceMap.getIcon("bgLabel2.icon")); // NOI18N
        bgLabel2.setName("bgLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel9.add(bgLabel2, gridBagConstraints);

        add(jPanel9, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        Date now = MyDateTime.getNow();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        jFTxtNam.setText("" + calendar.get(Calendar.YEAR));
        //jFTxtThang.setText("" + calendar.get(Calendar.MONTH));

    }//GEN-LAST:event_formComponentShown

    private void jBtnThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThongKeMousePressed
        // TODO add your handling code here:
        String sNam = jFTxtNam.getText();
        if(sNam.equals(""))
        {
            JOptionPane.showMessageDialog(this.getComponent(0), "Hãy nhập vào năm!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int nam = Integer.parseInt(sNam);
        if(nam<0)
        {
            JOptionPane.showMessageDialog(this.getComponent(0), "Dữ liệu nhập không hợp lệ!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int tuThang = Integer.parseInt(jCbTuThang.getSelectedItem().toString());
        int denThang = Integer.parseInt(jCbDenThang.getSelectedItem().toString());

        thongKe = thuePhongController.thongKeThuePhong(tuThang, denThang, nam);
        if(thongKe!=null)
            hienThiKetQua();
        else
        {
            JOptionPane.showMessageDialog(this.getComponent(0), "Không tìm thấy kết quả!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    }//GEN-LAST:event_jBtnThongKeMousePressed

    private void jCbTuThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbTuThangItemStateChanged
        // TODO add your handling code here:
        int tuThang = Integer.parseInt(jCbTuThang.getSelectedItem().toString());
        initComboBoxDenThang(tuThang);
    }//GEN-LAST:event_jCbTuThangItemStateChanged

    private void hienThiKetQua()
    {
        //  "Ma phong", "Loai phong", "Don gia", "Tong so ngay muon", "Tong so tien"
        jTablePhong.setModel(new javax.swing.table.DefaultTableModel(
            headerTable,0
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        DefaultTableModel model = (DefaultTableModel) jTablePhong.getModel();

        try {
            if(thongKe.next())
            {
                do {
                    Object[] arr = new Object[5];

                    arr[0] = thongKe.getInt("id");
                    arr[1] = thongKe.getString("ten");
                    arr[2] = thongKe.getInt("gia");
                    arr[3] = thongKe.getInt("SoNgayThue");
                    arr[4] = thongKe.getInt("TongGiaTien");

                    model.addRow(arr);
                }
                while (thongKe.next());
            }
            else
            {
                JOptionPane.showMessageDialog(this.getComponent(0), "Không tìm thấy kết quả!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
            thongKe.close();

        } catch (SQLException ex) {
            Logger.getLogger(JPanelThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    private void initComboBoxDenThang(int tuThang)
    {
        jCbDenThang.removeAllItems();
        int i;
        for(i=tuThang;i<=12;i++)
        {
            jCbDenThang.addItem(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel2;
    private javax.swing.JLabel imgThongKe;
    private javax.swing.JButton jBtnThongKe;
    private javax.swing.JComboBox jCbDenThang;
    private javax.swing.JComboBox jCbTuThang;
    private javax.swing.JFormattedTextField jFTxtNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNam1;
    private javax.swing.JLabel jLabelThang2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePhong;
    // End of variables declaration//GEN-END:variables

    private ThuePhongController thuePhongController;    
    private ResultSet thongKe;
    private String[] headerTable = new String [] {
                "Mã Phòng", "Loại Phòng", "Đơn Giá", "Tổng Số Ngày Mượn", "Tổng Số Tiền"
            };
}

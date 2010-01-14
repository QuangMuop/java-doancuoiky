/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogXemChiTiet.java
 *
 * Created on Dec 24, 2009, 12:32:35 AM
 */

package client;

import BUS.PhongController;
import DTO.LoaiPhong;
import DTO.Phong;
import DTO.TinhTrangPhong;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author bin
 */
public class JDialogXemChiTiet extends javax.swing.JDialog {
    private ArrayList<LoaiPhong> lstLoaiPhong;
    private ArrayList<TinhTrangPhong> lstTinhTrangPhong;
    private PhongController phongController;
    private Phong phong;
    private Phong phongTmp;

    private ImageIcon iconPhongVip;
    private ImageIcon iconPhongTrung;
    private ImageIcon iconPhongThuong;

    public Phong getPhong()
    {
        return this.phong;
    }

    /** Creates new form JDialogXemChiTiet */
    public JDialogXemChiTiet(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDialogXemChiTiet(java.awt.Frame parent, boolean modal, Phong phong) {
        super(parent, modal);
        initComponents();

        this.setTitle("Xem chi tiết phòng");
        this.setDefaultCloseOperation(JDialogXemChiTiet.DISPOSE_ON_CLOSE);
        this.setSize(500, 600);
        this.setLocationRelativeTo(parent);

        this.phong = phong;
        phongTmp = new Phong();
        phongController = new PhongController();

        WorkerGetListLoaiPhong workerLoaiPhong = new WorkerGetListLoaiPhong();
        workerLoaiPhong.run();
        
        WorkerGetListTinhTrangPhong workerTinhTrangPhong = new WorkerGetListTinhTrangPhong();
        workerTinhTrangPhong.run();

        //wait for worker and load icons
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL;
        imageURL = cldr.getResource("client/resources/PhongVIP.png");
        this.iconPhongVip = new ImageIcon(imageURL);

        imageURL = cldr.getResource("client/resources/PhongHangTrung.png");
        this.iconPhongTrung = new ImageIcon(imageURL);

        imageURL = cldr.getResource("client/resources/PhongHangThuong.png");
        this.iconPhongThuong = new ImageIcon(imageURL);


        try {
            this.lstLoaiPhong = workerLoaiPhong.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDialogXemChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JDialogXemChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lstLoaiPhong!=null)
        {
            initComboLoaiPhong();
        }

        try {
            this.lstTinhTrangPhong = workerTinhTrangPhong.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDialogXemChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JDialogXemChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lstTinhTrangPhong!=null)
        {
            initComboTinhTrangPhong();
        }

        hienThiThongTinPhong(phong);
    }

    private void initComboTinhTrangPhong()
    {
        int i;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(i=0;i<this.lstTinhTrangPhong.size();i++)
        {
            model.addElement(this.lstTinhTrangPhong.get(i).getTen());
        }
        this.jCbTinhTrang.setModel(model);
        
        this.jCbTinhTrang.setEnabled(false);
    }

    private void initComboLoaiPhong()
    {
        int i;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(i=0;i<this.lstLoaiPhong.size();i++)
        {
            model.addElement(this.lstLoaiPhong.get(i).getTen());
        }
        this.jCbLoaiPhong.setModel(model);

        this.jCbLoaiPhong.setEnabled(false);
    }

    private void hienThiThongTinPhong(Phong phong)
    {
        int cost = phong.getGia() + phong.getIdLoaiPhong().getGia();
        String strLoaiPhong = phong.getIdLoaiPhong().getTen();

        this.jTxtGiaTien.setText("" + cost);
        this.jTxtLau.setText("" + phong.getLau());
        this.jCbLoaiPhong.setSelectedItem(strLoaiPhong);
        this.jTxtMoTa.setText(phong.getMoTa());
        this.jTxtSoPhong.setText("" + phong.getId());
        this.jCbTinhTrang.setSelectedItem(phong.getIdTinhTrang().getTen());

        //set icon to display
        strLoaiPhong = strLoaiPhong.toLowerCase();

        if(strLoaiPhong.contains("vip"))
            this.jLabelHinhPhong.setIcon(this.iconPhongVip);
        else if(strLoaiPhong.contains("hang trung"))
            this.jLabelHinhPhong.setIcon(this.iconPhongTrung);
        else if(strLoaiPhong.contains("hang thuong"))
            this.jLabelHinhPhong.setIcon(this.iconPhongThuong);
        else//truong hop khong khop thi gan dai luon :D
            this.jLabelHinhPhong.setIcon(this.iconPhongThuong);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabelHinhPhong = new javax.swing.JLabel();
        jLabelGiaTien1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtMoTa = new javax.swing.JTextArea();
        jBtnChinhSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCbLoaiPhong = new javax.swing.JComboBox();
        jCbTinhTrang = new javax.swing.JComboBox();
        jBtnCapNhat = new javax.swing.JButton();
        jTxtSoPhong = new javax.swing.JFormattedTextField();
        jTxtLau = new javax.swing.JFormattedTextField();
        jTxtGiaTien = new javax.swing.JFormattedTextField();
        jBtnThoat = new javax.swing.JButton();
        bgLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JDialogXemChiTiet.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setIconImage(null);
        setMinimumSize(new java.awt.Dimension(179, 80));
        setModal(true);
        setName("Form"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel8.setName("jPanel8"); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabelHinhPhong.setIcon(resourceMap.getIcon("jLabelHinhPhong.icon")); // NOI18N
        jLabelHinhPhong.setName("jLabelHinhPhong"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 18);
        jPanel8.add(jLabelHinhPhong, gridBagConstraints);

        jLabelGiaTien1.setText(resourceMap.getString("jLabelGiaTien1.text")); // NOI18N
        jLabelGiaTien1.setName("jLabelGiaTien1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabelGiaTien1, gridBagConstraints);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel4, gridBagConstraints);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel2, gridBagConstraints);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel6, gridBagConstraints);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel8, gridBagConstraints);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTxtMoTa.setBackground(resourceMap.getColor("jTxtMoTa.background")); // NOI18N
        jTxtMoTa.setColumns(20);
        jTxtMoTa.setEditable(false);
        jTxtMoTa.setRows(3);
        jTxtMoTa.setName("jTxtMoTa"); // NOI18N
        jScrollPane2.setViewportView(jTxtMoTa);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jScrollPane2, gridBagConstraints);

        jBtnChinhSua.setBackground(resourceMap.getColor("jBtnChinhSua.background")); // NOI18N
        jBtnChinhSua.setText(resourceMap.getString("jBtnChinhSua.text")); // NOI18N
        jBtnChinhSua.setName("jBtnChinhSua"); // NOI18N
        jBtnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnChinhSuaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnChinhSuaMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        jPanel8.add(jBtnChinhSua, gridBagConstraints);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        jPanel8.add(jLabel1, gridBagConstraints);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel3, gridBagConstraints);

        jCbLoaiPhong.setBackground(resourceMap.getColor("jCbLoaiPhong.background")); // NOI18N
        jCbLoaiPhong.setEnabled(false);
        jCbLoaiPhong.setName("jCbLoaiPhong"); // NOI18N
        jCbLoaiPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbLoaiPhongItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jCbLoaiPhong, gridBagConstraints);

        jCbTinhTrang.setBackground(resourceMap.getColor("jCbLoaiPhong.background")); // NOI18N
        jCbTinhTrang.setEnabled(false);
        jCbTinhTrang.setName("jCbTinhTrang"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jCbTinhTrang, gridBagConstraints);

        jBtnCapNhat.setBackground(resourceMap.getColor("jBtnCapNhat.background")); // NOI18N
        jBtnCapNhat.setText(resourceMap.getString("jBtnCapNhat.text")); // NOI18N
        jBtnCapNhat.setEnabled(false);
        jBtnCapNhat.setName("jBtnCapNhat"); // NOI18N
        jBtnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnCapNhatMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 34, 0, 34);
        jPanel8.add(jBtnCapNhat, gridBagConstraints);

        jTxtSoPhong.setBackground(resourceMap.getColor("jTxtLau.background")); // NOI18N
        jTxtSoPhong.setEditable(false);
        jTxtSoPhong.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTxtSoPhong.setName("jTxtSoPhong"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jTxtSoPhong, gridBagConstraints);

        jTxtLau.setBackground(resourceMap.getColor("jTxtLau.background")); // NOI18N
        jTxtLau.setEditable(false);
        jTxtLau.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTxtLau.setName("jTxtLau"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jTxtLau, gridBagConstraints);

        jTxtGiaTien.setBackground(resourceMap.getColor("jTxtGiaTien.background")); // NOI18N
        jTxtGiaTien.setEditable(false);
        jTxtGiaTien.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTxtGiaTien.setName("jTxtGiaTien"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jTxtGiaTien, gridBagConstraints);

        jBtnThoat.setBackground(resourceMap.getColor("jBtnThoat.background")); // NOI18N
        jBtnThoat.setText(resourceMap.getString("jBtnThoat.text")); // NOI18N
        jBtnThoat.setName("jBtnThoat"); // NOI18N
        jBtnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnThoatMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 50, 0, 50);
        jPanel8.add(jBtnThoat, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jPanel8, gridBagConstraints);

        bgLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgLabel4.setIcon(resourceMap.getIcon("bgLabel4.icon")); // NOI18N
        bgLabel4.setName("bgLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(bgLabel4, gridBagConstraints);

        getContentPane().add(jPanel7, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnChinhSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnChinhSuaMousePressed
        // TODO add your handling code here:
        if(!jBtnChinhSua.isEnabled())
            return;

        int result = JOptionPane.showConfirmDialog(this.getComponent(0),"Bạn có muốn sửa hay không?" , "Thông Báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.OK_OPTION) {
            //enable fields
            this.jBtnCapNhat.setEnabled(true);

            this.jTxtGiaTien.setEditable(true);
            this.jTxtLau.setEditable(true);
            this.jCbLoaiPhong.setEnabled(true);
            this.jTxtMoTa.setEditable(true);
            this.jTxtSoPhong.setEditable(true);
            this.jCbTinhTrang.setEnabled(true);

            //disable button chinh sua
            this.jBtnChinhSua.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnChinhSuaMousePressed

    private LoaiPhong layLoaiPhongTheoTen(String ten)
    {
        int i;
        for(i=0;i<this.lstLoaiPhong.size();i++)
        {
            if(this.lstLoaiPhong.get(i).getTen().equals(ten))
                return this.lstLoaiPhong.get(i);
        }
        return null;
    }
    
    private TinhTrangPhong layTinhTrangPhongTheoTen(String ten)
    {
        int i;
        for(i=0;i<this.lstTinhTrangPhong.size();i++)
        {
            if(this.lstTinhTrangPhong.get(i).getTen().equals(ten))
                return this.lstTinhTrangPhong.get(i);
        }
        return null;
    }

    private String CapNhatPhong()
    {        
        phongTmp.setId(this.phong.getId());
        String tmp = this.jTxtSoPhong.getText();
        if(tmp.equals(""))
        {
            return "Hay nhap vao so phong";
        }
        //cap nhat lai ma phong moi
        int soPhong = Integer.parseInt(tmp);
        phongTmp.setId(soPhong);

        //cap nhat lai gia tien
        tmp = this.jTxtGiaTien.getText();
        if(tmp.equals(""))
        {
            return "Hay nhap vao gia tien";
        }

        int gia = Integer.parseInt(tmp);
        phongTmp.setGia(gia);

        //cap nhat lai lau
        tmp = this.jTxtLau.getText();
        if(tmp.equals(""))
        {
            return "Hay nhap vao so lau";
        }

        int lau = Integer.parseInt(tmp);
        phongTmp.setLau(lau);

        phongTmp.setMoTa(this.jTxtMoTa.getText());
        phongTmp.setIdLoaiPhong(layLoaiPhongTheoTen(this.jCbLoaiPhong.getSelectedItem().toString()));
        phongTmp.setIdTinhTrang(layTinhTrangPhongTheoTen(this.jCbTinhTrang.getSelectedItem().toString()));

        String err = phongController.kiemTraNghiepVuPhong(phongTmp);
        if(err.equals(""))
        {
            if(phongController.updatePhong(phongTmp))
            {
                return "";
            }
            else
            {
                return "Cap nhat that bai";
            }
        }
        else
        {            
            return err;
        }
    }


    private void jBtnCapNhatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnCapNhatMousePressed
        // TODO add your handling code here:
        if(!jBtnCapNhat.isEnabled())
            return;

        int result = JOptionPane.showConfirmDialog(this.getComponent(0),"Bạn có muốn lưu những thay đổi không?" , "Thông Báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.OK_OPTION) {
            String err = CapNhatPhong();
            if(err.equals(""))
            {
                phong = phongTmp;
                JOptionPane.showMessageDialog(this.getComponent(0),"Cập nhật phòng thành công!" , "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiThongTinPhong(phong);
            }
            else
            {
                JOptionPane.showMessageDialog(this.getComponent(0),err , "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //restore old value
            hienThiThongTinPhong(this.phong);
        }

        //disable fields
        this.jBtnCapNhat.setEnabled(false);

        this.jTxtGiaTien.setEditable(false);
        this.jTxtLau.setEditable(false);
        this.jCbLoaiPhong.setEnabled(false);
        this.jTxtMoTa.setEditable(false);
        this.jTxtSoPhong.setEditable(false);
        this.jCbTinhTrang.setEnabled(false);

        //enable button chinh sua
        this.jBtnChinhSua.setEnabled(true);
}//GEN-LAST:event_jBtnCapNhatMousePressed

    private void jBtnThoatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThoatMousePressed
        // TODO add your handling code here:
        if(this.jBtnCapNhat.isEnabled())
        {
            int result = JOptionPane.showConfirmDialog(this.getComponent(0),"Bạn có muốn lưu những thay đổi không?" , "Thông Báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.OK_OPTION) {
                String err = CapNhatPhong();
                if(err.equals(""))
                {
                    phong = phongTmp;
                    JOptionPane.showMessageDialog(this.getComponent(0),"Cập nhật phòng thành công!" , "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    hienThiThongTinPhong(phong);
                }
                else
                {
                    JOptionPane.showMessageDialog(this.getComponent(0),err , "Thông Báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_jBtnThoatMousePressed

    private void capNhatHinhPhong(String strLoaiPhong)
    {
        strLoaiPhong = strLoaiPhong.toLowerCase();
        
        if(strLoaiPhong.contains("vip"))
            this.jLabelHinhPhong.setIcon(this.iconPhongVip);
        else if(strLoaiPhong.contains("hang trung"))
            this.jLabelHinhPhong.setIcon(this.iconPhongTrung);
        else if(strLoaiPhong.contains("hang thuong"))
            this.jLabelHinhPhong.setIcon(this.iconPhongThuong);
        else//truong hop khong khop thi gan dai luon :D
            this.jLabelHinhPhong.setIcon(this.iconPhongThuong);
    }

    private void jCbLoaiPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbLoaiPhongItemStateChanged
        // TODO add your handling code here:
        capNhatHinhPhong(this.jCbLoaiPhong.getSelectedItem().toString());
    }//GEN-LAST:event_jCbLoaiPhongItemStateChanged

    private void jBtnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnChinhSuaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jBtnChinhSuaMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel4;
    private javax.swing.JButton jBtnCapNhat;
    private javax.swing.JButton jBtnChinhSua;
    private javax.swing.JButton jBtnThoat;
    private javax.swing.JComboBox jCbLoaiPhong;
    private javax.swing.JComboBox jCbTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelGiaTien1;
    private javax.swing.JLabel jLabelHinhPhong;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jTxtGiaTien;
    private javax.swing.JFormattedTextField jTxtLau;
    private javax.swing.JTextArea jTxtMoTa;
    private javax.swing.JFormattedTextField jTxtSoPhong;
    // End of variables declaration//GEN-END:variables

}
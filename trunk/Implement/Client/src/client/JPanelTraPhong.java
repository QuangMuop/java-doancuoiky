/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelTraPhong.java
 *
 * Created on Dec 18, 2009, 11:49:39 AM
 */

package client;

import BUS.PhongController;
import BUS.ThuePhongController;
import DTO.KhachHang;
import DTO.Phong;
import DTO.ThuePhong;
import Utils.MyDateTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author huy
 */
public class JPanelTraPhong extends javax.swing.JPanel {

    /** Creates new form JPanelTraPhong */
    public JPanelTraPhong() {
        initComponents();

        thuePhongController = new ThuePhongController();
        phongController = new PhongController();
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

        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jCbMaPhong = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jLabelLoaiPhong = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabelDonGia = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabelNgayThue = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabelNgayTra = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabelSoNgayThue = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabelSoNguoiCuTru = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabelTenKhach = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabelNgaySinh = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabelGioiTinh = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabelDiaChi = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabelDienThoai = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabelLoaiKhach = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabelDonGiaKhachHang = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabelTongTien = new javax.swing.JLabel();
        jBtnTraPhong = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        imgPhong = new javax.swing.JLabel();
        imgNguoiThue = new javax.swing.JLabel();
        imgThanhToan = new javax.swing.JLabel();
        bgLabel1 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridLayout(1, 1));

        jPanel8.setName("jPanel8"); // NOI18N
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JPanelTraPhong.class);
        jLabel39.setFont(resourceMap.getFont("jLabel39.font")); // NOI18N
        jLabel39.setForeground(resourceMap.getColor("jLabel39.foreground")); // NOI18N
        jLabel39.setText(resourceMap.getString("jLabel39.text")); // NOI18N
        jLabel39.setName("jLabel39"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jLabel39, gridBagConstraints);

        jLabel41.setText(resourceMap.getString("jLabel41.text")); // NOI18N
        jLabel41.setName("jLabel41"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 45);
        jPanel2.add(jLabel41, gridBagConstraints);

        jCbMaPhong.setBackground(resourceMap.getColor("jCbMaPhong.background")); // NOI18N
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
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jCbMaPhong, gridBagConstraints);

        jLabel42.setText(resourceMap.getString("jLabel42.text")); // NOI18N
        jLabel42.setName("jLabel42"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 40);
        jPanel2.add(jLabel42, gridBagConstraints);

        jLabelLoaiPhong.setText(resourceMap.getString("jLabelLoaiPhong.text")); // NOI18N
        jLabelLoaiPhong.setName("jLabelLoaiPhong"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelLoaiPhong, gridBagConstraints);

        jLabel44.setText(resourceMap.getString("jLabel44.text")); // NOI18N
        jLabel44.setName("jLabel44"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 56);
        jPanel2.add(jLabel44, gridBagConstraints);

        jLabelDonGia.setText(resourceMap.getString("jLabelDonGia.text")); // NOI18N
        jLabelDonGia.setName("jLabelDonGia"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelDonGia, gridBagConstraints);

        jLabel46.setText(resourceMap.getString("jLabel46.text")); // NOI18N
        jLabel46.setName("jLabel46"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 42);
        jPanel2.add(jLabel46, gridBagConstraints);

        jLabelNgayThue.setText(resourceMap.getString("jLabelNgayThue.text")); // NOI18N
        jLabelNgayThue.setName("jLabelNgayThue"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelNgayThue, gridBagConstraints);

        jLabel48.setText(resourceMap.getString("jLabel48.text")); // NOI18N
        jLabel48.setName("jLabel48"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 50);
        jPanel2.add(jLabel48, gridBagConstraints);

        jLabelNgayTra.setText(resourceMap.getString("jLabelNgayTra.text")); // NOI18N
        jLabelNgayTra.setName("jLabelNgayTra"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelNgayTra, gridBagConstraints);

        jLabel50.setText(resourceMap.getString("jLabel50.text")); // NOI18N
        jLabel50.setName("jLabel50"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 28);
        jPanel2.add(jLabel50, gridBagConstraints);

        jLabelSoNgayThue.setText(resourceMap.getString("jLabelSoNgayThue.text")); // NOI18N
        jLabelSoNgayThue.setName("jLabelSoNgayThue"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelSoNgayThue, gridBagConstraints);

        jLabel52.setText(resourceMap.getString("jLabel52.text")); // NOI18N
        jLabel52.setName("jLabel52"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 20);
        jPanel2.add(jLabel52, gridBagConstraints);

        jLabelSoNguoiCuTru.setText(resourceMap.getString("jLabelSoNguoiCuTru.text")); // NOI18N
        jLabelSoNguoiCuTru.setName("jLabelSoNguoiCuTru"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelSoNguoiCuTru, gridBagConstraints);

        jLabel54.setFont(resourceMap.getFont("jLabel54.font")); // NOI18N
        jLabel54.setForeground(resourceMap.getColor("jLabel54.foreground")); // NOI18N
        jLabel54.setText(resourceMap.getString("jLabel54.text")); // NOI18N
        jLabel54.setName("jLabel54"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jLabel54, gridBagConstraints);

        jLabel56.setText(resourceMap.getString("jLabel56.text")); // NOI18N
        jLabel56.setName("jLabel56"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 11);
        jPanel2.add(jLabel56, gridBagConstraints);

        jLabelTenKhach.setText(resourceMap.getString("jLabelTenKhach.text")); // NOI18N
        jLabelTenKhach.setName("jLabelTenKhach"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelTenKhach, gridBagConstraints);

        jLabel58.setText(resourceMap.getString("jLabel58.text")); // NOI18N
        jLabel58.setName("jLabel58"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 46);
        jPanel2.add(jLabel58, gridBagConstraints);

        jLabelNgaySinh.setText(resourceMap.getString("jLabelNgaySinh.text")); // NOI18N
        jLabelNgaySinh.setName("jLabelNgaySinh"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelNgaySinh, gridBagConstraints);

        jLabel60.setText(resourceMap.getString("jLabel60.text")); // NOI18N
        jLabel60.setName("jLabel60"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 54);
        jPanel2.add(jLabel60, gridBagConstraints);

        jLabelGioiTinh.setText(resourceMap.getString("jLabelGioiTinh.text")); // NOI18N
        jLabelGioiTinh.setName("jLabelGioiTinh"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelGioiTinh, gridBagConstraints);

        jLabel62.setText(resourceMap.getString("jLabel62.text")); // NOI18N
        jLabel62.setName("jLabel62"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 61);
        jPanel2.add(jLabel62, gridBagConstraints);

        jLabelDiaChi.setText(resourceMap.getString("jLabelDiaChi.text")); // NOI18N
        jLabelDiaChi.setName("jLabelDiaChi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelDiaChi, gridBagConstraints);

        jLabel64.setText(resourceMap.getString("jLabel64.text")); // NOI18N
        jLabel64.setName("jLabel64"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 44);
        jPanel2.add(jLabel64, gridBagConstraints);

        jLabelDienThoai.setText(resourceMap.getString("jLabelDienThoai.text")); // NOI18N
        jLabelDienThoai.setName("jLabelDienThoai"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelDienThoai, gridBagConstraints);

        jLabel66.setText(resourceMap.getString("jLabel66.text")); // NOI18N
        jLabel66.setName("jLabel66"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 16);
        jPanel2.add(jLabel66, gridBagConstraints);

        jLabelLoaiKhach.setText(resourceMap.getString("jLabelLoaiKhach.text")); // NOI18N
        jLabelLoaiKhach.setName("jLabelLoaiKhach"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelLoaiKhach, gridBagConstraints);

        jLabel68.setText(resourceMap.getString("jLabel68.text")); // NOI18N
        jLabel68.setName("jLabel68"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 56);
        jPanel2.add(jLabel68, gridBagConstraints);

        jLabelDonGiaKhachHang.setText(resourceMap.getString("jLabelDonGiaKhachHang.text")); // NOI18N
        jLabelDonGiaKhachHang.setName("jLabelDonGiaKhachHang"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelDonGiaKhachHang, gridBagConstraints);

        jLabel70.setFont(resourceMap.getFont("jLabel70.font")); // NOI18N
        jLabel70.setForeground(resourceMap.getColor("jLabel70.foreground")); // NOI18N
        jLabel70.setText(resourceMap.getString("jLabel70.text")); // NOI18N
        jLabel70.setName("jLabel70"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jLabel70, gridBagConstraints);

        jLabel72.setText(resourceMap.getString("jLabel72.text")); // NOI18N
        jLabel72.setName("jLabel72"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 36);
        jPanel2.add(jLabel72, gridBagConstraints);

        jLabelTongTien.setText(resourceMap.getString("jLabelTongTien.text")); // NOI18N
        jLabelTongTien.setName("jLabelTongTien"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 20, 2, 0);
        jPanel2.add(jLabelTongTien, gridBagConstraints);

        jBtnTraPhong.setText(resourceMap.getString("jBtnTraPhong.text")); // NOI18N
        jBtnTraPhong.setName("jBtnTraPhong"); // NOI18N
        jBtnTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnTraPhongMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 135, 2, 134);
        jPanel2.add(jBtnTraPhong, gridBagConstraints);

        jLabel75.setFont(resourceMap.getFont("jLabel75.font")); // NOI18N
        jLabel75.setForeground(resourceMap.getColor("jLabel75.foreground")); // NOI18N
        jLabel75.setText(resourceMap.getString("jLabel75.text")); // NOI18N
        jLabel75.setName("jLabel75"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 21, 0);
        jPanel2.add(jLabel75, gridBagConstraints);

        imgPhong.setIcon(resourceMap.getIcon("imgPhong.icon")); // NOI18N
        imgPhong.setText(resourceMap.getString("imgPhong.text")); // NOI18N
        imgPhong.setName("imgPhong"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 21);
        jPanel2.add(imgPhong, gridBagConstraints);

        imgNguoiThue.setIcon(resourceMap.getIcon("imgNguoiThue.icon")); // NOI18N
        imgNguoiThue.setText(resourceMap.getString("imgNguoiThue.text")); // NOI18N
        imgNguoiThue.setName("imgNguoiThue"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 21);
        jPanel2.add(imgNguoiThue, gridBagConstraints);

        imgThanhToan.setIcon(resourceMap.getIcon("imgThanhToan.icon")); // NOI18N
        imgThanhToan.setText(resourceMap.getString("imgThanhToan.text")); // NOI18N
        imgThanhToan.setName("imgThanhToan"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 21);
        jPanel2.add(imgThanhToan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel8.add(jPanel2, gridBagConstraints);

        bgLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgLabel1.setIcon(resourceMap.getIcon("bgLabel1.icon")); // NOI18N
        bgLabel1.setName("bgLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel8.add(bgLabel1, gridBagConstraints);

        add(jPanel8);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        //lay ds phong dang thue
        lstThuePhong = thuePhongController.layDSThuePhong();
        if(lstThuePhong!=null)
        {
            initComboBoxMaPhong();
            hienThiThongTinThuePhong(lstThuePhong.get(0));
        }
    }//GEN-LAST:event_formComponentShown

    private void hienThiThongTinThuePhong(ThuePhong thuePhong) {
        KhachHang khach = thuePhong.getKhachHang();
        jLabelDiaChi.setText(khach.getDiaChi());
        jLabelDienThoai.setText(khach.getDienThoai());
        jLabelGioiTinh.setText(khach.getGioiTinh());
        //jLabelDonGiaKhachHang.setText(khach.getIdLoaiKhachHang().);
        jLabelLoaiKhach.setText(khach.getIdLoaiKhachHang().getTen());
        jLabelNgaySinh.setText(khach.getNgaySinh().toString());
        jLabelTenKhach.setText(khach.getTen());
        
        Phong phong = thuePhong.getPhong();
        jLabelDonGia.setText("" + phong.getIdLoaiPhong().getGia());
        jLabelLoaiPhong.setText(phong.getIdLoaiPhong().getTen());
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
        
        Date ngayTra = calendar.getTime();
        jLabelNgayTra.setText(sdf.format(ngayTra));
        
        Date ngayThue = thuePhong.getNgayThue();
        jLabelNgayThue.setText(sdf.format(ngayThue));
        
        int soNgayThue = MyDateTime.SubDate(ngayThue, ngayTra);
        jLabelSoNgayThue.setText("" + soNgayThue);
        //jLabelSoNguoiCuTru.setText(TOOL_TIP_TEXT_KEY);
        jLabelTongTien.setText("" + thuePhongController.tinhTienThuePhong(phong, soNgayThue));
    }

    private void initComboBoxMaPhong() {
        jCbMaPhong.removeAllItems();

        int i;
        for(i=0;i<lstThuePhong.size();i++)
        {
            jCbMaPhong.addItem(lstThuePhong.get(i).getPhong().getId());
        }
    }

    private ThuePhong timThuePhongTheoMaPhong(int id)
    {
        int i;
        for(i=0;i<lstThuePhong.size();i++)
        {
            if(lstThuePhong.get(i).getPhong().getId() == id)
                return lstThuePhong.get(i);
        }
        return null;
    }

    private void jBtnTraPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnTraPhongMousePressed
        // TODO add your handling code here:
        try
        {
            ThuePhong thuePhong = timThuePhongTheoMaPhong(Integer.parseInt(jCbMaPhong.getSelectedItem().toString()));

            Calendar calendar = Calendar.getInstance();

            Date ngayTra = calendar.getTime();
            thuePhong.setNgayTra(ngayTra);

            Date ngayThue = thuePhong.getNgayThue();

            int soNgayThue = MyDateTime.SubDate(ngayThue, ngayTra);
            int tongGia = thuePhongController.tinhTienThuePhong(thuePhong.getPhong(), soNgayThue);
            thuePhong.setTongGia(tongGia);

            if(thuePhongController.tiepNhanViecTraPhong(thuePhong))
                JOptionPane.showConfirmDialog(this.getComponent(0),"Tra phong thanh cong!" , "Thong bao", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showConfirmDialog(this.getComponent(0),"Tra phong that bai" , "Thong bao loi", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showConfirmDialog(this.getComponent(0),ex.getMessage() , "Thong bao loi", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnTraPhongMousePressed

    private void jCbMaPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbMaPhongItemStateChanged
        // TODO add your handling code here:
        if(jCbMaPhong.getItemCount()>0)
        {
            ThuePhong thuePhong = timThuePhongTheoMaPhong(Integer.parseInt(jCbMaPhong.getSelectedItem().toString()));
            hienThiThongTinThuePhong(thuePhong);
        }
    }//GEN-LAST:event_jCbMaPhongItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel1;
    private javax.swing.JLabel imgNguoiThue;
    private javax.swing.JLabel imgPhong;
    private javax.swing.JLabel imgThanhToan;
    private javax.swing.JButton jBtnTraPhong;
    private javax.swing.JComboBox jCbMaPhong;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabelDiaChi;
    private javax.swing.JLabel jLabelDienThoai;
    private javax.swing.JLabel jLabelDonGia;
    private javax.swing.JLabel jLabelDonGiaKhachHang;
    private javax.swing.JLabel jLabelGioiTinh;
    private javax.swing.JLabel jLabelLoaiKhach;
    private javax.swing.JLabel jLabelLoaiPhong;
    private javax.swing.JLabel jLabelNgaySinh;
    private javax.swing.JLabel jLabelNgayThue;
    private javax.swing.JLabel jLabelNgayTra;
    private javax.swing.JLabel jLabelSoNgayThue;
    private javax.swing.JLabel jLabelSoNguoiCuTru;
    private javax.swing.JLabel jLabelTenKhach;
    private javax.swing.JLabel jLabelTongTien;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables

    private ArrayList<ThuePhong> lstThuePhong;
    
    private ThuePhongController thuePhongController;
    private PhongController phongController;
}

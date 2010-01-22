/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelIntro.java
 *
 * Created on Jan 13, 2010, 11:47:46 PM
 */

package client;

import BUS.KhachSanController;
import DTO.KhachSan;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author bin
 */
public class JPanelIntro extends javax.swing.JPanel {
    
    /** Creates new form JPanelIntro */
    public JPanelIntro() {
        initComponents();
        
        khachSanController = new KhachSanController();
        initData();
    }

    private void hienThiThongTinKhachSan()
    {
        this.jLabelAddress.setText(khachSan.getDiaChi());
        this.jLabelNameHotel.setText(khachSan.getTen());
        this.jLabelPhone.setText(khachSan.getDienThoai());
        this.jLabelWebSite.setText(khachSan.getWebsite());
        this.jLabelFax.setText(khachSan.getFax());
        this.jLabelEmail.setText(khachSan.getEmail());
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

        jPanel1 = new javax.swing.JPanel();
        jLabelNameHotel = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelFax = new javax.swing.JLabel();
        jLabelWebSite = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnSlideShow = new javax.swing.JButton();
        jImg = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JPanelIntro.class);
        jLabelNameHotel.setFont(resourceMap.getFont("jLabelNameHotel.font")); // NOI18N
        jLabelNameHotel.setForeground(resourceMap.getColor("jLabelNameHotel.foreground")); // NOI18N
        jLabelNameHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameHotel.setText(resourceMap.getString("jLabelNameHotel.text")); // NOI18N
        jLabelNameHotel.setName("jLabelNameHotel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 20, 5);
        jPanel1.add(jLabelNameHotel, gridBagConstraints);

        jLabelAddress.setText(resourceMap.getString("jLabelAddress.text")); // NOI18N
        jLabelAddress.setName("jLabelAddress"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        jPanel1.add(jLabelAddress, gridBagConstraints);

        jLabelPhone.setText(resourceMap.getString("jLabelPhone.text")); // NOI18N
        jLabelPhone.setName("jLabelPhone"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        jPanel1.add(jLabelPhone, gridBagConstraints);

        jLabelEmail.setFont(resourceMap.getFont("jLabelEmail.font")); // NOI18N
        jLabelEmail.setForeground(resourceMap.getColor("jLabelEmail.foreground")); // NOI18N
        jLabelEmail.setText(resourceMap.getString("jLabelEmail.text")); // NOI18N
        jLabelEmail.setName("jLabelEmail"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        jPanel1.add(jLabelEmail, gridBagConstraints);

        jLabelFax.setText(resourceMap.getString("jLabelFax.text")); // NOI18N
        jLabelFax.setName("jLabelFax"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        jPanel1.add(jLabelFax, gridBagConstraints);

        jLabelWebSite.setFont(resourceMap.getFont("jLabelWebSite.font")); // NOI18N
        jLabelWebSite.setForeground(resourceMap.getColor("jLabelWebSite.foreground")); // NOI18N
        jLabelWebSite.setText(resourceMap.getString("jLabelWebSite.text")); // NOI18N
        jLabelWebSite.setName("jLabelWebSite"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        jPanel1.add(jLabelWebSite, gridBagConstraints);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        jBtnSlideShow.setBackground(resourceMap.getColor("jBtnSlideShow.background")); // NOI18N
        jBtnSlideShow.setText(resourceMap.getString("jBtnSlideShow.text")); // NOI18N
        jBtnSlideShow.setName("jBtnSlideShow"); // NOI18N
        jBtnSlideShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnSlideShowMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        jPanel1.add(jBtnSlideShow, gridBagConstraints);

        jImg.setIcon(resourceMap.getIcon("jImg.icon")); // NOI18N
        jImg.setText(resourceMap.getString("jImg.text")); // NOI18N
        jImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jImg.setName("jImg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        jPanel1.add(jImg, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

        jLabelImg.setIcon(resourceMap.getIcon("jLabelImg.icon")); // NOI18N
        jLabelImg.setText(resourceMap.getString("jLabelImg.text")); // NOI18N
        jLabelImg.setName("jLabelImg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jLabelImg, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        initData();
    }//GEN-LAST:event_formComponentShown

    private void jBtnSlideShowMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSlideShowMouseReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().open(new File("src/client/resources/SlideKhachSan.mpg"));
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnSlideShowMouseReleased

    private void initData()
    {
        khachSan = khachSanController.layKhachSan();

        if(khachSan!=null)
        {
            hienThiThongTinKhachSan();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSlideShow;
    private javax.swing.JLabel jImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFax;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelNameHotel;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelWebSite;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private KhachSan khachSan;
    private KhachSanController khachSanController;
    
}

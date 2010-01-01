/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogThemKhachHang.java
 *
 * Created on Jan 1, 2010, 11:43:26 AM
 */

package client;

import BUS.KhachHangController;
import DTO.KhachHang;
import DTO.LoaiKhachHang;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author bin
 */
public class JDialogThemKhachHang extends javax.swing.JDialog {
        
    public KhachHang getKhachHang()
    {
        return this.khachHang;
    }
    
    public boolean IsValid()
    {
        return this.isValid;
    }

    /** Creates new form JDialogThemKhachHang */
    public JDialogThemKhachHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        khachController = new KhachHangController();

        this.setTitle("Them khach hang");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JDialogThemKhachHang.HIDE_ON_CLOSE);
        
        //this.setLocationRelativeTo(parent);
        this.isValid = false;
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
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTxtTenKhach = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTxtNgaySinh = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        jCbGioiTinh = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jTxtDiaChi = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTxtDienThoai = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jCbLoaiKhach = new javax.swing.JComboBox();
        jBtnThemKhach = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imgCustomer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtCMND = new javax.swing.JFormattedTextField();
        bgLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JDialogThemKhachHang.class);
        jLabel27.setFont(resourceMap.getFont("jLabel27.font")); // NOI18N
        jLabel27.setForeground(resourceMap.getColor("jLabel27.foreground")); // NOI18N
        jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
        jLabel27.setName("jLabel27"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jLabel27, gridBagConstraints);

        jLabel29.setText(resourceMap.getString("jLabel29.text")); // NOI18N
        jLabel29.setName("jLabel29"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 17);
        jPanel2.add(jLabel29, gridBagConstraints);

        jTxtTenKhach.setBackground(resourceMap.getColor("jTxtTenKhach.background")); // NOI18N
        jTxtTenKhach.setColumns(80);
        jTxtTenKhach.setToolTipText(resourceMap.getString("jTxtTenKhach.toolTipText")); // NOI18N
        jTxtTenKhach.setName("jTxtTenKhach"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jTxtTenKhach, gridBagConstraints);

        jLabel30.setText(resourceMap.getString("jLabel30.text")); // NOI18N
        jLabel30.setName("jLabel30"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 44);
        jPanel2.add(jLabel30, gridBagConstraints);

        jTxtNgaySinh.setBackground(resourceMap.getColor("jTxtNgaySinh.background")); // NOI18N
        jTxtNgaySinh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jTxtNgaySinh.setToolTipText(resourceMap.getString("jTxtNgaySinh.toolTipText")); // NOI18N
        jTxtNgaySinh.setName("jTxtNgaySinh"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jTxtNgaySinh, gridBagConstraints);

        jLabel31.setText(resourceMap.getString("jLabel31.text")); // NOI18N
        jLabel31.setName("jLabel31"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 55);
        jPanel2.add(jLabel31, gridBagConstraints);

        jCbGioiTinh.setBackground(resourceMap.getColor("jCbGioiTinh.background")); // NOI18N
        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nu" }));
        jCbGioiTinh.setToolTipText(resourceMap.getString("jCbGioiTinh.toolTipText")); // NOI18N
        jCbGioiTinh.setName("jCbGioiTinh"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jCbGioiTinh, gridBagConstraints);

        jLabel32.setText(resourceMap.getString("jLabel32.text")); // NOI18N
        jLabel32.setName("jLabel32"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 59);
        jPanel2.add(jLabel32, gridBagConstraints);

        jTxtDiaChi.setBackground(resourceMap.getColor("jTxtDiaChi.background")); // NOI18N
        jTxtDiaChi.setToolTipText(resourceMap.getString("jTxtDiaChi.toolTipText")); // NOI18N
        jTxtDiaChi.setName("jTxtDiaChi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jTxtDiaChi, gridBagConstraints);

        jLabel33.setText(resourceMap.getString("jLabel33.text")); // NOI18N
        jLabel33.setName("jLabel33"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 42);
        jPanel2.add(jLabel33, gridBagConstraints);

        jTxtDienThoai.setBackground(resourceMap.getColor("jTxtDienThoai.background")); // NOI18N
        jTxtDienThoai.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTxtDienThoai.setToolTipText(resourceMap.getString("jTxtDienThoai.toolTipText")); // NOI18N
        jTxtDienThoai.setName("jTxtDienThoai"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jTxtDienThoai, gridBagConstraints);

        jLabel34.setText(resourceMap.getString("jLabel34.text")); // NOI18N
        jLabel34.setName("jLabel34"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 13);
        jPanel2.add(jLabel34, gridBagConstraints);

        jCbLoaiKhach.setBackground(resourceMap.getColor("jCbLoaiKhach.background")); // NOI18N
        jCbLoaiKhach.setToolTipText(resourceMap.getString("jCbLoaiKhach.toolTipText")); // NOI18N
        jCbLoaiKhach.setName("jCbLoaiKhach"); // NOI18N
        jCbLoaiKhach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbLoaiKhachItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jCbLoaiKhach, gridBagConstraints);

        jBtnThemKhach.setText(resourceMap.getString("jBtnThemKhach.text")); // NOI18N
        jBtnThemKhach.setToolTipText(resourceMap.getString("jBtnThemKhach.toolTipText")); // NOI18N
        jBtnThemKhach.setName("jBtnThemKhach"); // NOI18N
        jBtnThemKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnThemKhachMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.insets = new java.awt.Insets(22, 100, 1, 100);
        jPanel2.add(jBtnThemKhach, gridBagConstraints);

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

        imgCustomer.setIcon(resourceMap.getIcon("imgCustomer.icon")); // NOI18N
        imgCustomer.setName("imgCustomer"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        jPanel2.add(imgCustomer, gridBagConstraints);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 28, 2, 59);
        jPanel2.add(jLabel4, gridBagConstraints);

        jTxtCMND.setBackground(resourceMap.getColor("jTxtCMND.background")); // NOI18N
        jTxtCMND.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTxtCMND.setToolTipText(resourceMap.getString("jTxtCMND.toolTipText")); // NOI18N
        jTxtCMND.setName("jTxtCMND"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(jTxtCMND, gridBagConstraints);

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

        getContentPane().add(jPanel7, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbLoaiKhachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbLoaiKhachItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbLoaiKhachItemStateChanged

    private void jBtnThemKhachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemKhachMousePressed
        // TODO add your handling code here:
        try {
            //lay thong tin khach hang
            KhachHang khach = new KhachHang();

            khach.setId(jTxtCMND.getText());
            khach.setDiaChi(jTxtDiaChi.getText());
            khach.setDienThoai(jTxtDienThoai.getText());
            khach.setGioiTinh((String)jCbGioiTinh.getSelectedItem());

            String sNgaySinh = jTxtNgaySinh.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if(!sNgaySinh.equals(""))
            {                
                khach.setNgaySinh(sdf.parse(sNgaySinh));
            }
            else
            {
                khach.setNgaySinh(sdf.parse("1/1/0001"));
            }

            khach.setTen(jTxtTenKhach.getText());
            LoaiKhachHang loaiKhachHang = layLoaiKhachHangTheoTen(jCbLoaiKhach.getSelectedItem().toString());
            khach.setIdLoaiKhachHang(loaiKhachHang);

            String error = khachController.kiemTraKhachHang(khach);
            if(!error.equals("")) {
                JOptionPane.showMessageDialog(this.getComponent(0),error , "Thong bao loi", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                this.khachHang = khach;
                this.isValid = true;
                this.setVisible(false);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this.getComponent(0),ex.getMessage() , "Thong bao loi", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_jBtnThemKhachMousePressed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        //lay danh sach loai khach hang
        WorkerGetListLoaiKhachHang workerLoaiKhach = new WorkerGetListLoaiKhachHang();
        workerLoaiKhach.execute();
        try {
            lstLoaiKhachHang = workerLoaiKhach.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDialogThemKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JDialogThemKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lstLoaiKhachHang = khachController.getDSLoaiKhachHang();
        if(lstLoaiKhachHang!=null)
        {
            initComboBoxLoaiKhachHang();
        }
    }//GEN-LAST:event_formComponentShown

    private void initComboBoxLoaiKhachHang()
    {
        jCbLoaiKhach.removeAllItems();

        int i;
        //add item to combobox
        for(i=0;i<lstLoaiKhachHang.size();i++)
        {
            jCbLoaiKhach.addItem(lstLoaiKhachHang.get(i).getTen());
        }
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

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogThemKhachHang dialog = new JDialogThemKhachHang(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel3;
    private javax.swing.JLabel imgCustomer;
    private javax.swing.JButton jBtnThemKhach;
    private javax.swing.JComboBox jCbGioiTinh;
    private javax.swing.JComboBox jCbLoaiKhach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JFormattedTextField jTxtCMND;
    private javax.swing.JTextField jTxtDiaChi;
    private javax.swing.JFormattedTextField jTxtDienThoai;
    private javax.swing.JFormattedTextField jTxtNgaySinh;
    private javax.swing.JTextField jTxtTenKhach;
    // End of variables declaration//GEN-END:variables

    private KhachHangController khachController;
    private ArrayList<LoaiKhachHang> lstLoaiKhachHang;
    private KhachHang khachHang;
    private boolean isValid;
}

class WorkerGetListLoaiKhachHang extends SwingWorker<ArrayList<LoaiKhachHang>, Void>
{
    private KhachHangController khachController;

    @Override
    protected ArrayList<LoaiKhachHang> doInBackground() throws Exception {

        khachController = new KhachHangController();
        return khachController.getDSLoaiKhachHang();

    }

}
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

/**
 *
 * @author huy
 */
public class JPanelThongKe extends javax.swing.JPanel {

    /** Creates new form JPanelThongKe */
    public JPanelThongKe() {
        initComponents();
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelThang = new javax.swing.JLabel();
        jFTxtThang = new javax.swing.JFormattedTextField();
        jLabelNam = new javax.swing.JLabel();
        jFTxtNam = new javax.swing.JFormattedTextField();
        jBtnThongKe = new javax.swing.JButton();
        bgLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bgLabel3 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        setLayout(new java.awt.GridLayout(1, 1));

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(client.ClientApp.class).getContext().getResourceMap(JPanelThongKe.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setName("jLabel1"); // NOI18N
        jSplitPane1.setLeftComponent(jLabel1);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabelThang.setText(resourceMap.getString("jLabelThang.text")); // NOI18N
        jLabelThang.setName("jLabelThang"); // NOI18N
        jPanel3.add(jLabelThang, new java.awt.GridBagConstraints());

        jFTxtThang.setBackground(resourceMap.getColor("jFTxtThang.background")); // NOI18N
        jFTxtThang.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFTxtThang.setText(resourceMap.getString("jFTxtThang.text")); // NOI18N
        jFTxtThang.setName("jFTxtThang"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        jPanel3.add(jFTxtThang, gridBagConstraints);

        jLabelNam.setText(resourceMap.getString("jLabelNam.text")); // NOI18N
        jLabelNam.setName("jLabelNam"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabelNam, gridBagConstraints);

        jFTxtNam.setBackground(resourceMap.getColor("jFTxtNam.background")); // NOI18N
        jFTxtNam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFTxtNam.setName("jFTxtNam"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        jPanel3.add(jFTxtNam, gridBagConstraints);

        jBtnThongKe.setText(resourceMap.getString("jBtnThongKe.text")); // NOI18N
        jBtnThongKe.setName("jBtnThongKe"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 10, 8);
        jPanel3.add(jBtnThongKe, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

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
        jPanel1.add(bgLabel, gridBagConstraints);

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setOpaque(false);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setBackground(resourceMap.getColor("jTable1.background")); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma Phong", "Loai Phong", "Don gia", "So ngay muon", "Tong so tien"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(resourceMap.getColor("jTable1.selectionBackground")); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addGap(103, 103, 103))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(581, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanel4, gridBagConstraints);

        bgLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgLabel3.setIcon(resourceMap.getIcon("bgLabel3.icon")); // NOI18N
        bgLabel3.setText(resourceMap.getString("bgLabel3.text")); // NOI18N
        bgLabel3.setName("bgLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(bgLabel3, gridBagConstraints);

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setRightComponent(jSplitPane2);

        add(jSplitPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLabel bgLabel3;
    private javax.swing.JButton jBtnThongKe;
    private javax.swing.JFormattedTextField jFTxtNam;
    private javax.swing.JFormattedTextField jFTxtThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNam;
    private javax.swing.JLabel jLabelThang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
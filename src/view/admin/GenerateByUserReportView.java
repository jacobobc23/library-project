/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.admin;

import controllers.PdfGeneratorController;
import controllers.UserManagemetController;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.User;

/**
 *
 * @author jacobobc
 */
public class GenerateByUserReportView extends javax.swing.JFrame {

    private final PdfGeneratorController controller;
    private final UserManagemetController userManagemetController;
    private final User admin;
    private final JFrame window;

    /**
     * Creates new form GenerateByUserReportView
     *
     * @param admin
     * @param window
     */
    public GenerateByUserReportView(User admin, JFrame window) {
        initComponents();
        this.admin = admin;
        controller = new PdfGeneratorController();
        userManagemetController = new UserManagemetController();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar Reporte");
        setResizable(false);
        fillTable();
        this.window = window;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        namePanel1 = new javax.swing.JPanel();
        txtUserId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnGeneratePdf = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        namePanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAditionalInformation = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        namePanel3 = new javax.swing.JPanel();
        txtSubtitle = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        namePanel4 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Titulo:");

        namePanel1.setBackground(new java.awt.Color(245, 245, 245));
        namePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserId.setBackground(new java.awt.Color(245, 245, 245));
        txtUserId.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUserId.setBorder(null);
        txtUserId.setFocusable(false);
        txtUserId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserIdKeyTyped(evt);
            }
        });
        namePanel1.add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, -1));

        jPanel3.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        namePanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnCancel.setBackground(new java.awt.Color(220, 20, 60));
        btnCancel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnGeneratePdf.setBackground(new java.awt.Color(0, 123, 255));
        btnGeneratePdf.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnGeneratePdf.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneratePdf.setText("Generar");
        btnGeneratePdf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGeneratePdf.setFocusable(false);
        btnGeneratePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePdfActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Subtitulo:");

        namePanel2.setBackground(new java.awt.Color(245, 245, 245));
        namePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        namePanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        txtAditionalInformation.setBackground(new java.awt.Color(245, 245, 245));
        txtAditionalInformation.setColumns(20);
        txtAditionalInformation.setRows(5);
        txtAditionalInformation.setBorder(null);
        jScrollPane1.setViewportView(txtAditionalInformation);

        namePanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 8, 280, 90));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Información adicional:");

        namePanel3.setBackground(new java.awt.Color(245, 245, 245));
        namePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubtitle.setBackground(new java.awt.Color(245, 245, 245));
        txtSubtitle.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSubtitle.setBorder(null);
        txtSubtitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubtitleKeyTyped(evt);
            }
        });
        namePanel3.add(txtSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, -1));

        jPanel6.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        namePanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("*");

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("*");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(usersTable);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("ID usuario:");

        namePanel4.setBackground(new java.awt.Color(245, 245, 245));
        namePanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setBackground(new java.awt.Color(245, 245, 245));
        txtTitle.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTitle.setBorder(null);
        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTitleKeyTyped(evt);
            }
        });
        namePanel4.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, -1));

        jPanel5.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        namePanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGeneratePdf))
                        .addGap(80, 80, 80))))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(namePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundPanelLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2))
                        .addComponent(namePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(namePanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namePanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namePanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnGeneratePdf))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnGeneratePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePdfActionPerformed
        if (hasEmptyFields()) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos obligatorios");
            return;
        }

        String fileName;

        do {
            fileName = JOptionPane.showInputDialog("Guardar como:");

            if (fileName == null) {
                return;
            }

            if (fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del documento");

            }
        } while (fileName.isEmpty());

        String id = txtUserId.getText();
        String title = txtTitle.getText();
        String subtitle = txtSubtitle.getText();
        String aditionalInformation = txtAditionalInformation.getText();

        boolean success = false;

        if (window instanceof LoansWindow) {
            success = controller.generatePDFLoansByUser(id, fileName, title, subtitle, aditionalInformation);
        } else if (window instanceof LoanRepaymentsWindow) {
            success = controller.generatePDFLoanRepaymentsByUser(id, fileName, title, subtitle, aditionalInformation);
        }

        if (success) {
            JOptionPane.showMessageDialog(null, "Reporte Creado, revise su escritorio");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron resultados");
        }
    }//GEN-LAST:event_btnGeneratePdfActionPerformed

    private void txtSubtitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtitleKeyTyped
        String subtitle = txtSubtitle.getText().trim();
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || subtitle.length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSubtitleKeyTyped

    private void txtTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyTyped
        String title = txtTitle.getText().trim();
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || title.length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTitleKeyTyped

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        int seleccion = usersTable.getSelectedRow();

        txtUserId.setText(usersTable.getValueAt(seleccion, 0).toString());
    }//GEN-LAST:event_usersTableMouseClicked

    private void txtUserIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserIdKeyTyped
        String fileName = txtUserId.getText().trim();
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || fileName.length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserIdKeyTyped

    private boolean hasEmptyFields() {
        return (txtUserId.getText().isEmpty() || txtSubtitle.getText().isEmpty());
    }

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<Object> users = userManagemetController.listUsers();
        model.setColumnIdentifiers(new Object[]{
            "ID", "Nombre"
        });

        usersTable.setModel(model);

        for (int i = 0; i < users.size(); i++) {
            User user = (User) users.get(i);
            if (!user.getId().equals(admin.getId())) {

                model.addRow(new Object[]{
                    user.getId(),
                    user.getFullName(),});
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGeneratePdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel namePanel1;
    private javax.swing.JPanel namePanel2;
    private javax.swing.JPanel namePanel3;
    private javax.swing.JPanel namePanel4;
    private javax.swing.JTextArea txtAditionalInformation;
    private javax.swing.JTextField txtSubtitle;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}

package view.admin;

import controllers.LoanManagementController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Loan;
import model.User;
import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class LoansWindow extends javax.swing.JFrame {

    private final User admin;
    private final LoanManagementController controller;

    /**
     * Creates new form LoansWindow
     */
    public LoansWindow(User admin) {
        initComponents();
        this.admin = admin;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Préstamos");
        setResizable(false);
        lblAdminName.setText(admin.getFullName());
        controller = new LoanManagementController();
        fillTable();
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
        menuBarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAdminName = new javax.swing.JLabel();
        lblAdminAccount = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBooksManagement = new javax.swing.JButton();
        btnUserManagement = new javax.swing.JButton();
        btnTransactions = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        loansTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        menuBarPanel.setBackground(new java.awt.Color(0, 123, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAdminName.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblAdminName.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminName.setText("jLabel2");
        lblAdminName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAdminAccount.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblAdminAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminAccount.setText("Gestionar mi cuenta");
        lblAdminAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdminAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAdminAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminAccountMouseClicked(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("SALIR");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnBooksManagement.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnBooksManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnBooksManagement.setText("    LIBROS");
        btnBooksManagement.setBorderPainted(false);
        btnBooksManagement.setContentAreaFilled(false);
        btnBooksManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBooksManagement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBooksManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBooksManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBooksManagementMouseExited(evt);
            }
        });
        btnBooksManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksManagementActionPerformed(evt);
            }
        });

        btnUserManagement.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUserManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnUserManagement.setText("    USUARIOS");
        btnUserManagement.setBorderPainted(false);
        btnUserManagement.setContentAreaFilled(false);
        btnUserManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserManagement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUserManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserManagementMouseExited(evt);
            }
        });
        btnUserManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserManagementActionPerformed(evt);
            }
        });

        btnTransactions.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnTransactions.setForeground(new java.awt.Color(255, 255, 255));
        btnTransactions.setText("    TRANSACCIONES");
        btnTransactions.setBorderPainted(false);
        btnTransactions.setContentAreaFilled(false);
        btnTransactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransactions.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransactionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransactionsMouseExited(evt);
            }
        });
        btnTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarPanelLayout = new javax.swing.GroupLayout(menuBarPanel);
        menuBarPanel.setLayout(menuBarPanelLayout);
        menuBarPanelLayout.setHorizontalGroup(
            menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblAdminName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuBarPanelLayout.createSequentialGroup()
                .addGroup(menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuBarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAdminAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                    .addGroup(menuBarPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(btnBooksManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUserManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuBarPanelLayout.setVerticalGroup(
            menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdminName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdminAccount)
                .addGap(88, 88, 88)
                .addComponent(btnBooksManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransactions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        loansTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(loansTable);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
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

    private void lblAdminAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminAccountMouseClicked
        new AdminAccountWindow(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAdminAccountMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        new LogInWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBooksManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBooksManagementMouseEntered
        Color color = new Color(135, 178, 255);
        btnBooksManagement.setBackground(color);
        btnBooksManagement.setOpaque(true);
    }//GEN-LAST:event_btnBooksManagementMouseEntered

    private void btnBooksManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBooksManagementMouseExited
        btnBooksManagement.setOpaque(false);
    }//GEN-LAST:event_btnBooksManagementMouseExited

    private void btnBooksManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksManagementActionPerformed
        new BooksWindow(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBooksManagementActionPerformed

    private void btnUserManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserManagementMouseEntered
        Color color = new Color(135, 178, 255);
        btnUserManagement.setBackground(color);
        btnUserManagement.setOpaque(true);
    }//GEN-LAST:event_btnUserManagementMouseEntered

    private void btnUserManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserManagementMouseExited
        btnUserManagement.setOpaque(false);
    }//GEN-LAST:event_btnUserManagementMouseExited

    private void btnUserManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserManagementActionPerformed
        new UsersWindow(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUserManagementActionPerformed

    private void btnTransactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionsMouseEntered
        Color color = new Color(135, 178, 255);
        btnTransactions.setBackground(color);
        btnTransactions.setOpaque(true);
    }//GEN-LAST:event_btnTransactionsMouseEntered

    private void btnTransactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionsMouseExited
        btnTransactions.setOpaque(false);
    }//GEN-LAST:event_btnTransactionsMouseExited

    private void btnTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransactionsActionPerformed

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<Loan> loans = controller.listLoans();
        model.setColumnIdentifiers(new Object[]{
            "ID Usuario", "Nombre usuario", "ISBN Libro", "Título libro", "Fecha préstamo", "Fecha vencimiento"
        });

        loansTable.setModel(model);

        for (Loan loan : loans) {
            model.addRow(new Object[]{
                loan.getUser().getId(),
                loan.getUser().getFullName(),
                loan.getBook().getIsbn(),
                loan.getBook().getTitle(),
                loan.getDate(),
                loan.getDueDate()
            });
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnBooksManagement;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnTransactions;
    private javax.swing.JButton btnUserManagement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdminAccount;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JTable loansTable;
    private javax.swing.JPanel menuBarPanel;
    // End of variables declaration//GEN-END:variables
}

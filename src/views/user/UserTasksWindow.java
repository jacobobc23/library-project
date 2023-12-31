package views.user;

import java.awt.Color;
import javax.swing.JFrame;
import model.User;
import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class UserTasksWindow extends javax.swing.JFrame {

    private final User user;

    /**
     * Creates new form UserTasksWindow
     * @param user
     */
    public UserTasksWindow(User user) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre en pantalla completa.
        setResizable(false);
        setTitle("Gestiones");
        this.user = user;
        lblUserName.setText(user.getFullName());
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
        lblUserName = new javax.swing.JLabel();
        lblUserAccount = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBooksManagement = new javax.swing.JButton();
        btnLoans = new javax.swing.JButton();
        btnTransactions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        menuBarPanel.setBackground(new java.awt.Color(0, 123, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblUserName.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("jLabel2");
        lblUserName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblUserAccount.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblUserAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblUserAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserAccount.setText("Gestionar mi cuenta");
        lblUserAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUserAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblUserAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserAccountMouseClicked(evt);
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

        btnLoans.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLoans.setForeground(new java.awt.Color(255, 255, 255));
        btnLoans.setText("    PRÉSTAMOS");
        btnLoans.setBorderPainted(false);
        btnLoans.setContentAreaFilled(false);
        btnLoans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoansMouseExited(evt);
            }
        });
        btnLoans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoansActionPerformed(evt);
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
            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuBarPanelLayout.createSequentialGroup()
                .addGroup(menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuBarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUserAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                    .addGroup(menuBarPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(btnBooksManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLoans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuBarPanelLayout.setVerticalGroup(
            menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserAccount)
                .addGap(88, 88, 88)
                .addComponent(btnBooksManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransactions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(631, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void lblUserAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserAccountMouseClicked
        new UserAccountWindow(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblUserAccountMouseClicked

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
        new BooksWindow(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBooksManagementActionPerformed

    private void btnLoansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoansMouseEntered
        Color color = new Color(135, 178, 255);
        btnLoans.setBackground(color);
        btnLoans.setOpaque(true);
    }//GEN-LAST:event_btnLoansMouseEntered

    private void btnLoansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoansMouseExited
        btnLoans.setOpaque(false);
    }//GEN-LAST:event_btnLoansMouseExited

    private void btnLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoansActionPerformed
        new LoansWindow(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoansActionPerformed

    private void btnTransactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionsMouseEntered
        Color color = new Color(135, 178, 255);
        btnTransactions.setBackground(color);
        btnTransactions.setOpaque(true);
    }//GEN-LAST:event_btnTransactionsMouseEntered

    private void btnTransactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionsMouseExited
        btnTransactions.setOpaque(false);
    }//GEN-LAST:event_btnTransactionsMouseExited

    private void btnTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionsActionPerformed
        new UserTransactionsWindow(user).setVisible(true);
    }//GEN-LAST:event_btnTransactionsActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnBooksManagement;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoans;
    private javax.swing.JButton btnTransactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblUserAccount;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel menuBarPanel;
    // End of variables declaration//GEN-END:variables
}

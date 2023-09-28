package views.user;

import controllers.LoanManagementController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Loan;
import model.User;
import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class LoansWindow extends javax.swing.JFrame {

    private final User user;
    private final LoanManagementController controller;

    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form LoansWindow
     */
    public LoansWindow(User user) {
        initComponents();
        this.user = user;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Préstamos");
        lblUserName.setText(user.getFullName());
        setResizable(false);
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
        lblUserName = new javax.swing.JLabel();
        lblUserAccount = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBooksManagement = new javax.swing.JButton();
        btnTransactions = new javax.swing.JButton();
        lblLoans = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loansTable = new javax.swing.JTable();
        btnRepayLoan = new javax.swing.JButton();

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

        lblLoans.setBackground(new java.awt.Color(135, 178, 255));
        lblLoans.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblLoans.setForeground(new java.awt.Color(255, 255, 255));
        lblLoans.setText("       PRÉSTAMOS");
        lblLoans.setOpaque(true);

        javax.swing.GroupLayout menuBarPanelLayout = new javax.swing.GroupLayout(menuBarPanel);
        menuBarPanel.setLayout(menuBarPanelLayout);
        menuBarPanelLayout.setHorizontalGroup(
            menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBooksManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(lblLoans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(8, 8, 8)
                .addComponent(lblLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransactions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
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

        btnRepayLoan.setBackground(new java.awt.Color(0, 123, 255));
        btnRepayLoan.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRepayLoan.setForeground(new java.awt.Color(255, 255, 255));
        btnRepayLoan.setText("Devolución");
        btnRepayLoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRepayLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepayLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRepayLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRepayLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnRepayLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepayLoanActionPerformed
        int selected = loansTable.getSelectedRow();

        if (selected >= 0) {
            int loanId = (int) loansTable.getModel().getValueAt(selected, 0);
            Loan loan = controller.selectLoan(loanId);

            int answer = JOptionPane.showConfirmDialog(null, "¿Está seguro de realizar la devolución?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);

            if (answer == 0) {
                controller.repayLoan(loan);
                fillTable();
                JOptionPane.showMessageDialog(null, "Devolución realizada correctamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un préstamo de la tabla");
        }
    }//GEN-LAST:event_btnRepayLoanActionPerformed

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<Loan> loans = controller.listUserLoans(user);
        model.setColumnIdentifiers(new Object[]{
            "ID", "ISBN", "Título", "Fecha préstamo", "Fecha vencimiento"
        });

        loansTable.setModel(model);
        loansTable.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        loansTable.setRowSorter(sorter);

        for (Loan loan : loans) {
            model.addRow(new Object[]{
                loan.getId(),
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
    private javax.swing.JButton btnRepayLoan;
    private javax.swing.JButton btnTransactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoans;
    private javax.swing.JLabel lblUserAccount;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable loansTable;
    private javax.swing.JPanel menuBarPanel;
    // End of variables declaration//GEN-END:variables
}

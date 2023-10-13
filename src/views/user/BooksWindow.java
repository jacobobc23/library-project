package views.user;

import controllers.BookManagementController;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Book;
import model.User;
import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class BooksWindow extends javax.swing.JFrame {

    private final User user;
    private final BookManagementController controller;

    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form BooksWindow
     *
     * @param user
     */
    public BooksWindow(User user) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Libros");
        setResizable(false);
        this.user = user;
        lblUserName.setText(user.getFullName());
        controller = new BookManagementController();
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
        btnLoans = new javax.swing.JButton();
        btnTransactions = new javax.swing.JButton();
        lblBooks = new javax.swing.JLabel();
        booksPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtFilter = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnApplyLoan = new javax.swing.JButton();

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

        btnLoans.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLoans.setForeground(new java.awt.Color(255, 255, 255));
        btnLoans.setText("    PRÉSTAMOS");
        btnLoans.setBorderPainted(false);
        btnLoans.setContentAreaFilled(false);
        btnLoans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        lblBooks.setBackground(new java.awt.Color(135, 178, 255));
        lblBooks.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblBooks.setForeground(new java.awt.Color(255, 255, 255));
        lblBooks.setText("        LIBROS");
        lblBooks.setOpaque(true);

        javax.swing.GroupLayout menuBarPanelLayout = new javax.swing.GroupLayout(menuBarPanel);
        menuBarPanel.setLayout(menuBarPanelLayout);
        menuBarPanelLayout.setHorizontalGroup(
            menuBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLoans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(lblBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(lblBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransactions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        booksPanel.setBackground(new java.awt.Color(255, 255, 255));

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(booksTable);

        txtFilter.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFilter.setBorder(null);
        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFilterKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Buscar:");

        btnApplyLoan.setBackground(new java.awt.Color(0, 123, 255));
        btnApplyLoan.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnApplyLoan.setForeground(new java.awt.Color(255, 255, 255));
        btnApplyLoan.setText("Solicitar préstamo");
        btnApplyLoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApplyLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout booksPanelLayout = new javax.swing.GroupLayout(booksPanel);
        booksPanel.setLayout(booksPanelLayout);
        booksPanelLayout.setHorizontalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(booksPanelLayout.createSequentialGroup()
                        .addComponent(btnApplyLoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFilter)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(184, 184, 184))
        );
        booksPanelLayout.setVerticalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(booksPanelLayout.createSequentialGroup()
                        .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(booksPanelLayout.createSequentialGroup()
                                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, booksPanelLayout.createSequentialGroup()
                                .addComponent(btnApplyLoan)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(booksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(235, 235, 235))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(booksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoansActionPerformed
        new LoansWindow(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoansActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        filter();
    }//GEN-LAST:event_txtFilterKeyReleased

    private void txtFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFilterKeyTyped

    private void btnApplyLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyLoanActionPerformed
        int selected = booksTable.getSelectedRow();

        if (selected >= 0) {

            String isbn = booksTable.getModel().getValueAt(selected, 0).toString();
            Object book = controller.selectBook(isbn);

            if (book != null) {
                new LoanConfirmationWindow(user, (Book) book).setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un libro de la tabla.");
        }
    }//GEN-LAST:event_btnApplyLoanActionPerformed

    public final void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<Object> books = controller.listBooks();
        model.setColumnIdentifiers(new Object[]{
            "ISBN", "Título", "Autor", "Género", "Año de publicación"
        });

        booksTable.setModel(model);
        booksTable.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        booksTable.setRowSorter(sorter);

        for (int i = 0; i < books.size(); i++) {
            Book book = (Book) books.get(i);
            model.addRow(new Object[]{
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre().getName(),
                book.getPublicationYear()
            });
        }
    }

    /**
     * Actúa como un buscador avanzado. Permitiendo filtrar los libros por
     * distintos atributos.
     */
    private void filter() {
        String filterText = txtFilter.getText();

        RowFilter<Object, Object> isbn = RowFilter.regexFilter(filterText.trim(), 0);
        RowFilter<Object, Object> title = RowFilter.regexFilter("(?i)" + filterText.trim(), 1);
        RowFilter<Object, Object> author = RowFilter.regexFilter("(?i)" + filterText.trim(), 2);
        RowFilter<Object, Object> genre = RowFilter.regexFilter("(?i)" + filterText.trim(), 3);
        RowFilter<Object, Object> publicationYear = RowFilter.regexFilter(filterText.trim(), 4);
        RowFilter<Object, Object> copiesNumber = RowFilter.regexFilter(filterText.trim(), 5);

        sorter.setRowFilter(RowFilter.orFilter(Arrays.asList(isbn, title, author, genre, publicationYear, copiesNumber)));

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel booksPanel;
    private javax.swing.JTable booksTable;
    private javax.swing.JButton btnApplyLoan;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoans;
    private javax.swing.JButton btnTransactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBooks;
    private javax.swing.JLabel lblUserAccount;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel menuBarPanel;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}

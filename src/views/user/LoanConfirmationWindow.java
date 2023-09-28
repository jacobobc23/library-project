package views.user;

import controllers.BookManagementController;
import controllers.LoanManagementController;
import exceptions.LoanPastDueException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Book;
import model.Genre;
import model.Loan;
import model.User;

/**
 *
 * @author Jacobo-bc
 */
public class LoanConfirmationWindow extends javax.swing.JFrame {

    private final User user;
    private final Book book;
    private final LoanManagementController controller;
    private final BookManagementController controllerbook;

    /**
     * Creates new form LoanConfirmationWindow
     */
    public LoanConfirmationWindow(User user, Book book) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Confirmación préstamo");
        jDate.setMinSelectableDate(new Date());
        this.user = user;
        this.book = book;
        controller = new LoanManagementController();
        controllerbook = new BookManagementController();
        setCbxPublicationYear();
        setCbxGenre();
        showBookInformation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void showBookInformation() {
        lblIsbn.setText(book.getIsbn());
        lblAuthor.setText(book.getAuthor());
        lblTitle.setText(book.getTitle());
        cbxPublicationYear.setSelectedItem(book.getPublicationYear());
        cbxGenre.setSelectedItem(book.getGenre().getName());
    }

    private void setCbxPublicationYear() {

        int currentYear = LocalDate.now().getYear();

        for (int year = currentYear; year >= (currentYear - 400); year--) {
            cbxPublicationYear.addItem(String.valueOf(year));
        }

        cbxPublicationYear.insertItemAt("Seleccione una opción", 0);
    }

    private void setCbxGenre() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        cbxGenre.setModel(model);

        ArrayList<Genre> genres = controllerbook.listAllGenres();
        model.addElement("Seleccione una categoría"); // Agrega la opción predeterminada

        for (Genre genre : genres) {
            model.addElement(genre.getName()); // Agrega los nombres de las categorías al ComboBoxModel
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        cbxGenre = new javax.swing.JComboBox<>();
        namePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        namePanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblAuthor = new javax.swing.JLabel();
        IDPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblIsbn = new javax.swing.JLabel();
        cbxPublicationYear = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        birthDatePanel1 = new javax.swing.JPanel();
        btnConfirmLoan = new javax.swing.JButton();
        btnCancel1 = new javax.swing.JButton();
        jDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        cbxGenre.setBackground(new java.awt.Color(245, 245, 245));
        cbxGenre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxGenre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxGenre.setEnabled(false);

        namePanel.setBackground(new java.awt.Color(245, 245, 245));
        namePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        namePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblTitle.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblTitle.setText("jLabel7");
        namePanel.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Género ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Título ");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Autor ");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("ISBN ");

        namePanel1.setBackground(new java.awt.Color(245, 245, 245));
        namePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblAuthor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblAuthor.setText("jLabel7");
        namePanel1.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        IDPanel.setBackground(new java.awt.Color(245, 245, 245));
        IDPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        IDPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblIsbn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblIsbn.setText("jLabel7");
        IDPanel.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        cbxPublicationYear.setBackground(new java.awt.Color(245, 245, 245));
        cbxPublicationYear.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxPublicationYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxPublicationYear.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Año de publicación ");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de devolucion");

        birthDatePanel1.setBackground(new java.awt.Color(245, 245, 245));
        birthDatePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirmLoan.setBackground(new java.awt.Color(0, 123, 255));
        btnConfirmLoan.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnConfirmLoan.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmLoan.setText("Confirmar préstamo");
        btnConfirmLoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmLoanActionPerformed(evt);
            }
        });

        btnCancel1.setBackground(new java.awt.Color(220, 20, 60));
        btnCancel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancel1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel1.setText("Cancelar");
        btnCancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(namePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(IDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbxPublicationYear, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCancel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmLoan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxGenre, javax.swing.GroupLayout.Alignment.TRAILING, 0, 252, Short.MAX_VALUE)
                            .addComponent(jDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthDatePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxPublicationYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(birthDatePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmLoan)
                    .addComponent(btnCancel1))
                .addGap(38, 38, 38))
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

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnConfirmLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmLoanActionPerformed
        Date date = jDate.getDate();

        if (date == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de devolución del libro");
            return;
        }

        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        try {
            Loan loan = new Loan(user, book, loanDate, dueDate);
            controller.applyLoan(loan);
            JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente");
            this.dispose();
        } catch (LoanPastDueException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnConfirmLoanActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IDPanel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel birthDatePanel1;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnConfirmLoan;
    private javax.swing.JComboBox<String> cbxGenre;
    private javax.swing.JComboBox<String> cbxPublicationYear;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel namePanel;
    private javax.swing.JPanel namePanel1;
    // End of variables declaration//GEN-END:variables
}

package view.admin;

import controllers.BookManagementController;
import enums.Genre;
import exceptions.TitleAlreadyInUseException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import model.Book;

/**
 *
 * @author Jacobo-bc
 */
public class BookEdtingWindow extends javax.swing.JFrame {

    private final Book book;
    private final BooksWindow bw;
    private final BookManagementController controller;

    /**
     *
     * @param book el libro que se desea editar.
     * @param bw la ventana de los libros.
     */
    public BookEdtingWindow(Book book, BooksWindow bw) {
        initComponents();
        this.book = book;
        this.bw = bw;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Cierra la ventana sin cerrar el programa
        setResizable(false);
        setTitle(book.getTitle());
        controller = new BookManagementController();
        showBookInformation();
        setSpnCopiesNumber();
        setCbxPublicationYear();
        hideWarnings();
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
        jLabel1 = new javax.swing.JLabel();
        IDPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblIsbn = new javax.swing.JLabel();
        namePanel = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namePanel1 = new javax.swing.JPanel();
        txtAuthor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cbxGenre = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spnCopiesNumber = new javax.swing.JSpinner();
        cbxPublicationYear = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnUpdateBook = new javax.swing.JButton();
        titleWarning = new javax.swing.JLabel();
        IDWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("ISBN *");

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

        namePanel.setBackground(new java.awt.Color(245, 245, 245));
        namePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setBackground(new java.awt.Color(245, 245, 245));
        txtTitle.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTitle.setBorder(null);
        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTitleKeyTyped(evt);
            }
        });
        namePanel.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, -1));

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

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Título *");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Autor *");

        namePanel1.setBackground(new java.awt.Color(245, 245, 245));
        namePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAuthor.setBackground(new java.awt.Color(245, 245, 245));
        txtAuthor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtAuthor.setBorder(null);
        txtAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAuthorKeyTyped(evt);
            }
        });
        namePanel1.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, -1));

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

        cbxGenre.setBackground(new java.awt.Color(245, 245, 245));
        cbxGenre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "FICCIÓN", "NO_FICCIÓN", "MISTERIO", "CIENCIA_FICCIÓN", "FANTASÍA", "ROMANCE", "HORROR" }));
        cbxGenre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Género *");

        spnCopiesNumber.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        cbxPublicationYear.setBackground(new java.awt.Color(245, 245, 245));
        cbxPublicationYear.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxPublicationYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Año de publicación *");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Número de copias *");

        btnCancel.setBackground(new java.awt.Color(220, 20, 60));
        btnCancel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdateBook.setBackground(new java.awt.Color(0, 123, 255));
        btnUpdateBook.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnUpdateBook.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBook.setText("Actualizar");
        btnUpdateBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateBook.setFocusable(false);
        btnUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookActionPerformed(evt);
            }
        });

        titleWarning.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        titleWarning.setForeground(new java.awt.Color(255, 0, 0));
        titleWarning.setText("TITULO YA REGISTRADO");

        IDWarning.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        IDWarning.setForeground(new java.awt.Color(170, 170, 170));
        IDWarning.setText("NO EDITABLE");

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
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbxPublicationYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(namePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(IDWarning))
                                .addComponent(IDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spnCopiesNumber)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(titleWarning))
                                .addComponent(namePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxGenre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnUpdateBook, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(80, 80, 80))))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(titleWarning))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IDWarning))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPublicationYear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCopiesNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdateBook))
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

    /**
     * Realiza las modificaciones al libro
     *
     * @param evt
     */
    private void btnUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookActionPerformed
        if (hasEmptyFields()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
            return;
        }

        String isbn = lblIsbn.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        Genre genre = Genre.valueOf(cbxGenre.getSelectedItem().toString());
        int publicationYear = Integer.parseInt(cbxPublicationYear.getSelectedItem().toString());
        int copiesNumber = (int) spnCopiesNumber.getValue();

        try {
            Book updatedBook = new Book(isbn, title, author, genre, publicationYear, copiesNumber);
            controller.updateBook(updatedBook);
            bw.fillTable();
            JOptionPane.showMessageDialog(null, "Libro actualizado correctamente");
        } catch (TitleAlreadyInUseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateBookActionPerformed

    /**
     * Cancela el proceso de editar el libro.
     *
     * @param evt
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTitleKeyTyped

    private void txtAuthorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAuthorKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAuthorKeyTyped

    private void txtTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyReleased
        validateFields();
    }//GEN-LAST:event_txtTitleKeyReleased

    /**
     * Verifica si hay algun campo que falta por llenar.
     *
     * @return
     */
    private boolean hasEmptyFields() {
        return (txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty()
                || cbxGenre.getSelectedIndex() == 0 || cbxPublicationYear.getSelectedIndex() == 0 || spnCopiesNumber.getValue().toString().equals("0"));
    }

    /**
     * Modifica la estructura del comboBox que recibe el año de publicación.
     */
    private void setCbxPublicationYear() {

        int currentYear = LocalDate.now().getYear();

        for (int year = currentYear; year >= (currentYear - 400); year--) {
            cbxPublicationYear.addItem(String.valueOf(year));
        }

        cbxPublicationYear.insertItemAt("Seleccione una opción", 0);
    }

    /**
     * Modifica la estructura del spinner que recibe el número de copias.
     */
    private void setSpnCopiesNumber() {
        SpinnerNumberModel model = new SpinnerNumberModel();
        model.setMinimum(0);
        model.setMaximum(100);
        spnCopiesNumber.setModel(model);
        spnCopiesNumber.setValue(book.getCopiesNumber());
    }

    /**
     * Valida que el dato ingresado en los campos sea el deseado, en caso de que
     * no, muestra la advertencia adecuada.
     */
    private void validateFields() {
        String title = txtTitle.getText().trim();

        boolean titleInUse = controller.isTitleInUse(title);

        boolean enableBtnUpdateBook = true; // Variable para controlar el estado del botón

        if (!title.isEmpty() && !title.equals(book.getTitle()) && titleInUse) {
            titleWarning.setVisible(true);
            enableBtnUpdateBook = false;
        } else {
            titleWarning.setVisible(false);
        }

        btnUpdateBook.setEnabled(enableBtnUpdateBook);
    }

    /**
     * Oculta las advertencias que hay ante posibles errores.
     */
    private void hideWarnings() {
        titleWarning.setVisible(false);
    }

    /**
     * Muestra la información del libro que se va a editar.
     */
    private void showBookInformation() {
        lblIsbn.setText(book.getIsbn());
        txtTitle.setText(book.getTitle());
        txtAuthor.setText(book.getAuthor());
        cbxPublicationYear.setSelectedItem(book.getPublicationYear());
        cbxGenre.setSelectedItem(book.getGenre().name());
        spnCopiesNumber.setValue(book.getCopiesNumber());
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IDPanel;
    private javax.swing.JLabel IDWarning;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdateBook;
    private javax.swing.JComboBox<String> cbxGenre;
    private javax.swing.JComboBox<String> cbxPublicationYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JPanel namePanel;
    private javax.swing.JPanel namePanel1;
    private javax.swing.JSpinner spnCopiesNumber;
    private javax.swing.JLabel titleWarning;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}

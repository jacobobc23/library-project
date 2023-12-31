/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.admin;

import controllers.PdfTransactionsController;
import controllers.TransactionController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Transaction;
import model.User;

/**
 *
 * @author jacobobc
 */
public class TransactionsWindow extends javax.swing.JFrame {

    private final TransactionController controller;
    private final PdfTransactionsController pdfController;
    private final User admin;

    /**
     * Creates new form TransactionsWindow
     *
     * @param admin
     */
    public TransactionsWindow(User admin) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transacciones - " + admin.getFullName());
        this.admin = admin;
        controller = new TransactionController();
        pdfController = new PdfTransactionsController();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionsTable = new javax.swing.JTable();
        btnGenerate = new javax.swing.JButton();
        cbxTransactionType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        transactionsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(transactionsTable);

        btnGenerate.setText("GENERAR");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        cbxTransactionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Login", "Registro libro", "Edición libro", "Eliminación libro", "Registro usuario", "Edición usuario", "Eliminación usuario", "Solicitud préstamo", "Devolución préstamo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxTransactionType, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTransactionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        if (cbxTransactionType.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de reporte");
            return;
        }

        String filename;

        do {
            filename = JOptionPane.showInputDialog("Guardar como:");

            if (filename == null) {
                return;
            }

            if (filename.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del documento");
            }
        } while (filename.isEmpty());

        boolean success = false;

        switch (cbxTransactionType.getSelectedIndex()) {
            case 1:
                success = pdfController.generateLoginsPdf(filename);
                break;
            case 2:
                success = pdfController.generateRegistrationBooksPdf(filename);
                break;
            case 3:
                success = pdfController.generateUpdateBooksPdf(filename);
                break;
            case 4:
                success = pdfController.generateDeletionBooksPdf(filename);
                break;
            case 5:
                success = pdfController.generateRegistrationUsersPdf(filename);
                break;
            case 6:
                success = pdfController.generateUpdateUsersPdf(filename);
                break;
            case 7:
                success = pdfController.generateDeletionUsersPdf(filename);
                break;
            case 8:
                success = pdfController.generateRequestsLoansPdf(filename);
                break;
            case 9:
                success = pdfController.generateLoanRepaymentsPdf(filename);
                break;
            default:
                break;
        }

        if (success) {
            JOptionPane.showMessageDialog(null, "Reporte creado, revise su escritorio");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para generar el reporte");
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<Transaction> transactions = controller.listTransactions(admin.getId());
        model.setColumnIdentifiers(new Object[]{
            "ID", "Acción", "Fecha"
        });

        transactionsTable.setModel(model);

        for (Transaction transaction : transactions) {
            model.addRow(new Object[]{
                transaction.getId(),
                transaction.getActionType(),
                transaction.getTime()
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JComboBox<String> cbxTransactionType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable transactionsTable;
    // End of variables declaration//GEN-END:variables
}

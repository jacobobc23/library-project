package view.admin;

import controllers.UserManagemetController;
import exceptions.UserHasLoansException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.User;
import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class UsersWindow extends javax.swing.JFrame {

    private final User admin;
    private final UserManagemetController controller;

    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form UsersWindow
     *
     * @param admin
     */
    public UsersWindow(User admin) {
        initComponents();
        this.admin = admin;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Gestión de usuarios");
        setResizable(false);
        lblAdminName.setText(admin.getFullName());
        controller = new UserManagemetController();
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
        btnLoans = new javax.swing.JButton();
        lblUsers = new javax.swing.JLabel();
        usersPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnDeleteUser = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnUpdateUser = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();

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

        lblUsers.setBackground(new java.awt.Color(135, 178, 255));
        lblUsers.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblUsers.setForeground(new java.awt.Color(255, 255, 255));
        lblUsers.setText("       USUARIOS");
        lblUsers.setOpaque(true);

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
            .addComponent(btnLoans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        usersPanel.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setViewportView(usersTable);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Buscar:");

        btnDeleteUser.setBackground(new java.awt.Color(220, 20, 60));
        btnDeleteUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setText("Eliminar");
        btnDeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnAddUser.setBackground(new java.awt.Color(0, 123, 255));
        btnAddUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setText("Nuevo");
        btnAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnUpdateUser.setBackground(new java.awt.Color(255, 215, 0));
        btnUpdateUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnUpdateUser.setText("Editar");
        btnUpdateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout usersPanelLayout = new javax.swing.GroupLayout(usersPanel);
        usersPanel.setLayout(usersPanelLayout);
        usersPanelLayout.setHorizontalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addComponent(btnAddUser)
                        .addGap(48, 48, 48)
                        .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFilter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(129, 129, 129))
        );
        usersPanelLayout.setVerticalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usersPanelLayout.createSequentialGroup()
                        .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddUser)
                                .addComponent(btnUpdateUser)
                                .addComponent(btnDeleteUser))
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(menuBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(usersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(235, 235, 235))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(usersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnLoansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoansMouseEntered
        Color color = new Color(135, 178, 255);
        btnLoans.setBackground(color);
        btnLoans.setOpaque(true);
    }//GEN-LAST:event_btnLoansMouseEntered

    private void btnLoansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoansMouseExited
        btnLoans.setOpaque(false);
    }//GEN-LAST:event_btnLoansMouseExited

    private void btnLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoansActionPerformed
        new LoansWindow(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoansActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        new UserRegistryWindow(this).setVisible(true);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        int selected = usersTable.getSelectedRow();

        if (selected >= 0) {

            String ID = usersTable.getModel().getValueAt(selected, 0).toString();
            User user = controller.searchUser(ID);

            if (user != null) {
                new UserEditingWindow(user, this).setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
        }
    }//GEN-LAST:event_btnUpdateUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int selected = usersTable.getSelectedRow();

        if (selected >= 0) {

            String id = usersTable.getModel().getValueAt(selected, 0).toString();

            int answer = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el usuario?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);

            if (answer == 0) {
                try {
                    controller.deleteUser(id);

                    fillTable();
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");

                } catch (UserHasLoansException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");

        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        filter();
    }//GEN-LAST:event_txtFilterKeyReleased

    private void txtFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFilterKeyTyped

    public final void fillTable() {
        DefaultTableModel model = new DefaultTableModel();

        ArrayList<User> users = controller.listUsers();
        model.setColumnIdentifiers(new Object[]{
            "ID", "Nombre", "Rol", "Teléfono", "Usuario", "Contraseña"
        });

        usersTable.setModel(model);

        usersTable.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        usersTable.setRowSorter(sorter);

        for (User user : users) {
            if (!user.getId().equals(admin.getId())) {
                model.addRow(new Object[]{
                    user.getId(),
                    user.getFullName(),
                    user.getRole().toString(),
                    user.getMobileNumber(),
                    user.getUsername(),
                    user.getPassword()
                });
            }
        }
    }

    private void filter() {
        String filterText = txtFilter.getText();

        RowFilter<Object, Object> idFilter = RowFilter.regexFilter(filterText.trim(), 0);
        RowFilter<Object, Object> nameFilter = RowFilter.regexFilter("(?i)" + filterText.trim(), 1);

        sorter.setRowFilter(RowFilter.orFilter(Arrays.asList(idFilter, nameFilter)));
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBooksManagement;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoans;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdminAccount;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JPanel menuBarPanel;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}

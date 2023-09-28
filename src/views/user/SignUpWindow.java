package views.user;

import controllers.UserManagemetController;
import enums.Role;
import exceptions.MobileNumberAlreadyInUseException;
import exceptions.UserAlreadyRegisteredException;
import exceptions.UserNameAlreadyInUseException;
import javax.swing.JOptionPane;
import model.User;
import view.logIn.LogInWindow;

/**
 *
 * @author Jacobo-bc
 */
public class SignUpWindow extends javax.swing.JFrame {

    private final UserManagemetController controller;

    private boolean passwordVisible = false;

    /**
     * Creates new form UserRegistryWindow
     *
     */
    public SignUpWindow() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de usuario");
        setResizable(false);
        controller = new UserManagemetController();
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
        txtID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        namePanel = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mobileNumberPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtMobileNumber = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        passwordPanel = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        toggleBtnShowPass = new javax.swing.JToggleButton();
        btnCancel = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        IDWarning = new javax.swing.JLabel();
        mobNumWarning = new javax.swing.JLabel();
        userWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Cédula *");

        IDPanel.setBackground(new java.awt.Color(245, 245, 245));
        IDPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setBackground(new java.awt.Color(245, 245, 245));
        txtID.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtID.setBorder(null);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        IDPanel.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, 20));

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

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Nombre *");

        namePanel.setBackground(new java.awt.Color(245, 245, 245));
        namePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setBackground(new java.awt.Color(245, 245, 245));
        txtName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtName.setBorder(null);
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        namePanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, -1));

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

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Teléfono *");

        mobileNumberPanel.setBackground(new java.awt.Color(245, 245, 245));
        mobileNumberPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        mobileNumberPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtMobileNumber.setBackground(new java.awt.Color(245, 245, 245));
        txtMobileNumber.setBorder(null);
        try {
            txtMobileNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMobileNumber.setActionCommand("<Not Set>");
        txtMobileNumber.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtMobileNumber.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtMobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMobileNumberKeyReleased(evt);
            }
        });
        mobileNumberPanel.add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Usuario *");

        userPanel.setBackground(new java.awt.Color(245, 245, 245));
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBackground(new java.awt.Color(245, 245, 245));
        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUsername.setBorder(null);
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        userPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 20));

        jPanel5.setBackground(new java.awt.Color(0, 123, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        userPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Contraseña *");

        passwordPanel.setBackground(new java.awt.Color(245, 245, 245));
        passwordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setEchoChar('\u25cf');
        txtPassword.setBackground(new java.awt.Color(245, 245, 245));
        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtPassword.setBorder(null);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        passwordPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 230, -1));

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

        passwordPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        toggleBtnShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show.png"))); // NOI18N
        toggleBtnShowPass.setBorderPainted(false);
        toggleBtnShowPass.setContentAreaFilled(false);
        toggleBtnShowPass.setFocusable(false);
        toggleBtnShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleBtnShowPassActionPerformed(evt);
            }
        });
        passwordPanel.add(toggleBtnShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 30, 20));

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

        btnAddUser.setBackground(new java.awt.Color(0, 123, 255));
        btnAddUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setText("Registrar");
        btnAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUser.setFocusable(false);
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        IDWarning.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        IDWarning.setForeground(new java.awt.Color(255, 0, 0));
        IDWarning.setText("CÉDULA YA REGISTRADA");

        mobNumWarning.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        mobNumWarning.setForeground(new java.awt.Color(255, 0, 0));
        mobNumWarning.setText("TELÉFONO EN USO");

        userWarning.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        userWarning.setForeground(new java.awt.Color(255, 0, 0));
        userWarning.setText("USUARIO EN USO");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobNumWarning))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userWarning))
                    .addComponent(jLabel6)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDWarning))
                    .addComponent(IDPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mobileNumberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDWarning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mobNumWarning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mobileNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(userWarning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAddUser))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        if (hasEmptyFields()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
            return;
        }

        String id = txtID.getText().trim();
        String fullname = txtName.getText();
        Role role = Role.USER;
        String mobilenumber = txtMobileNumber.getText();
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        try {
            User user = new User(id, fullname, role, mobilenumber, username, password);
            controller.insertUser(user);
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
            returnWindow();
        } catch (UserAlreadyRegisteredException | UserNameAlreadyInUseException | MobileNumberAlreadyInUseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        returnWindow();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void toggleBtnShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleBtnShowPassActionPerformed
        passwordVisible = !passwordVisible;

        if (passwordVisible) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_toggleBtnShowPassActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        String id = txtID.getText();
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || id.length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        String name = txtName.getText().trim();
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || name.length() == 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        validateFields();
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtMobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileNumberKeyReleased
        validateFields();
    }//GEN-LAST:event_txtMobileNumberKeyReleased

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        validateFields();
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        String userName = txtUsername.getText().trim();
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) || userName.length() == 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        String pass = txtPassword.getText().trim();
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) || pass.length() == 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private boolean hasEmptyFields() {
        return (txtID.getText().isEmpty() || txtName.getText().isEmpty()
                || txtMobileNumber.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty());
    }

    private void returnWindow() {
        new LogInWindow().setVisible(true);
        this.dispose();
    }

    private void validateFields() {
        String id = txtID.getText().trim();
        String mobileNumber = txtMobileNumber.getText();
        String username = txtUsername.getText().trim();

        boolean isUserRegistered = controller.isUserRegistered(id);
        boolean isMobNumInUse = controller.isMobileNumberInUse(mobileNumber);
        boolean isUsernameInUse = controller.isUsernameInUse(username);

        boolean enableBtnAddUser = true; // Variable para controlar el estado del botón

        if (!id.isEmpty() && isUserRegistered) {
            IDWarning.setVisible(true);
            enableBtnAddUser = false;
        } else {
            IDWarning.setVisible(false);
        }

        if (!mobileNumber.isEmpty() && isMobNumInUse) {
            mobNumWarning.setVisible(true);
            enableBtnAddUser = false;
        } else {
            mobNumWarning.setVisible(false);
        }

        if (!username.isEmpty() && isUsernameInUse) {
            userWarning.setVisible(true);
            enableBtnAddUser = false;
        } else {
            userWarning.setVisible(false);
        }

        btnAddUser.setEnabled(enableBtnAddUser);
    }

    private void hideWarnings() {
        IDWarning.setVisible(false);
        mobNumWarning.setVisible(false);
        userWarning.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IDPanel;
    private javax.swing.JLabel IDWarning;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel mobNumWarning;
    private javax.swing.JPanel mobileNumberPanel;
    private javax.swing.JPanel namePanel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JToggleButton toggleBtnShowPass;
    private javax.swing.JTextField txtID;
    private javax.swing.JFormattedTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPanel userPanel;
    private javax.swing.JLabel userWarning;
    // End of variables declaration//GEN-END:variables
}

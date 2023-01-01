package login_register;

import connection.DBConnection;
import javax.swing.JOptionPane;
import swing.login.EventLogin;
import syntech.HomeMain;

public class Login extends PanelCustom {

    private EventLogin event;

    public Login() {
        initComponents();
        setAlpha(1);
    }

    public void setEventLogin(EventLogin event) {
        this.event = event;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUserName = new swing.login.TextField();
        txtPassword = new swing.login.Password();
        btnSignIn = new swing.login.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN IN");

        txtUserName.setForeground(new java.awt.Color(76, 76, 76));
        txtUserName.setDisabledTextColor(new java.awt.Color(142, 143, 145));
        txtUserName.setDoubleBuffered(true);
        txtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUserName.setHint("USER NAME");

        txtPassword.setForeground(new java.awt.Color(76, 76, 76));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setHint("PASSWORD");

        btnSignIn.setBackground(new java.awt.Color(86, 142, 255));
        btnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnSignIn.setText("SIGN IN");
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Username!");
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Password!");
        } else{
            try {
                DBConnection db = new DBConnection();
                db.getUser(txtUserName.getText(), txtPassword.getText());
               return;
            } catch (Exception e) {
            }
        }
        HomeMain home = new HomeMain();
//        this.setVisible(false);
        home.setVisible(true);
        

    }//GEN-LAST:event_btnSignInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Button btnSignIn;
    private javax.swing.JLabel jLabel1;
    private swing.login.Password txtPassword;
    private swing.login.TextField txtUserName;
    // End of variables declaration//GEN-END:variables
}

package form;

import cell.CellAction;
import cell.user.CellEmail;
import cell.user.CellPassword;
import cell.user.CellPhone;
import cell.user.CellRole;
import cell.user.CellUserID;
import cell.user.CellUserLogin;
import cell.user.CellUserName;
import component.AddUser;
import connection.DBConnection;
import java.util.ArrayList;
import model.User;

public class FormUser extends javax.swing.JPanel {

    private DBConnection databaseConnection = new DBConnection();
    private ArrayList<User> users = new ArrayList<User>();

    public FormUser() {
        initComponents();
        setOpaque(false);
        table.addTableStyle(jScrollPane1);
        users = databaseConnection.getUsers();
        initDataTable();
    }

    private void initDataTable() {
        table.addTableCell(new CellUserID(), 0);
        table.addTableCell(new CellUserName(), 1);
        table.addTableCell(new CellPhone(), 2);
        table.addTableCell(new CellEmail(), 3);
        table.addTableCell(new CellRole(), 4);
        table.addTableCell(new CellUserLogin(), 5);
        table.addTableCell(new CellPassword(), 6);
        table.addTableCell(new CellAction(), 8);
        for (int index = 0; index < users.size(); index++) {
            User user = users.get(index);
            table.addRow(user, false);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new swing.home.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.home.Table();
        btnAddUser = new swing.login.Button();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(974, 548));

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(515, 120));

        table.setBackground(new java.awt.Color(242, 231, 213));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Last name", "First name", "Phone", "Email", "Role", "User name", "Password", "Action"
            }
        ));
        table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(20);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(40);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
            table.getColumnModel().getColumn(8).setMinWidth(75);
            table.getColumnModel().getColumn(8).setPreferredWidth(75);
            table.getColumnModel().getColumn(8).setMaxWidth(75);
        }

        jTabbedPane1.addTab("All", jScrollPane1);

        btnAddUser.setBackground(new java.awt.Color(242, 231, 213));
        btnAddUser.setForeground(new java.awt.Color(109, 152, 134));
        btnAddUser.setText("+ Add");
        btnAddUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(247, 247, 247));
        jLabel1.setText("USER");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUser add = new AddUser();
//        this.setVisible(false);
        add.setVisible(true);
    }//GEN-LAST:event_btnAddUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Button btnAddUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private swing.home.RoundPanel roundPanel2;
    private swing.home.Table table;
    // End of variables declaration//GEN-END:variables
}

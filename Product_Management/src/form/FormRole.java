package form;

import cell.CellAction;
import cell.role.CellAuthority;
import cell.role.CellRoleID;
import cell.role.CellRoleName;

import connection.DBConnection;
import java.util.ArrayList;
import model.Role;

public class FormRole extends javax.swing.JPanel {
    
    private DBConnection databaseConnection = new DBConnection();
    private ArrayList<Role> roles = new ArrayList<Role>();
    
   public FormRole() {
        initComponents();
        setOpaque(false);
         table.addTableStyle(jScrollPane1);
        roles = databaseConnection.getRoles();
        initDataTable();
    }

    private void initDataTable() {
        table.addTableCell(new CellRoleID(), 0);
        table.addTableCell(new CellRoleName(), 1);
        table.addTableCell(new CellAuthority(), 2);
        table.addTableCell(new CellAction(), 3);
        for (int index = 0; index < roles.size(); index++) {
            Role role = roles.get(index);
            table.addRow(role, false);
        }
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new swing.home.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.home.Table();
        btnAddRole = new swing.login.Button();
        jLabel2 = new javax.swing.JLabel();

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(515, 120));

        table.setBackground(new java.awt.Color(242, 231, 213));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Authority", "Action"
            }
        ));
        table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jTabbedPane1.addTab("All", jScrollPane1);

        btnAddRole.setBackground(new java.awt.Color(242, 231, 213));
        btnAddRole.setForeground(new java.awt.Color(109, 152, 134));
        btnAddRole.setText("+ Add");
        btnAddRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 247, 247));
        jLabel2.setText("ROLE");

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
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRoleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Button btnAddRole;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private swing.home.RoundPanel roundPanel2;
    private swing.home.Table table;
    // End of variables declaration//GEN-END:variables
}

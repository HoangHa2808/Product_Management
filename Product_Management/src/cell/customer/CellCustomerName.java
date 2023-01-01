package cell.customer;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import connection.DBConnection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Customer;
import model.CustomerEditting;

public class CellCustomerName extends TableCustomCell {

    private Customer localCustomer;

    public CellCustomerName() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSave = new javax.swing.JButton();
        txtLastName = new swing.login.TextFieldBasic();
        txtFirstName = new swing.login.TextFieldBasic();

        cmdSave.setText("Lưu");

        txtLastName.setLabelText("Last name");

        txtFirstName.setLabelText("First name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdSave)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void addEventSave(TableCustom table) {
        cmdSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.stopCellEditing();
                int row = getRow();

                DBConnection dbc = new DBConnection();
                String id = table.getValueAt(row, 0).toString();
                String lastName = table.getValueAt(row,1).toString();
                String firstName = table.getValueAt(row,2).toString();
                String phoneNumber = table.getValueAt(row, 3).toString();
                String email = table.getValueAt(row, 4).toString();
                String address = table.getValueAt(row, 5).toString();
                localCustomer = new Customer(id, lastName, firstName, phoneNumber, email, address);
                dbc.updateCustomer(id, localCustomer);
                String st ="Last name : " + table.getValueAt(row, 1) + " First name : " + table.getValueAt(row, 2).toString();
                JOptionPane.showMessageDialog(null, st + "\nKhách hàng mới đã được cập nhật vào CSDL");
            }
        });
    }

     @Override
    public void setData(Object o) {
        if (o != null) {
            CustomerEditting d = (CustomerEditting) o;
            txtFirstName.setText(d.getFirstName());
            txtLastName.setText(d.getLastName());
        }
    }
    
    @Override
    public Object getData() {
        String lastName = txtLastName.getText().trim();
        String firstName = txtFirstName.getText().trim();
        return new CustomerEditting(lastName, firstName);
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        Customer customer = (Customer) data;
        return new CellRenderCustomer(customer);
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellCustomerName cell = new CellCustomerName();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private swing.login.TextFieldBasic txtFirstName;
    private swing.login.TextFieldBasic txtLastName;
    // End of variables declaration//GEN-END:variables
}

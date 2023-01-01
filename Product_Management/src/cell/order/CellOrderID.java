package cell.order;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import connection.DBConnection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Order;

public class CellOrderID extends TableCustomCell {

    private Order localOrder;

    public CellOrderID() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtOrderID = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel2.setForeground(new java.awt.Color(200, 200, 200));
        jLabel2.setText("Mã đơn hàng");

        cmdSave.setText("Lưu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmdSave)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                String productID = table.getValueAt(row,1).toString();
                String customerID = table.getValueAt(row,2).toString();
                int qty = Integer.parseInt(table.getValueAt(row, 3).toString());
                double price = Double.parseDouble(table.getValueAt(row, 4).toString());
                double total = Double.parseDouble(table.getValueAt(row, 5).toString());
                String discount = table.getValueAt(row, 6).toString();
                double payment = Double.parseDouble(table.getValueAt(row, 7).toString());
                String note = table.getValueAt(row, 8).toString();
                localOrder = new Order(id, productID,customerID,qty, price, total,discount, payment, note);
                dbc.updateOrder(id, localOrder);
                String st = "ID : " + table.getValueAt(row, 0).toString() + " Product ID : " + table.getValueAt(row, 1);
                JOptionPane.showMessageDialog(null, st + "\nĐơn hàng đã được cập nhật vào CSDL");
            }
        });
    }

    @Override
    public void setData(Object o) {
            txtOrderID.setText((String) o);
    }

    @Override
    public Object getData() {
        String name = txtOrderID.getText().trim();
        return name;
    }

//    @Override
//    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
//        Order order = (Order) data;
//        return new CellNameRender(product.getName());
//        return new CellRenderOrder(order);
//    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellOrderID cell = new CellOrderID();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtOrderID;
    // End of variables declaration//GEN-END:variables
}

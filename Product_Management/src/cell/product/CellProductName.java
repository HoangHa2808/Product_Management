package cell.product;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import connection.DBConnection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Product;

public class CellProductName extends TableCustomCell {

    private Product localProduct;

    public CellProductName() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();

        jLabel2.setForeground(new java.awt.Color(200, 200, 200));
        jLabel2.setText("Tên sản phẩm");

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
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                String name = table.getValueAt(row,1).toString();
                double price = Double.parseDouble(table.getValueAt(row, 2).toString());
                double sellPrice = Double.parseDouble(table.getValueAt(row, 3).toString());
                String content = table.getValueAt(row, 4).toString();
                String desctiption = table.getValueAt(row, 5).toString();
                int qty = Integer.parseInt(table.getValueAt(row, 6).toString());
                String status = table.getValueAt(row, 7).toString();
                localProduct = new Product(id, name, price, sellPrice, content, desctiption, qty, status);
                dbc.updateProduct(id, localProduct);
                String st = "ID : " + table.getValueAt(row, 0) + " Name : " + table.getValueAt(row, 1).toString();
                JOptionPane.showMessageDialog(null, st + "\nSản phẩm đã được cập nhật vào CSDL");
            }
        });
    }

    @Override
    public void setData(Object o) {
            txtName.setText((String) o);
    }

    @Override
    public Object getData() {
        String name = txtName.getText().trim();
        return name;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        Product product = (Product) data;
//        return new CellNameRender(product.getName());
        return new CellRenderProduct(product);
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellProductName cell = new CellProductName();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

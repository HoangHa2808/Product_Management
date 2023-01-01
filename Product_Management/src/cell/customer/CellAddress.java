package cell.customer;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

public class CellAddress extends TableCustomCell {

    public CellAddress() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textAreaScroll1 = new swing.login.TextAreaScroll();
        txtAddress = new swing.login.TextArea();

        textAreaScroll1.setLabelText("Địa chỉ");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        textAreaScroll1.setViewportView(txtAddress);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        txtAddress.setText(o.toString());
    }

    @Override
    public Object getData() {
        return txtAddress.getText().trim();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellAddress cell = new CellAddress();
        cell.setData(o);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.TextAreaScroll textAreaScroll1;
    private swing.login.TextArea txtAddress;
    // End of variables declaration//GEN-END:variables
}

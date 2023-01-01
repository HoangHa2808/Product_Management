package cell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

public class CellContent extends TableCustomCell {

    public CellContent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textAreaScroll1 = new swing.login.TextAreaScroll();
        txtContent = new swing.login.TextArea();

        textAreaScroll1.setLabelText("Nội dung");

        txtContent.setColumns(20);
        txtContent.setRows(5);
        textAreaScroll1.setViewportView(txtContent);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        txtContent.setText(o.toString());
    }

    @Override
    public Object getData() {
        return txtContent.getText().trim();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellContent cell = new CellContent();
        cell.setData(o);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.TextAreaScroll textAreaScroll1;
    private swing.login.TextArea txtContent;
    // End of variables declaration//GEN-END:variables
}

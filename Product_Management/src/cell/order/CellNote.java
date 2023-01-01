package cell.order;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

public class CellNote extends TableCustomCell {

    public CellNote() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textAreaScroll1 = new swing.login.TextAreaScroll();
        txtNote = new swing.login.TextArea();

        textAreaScroll1.setLabelText("Chú thích");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        textAreaScroll1.setViewportView(txtNote);

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
        txtNote.setText(o.toString());
    }

    @Override
    public Object getData() {
        return txtNote.getText().trim();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellNote cell = new CellNote();
        cell.setData(o);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.TextAreaScroll textAreaScroll1;
    private swing.login.TextArea txtNote;
    // End of variables declaration//GEN-END:variables
}

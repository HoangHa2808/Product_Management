package model;

import com.raven.table.model.TableRowData;

public class Category extends TableRowData {

    private String name, productID, categoryID;

    public Category() {
    }

    public Category(String name, String productID, String categoryID) {
        this.name = name;
        this.productID = productID;
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }


    @Override
    public Object[] toTableRow() {
        return new Object[]{name, productID, categoryID};
    }
}


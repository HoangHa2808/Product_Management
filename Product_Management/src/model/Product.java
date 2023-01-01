package model;

import com.raven.table.model.TableRowData;

public class Product extends TableRowData {

    private String productID;
    private String name;
    private double price, sellPrice;
    private String content, description;
    private int qty;
    private String status;

    public Product() {
    }

    public Product(String productID, String name, double price, double sellPrice, String content, String description, int qty, String status) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.sellPrice = sellPrice;
        this.content = content;
        this.description = description;
        this.qty = qty;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{productID, name, price, sellPrice, content, description, qty, status};
    }
}

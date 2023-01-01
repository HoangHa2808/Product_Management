package model;

import com.raven.table.model.TableRowData;

public class Order extends TableRowData{
    private String id, productID, customerID;
    private int qty;
    private double price, total;
    private String discount;
    private double payment;
    private String note;

    public Order() {
    }

    public Order(String id, String productID, String customerID, int qty, double price, double total, String discount, double payment, String note) {
        this.id = id;
        this.productID = productID;
        this.customerID = customerID;
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.discount = discount;
        this.payment = payment;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

     @Override
    public Object[] toTableRow() {
        return new Object[]{id, productID, customerID, qty, price, total, discount, payment, note};
    }
}

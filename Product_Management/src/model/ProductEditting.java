package model;

public class ProductEditting{

    private String productID, name;

    public ProductEditting() {
    }

    public ProductEditting(String productID, String name) {
        this.productID = productID;
        this.name = name;
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
    
    @Override
    public String toString() {
        return name;
    }
}

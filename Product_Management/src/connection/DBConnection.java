package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Category;
import model.Customer;
import model.Product;
import model.UserLogin;
import model.Order;
import model.Role;
import model.User;

public class DBConnection {

    private String connectionUrl = "jdbc:sqlserver://AdminPC\\MSSQLSERVER02:1433;encrypt=true;databaseName=Product_Management;user=summer;password=123456;encrypt=true;trustServerCertificate=true";
    private String selectSql;

    private void connect() {
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            statement.executeUpdate(selectSql);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="getProduct">
    public ArrayList<Product> getProducts() {
        ResultSet producttSet = null;
        selectSql = "SELECT * FROM Product";
        ArrayList<Product> products = new ArrayList<Product>();
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            producttSet = statement.executeQuery(selectSql);
            while (producttSet.next()) {
                System.out.println(producttSet.getString(2) + " " + producttSet.getString(3));
                products.add(convertResultSetProduct(producttSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    private Product convertResultSetProduct(ResultSet productSet) {
        try {
            String id = productSet.getString(1);
            String name = productSet.getString(2);
            double price = productSet.getDouble(3);
            double sellPrice = productSet.getDouble(4);
            String content = productSet.getString(5);
            String description = productSet.getString(6);
            int qty = productSet.getInt(7);
            String status = productSet.getString(8);
            return new Product(id, name, price, sellPrice, content, description, qty, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Product();
    }

    public void insertProduct(String id, Product product) {
        selectSql = "Insert into Product(ID, NameP, Price, SellPrice, Content, Descriptions, Qty, Statu) Values('" + product.getProductID() + "',N'"
                + product.getName() + "','"
                + product.getPrice() + "','"
                + product.getSellPrice() + "',N'"
                + product.getContent() + "', N'"
                + product.getDescription() + "','"
                + product.getQty() + "',N'"
                + product.getStatus() + "')";

        connect();
    }

    public void updateProduct(String id, Product product) {
        selectSql = "UPDATE Product SET nameP = '" + product.getName()
                + "',price = " + product.getPrice()
                + ",sellPrice = " + product.getSellPrice()
                + ",content = '" + product.getContent()
                + "',descriptions = N'" + product.getDescription()
                + "',qty = " + product.getQty()
                + ",statu = '" + product.getStatus() + "' WHERE id = '" + id + "'";
        connect();
    }

    public void deleteProduct(String id) {
        selectSql = "DELETE FROM Product WHERE id = '" + id + "'";
        connect();

    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getCategories">
    public ArrayList<Category> getCategories() {
        ResultSet categorySet = null;
        String selectSql = "SELECT * FROM Product_Category";
        ArrayList<Category> categories = new ArrayList<Category>();
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            categorySet = statement.executeQuery(selectSql);
            while (categorySet.next()) {
                System.out.println(categorySet.getString(2) + " " + categorySet.getString(3));
                categories.add(convertResultSetCategory(categorySet));
            }
        } // Handle any errors that may have occurred. // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return categories;
    }

    private Category convertResultSetCategory(ResultSet categorySet) {
        try {
            String name = categorySet.getString(1);
            String productID = categorySet.getString(2);
            String categoryID = categorySet.getString(3);
            return new Category(name, productID, categoryID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Category();
    }

    public void insertCategory(String id, Category category) {
        selectSql = "Insert into Category(ID, productID, customerID, Qty, Total, Price, Discount, InvoicePayment, Note) Values('" + category.getName() + "','"
                + category.getProductID() + "','"
                + category.getCategoryID() + "')";

        connect();
    }

    public void deleteCategory(String id) {
        selectSql = "DELETE FROM Category WHERE id = '" + id + "'";
        connect();
    }

//    public void updateCategory(String id, Category category) {
//        String selectSql = "UPDATE ProductCategory SET descrition = N'" + category.getDescription()
//                + "',productID = " + category.getProductID()
//                + ",categoryID = " + category.getCategoryID()
//                + "',name = '" + category.getName()
//                + "' WHERE id = '" + id + "'";
////        ArrayList<Product> products = new ArrayList<Product>();
//        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
//            statement.executeUpdate(selectSql);
//        } // Handle any errors that may have occurred. // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
// </editor-fold>
    // <editor-fold desc="Login">
    public UserLogin getUser(String username, String password) {
        ResultSet userSet = null;
        String selectSql = "SELECT * FROM Users\n"
                + "WHERE username = '" + username + "' AND passwords = '" + password + "'";
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            userSet = statement.executeQuery(selectSql);
            ArrayList<UserLogin> users = new ArrayList<>();
            while (userSet.next()) {
                System.out.println(userSet.getString(2) + " " + userSet.getString(3));
                users.add(convertResultSetUserLogin(userSet));
            }

            return users.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private UserLogin convertResultSetUserLogin(ResultSet userSet) {
        try {
            String username = userSet.getString(1);
            String password = userSet.getString(2);
            return new UserLogin(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UserLogin();
    }// </editor-fold>

    // <editor-fold desc="getOrder">
    public ArrayList<Order> getOrders() {
        ResultSet orderSet = null;
        String selectSql = "SELECT * FROM Orders";
        ArrayList<Order> orders = new ArrayList<Order>();
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            orderSet = statement.executeQuery(selectSql);
            while (orderSet.next()) {
                System.out.println(orderSet.getString(2) + " " + orderSet.getString(3));
                orders.add(convertResultSetOrder(orderSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return orders;
    }

    private Order convertResultSetOrder(ResultSet ordersSet) {
        try {
            String id = ordersSet.getString(1);
            String productID = ordersSet.getString(2);
            String customerID = ordersSet.getString(3);
            int qty = ordersSet.getInt(4);
            double price = ordersSet.getDouble(5);
            double total = ordersSet.getDouble(6);
            String discount = ordersSet.getString(7);
            double payment = ordersSet.getDouble(8);
            String note = ordersSet.getString(9);
            return new Order(id, productID, customerID, qty, price, total, discount, payment, note);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Order();
    }

//    public void increaseIDOrder(String id, Order order) {
//        String incrtSql = "BEIN DECLARE @ID VARCHAR(5) DECLARE @MAX INT "
//                + "SELECT @MAX=COUNT(ID)+1 FROM Orders WEHRE ID LIKE 'HD' SET @ID='HD' + RIGHT('0' + CAST(@MAX AS VARCHER(3)), 3)"
//                + "WHILE(EXISTS(SELECT ID FROM Orders WHERE ID=@ID))"
//                + "BEGIN SET @ID=@ID+1 SET @MAX='HD' + RIGHT('0' + CAST(@MAX AS VARCHAR(3)),3)"
//                + "END SELECT @ID END";
//        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
//            statement.executeQuery(incrtSql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }

    public void insertOrder(String id, Order order) {
        selectSql = "Insert into Orders(ID, productID, customerID, Qty, Total, Price, Discount, InvoicePayment, Note) Values('" + order.getId() + "','"
                + order.getProductID() + "','"
                + order.getCustomerID() + "',"
                + order.getQty() + ",'"
                + order.getTotal() + "','"
                + order.getPrice() + "',N'"
                + order.getDiscount() + "','"
                + order.getPayment() + "',N'"
                + order.getNote() + "')";

        connect();
    }

    public void updateOrder(String id, Order order) {
        selectSql = "UPDATE Orders SET price = " + order.getPrice()
                + ",qty = " + order.getQty()
                + ",total = " + order.getTotal()
                + ",discount = '" + order.getDiscount()
                + "',payment = N'" + order.getPayment()
                + "',note = N'" + order.getNote() + "' WHERE id = '" + id + "'";
        connect();
    }

    public void deleteOrder(String id) {
        selectSql = "DELETE FROM Orders WHERE id = '" + id + "'";
        connect();

    }// </editor-fold>

    // <editor-fold desc="getCustomer">
    public ArrayList<Customer> getCustomer() {
        ResultSet customerSet = null;
        String selectSql = "SELECT * FROM Customer";
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            customerSet = statement.executeQuery(selectSql);
            while (customerSet.next()) {
                System.out.println(customerSet.getString(2) + " " + customerSet.getString(3));
                customers.add(convertResultSetCustomer(customerSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return customers;
    }

    private Customer convertResultSetCustomer(ResultSet customerSet) {
        try {
            String id = customerSet.getString(1);
            String lastName = customerSet.getString(2);
            String firstName = customerSet.getString(3);
            String phoneNumber = customerSet.getString(4);
            String email = customerSet.getString(5);
            String address = customerSet.getString(6);
            return new Customer(id, lastName, firstName, phoneNumber, email, address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Customer();
    }

    public void insertCustomer(String id, Customer customer) {
        selectSql = "Insert into Customer(ID, LastName, FirstName, Phone, Email, Addres) Values('" + customer.getID() + "',N'"
                + customer.getLastName() + "',N'"
                + customer.getFirstName() + "','"
                + customer.getPhoneNumber() + "',N'"
                + customer.getEmail() + "', N'"
                + customer.getAddress() + "')";

        connect();
    }

    public void updateCustomer(String id, Customer customer) {
        selectSql = "UPDATE Customer SET lastName = N'" + customer.getLastName()
                + "',firstName = N'" + customer.getFirstName()
                + "',phoneNumber = '" + customer.getPhoneNumber()
                + "',email = N'" + customer.getEmail()
                + "',address = N'" + customer.getAddress() + "' WHERE id = '" + id + "'";
        connect();
    }

    public void deleteCustomer(String id) {
        selectSql = "DELETE FROM Customer WHERE id = '" + id + "'";
        connect();
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getUser">
    public ArrayList<User> getUsers() {
        ResultSet userSet = null;
        String selectSql = "SELECT * FROM Users";
        ArrayList<User> users = new ArrayList<User>();
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            userSet = statement.executeQuery(selectSql);
            while (userSet.next()) {
                System.out.println(userSet.getString(2) + " " + userSet.getString(3));
                users.add(convertResultSetUser(userSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    private User convertResultSetUser(ResultSet userSet) {
        try {
            String id = userSet.getString(1);
            String lastName = userSet.getString(2);
            String firstName = userSet.getString(3);
            String phoneNumber = userSet.getString(4);
            String email = userSet.getString(5);
            String role = userSet.getString(6);
            String userName = userSet.getString(7);
            String password = userSet.getString(8);
            return new User(id, lastName, firstName, phoneNumber, email, role, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User();
    }

    public void insertUser(String id, User user) {
        selectSql = "Insert into Users(ID, LastName, FirstName, Phone, Email, Role, UserName, Password) Values('" + user.getId() + "',N'"
                + user.getLastName() + "',N'"
                + user.getFirstName() + "','"
                + user.getPhoneNumber() + "',N'"
                + user.getEmail() + "', '"
                + user.getRole() + "',N'"
                + user.getUserName() + "',N'"
                + user.getPassword() + "')";

        connect();
    }

    public void updateUser(String id, User user) {
        selectSql = "UPDATE Users SET lastName = N'" + user.getLastName()
                + "',firstName = " + user.getFirstName()
                + ",phone = " + user.getPhoneNumber()
                + ",email = '" + user.getEmail()
                + "',role = N'" + user.getRole()
                + "',userName = " + user.getUserName()
                + ",password = '" + user.getPassword() + "' WHERE id = '" + id + "'";
        connect();
    }

    public void deleteUser(String id) {
        selectSql = "DELETE FROM Product WHERE id = '" + id + "'";
        connect();
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getRole">
    public ArrayList<Role> getRoles() {
        ResultSet roleSet = null;
        String selectSql = "SELECT * FROM Roles";
        ArrayList<Role> roles = new ArrayList<Role>();
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  Statement statement = connection.createStatement();) {
            roleSet = statement.executeQuery(selectSql);
            while (roleSet.next()) {
                System.out.println(roleSet.getString(2) + " " + roleSet.getString(3));
                roles.add(convertResultSetRole(roleSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return roles;
    }

    private Role convertResultSetRole(ResultSet roleSet) {
        try {
            String id = roleSet.getString(1);
            String name = roleSet.getString(2);
            String authority = roleSet.getString(3);
            return new Role(id, name, authority);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Role();
    }

    public void insertRole(String id, Role role) {
        selectSql = "Insert into Roles(ID, NameP, Price, SellPrice, Content, Descriptions, Qty, Statu) Values('" + role.getId() + "',N'"
                + role.getName() + "','"
                + role.getAuthority() + "')";
        connect();
    }

    public void updateRole(String id, Role role) {
        selectSql = "UPDATE Roles SET name = '" + role.getName()
                + "',authourity = " + role.getAuthority() + "' WHERE id = '" + id + "'";
        connect();
    }

    public void deleteRole(String id) {
        selectSql = "DELETE FROM Roles WHERE id = '" + id + "'";
        connect();

    }// </editor-fold>
}

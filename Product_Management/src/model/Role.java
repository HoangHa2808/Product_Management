package model;

import com.raven.table.model.TableRowData;

public class Role extends TableRowData {

    private String id, name, authority;

    public Role() {
    }

    public Role(String id, String name, String authority) {
        this.id = id;
        this.name = name;
        this.authority = authority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

   
    @Override
    public Object[] toTableRow() {
        return new Object[]{id, name, authority};
    }
}


package dataBase;

import models.Address;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDao extends DataBaseAccess {
    public AddressDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public int saveAddress(Address address) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sql = String.format("insert into `address` (`city`,`street`,`allay`,`house_number`,`post_code`) values ('%s','%s','%s','%d','%s')"
                    , address.getCity(), address.getStreet(), address.getAlley(), address.getHouseNumber(), address.getPostCode());
            return statement.executeUpdate(sql);
        } else return -1;

    }

}


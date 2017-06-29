package productos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.jws.WebService;

/**
 *
 * @author Lic. Alexis Ayala Solorio
 */
@WebService(serviceName = "ProductsWS")
public class ProductsWS {

    public Collection<ProductsDetails> getDetails(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
         
        try {
             
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/dbproducts","root","");
            stmt=conn.createStatement();
            String sql="select * from productos";
            rs=stmt.executeQuery(sql);
            Collection<ProductsDetails> details=new ArrayList<ProductsDetails>();
            while(rs.next()){
                ProductsDetails pd=new ProductsDetails();
                pd.setId(rs.getString(1));
                pd.setName(rs.getString(2));
                pd.setDescription(rs.getString(3));
                pd.setUnit(rs.getString(4));
                pd.setPrice(rs.getString(5));
                pd.setStock(rs.getString(6));
                details.add(pd);
            }
            return details;
        } 
        catch(ClassNotFoundException c){
            c.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
         
        return null;
    }
}
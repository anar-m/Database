package jdbcTesting;

import java.sql.*;

public class JDBC_Query01 {

    // Sizden bir JDBC sorgusu yapmanız istendiğinde ilk yapacağınız iş:

    // Database yöneticisinden ilgili database bilgilerini (database access information) almak olmalidir.

    /*
       URL:  "jdbc:mysql://45.87.83.5/u168183796_qawonder",
         USERNAME:  "wonderworld_qawcollegeuser",
           PASSWORD : "1gvyfx6#Q");
    */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. Adım olarak: Kullanılacak veritabanı için doğru sürücüyü ekle

        Class.forName("com.mysql.jdbc.Driver");

        // 2. Adım olarak : Veritabanı ile iletişimi başlat

        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qawonder",
                "u168183796_qawonderuser",
                "1gvyfx6#Q");

        // 3. Adım : SQL ifadeleri oluştur ve çalıştır (select, Insert/ Update/delete)

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // Bir statement oluşturmak için MUTLAKA bit connection'ınızın olması gerekli.
        // Statement oluşturmak için bizim sorgumuz için yeterli olabilir ancak ileride bu
        // statementi kullanmak istediğimizde cagırabilmek için onu bit yere atadık.

        // 4.Adım olarak : Sql sorgularını çalıştır ve gelen sonuçları işle, kaydet vb.

        String query = "SELECT name FROM u168183796_qawonder.staff";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

        System.out.println(resultSet.getString("name"));

       resultSet.first();
        System.out.println(resultSet.getString("name"));

        resultSet.absolute(10);
        System.out.println(resultSet.getString("name"));




    }


}

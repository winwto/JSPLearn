package dao;

import java.sql.*;

public class DbDao {
    private Connection conn;
    private String driver;
    private String url;
    private String username;
    private String pass;

    public DbDao(){
    }

    public DbDao(String driver, String url, String username, String pass){
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.pass = pass;
    }

    /**
     * 插入记录
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public boolean insert(String sql, Object... args) throws Exception {
        PreparedStatement preparedStatement = getConn().prepareStatement(sql);
        for (int i = 0; i < args.length; i++){
            preparedStatement.setObject(i + 1, args[i]);
        }
        if(preparedStatement.executeUpdate() != 1) return false;
        return true;
    }

    /**
     * 执行查询
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement preparedStatement = getConn().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        return preparedStatement.executeQuery();
    }

    /**
     * 执行修改
     * @param sql
     * @param args
     * @throws SQLException
     */
    public void moidfy(String sql, Object... args) throws Exception {
        PreparedStatement preparedStatement = this.getConn().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void closeConn() throws SQLException {
        if(conn != null && !conn.isClosed()){
            conn.close();
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection getConn() throws Exception {
        if (conn == null){
            setConn(this.conn);
        }
        return conn;
    }

    public void setConn(Connection conn) throws Exception {
        if (conn == null){
            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.url, this.username, this.pass);
        }
    }
}

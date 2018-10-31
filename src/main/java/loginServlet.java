import dao.DbDao;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebService(name="login")
public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String err = "";
        String userName = request.getParameter("username");
        String pass = request.getParameter("pass");
        RequestDispatcher requestDispatcher;
        DbDao dbDao = new DbDao("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ssh","root","asd123456");
        try {
            ResultSet rs = dbDao.query("SELECT u_password FROM user_info WHERE u_name = ?", userName);
            if (rs.next()){
                if (rs.getString("u_password").equals(pass)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", userName);
                    requestDispatcher = request.getRequestDispatcher("/userinf.jsp");
                    requestDispatcher.forward(request,response);
                } else {
                    err += "您输入的密码不正确，请重新输入";
                }
            } else {
                err += "您的用户名不存在，请先注册";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (err != null && !err.equals("")){
            requestDispatcher = request.getRequestDispatcher("/login.jsp");
            request.setAttribute("err", err);
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}

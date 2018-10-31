package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

@WebServlet(name = "TimerServlet")
public class TimerServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        Timer timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(new Date());
            }
        });
        timer.start();
    }
}

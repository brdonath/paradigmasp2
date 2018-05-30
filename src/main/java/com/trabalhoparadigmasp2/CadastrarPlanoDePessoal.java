package com.trabalhoparadigmasp2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class CadastrarPlanoDePessoal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement stmt;
        Connection connection = null;
        try {
            connection = DBConnection.get();
            stmt = connection.createStatement();

            String sql = String.format("INSERT INTO planopessoal " +
                            "(reqfuncionario,quantidade,habilidades,reqlegislativos,reqservicos,reqproducao) VALUES ('%s','%s','%s','%s','%s','%s')",
                    req.getParameter("reqfuncionario"),
                    req.getParameter("quantidade"),
                    req.getParameter("habilidades"),
                    req.getParameter("reqlegislativos"),
                    req.getParameter("reqservicos"),
                    req.getParameter("reqproducao"));
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            DBConnection.close();
        }

        resp.setContentType("text/html");
        req.getRequestDispatcher("/").forward(req, resp);
    }
}

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
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/trabalhoparadigmasp2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        //  Database credentials
        final String USER = "root";
        final String PASS = "root";

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = String.format("INSERT INTO planopessoal " +
                            "(reqfuncionario,quantidade,habilidades,reqlegislativos,reqservicos,reqproducao) VALUES ('%s','%s','%s','%s','%s','%s')",
                    req.getParameter("reqfuncionario"),
                    req.getParameter("quantidade"),
                    req.getParameter("habilidades"),
                    req.getParameter("reqlegislativos"),
                    req.getParameter("reqservicos"),
                    req.getParameter("reqproducao"));
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        resp.setContentType("text/html");
        req.getRequestDispatcher("/").forward(req, resp);
    }
}

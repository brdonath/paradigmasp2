package com.trabalhoparadigmasp2;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastrarCurriculo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT `curriculo`.`idcurriculo`,\n" +
                    "    `curriculo`.`nome`,\n" +
                    "    `curriculo`.`bday`,\n" +
                    "    `curriculo`.`cpf`,\n" +
                    "    `curriculo`.`ecivil`,\n" +
                    "    `curriculo`.`genero`,\n" +
                    "    `curriculo`.`email`,\n" +
                    "    `curriculo`.`tel`,\n" +
                    "    `curriculo`.`formacao`,\n" +
                    "    `curriculo`.`experiencia1`,\n" +
                    "    `curriculo`.`experiencia2`,\n" +
                    "    `curriculo`.`experiencia3`,\n" +
                    "    `curriculo`.`idioma1`,\n" +
                    "    `curriculo`.`idioma2`,\n" +
                    "    `curriculo`.`pretensaosalarial`,\n" +
                    "    `curriculo`.`maisinfo`\n" +
                    "FROM `trabalhoparadigmasp2`.`curriculo`;";
            ResultSet rs = stmt.executeQuery(sql);

            List<Map<String, String>> res = new ArrayList<>();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                Map<String, String> row = new HashMap<>();

                row.put("idcurriculo", rs.getString("idcurriculo"));
                row.put("nome", rs.getString("nome"));
                row.put("bday", rs.getString("bday"));
                row.put("cpf", rs.getString("cpf"));
                row.put("ecivil", rs.getString("ecivil"));
                row.put("genero", rs.getString("genero"));
                row.put("email", rs.getString("email"));
                row.put("tel", rs.getString("tel"));
                row.put("formacao", rs.getString("formacao"));
                row.put("experiencia1", rs.getString("experiencia1"));
                row.put("experiencia2", rs.getString("experiencia2"));
                row.put("experiencia3", rs.getString("experiencia3"));
                row.put("idioma1", rs.getString("idioma1"));
                row.put("idioma2", rs.getString("idioma2"));
                row.put("pretensaosalarial", rs.getString("pretensaosalarial"));
                row.put("maisinfo", rs.getString("maisinfo"));


                res.add(row);
            }

            req.setAttribute("result", res);
            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        resp.setContentType("text/html");
        req.getRequestDispatcher("/curriculos.jsp").forward(req, resp);
    }

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
            sql = String.format("INSERT INTO curriculo(nome,bday,cpf,ecivil,genero,email,tel,formacao,experiencia1,experiencia2,experiencia3,idioma1,idioma2,pretensaosalarial,maisinfo) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    req.getParameter("nome"),
                    req.getParameter("bday"),
                    req.getParameter("cpf"),
                    req.getParameter("ecivil"),
                    req.getParameter("genero"),
                    req.getParameter("email"),
                    req.getParameter("tel"),
                    req.getParameter("formacao"),
                    req.getParameter("experiencia1"),
                    req.getParameter("experiencia2"),
                    req.getParameter("experiencia3"),
                    req.getParameter("idioma1"),
                    req.getParameter("idioma2"),
                    req.getParameter("pretensaosalarial"),
                    req.getParameter("maisinfo"));
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

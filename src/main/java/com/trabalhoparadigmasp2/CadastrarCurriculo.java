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

        Statement stmt;
        Connection connection = null;
        try {
            connection = DBConnection.get();
            stmt = connection.createStatement();

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
            while (rs.next()) {
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
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            DBConnection.close();
        }

        resp.setContentType("text/html");
        req.getRequestDispatcher("/curriculos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement stmt;
        Connection connection = null;
        try {
            connection = DBConnection.get();
            stmt = connection.createStatement();
            String sql = String.format("INSERT INTO curriculo(nome,bday,cpf,ecivil,genero,email,tel,formacao,experiencia1,experiencia2,experiencia3,idioma1,idioma2,pretensaosalarial,maisinfo) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
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
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            DBConnection.close();
        }

        resp.setContentType("text/html");
        req.getRequestDispatcher("/").forward(req, resp);
    }
}

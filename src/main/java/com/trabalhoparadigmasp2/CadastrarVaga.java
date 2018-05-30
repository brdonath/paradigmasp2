package com.trabalhoparadigmasp2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastrarVaga extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Statement stmt;
        Connection connection = null;
        try {
            connection = DBConnection.get();
            stmt = connection.createStatement();

            String sql = "SELECT `vaga`.`idvaga`,\n" +
                    "    `vaga`.`titulo`,\n" +
                    "    `vaga`.`departamento`,\n" +
                    "    `vaga`.`descricao`,\n" +
                    "    `vaga`.`local`,\n" +
                    "    `vaga`.`bday`,\n" +
                    "    `vaga`.`escolaridade`,\n" +
                    "    `vaga`.`linguas`,\n" +
                    "    `vaga`.`experienciaminima`,\n" +
                    "    `vaga`.`outrasexigencias`,\n" +
                    "    `vaga`.`benecicios1`,\n" +
                    "    `vaga`.`pretensaosalarial`,\n" +
                    "    `vaga`.`email`,\n" +
                    "    `vaga`.`tel`,\n" +
                    "    `vaga`.`benecicios2`,\n" +
                    "    `vaga`.`benecicios3`\n" +
                    "FROM `trabalhoparadigmasp2`.`vaga`;\n";
            ResultSet rs = stmt.executeQuery(sql);

            List<Map<String, String>> res = new ArrayList<>();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                Map<String, String> row = new HashMap<>();

                row.put("idvaga", rs.getString("idvaga"));
                row.put("titulo", rs.getString("titulo"));
                row.put("departamento", rs.getString("departamento"));
                row.put("descricao", rs.getString("descricao"));
                row.put("local", rs.getString("local"));
                row.put("bday", rs.getString("bday"));
                row.put("escolaridade", rs.getString("escolaridade"));
                row.put("linguas", rs.getString("linguas"));
                row.put("experienciaminima", rs.getString("experienciaminima"));
                row.put("outrasexigencias", rs.getString("outrasexigencias"));
                row.put("benecicios1", rs.getString("benecicios1"));
                row.put("pretensaosalarial", rs.getString("pretensaosalarial"));
                row.put("email", rs.getString("email"));
                row.put("tel", rs.getString("tel"));
                row.put("benecicios3", rs.getString("benecicios3"));
                row.put("benecicios2", rs.getString("benecicios2"));

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
        req.getRequestDispatcher("/vagas.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement stmt;
        Connection connection = null;
        try {
            connection = DBConnection.get();
            stmt = connection.createStatement();

            String sql = String.format("INSERT INTO vaga(titulo,departamento,descricao,local,bday,escolaridade,linguas,experienciaminima,outrasexigencias,benecicios1, benecicios2,benecicios3,pretensaosalarial,email,tel)VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    req.getParameter("titulo"),
                    req.getParameter("departamento"),
                    req.getParameter("descricao"),
                    req.getParameter("local"),
                    req.getParameter("bday"),
                    req.getParameter("escolaridade"),
                    req.getParameter("linguas"),
                    req.getParameter("experienciaminima"),
                    req.getParameter("outrasexigencias"),
                    req.getParameter("benecicios1"),
                    req.getParameter("benecicios2"),
                    req.getParameter("benecicios3"),
                    req.getParameter("pretensaosalarial"),
                    req.getParameter("email"),
                    req.getParameter("tel"));
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

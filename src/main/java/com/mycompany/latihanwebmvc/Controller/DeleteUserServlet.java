/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanwebmvc.Controller;

/**
 *
 * @author helmy
 */
import java.io.IOException; //import class DBUtil

import jakarta.servlet.ServletException; //import class User dari Package Model
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mycompany.latihanwebmvc.Database.DBUtil;
import java.sql.*;


@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
         try (Connection conn = DBUtil.getConnection()) {
             String query = "DELETE FROM users WHERE id = ?";
             try (PreparedStatement stmt = conn.prepareStatement(query)) {
                 stmt.setInt(1, userId);
                 stmt.executeUpdate();
             }
             response.sendRedirect("/userList");
         } catch (SQLException e) {
             e.printStackTrace();
             response.sendRedirect("error.jsp");
         }
    }
}

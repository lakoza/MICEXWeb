/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anneke;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
public class ServletDHX extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("Cp1251");

        // Устанавливаем MIME
        response.setContentType("text/html;charset=UTF-8");

        //request.getRequestDispatcher("/WEB-INF/paging.html").forward(request, response);
       PrintWriter out = response.getWriter();
        PageFactory factory = new PageFactory();
        out.println(factory.getPage());
    }

}

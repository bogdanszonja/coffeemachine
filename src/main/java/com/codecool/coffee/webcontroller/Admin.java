package com.codecool.coffee.webcontroller;

import com.codecool.coffee.coffeshop.Coffee;
import com.codecool.coffee.coffeshop.Order;
import com.codecool.coffee.coffeshop.Room;
import com.codecool.coffee.sql.SQLConnection;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Deque;


@WebServlet(urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        engine.process("admin.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain; charset=UTF-8");

        Deque<Order> allOrder = SQLConnection.getAllOrders();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orders", allOrder);

        response.getWriter().write(jsonObject.toString());

    }

}


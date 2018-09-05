package com.codecool.coffee.webcontroller;

import com.codecool.coffee.coffeshop.*;
import com.codecool.coffee.sql.SQLConnection;
import netscape.javascript.JSObject;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.activity.InvalidActivityException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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

        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject requestJSONObject = new JSONObject(jb.toString());

        String action = requestJSONObject.getString("action");
        if (action.equals("get_orders")) {
            Deque<Order> allOrder = SQLConnection.getAllOrders();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("orders", allOrder);
            response.getWriter().write(jsonObject.toString());
        } else if (action.equals("get_coffeemachine_levels")) {
            int waterLevel = CoffeeMachine.getInstance().getWaterLevel();
            int beanLevel = CoffeeMachine.getInstance().getCoffeeBeanLevel();
            int groundLevel = CoffeeMachine.getInstance().getRemainingGroundLevel();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("water", waterLevel);
            jsonObject.put("bean", beanLevel);
            jsonObject.put("ground", groundLevel);
            response.getWriter().write(jsonObject.toString());
        } else if (action.equals("make_order")) {
            int id = requestJSONObject.getInt("order_id");
            JSONObject jsonObject = new JSONObject();
            try {
                Barista.getInstance().brewCoffee(id);
                jsonObject.put("success", true);

            } catch (InvalidActivityException e) {
                jsonObject.put("success", false);
                jsonObject.put("message", "Maintain coffe machine before making the order");
            }
            response.getWriter().write(jsonObject.toString());
        }

    }
}


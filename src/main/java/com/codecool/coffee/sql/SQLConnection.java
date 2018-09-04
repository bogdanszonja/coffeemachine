package com.codecool.coffee.sql;

import com.codecool.coffee.coffeshop.Coffee;
import com.codecool.coffee.coffeshop.CoffeeMachine;
import com.codecool.coffee.coffeshop.Order;
import com.codecool.coffee.coffeshop.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class SQLConnection {
    private static final Logger logger = LoggerFactory.getLogger(SQLConnection.class);

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost/" + System.getenv("db_name");
    private static final String USER = System.getenv("db_user");
    private static final String PASS = System.getenv("db_password");

    private static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
            logger.warn("JDBC connection haven't been established");
        }
        return conn;
    }

    public static void addNewOrder(Order order){
        Connection conn = getConn();
        PreparedStatement ps = null;
        String query = "INSERT INTO orders (costumer_name, costumer_room, coffe_type, order_time) VALUES (?, ?, ?, ?) RETURNING id";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, order.getCustomerName());
            ps.setString(2, order.getCustomerRoom().name());
            ps.setString(3, order.getCoffeeType().name());
            ps.setTimestamp(4, new Timestamp(order.getOrderTime().getTime()));
            ResultSet rs = ps.executeQuery();
            rs.next();
            order.setId(rs.getInt("id"));
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(ps!=null)
                    ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Deque<Order> getAllOrders(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        String query = "SELECT id, costumer_name, costumer_room, coffe_type, order_time FROM orders WHERE completed = false ORDER BY order_time";
        Deque<Order> orders = new ArrayDeque<>();
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String costumerName = rs.getString("costumer_name");
                Coffee coffeeType = Coffee.valueOf(rs.getString("coffe_type"));
                Date orderTime = new Date(rs.getTimestamp("order_time").getTime());
                Room costumerRoom = Room.valueOf(rs.getString("costumer_room"));
                orders.add(new Order(id, costumerName, coffeeType, orderTime, costumerRoom));
            }
            return orders;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(ps!=null)
                    ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void markOrderAsCompleted(Order order){
        markOrderAsCompleted(order.getId());
    }

    public static void markOrderAsCompleted(int id){
        Connection conn = getConn();
        PreparedStatement ps = null;
        String query = "UPDATE orders SET completed=true WHERE id=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(ps!=null)
                    ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static Order getPriorityOrder(){
        Connection conn = getConn();
        PreparedStatement ps = null;
        String query = "SELECT id, costumer_name, costumer_room, coffe_type, order_time FROM orders " +
                       "WHERE completed = false " +
                       "ORDER BY order_time " +
                       "LIMIT 1";
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int id = rs.getInt("id");
            String costumerName = rs.getString("costumer_name");
            Coffee coffeeType = Coffee.valueOf(rs.getString("coffe_type"));
            Date orderTime = new Date(rs.getTimestamp("order_time").getTime());
            Room costumerRoom = Room.valueOf(rs.getString("costumer_room"));
            Order priorityOrder = new Order(id, costumerName, coffeeType, orderTime, costumerRoom);
            return priorityOrder;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(ps!=null)
                    ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

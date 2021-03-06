package org.repository;
import org.model.Customer;
import java.sql.DriverManager;


import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class CustomerRepositoryDB {
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banking?user=root&password=student");
            PreparedStatement ps = conn.prepareStatement("SELECT customer_id,name,city from customers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getString("customer_id"),
                        rs.getString("name"),
                        rs.getString("city"));

                customers.add(customer);
            }}
        catch(SQLException e)
            {
                e.printStackTrace();
            }
            return customers;
        }

    }

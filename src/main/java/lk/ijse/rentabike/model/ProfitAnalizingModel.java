package lk.ijse.rentabike.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProfitAnalizingModel {

    public static Map<String, Double> profitanalysis(){
        Map<String, Double> profits = new HashMap<>();
        try {
            // Connect to the billing table in the database using JDBC
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentabike", "root", "1234");
            Statement statement = con.createStatement();

            // Create four variables to store the profits for Today, This week, This month, and This year
            double todayProfit = 0;
            double thisWeekProfit = 0;
            double thisMonthProfit = 0;
            double thisYearProfit = 0;

            // Retrieve all the payments from the billing table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Payment");

            // Get today's date
            LocalDate today = LocalDate.now();

            while (resultSet.next()) {
                // Get the payment date and amount
                LocalDate paymentDate = resultSet.getDate("paymentDate").toLocalDate();
                double profit = resultSet.getDouble("paymentAmount");

                // Calculate the profit
                //double profit = price - cost;

                // Add the profit to the corresponding variable based on its date range
                if (paymentDate.equals(today)) {
                    todayProfit += profit;
                }
                if (paymentDate.isAfter(today.minusDays(7))) {
                    thisWeekProfit += profit;
                }
                if (paymentDate.isAfter(today.minusDays(30))) {
                    thisMonthProfit += profit;
                }
                if (paymentDate.isAfter(today.minusDays(365))) {
                    thisYearProfit += profit;
                }
            }

            // Store the profits in the map
            profits.put("Today", todayProfit);
            profits.put("This week", thisWeekProfit);
            profits.put("This month", thisMonthProfit);
            profits.put("This year", thisYearProfit);

            // Close the database connection
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return the map of profits
        return profits;
    }
}

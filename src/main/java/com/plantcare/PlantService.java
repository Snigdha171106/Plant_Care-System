package com.plantcare;

import java.sql.*;
import java.util.Scanner;

public class PlantService 
{

    private final Scanner scanner = new Scanner(System.in); 

    public void addPlant() 
    {
        try (Connection connection = DBConnection.getConnection()) 
        {

            System.out.print("Plant Name: ");
            String name = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            System.out.print("Sunlight Requirement: ");
            String sunlight = scanner.nextLine();

            System.out.print("Water Schedule: ");
            String waterSchedule = scanner.nextLine();

            System.out.print("Soil Type: ");
            String soilType = scanner.nextLine();

            String query = "INSERT INTO plants (name, category, sunlight, water_schedule, soil_type) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, category);
            statement.setString(3, sunlight);
            statement.setString(4, waterSchedule);
            statement.setString(5, soilType);

            statement.executeUpdate();
            System.out.println("Plant added successfully.\n");

        } 
        catch (SQLException e) 
        {
            System.out.println("Error while adding plant: " + e.getMessage());
        }
    }

    public void showPlantCareInfo() 
    {
        try (Connection connection = DBConnection.getConnection()) 
        {

            System.out.print("Enter plant name to view details: ");
            String plantName = scanner.nextLine();

            String query = "SELECT * FROM plants WHERE name ILIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, plantName);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("\nPlant Name: " + result.getString("name"));
                System.out.println("Category: " + result.getString("category"));
                System.out.println("Sunlight: " + result.getString("sunlight"));
                System.out.println("Water Schedule: " + result.getString("water_schedule"));
                System.out.println("Soil Type: " + result.getString("soil_type") + "\n");
            } else {
                System.out.println("No plant found with that name.\n");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching plant info: " + e.getMessage());
        }
    }

    public void listAllPlants() {
        try (Connection connection = DBConnection.getConnection()) {

            String query = "SELECT id, name FROM plants ORDER BY id";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            System.out.println("\nList of all plants:");
            while (result.next()) {
                System.out.println("ID: " + result.getInt("id") + " - " + result.getString("name"));
            }
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Error listing plants: " + e.getMessage());
        }
    }
}
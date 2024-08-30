package com.kgisl.csv;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.kgisl.csv.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;

public class Vehicledb {
    public static void main(String[] args) throws Exception {
 
    String fileName = "D:\\csv\\Vehicle.csv";
     
        List<Vehicle> vehicles = new CsvToBeanBuilder(new FileReader(fileName)).withType(Vehicle.class).build().parse();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Vehiclehouse", "root", "");
        String sql = "INSERT INTO Vehicle (id,namee,date,district,registration_Number,price,milage) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        for(Vehicle vehicle: vehicles){
 
            statement.setInt(1, vehicle.getId());
            statement.setString(2, vehicle.getName());
            statement.setString(3, vehicle.getDate());
            statement.setString(4, vehicle.getDistrict());
            statement.setString(5, vehicle.getRegistrationNumber());
            statement.setInt(6, vehicle.getPrice());
            statement.setInt(7, vehicle.getMilage());


            statement.addBatch();
        }
        statement.executeBatch();
 
        String sql2 = "select * from Vehicle";
        ResultSet rs = statement.executeQuery(sql2);
        List<Vehicle> list = new ArrayList<>();
        while (rs.next()) {
            Vehicle obj = new Vehicle();
            obj.setId(rs.getInt(1));
            obj.setName(rs.getString(2));
            obj.setDate(rs.getString(3));
            obj.setDistrict(rs.getString(4));
            obj.setRegistrationNumber(rs.getString(5));
            obj.setPrice(rs.getInt(6));
            obj.setMilage(rs.getInt(7));
 
            list.add(obj);
        }
        
         Map<String, List<Vehicle>> vehiclesByDistrict = list.stream()
                .collect(Collectors.groupingBy(Vehicle::getDistrict));

        // Printing the grouped result
        System.out.println("Group by District");
        vehiclesByDistrict.forEach((district, vehicleList) -> {
            System.out.println("District: " + district);
            vehicleList.forEach(System.out::println);
        });

        System.out.println("vehicles that start with the letter 'S'");
        List<Vehicle> filteredVehicles2 = vehicles.stream()
        .filter(v -> v.getName().startsWith("S"))
        .collect(Collectors.toList());

         filteredVehicles2.forEach(System.out::println);
         System.out.println("Vehicles with a price above 1 lakh");
         List<Vehicle> filteredVehicles = vehicles.stream()
         .filter(v -> v.getPrice() > 100000)
         .collect(Collectors.toList());

       filteredVehicles.forEach(System.out::println);
 
        System.out.println("Vehicles registered in Coimbatore with the price range of 50000 - 90000 and milage above 50");       
         List<Vehicle> filteredVehicles1 = vehicles.stream()
            .filter(vehicle -> vehicle.getDistrict().equalsIgnoreCase("Coimbatore"))
            .filter(vehicle -> vehicle.getPrice() >= 50000 && vehicle.getPrice() <= 90000)
            .filter(vehicle -> vehicle.getMilage() > 50)
            .collect(Collectors.toList());
        filteredVehicles1.forEach(System.out::println);
        
        System.out.println("Vehicles starting with 'H'and registration in Mumbai with milage >60 :");
        List<Vehicle> list1 = new ArrayList<>();
        Map<String, List<Vehicle>> groupedVehicles = vehicles.stream()
                .filter(v -> v.getName().startsWith("H"))
                .filter(v -> v.getDistrict().equalsIgnoreCase("Mumbai"))
                .filter(v -> v.getMilage() > 60)
                .collect(Collectors.groupingBy(Vehicle::getName));

        groupedVehicles.forEach((name, vehicleList) -> {
            System.out.println("Vehicle Name: " + name);
            vehicleList.forEach(System.out::println);
        });
        



}
}

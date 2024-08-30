package com.kgisl.csv;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class VehicleCsvExample {

    public static void main(String[] args) throws IOException {

        String fileName = "Vehicle.csv";

        List<Vehicle> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Vehicle.class)
                .build()
                .parse();

        beans.forEach(System.out::println);

    }

}

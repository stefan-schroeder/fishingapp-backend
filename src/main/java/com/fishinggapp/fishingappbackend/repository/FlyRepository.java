package com.fishinggapp.fishingappbackend.repository;

import com.fishinggapp.fishingappbackend.model.FlyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FlyRepository {
    private static final String DATABASE_NAME = "/database/flies/Flies 1-169CSV.csv";
    private static final String NEW_LINE = System.lineSeparator();
    private static final Logger LOG = LoggerFactory.getLogger(FlyRepository.class);
    public FlyRepository() {
        File file = new File(DATABASE_NAME);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }



    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public void save(FlyData fly) throws Exception {
        FlyData f = findByUsername(fly.id());
        if(c != null) {
            throw new
                    Exception("This username already exists. " +
                    "Please choose another one.");
        }
        Path path = Paths.get(DATABASE_NAME);
        String data = customer.username() + ","
                + customer.password()// (THIS IS ONLY TEMPORARY!)
                // we should never store the plain password.
                // In the next step in this lab,
                // we will encode the password
                //before saving it to the file
                + "," + customer.email();
        appendToFile(path, data + NEW_LINE);
    }

    public List<Customer> findAll() throws IOException {
        List<Customer> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            if(!line.trim().isEmpty()) {
                //TODO
            }
        }
        return result;
    }

    public Customer findByUsername(String username) throws IOException {
        List<Customer> customers = findAll();
        for(Customer customer : customers) {
            if (customer.username().trim().equalsIgnoreCase(username.trim())) {
                return customer;
            }
        }
        return null;
    }
}

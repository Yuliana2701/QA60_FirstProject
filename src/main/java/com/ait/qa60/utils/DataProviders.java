package com.ait.qa60.utils;

import com.ait.qa60.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {



    @DataProvider
    public Iterator<Object[]> addNewUsers() {
        List<Object[]> list = new ArrayList<>();
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        list.add(new Object[]{new User("Ivanov", "Ivan", "ivan" + i + "@test.com", "Password123!", "male")});
        list.add(new Object[]{new User("Petrova", "Anna", "anna" + i + "@test.com", "Password123!", "female")});
        list.add(new Object[]{new User("Smith", "John", "john" + i + "@test.com", "Password123!", "male")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user_registration_data.csv")));

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0]).
                    setLastName(split[1]).setEmail(split[2]).setPassword(split[3])
                    .setGender(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}



package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContacts {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Molly")
                        .phone("34562562587")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()

        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Molly")
                        .lastName("Tony")
                        .phone("34544444444")
                        .email("molly@gmail.com")
                        .address("NY")
                        .build()

        });

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Molly")
                        .phone("123")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()

        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Molly")
                        .phone("1232226566464646489484848451")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()

        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Molly")
                        .phone("wwwwwwwwwwwww")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()

        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Tony")
                        .lastName("Molly")
                        .phone("")
                        .email("tony@gmail.com")
                        .address("NY")
                        .description("Friend")
                        .build()

        });

        return list.iterator();
    }
}

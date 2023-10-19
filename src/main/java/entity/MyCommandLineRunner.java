package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    AppUser appUser;
    @Override
    public void run(String... args) throws Exception {

    }
}

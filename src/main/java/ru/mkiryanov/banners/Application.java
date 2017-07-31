package ru.mkiryanov.banners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.mkiryanov.banners.controller.BannersRestController;

/**
 * @author maksim-kiryanov
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public BannersRestController bannersRestController() {
        return new BannersRestController();
    }
}

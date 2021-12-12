package hu.unideb.inf.demo.food;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FoodStartConfig {

    @Bean
    CommandLineRunner commandLineRunner(FoodRepository foodRepository) {
        return args -> {
            Food alma = new Food(
                    "Alma",
                    "Gyimilcs",
                    200L,
                    3L
            );

            Food pizza = new Food(
                    "Pizza",
                    "Olasz etel",
                    3000l,
                    5l
            );
            foodRepository.saveAll(
                    List.of(alma, pizza)
            );
        };
    }
}

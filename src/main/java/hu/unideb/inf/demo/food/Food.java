package hu.unideb.inf.demo.food;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @SequenceGenerator(
            name = "food_sequence",
            sequenceName = "food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Long cost;
    private Long rating;

    public Food(String name, String description, Long cost, Long rating) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
    }
}

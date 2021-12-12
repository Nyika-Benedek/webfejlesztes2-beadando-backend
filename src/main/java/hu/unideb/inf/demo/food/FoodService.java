package hu.unideb.inf.demo.food;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Objects;


@Component
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public void addNewFood(Food food) {
        foodRepository.save(food);
        //System.out.println(food + "has been saved to the database");
    }

    public void deleteFood(Long foodId) {
        boolean isExist = foodRepository.existsById(foodId);
        if (!isExist){
            throw new IllegalStateException("Food does not exists: " + foodId + "{foodId}");
        }
        else
            foodRepository.deleteById(foodId);
    }

    @Transactional
    public Food updateFood(Long foodId, String name, String description, Long cost, Long rating) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new IllegalStateException("food with id "+ foodId + " does not exist"));

        if (name != null && name.length() > 0L && !Objects.equals(food.getName(), name)){
            food.setName(name);
        }
        if (description != null && description.length() > 0 && !Objects.equals(food.getDescription(), description)){
            food.setDescription(description);
        }
        if (cost != null && cost > 0L && !Objects.equals(food.getCost(), cost)){
            food.setCost(cost);
        }
        if (rating != null && rating > 0L && !Objects.equals(food.getRating(), rating)){
            food.setRating(rating);
        }
        return food;
    }
}

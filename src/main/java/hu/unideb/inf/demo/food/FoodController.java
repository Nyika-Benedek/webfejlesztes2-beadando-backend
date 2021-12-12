package hu.unideb.inf.demo.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "foods")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getFoods() {
        return foodService.getFoods();
    }

    @PostMapping
    public Food addNewFood(@RequestBody Food food){
        foodService.addNewFood(food);
        return food;
    }

    @DeleteMapping(path = "{foodId}")
    public void deleteFood(@PathVariable("foodId") Long foodId) {
        foodService.deleteFood(foodId);
    }


    @PutMapping(path = "{foodId}")
    public Food updateFood(
            @PathVariable("foodId") Long foodId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Long cost,
            @RequestParam(required = false) Long rating) {
        return foodService.updateFood(foodId, name, description, cost, rating);
    }
}

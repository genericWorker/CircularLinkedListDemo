import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MenuPlanner {
    List<String> menu = Arrays.asList(
            "Thai Chicken Salad",
            "Salmon and Brussel Sprouts",
            "Chipotle Bowl",
            "Taco Salad",
            "Chicken Caesar Wrap",
            "Stuffed Peppers",
            "Sushi",
            "Veggie Frittata",
            "Asian Chopped Salad",
            "Curry Chicken Soup",
            "Quick and Simple Thai Chickpea Curry",
            "Veggie Burgers",
            "Spinach Feta Salmon Burgers",
            "Teriyaki Stir-Fried",
            "Pesto Chicken Wrap",
            "Fahita Bowl",
            "Chicken Pasta",
            "Steak Whole Wheat Burrito",
            "Balsamic Chicken and Veggies",
            "Sweet Potatoes and Roasted Tofu",
            "Cilantro Lime Chicken"
    );

    public static void main(String[] args) {
     MenuPlanner mp = new MenuPlanner();
     mp.testMenuPlanner();
    }

    public void testMenuPlanner() {

        List<List<String>> weeklyMenus = generateMenus(menu, 10);

        for (int i = 0; i < weeklyMenus.size(); i++) {
            System.out.println("Week " + (i + 1) + " Menu:");
            for (String item : weeklyMenus.get(i)) {
                System.out.println(item);
            }
            System.out.println();
        }
    }

    public List<List<String>> generateMenus(List<String> menu, int numWeeks) {
        // List of weekmenu lists
        List<List<String>> weeksMenus = new ArrayList<>();
        Random random = new Random();
        List<String> weekMenu;
        List<String> remainingItems = new ArrayList<>(menu);

        for (int week = 0; week < numWeeks; week++) {
            weekMenu = new ArrayList<>();
            while (weekMenu.size() < 7) {
                //  Find a random meal
                String item = remainingItems.get(random.nextInt(remainingItems.size()));
                // Don't allow duplicate meals but otherwise add a meal umtil 7 meals found
                if (!weekMenu.contains(item)) {
                    weekMenu.add(item);
                }
            }
            // Add the week of meals of the list menu weeks
            weeksMenus.add(weekMenu);
            // Replenish the remaining items list for the next week, don't include this week
            remainingItems.addAll(menu);
            remainingItems.removeAll(weekMenu);
        }
        return weeksMenus;
    }
}

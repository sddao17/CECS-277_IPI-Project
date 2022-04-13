
import java.util.ArrayList;

/**
 *
 * @author Alexander Loo, Phoenix Ngan, Steven Dao
 * @version 1.0
 * Due Date: February 17, 2021, 2:00pm
 *
 * * Purpose:  Demonstrate Inheritance/Polymorphism/Interface by writing software
 *          in support of a Dessert Shop which sells candy by the pound, cookies
 *          by the dozen, ice cream, and sundaes (ice cream with a topping).
 *
 *          To do this, implement an inheritance hierarchy of classes derived
 *          from a DessertItem superclass.
 *          Then, modify the DessertItem class to implement the Comparable
 *          interface, and define a static max method in the DessertItem class
 *          for finding the larger of two DessertItem objects.
 * Target Output: Demonstrate the concepts above through extensive testing of every constructor and method.
 */

public class MainTest {

    /**
     * Tests all methods/constructors of the Checkout/DessertItem classes and its subclasses.
     * @param args command-line arguments for the application of type String array
     */
    public static void main(String[] args) {
        // ArrayList to test default/null constructors
        ArrayList<DessertItem> testingDefaultConstructors = new ArrayList<DessertItem>() {
            {
                //add(new DessertItem());   - does not work: abstract classes cannot be instantiated
                add(new Candy());
                add(new Cookie());
                add(new IceCream());
                add(new Sundae());
            }
        };
        // ArrayList to test overloaded constructors
        ArrayList<DessertItem> testingOverloadedConstructors = new ArrayList<DessertItem>() {
            {
              /*
                  Candies
               */
                add(new Candy("Starbursts", 110, 0.11, 6.14));
                add(new Candy("Reese's Peanut Butter Cups", 2342, 3.79, 8.99));
                add(new Candy("White Chocolate-flavored Peppermint-swirled Gumballs", 775, 0.73, 11.13));
              /*
                  Cookies
               */
                add(new Cookie("Lemon Meringue Pie Macaroons", 1347, 15, 31));
                add(new Cookie("Red Velvet Cookies", 660, 3, 24));
              /*
                  Ice creams
               */
                add(new IceCream("Pistachio Ice Cream", 504, 4.40));
                add(new IceCream("French Vanilla Bean Ice Cream", 1848, 16.6));
              /*
                  Sundaes
               */
                add(new Sundae("Raspberry Rose", 438, 7,
                        "Sprinkles", 0.75, 77));
                add(new Sundae("Lithuanian Banana Split", 860, 14,
                        "Extra Caramel Fudge", 2, 260));
            }
        };

      /*
          Begin testing methods/constructors
      */
        System.out.println("---------------------------------------------------"
                + "-------------------");

        // creating the Checkout instance, named register
        Checkout register = new Checkout();

        // testing default constructors
        for (DessertItem dessertItem : testingDefaultConstructors) {
            register.enterItem(dessertItem);
        }

        // calling toString method to print the receipt
        System.out.println(register);

        System.out.println("---------------------------------------------------"
                + "-------------------");

        // testing clear()
        register.clear();
        System.out.println(register);

        System.out.println("---------------------------------------------------"
                + "-------------------");
        // testing overloaded constructors
        for (DessertItem dessertItem : testingOverloadedConstructors) {
            register.enterItem(dessertItem);
        }

        System.out.println(register);

        System.out.println("---------------------------------------------------"
                + "-------------------");

        //Calories
        ArrayList<DessertItem> Food = new ArrayList<DessertItem>() {
            {
                //add(new DessertItem());   - does not work: abstract classes cannot be instantiated
                add(new Candy("Gummy Worms", 200, .5, 5));
                add(new Cookie("Chocolate Chip Cookies", 500, 2, 10));
                add(new IceCream("Vanilla Ice Cream", 300, 5));
                add(new Sundae("Oreo Sundae", 600, 8.50, "Oreos", 1.00, 60));
            }
        };

        for(int i = 0; i <= Food.size() - 1; i++) {
            Food.get(i).unsortedCalories();
        }

        System.out.println();

        //Food.get(0);
        System.out.println(Food.get(1).getCalories() + Food.get(1).getName());
        System.out.println(Food.get(2).getCalories() + Food.get(2).getName());
        System.out.println(DessertItem.max(Food.get(1),Food.get(2)).getName());
        System.out.println(DessertItem.max(Food.get(2), Food.get(1)).getName());
    }
}

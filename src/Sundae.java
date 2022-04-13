
import java.text.DecimalFormat;

public class Sundae extends IceCream {

    private String topping;
    private double toppingCost;
    private int toppingCalories;

    /**
     * Null default constructor for the Sundae class.
     */
    public Sundae() {
        super();
        super.setName("(Sundae)");
        topping = "(Topping)";
        toppingCost = 0;
        toppingCalories = 0;
    }
    /**
     * Overloaded (+6) constructor for the Sundae class.
     * Initializes Sundae data.
     * @param name the name of the Sundae
     * @param calories the amount of calories of the Sundae
     * @param cost the cost of the Sundae
     * @param newTopping the name of the topping
     * @param newToppingCost the cost of the topping
     * @param newToppingCalories the calories of the topping
     */
    public Sundae(String name, int calories, double cost, String newTopping, double newToppingCost,
                  int newToppingCalories) {
        super(name, calories + newToppingCalories, cost);
        super.setName(name + "(Sundae)");
        topping = newTopping + "(Topping)";
        toppingCost = newToppingCost;
        toppingCalories = newToppingCalories;
    }
    /**
     * Returns the cost of the Sundae.
     * @return the cost of the IceCream plus the cost of the toppings
     */
    public double getCost(){
        return super.getCost() + toppingCost;
    }
    /**
     * Returns the name of the topping.
     * @return the name of the topping
     */
    public String getTopping() {
        return topping;
    }
    /**
     * Sets the new topping and updates the calorie count of the DessertItem.
     * @param newTopping the new topping
     * @param newToppingCost the new cost of the topping
     * @param newToppingCalories the calories of the new topping
     */
    public void setTopping(String newTopping, double newToppingCost, int newToppingCalories) {
        super.setCalories(super.getCalories() - toppingCalories + newToppingCalories);
        topping = newTopping;
        toppingCost = newToppingCost;
        toppingCalories = newToppingCalories;
    }
    /**
     * Overriding toString method that outputs a description for the receipt
     * @return a description of the Sundae including its name and description of the topping, if any
     */
    public String toString() {
        // format the prices so that they always show 2 decimal places
        DecimalFormat df2 = new DecimalFormat("#0.00");
        // use StringBuilder to avoid warning of string concatenation in loops
        StringBuilder description = new StringBuilder("\n\t");
        // a tracker that helps monitor whether a word will overflow into the next line
        StringBuilder currentLine = new StringBuilder();

        // separate the words in the Sundae name and separate them into new lines if the name is too long
        String[] wordsInName = getName().split(" ");
        int numOfWords = wordsInName.length;

        // if the name is too long, separate the name into new lines
        for (int i = 0; i < numOfWords; ++i) {
            // if it's the first word in the name
            if (i == 0) {
                // if it's the only word in the name
                if (numOfWords <= 1) {
                    description.append(wordsInName[i]).append("\n\t");
                }
                // else, it is the first but not the only word in the name
                else {
                    description.append(wordsInName[i]);
                }
                currentLine.append(wordsInName[i]);
            }
            // if there is enough room in the line for another word
            else if (i != numOfWords - 1 && currentLine.length() + wordsInName[i].length() < 26) {
                description.append(" ").append(wordsInName[i]);
                currentLine.append(" ").append(wordsInName[i]);
            }
            // if the word would cause overflow into the next line
            else if (i != numOfWords - 1) {
                description.append("\n\t").append(wordsInName[i]);
                currentLine.delete(0, currentLine.length());
                currentLine.append(wordsInName[i]);
            }
            // else, it is the last word in the name
            else {
                // if there is enough room for adding the word and (Sundae) to the end of the string
                if (currentLine.length() + wordsInName[i].length() < 26) {
                    description.append(" ");
                    currentLine.append(" ");
                }
                // else, adding the word and (Sundae) would cause overflow
                else {
                    description.append("\n\t");
                    currentLine.delete(0, currentLine.length());
                }
                description.append(wordsInName[i]).append("\n\t");
                currentLine.append(wordsInName[i]);
            }
        }

        // reset the tracker of the current line
        currentLine.delete(0, currentLine.length());

        // separate the words in the Topping name and separate them into new lines if the name is too long
        wordsInName = topping.split(" ");
        numOfWords = wordsInName.length;

        // if the name is too long, separate the name into new lines
        for (int i = 0; i < numOfWords; ++i) {
            // if it's the first word in the name
            if (i == 0) {
                description.append(" + ").append(wordsInName[i]);
                currentLine.append(" + ").append(wordsInName[i]);
            }
            // if there is enough room in the line for another word
            else if (i != numOfWords - 1 && currentLine.length() + wordsInName[i].length() < 23) {
                description.append(" ").append(wordsInName[i]);
                currentLine.append(" ").append(wordsInName[i]);
            }
            // if the word would cause overflow into the next line
            else if (i != numOfWords - 1) {
                description.append("\n\t").append(wordsInName[i]);
                currentLine.delete(0, currentLine.length());
                currentLine.append(wordsInName[i]);
            }
            // else, it is the last word in the name
            else {
                // if there is enough room for adding the word and (Topping) to the end of the string
                if (currentLine.length() + wordsInName[i].length() < 23) {
                    description.append(" ");
                    currentLine.append(" ");
                }
                // else, adding the word and (Topping) would cause overflow
                else {
                    description.append("\n\t   ");
                    currentLine.delete(0, currentLine.length());
                    currentLine.append("   ");
                }
                description.append(wordsInName[i]);
                currentLine.append(wordsInName[i]);
            }
        }
        description.append(String.format("%-" + (34 - currentLine.length()) + "s$", ""))
                .append(df2.format(getCost()));

        return description.toString();
    }
}

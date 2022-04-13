
import java.text.DecimalFormat;

public class Candy extends DessertItem {

    private double weight;
    private double pricePerPound;

    /**
     * Null default constructor for the Candy class.
     */
    public Candy() {
        super("(Candy)", 0);
        weight = 0;
        pricePerPound = 0;
    }
    /**
     * Overloaded (+4) constructor for the Candy class.
     * Initializes Candy data.
     * @param name the name of the Candy
     * @param calories the amount of calories of the Candy
     * @param newWeight the weight of the Candy in pounds
     * @param newPricePerPound the price per pound of the Candy
     */
    public Candy(String name, int calories, double newWeight, double newPricePerPound) {
        super(name + "(Candy)", calories);
        weight = newWeight;
        pricePerPound = newPricePerPound;
    }
    /**
     * Returns the total cost of the Candy.
     * @return the total cost of the Candy
     */
    public double getCost() {
        return weight * pricePerPound;
    }
    /**
     * Returns the weight of the Candy.
     * @return the weight of the Candy
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Returns the price per pound of the Candy.
     * @return the price per pound of the Candy
     */
    public double getPricePerPound() {
        return pricePerPound;
    }
    /**
     * Sets the weight of the Candy.
     * @param newWeight the new weight of the candy
     */
    public void setWeight(double newWeight) {
        weight = newWeight;
    }
    /**
     * Sets the new price per pound of the Candy.
     * @param newPricePerPound the new price per pound of the candy
     */
    public void setPricePerPound(double newPricePerPound) {
        pricePerPound = newPricePerPound;
    }
    /**
     * Overriding toString method that outputs a description for the receipt
     * @return a description of the Candy including its name, weight, price per pound, and price
     */
    public String toString() {
        // format the prices so that they always show 2 decimal places
        DecimalFormat df2 = new DecimalFormat("#0.00");
        // use StringBuilder to avoid warning of string concatenation in loops
        StringBuilder description = new StringBuilder("\n\t");
        // a tracker that helps monitor whether a word will overflow into the next line
        StringBuilder currentLine = new StringBuilder();

        // separate the words in the name and separate them into new lines if the name is too long
        String[] wordsInName = getName().split(" ");
        int numOfWords = wordsInName.length;

        // if the name is too long, separate the name into new lines
        for (int i = 0; i < numOfWords; ++i) {
            // if it's the first word in the name
            if (i == 0) {
                description.append(wordsInName[i]);
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
                // if there is enough room for adding the word and (Candy) to the end of the string
                if (currentLine.length() + wordsInName[i].length() < 26) {
                    description.append(" ");
                    currentLine.append(" ");
                }
                // else, adding the word and (Candy) would cause overflow
                else {
                    description.append("\n\t");
                    currentLine.delete(0, currentLine.length());
                }
                description.append(wordsInName[i]);
                currentLine.append(wordsInName[i]);
            }
        }
        description.append(String.format("\n\t %-4s lbs. @ $%-5s / lb.%10s", weight, pricePerPound, "$"))
                .append(df2.format(getCost()));

        return description.toString();
    }
}

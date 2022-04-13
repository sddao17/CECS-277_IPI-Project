
import java.text.DecimalFormat;

public class IceCream extends DessertItem {

    private double cost;

    /**
     * Null default constructor for the IceCream class.
     */
    public IceCream() {
        super("(IceCream)", 0);
        cost = 0;
    }
    /**
     * Overloaded (+3) constructor for the IceCream class.
     * Initializes IceCream data.
     * @param name the name of the IceCream
     * @param calories the amount of calories of the IceCream
     * @param newCost the cost of the IceCream
     */
    public IceCream(String name, int calories, double newCost) {
        super(name + "(IceCream)", calories);
        cost = newCost;
    }
    /**
     * Returns the cost of the IceCream.
     * @return the cost of the IceCream
     */
    public double getCost(){
        return cost;
    }
    /**
     * Sets the cost of the IceCream.
     * @param newCost the new cost of the IceCream
     */
    public void setCost(double newCost) {
        cost = newCost;
    }
    /**
     * Overriding toString method that outputs a description for the receipt
     * @return a description of the IceCream including its name, calories, and cost
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
                // if there is enough room for adding the word and (IceCream) to the end of the string
                if (currentLine.length() + wordsInName[i].length() < 26) {
                    description.append(" ");
                    currentLine.append(" ");
                }
                // else, adding the word and (IceCream) would cause overflow
                else {
                    description.append("\n\t");
                    currentLine.delete(0, currentLine.length());
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


import java.text.DecimalFormat;

public class Cookie extends DessertItem {

    private int numOfCookies;
    private double pricePerDozen;

    /**
     * Null default constructor for the Candy class.
     */
    public Cookie() {
        super("(Cookie)", 0);
        numOfCookies = 0;
        pricePerDozen = 0;
    }
    /**
     * Overloaded (+4) constructor for the Cookie class.
     * Initializes Cookie data.
     * @param name the name of the Cookie
     * @param calories the amount of calories of the Cookie
     * @param newNumOfCookies the number of Cookies
     * @param newPricePerDozen the price per dozen of Cookies
     */
    public Cookie(String name, int calories, int newNumOfCookies, double newPricePerDozen) {
        super(name + "(Cookie)", calories);
        numOfCookies = newNumOfCookies;
        pricePerDozen = newPricePerDozen;
    }
    /**
     * Returns the total cost of the Cookie.
     * @return the total cost of the Cookie
     */
    public double getCost(){
        return numOfCookies * (pricePerDozen / 12);
    }
    /**
     * Returns the number of Cookies.
     * @return the number of Cookies
     */
    public double getNumOfCookies() {
        return numOfCookies;
    }
    /**
     * Returns the price per dozen of Cookies.
     * @return the price per dozen of Cookies.
     */
    public double getPricePerDozen() {
        return pricePerDozen;
    }
    /**
     * Sets the number of Cookies.
     * @param newNumOfCookies the new number of Cookies.
     */
    public void setNumOfCookies(int newNumOfCookies) {
        numOfCookies = newNumOfCookies;
    }
    /**
     * Sets the new price per dozen of Cookies.
     * @param newPricePerDozen the new price per dozen of Cookies
     */
    public void setPricePerDozen(double newPricePerDozen) {
        pricePerDozen = newPricePerDozen;
    }
    /**
     * Overriding toString method that outputs a description for the receipt
     * @return a description of the Cookie including its name, quantity, and price per dozen
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
                // if there is enough room for adding the word and (Cookie) to the end of the string
                if (currentLine.length() + wordsInName[i].length() < 26) {
                    description.append(" ");
                    currentLine.append(" ");
                }
                // else, adding the word and (Cookie) would cause overflow
                else {
                    description.append("\n\t");
                    currentLine.delete(0, currentLine.length());
                }
                description.append(wordsInName[i]);
                currentLine.append(wordsInName[i]);
            }
        }
        description.append(String.format("\n\t x%3s @ $%-5s / dozen%13s", numOfCookies, df2.format(pricePerDozen), "$"))
                .append(df2.format(getCost()));

        return description.toString();
    }
}


import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Creates a Checkout instance with an empty list of DessertItem's.
 */
public class Checkout {
    private final ArrayList<DessertItem> cart;
    double taxRate;
    /**
     * Default constructor.
     * Creates a Checkout instance with an empty list of DessertItem's.
     */
    public Checkout() {
        cart = new ArrayList<>();
        taxRate = 0.07;
    }
    /**
     *  Clears the Checkout to begin checking out a new set of items.
     */
    public void clear() {
        cart.clear();
    }
    /**
     * A DessertItem is added to the end of the list of items.
     */
    public void enterItem(DessertItem item) {
        cart.add(item);
    }
    /**
     *  Returns the number of DessertItem's in the list.
     */
    public int numberOfItems() {
        return cart.size();
    }
    /**
     * Returns total cost of items in cents (without tax).
     * @return total cost of items in cents (without tax)
     */
    public int totalCost() {
        double totalCost = 0;

        for (DessertItem item : cart) {
            totalCost += item.getCost();
        }
        // convert the total from double to int & dollars to cents
        return (int)(totalCost * 100);
    }
    /**
     * Returns total tax on items in cents
     * @return total tax on items in cents
     */
    public int totalTax() {
        double totalCost = 0;

        for (DessertItem item : cart) {
            totalCost += item.getCost();
        }
        // convert the tax from double to int & dollars to cents
        return (int)Math.round((totalCost * taxRate * 100));
    }
    /**
     * Returns a String representing a receipt for the current list of items
     * @return a String representing a receipt for the current list of DessertItem's with the name of the
     *          Dessert store, the items purchased, the tax, and the total cost
     */
    public String toString() {
        // format the prices so that they always show 2 decimal places
        DecimalFormat df2 = new DecimalFormat("#0.00");
        // use StringBuilder to avoid warning of string concatenation in loops
        StringBuilder receipt = new StringBuilder();

        // output total stats
        receipt.append("Output Receipt:\n")
                .append("\nNumber of items: ").append(numberOfItems())
                .append("\nTotal Tax (cents): ").append(totalTax())
                .append("\nTotal Cost (cents, w/o tax): ").append(totalCost())
                .append("\nTotal Cost (cents, w/ tax): ").append((totalTax() + totalCost()));

        receipt.append(String.format("\n\n\t%35s\n", "Holy Macaroons! Confectionery"))
                .append("\t-----------------------------------------\n");

        for (DessertItem item : cart) {
            // adds the item's toString description to the receipt as a string
            receipt.append(item);
        }

        receipt.append(String.format("\n\n\t%-34s$", "Tax")).append(df2.format((double)totalTax() / 100))
                .append(String.format("\n\t%-34s$", "Total Cost"))
                .append(df2.format((double)(totalCost() + totalTax()) / 100));
        return receipt.toString();
    }
}

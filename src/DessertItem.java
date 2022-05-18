
public abstract class DessertItem {

    protected String name;
    protected int calories;

    /**
     * Null default constructor for DessertItem class.
     */
    public DessertItem() {
        this("", 0);
    }
    /**
     * Initializes DessertItem data.
     * @param name the name of the DessertItem
     * @param calories the amount of calories of the DessertItem
     */
    public DessertItem(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    /**
     * Returns the name of the DessertItem.
     * @return the name of the DessertItem
     */
    public final String getName() {
        return name;
    }
    /**
     * Abstract method. Returns the cost of the DessertItem.
     * @return the cost of the DessertItem
     */
    public abstract double getCost();
    /**
     * Returns the calories of the DessertItem.
     * @return the calories of the DessertItem
     */
    public int getCalories() {
        return calories;
    }
    /**
     * Sets the name of the DessertItem.
     * @param newName the new name of the DessertItem
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * Sets the calorie count of the DessertItem.
     * @param newCalories the new amount of calories of the DessertItem
     */
    public void setCalories(int newCalories) {
        calories = newCalories;
    }
    public void unsortedCalories() {
        System.out.println(this.getName() + " has " + this.getCalories() + " calories.");
    }

    public void sortedCalories(DessertItem list) {

        System.out.println(this.getName() + " has " + this.getCalories() + " calories.");
    }

    public int compareTo(DessertItem a) {
        if (this.getCalories() < a.getCalories()) {
            return -1;
        }
        else if(this.getCalories() > a.getCalories()) {
            return 1;
        }
        else
            return 0;

    }
    public static DessertItem max(DessertItem a, DessertItem b) {
        if(a.compareTo(b) < 0)
            return b;
        else
            return a;
    }
}

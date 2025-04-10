package week4;

public interface BidCollectionInterface {
    /**Adds a bid to this collection*/
    public void addBid();

    /**Returns the bid in this collection with the best yearly cost
     * @return the bid the best yearly cost*/
    public double getBestYearlyCost();

    /**Returns the bid in this collection with the best
     * @return bid as (unit cost + installation cost)*/
    public double getBestInitialCost();

    /**Clears all the items from this collection*/
    public void clearAllItems();

    /**Gets the number of items in this collection
     * @return number of items in the collection*/
    public int getNumberOfItems();

    /**Sees whether this collection is empty
     * @return true if the collection is empty*/
    public boolean isEmpty();
}

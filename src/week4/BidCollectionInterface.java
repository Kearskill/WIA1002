package week4;

public interface BidCollectionInterface {
    public void addBid();
    public double getBestYearlyCost();
    public double getBestInitialCost();
    public void clearAllItems();
    public int getNumberOfItems();
    public boolean isEmpty();
}
// Adds a bid to this collection.
// Returns the bid in this collection with the best yearly cost.
// Returns the bid in this collection with the best initial cost.
//      The initial cost will be defined as the unit cost plus the installation cost.

// Clears all of the items from this collection.
// Gets the number of items in this collection.
// Sees whether this collection is empty.
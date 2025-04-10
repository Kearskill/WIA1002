package week4;

public interface BidInterface {
    /*
    * Return the name of the company making this bid.
    *   @return the name in String*/

    public String getName();
    public String getDescription();
    public double getCapacity(double btu);
    public double getSeer();
    public double getAcCost();
    public double getInstallCost();
    public double getOperatingCost();
}
// Returns the name of the company making this bid.
// Returns the description of the air conditioner that this bid is for.
// Returns the capacity of this bid's AC in tons (1 ton = 12,000 BTU).
// Returns the seasonal efficiency of this bid's AC (SEER).
// Returns the cost of this bid's AC.
// Returns the cost of installing this bid's AC.
// Returns the yearly cost of operating this bid's AC.
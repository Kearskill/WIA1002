package week4;

public interface BidInterface {
    /**Return the name of the company making this bid.
     * @return the name in String*/
    public String getName();

    /**Returns the description of the air conditioner that this bid is for
     * @return the description in String*/
    public String getDescription();

    /**Returns the capacity of this bid's AC in tons
     * @param btu the unit to be converted
     * @return the capacity of this bid's AC in tons*/
    public double getCapacity(double btu);

    /**Returns the seasonal efficiency of this bid's AC (SEER)
     * @return the seasonal efficiency of this bid's AC (SEER)*/
    public double getSeer();

    /**Returns the cost of this bid's AC
     * @return the cost of this bid's AC*/
    public double getAcCost();

    /**Returns the cost of installing this bid's AC
     * @return the cost of installing this bid's AC*/
    public double getInstallCost();

    /**Returns the yearly cost of operating this bid's AC
     * @return the yearly cost of operating this bid's AC*/
    public double getOperatingCost();
}
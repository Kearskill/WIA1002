package week7;

public class L6Q3 {
    public static void main(String[] args) {
        System.out.println("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
    }
}

/*When a share of common stock of some company is sold,
the capital gain or loss is obtained by calculating the
difference between the share’s selling price and the
price originally paid to buy it. This rule is easy to
understand for a single share. However, if we sell
multiple shares of stock bought over a long period
of time, then we must identify the shares actually being sold
. A standard accounting principle for identifying which shares
of a stock were sold in such a case is to use a FIFO protocol –
the shares sold are the ones that have been held the longest.

For example, suppose we buy 100 shares at $20 each on
day 1, 20 shares at $24 on day 2, 200 shares at $36
on day 3, and then sell 150 shares on day 4 at $30 each.
Then applying the FIFO protocol means that of the 150 shares
sold, 100 were bought on day 1, 20 were bought on day 2,
and 30 were bought on day 3. The capital gain or loss in
this case would therefore be (100 * 10) + (20* 6) + (30 * -6) = $940.

Write a program that takes as input a sequence of
transactions of the form “buy x share(s) at $y each”
or “sell x share(s) at $y each,” assuming that the
transactions occur on consecutive days and the value x and
y are integers. Given this input sequence, the output
should be the total gain or loss for the sequence,
using the FIFO protocol to identify shares.*/
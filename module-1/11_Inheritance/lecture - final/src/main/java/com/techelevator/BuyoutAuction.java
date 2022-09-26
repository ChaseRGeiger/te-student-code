package com.techelevator;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        /*
            super() calls the constructor of the superclass.
            When required, this MUST BE the first line in
            the subclasses constructor.
         */
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (getHighBid().getBidAmount() < buyoutPrice) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            /*
                super.method() ( super.placeBid() ) calls the superclass
                version of the method.  Used in an Override method to call
                the original version of the method it is hiding.
             */
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }
}

package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentBid = false;
        if(offeredBid.getBidAmount() >= reservePrice){
            isCurrentBid = super.placeBid(offeredBid);
            return isCurrentBid;
        }
        return false;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }
}

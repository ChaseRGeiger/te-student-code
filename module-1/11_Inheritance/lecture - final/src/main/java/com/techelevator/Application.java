package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction buyoutAuction = new BuyoutAuction("Book", 10);

        buyoutAuction.placeBid( new Bid("John", 8) );

        ReserveAuction reserveAuction = new ReserveAuction("Shirt", 10);
        reserveAuction.placeBid( new Bid("Laura", 12) );

        /*
            Upcasting casts a subclass as its superclass
            Upcasting is implicit because it is a Widening
         */
        Auction reserveAuctionAsAuction = reserveAuction;
        Object reserveAuctionAsOBject = reserveAuction;

        /*
            Downcasting casts superclass to a subclass as long as
            the object in memory is already IS-A of that subclass
            Downcasting is Narrowing so must be explicit
         */
        // This works because this General Auction IS-A reserve auction object
        ReserveAuction reserveAuctionAgain = (ReserveAuction) reserveAuctionAsAuction;

        // This will cause a Class Cast Exception because the object is not a buyout auction
        //BuyoutAuction thisMightBeBuyoutAuction = (BuyoutAuction) reserveAuctionAsAuction;


        List<Auction> auctionsInAList = new ArrayList<Auction>();
        auctionsInAList.add( new Auction("ItemA") );
        auctionsInAList.add( new ReserveAuction("ReserveItem", 10) );
        auctionsInAList.add( new BuyoutAuction("BuyoutItem", 8) );

        for (Auction auction : auctionsInAList) {
            auction.placeBid( new Bid("Steve", 15) );
        }


    }
}

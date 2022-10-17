package com.techelevator.money;

import com.techelevator.money.change.*;

import java.util.ArrayList;
import java.util.List;

public class ChangeMaker {


    /**
     * Determines the best number and coins to return as change using the passed balance.
     * The resulting Map contains the Coin type as a Key and the count of each coin type as the value
     * @param balance
     * @return List of change to return
     */
    public List<Change> makeChange(double balance) {

        int amount = (int) Math.round(balance * 100);

        List<Change> change = new ArrayList<Change>();

        for (Change money : getDenominations()) {
            if (amount <= 0) { break; }
            int cnt = amount / money.getValue();
            if (cnt > 0) {
                amount = amount % (money.getValue() * cnt);
                money.setCount(cnt);
                change.add(money);
            }
        }

        return change;
    }

    private Change[] getDenominations() {
        return new Change[] { new TwentyDollar(), new TenDollar(), new FiveDollar(), new OneDollar(), new Quarter(), new Dime(), new Nickel() };
    }
}

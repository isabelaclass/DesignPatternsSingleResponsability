package singleresponsability;

import java.util.ArrayList;
import java.util.List;

public class PurchManager {

    List<Purch> purches = new ArrayList<Purch>();

    public void createPurch(Purch purch) {
        purches.add(purch);
    }
}

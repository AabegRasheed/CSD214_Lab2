package Lab2;

import java.util.Date;

public class DiscMag extends Magazine {
    private boolean hasDisc;

    public DiscMag(String title, double price, int copies, String ISBN10, boolean hasDisc, int orderQty, Date currIssue) {
        super(title, price, copies, ISBN10, orderQty, currIssue);
        this.hasDisc = hasDisc;
    }

    public boolean hasDisc() {
        return this.hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }

    @Override
    public String toString() {
        return "DiscMag: " + super.toString() + ", Has Disc: " + hasDisc;
    }
}


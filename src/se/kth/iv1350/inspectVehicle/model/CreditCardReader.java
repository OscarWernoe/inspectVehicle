package se.kth.iv1350.inspectVehicle.model;

import java.time.YearMonth;
import se.kth.iv1350.inspectVehicle.integration.CreditCard;
import se.kth.iv1350.inspectVehicle.integration.PaymentAuthorization;

/**
 * Represents a credit card reader.
 */
public class CreditCardReader {
    private final PaymentAuthorization payAuth;
    
    /**
     * Creates a new instance.
     */
    public CreditCardReader() {
        this.payAuth = new PaymentAuthorization();
    }
    
    /**
     * Creates a hard coded <code>CreditCard</code>.
     * 
     * @return The customer's credit card.
     */
    public CreditCard getCreditCard() {
        int pin = 1234;
        String number = "1111 AAAA 2222 BBBB";
        String holder = "John Doe";
        YearMonth expiryDate = YearMonth.of(2019, 9);
        int CVC = 999;
        return new CreditCard(pin, number, holder, expiryDate, CVC);
    }
    
    /**
     * Makes a payment using the customer's credit card and requests authorization.
     * 
     * @param card The customer's credit card.
     * @param cost The cost to be paid.
     * @return The result of the payment authorization.
     */
    public boolean makePayment(CreditCard card, int cost) {
        return payAuth.authorizePayment(card, cost);
    }
}

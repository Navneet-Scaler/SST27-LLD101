public class OrderService {
    double taxRate = 0.18;
    EmailClient emailClient;

    // EmailClient email = new EmailClient(); // Tightly coupled earlier

    public OrderService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = totalWithTax(subtotal);
        System.out.println("Order stored (pretend DB).");
        emailClient.send(customerEmail, "Thanks! Your total is " + total);
    }
}


public class Demo01 {
    public static void main(String[] args) {
        EmailClient email = new EmailClient();
        OrderService orderService = new OrderService(email);
        orderService.checkout("a@shop.com", 100.0);
    }
}

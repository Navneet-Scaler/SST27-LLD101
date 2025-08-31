import com.example.orders.*;
import java.util.List;
import java.util.ArrayList;

public class TryIt {
    public static void main(String[] args) {
        // create original order lines
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        List<OrderLine> lines = new ArrayList<>();
        lines.add(l1);
        lines.add(l2);

        // create immutable order using Builder
        Order o = new Order.Builder("o2", "a@b.com", lines)
                        .discountPercent(10)
                        .build();

        System.out.println("Before: " + o.totalAfterDiscount());

        // mutate l1 to demonstrate defensive copy in Order
        l1.setQuantity(999); // original line, but won't affect 'o' totals now
        System.out.println("After:  " + o.totalAfterDiscount());

        System.out.println("=> In the solution, totals remain stable due to defensive copies.");
    }
}

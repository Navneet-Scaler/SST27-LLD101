package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 *
 * FIXED: Immutable externally using Builder; defensive copies of lines.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 expected, validated in Builder
    private final boolean expedited;
    private final String notes;

    // public Order(String id, String customerEmail) { ... } // original constructor
    // public Order(String id, String customerEmail, Integer discountPercent) { ... } // original
    // public void addLine(OrderLine line) { lines.add(line); } // original
    // public void setDiscountPercent(Integer discountPercent) { this.discountPercent = discountPercent; } // original
    // public void setExpedited(boolean expedited) { this.expedited = expedited; } // original
    // public void setNotes(String notes) { this.notes = notes; } // original

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        // defensive copy + unmodifiable
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines));
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    // getters
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; } // now unmodifiable
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    /** Builder for Order */
    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String email, List<OrderLine> lines) {
            if (!PricingRules.isValidEmail(email)) throw new IllegalArgumentException("Invalid email");
            if (lines == null || lines.isEmpty()) throw new IllegalArgumentException("Order must have at least one line");
            this.id = id;
            this.customerEmail = email;
            this.lines.addAll(lines); // defensive copy
        }

        public Builder discountPercent(Integer discountPercent) {
            if (!PricingRules.isValidDiscount(discountPercent)) throw new IllegalArgumentException("Invalid discount");
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) { this.expedited = expedited; return this; }
        public Builder notes(String notes) { this.notes = notes; return this; }

        public Builder addLine(OrderLine line) {
            if (line == null) throw new IllegalArgumentException("line cannot be null");
            this.lines.add(line);
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

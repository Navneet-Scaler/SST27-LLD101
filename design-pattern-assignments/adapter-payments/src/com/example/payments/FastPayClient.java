package com.example.payments;

import java.util.Objects;

public class FastPayClient {
    public String payNow(String custId, int amountCents) {
        Objects.requireNonNull(custId, "custId");
        return "FP#" + custId + ":" + amountCents;
    }
}

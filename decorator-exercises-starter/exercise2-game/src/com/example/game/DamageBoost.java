package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int extraDamage;

    public DamageBoost(Character wrapped, int extraDamage) {
        super(wrapped);
        this.extraDamage = extraDamage;
    }

    @Override
    public int getDamage() {
        return wrapped.getDamage() + extraDamage;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with boosted damage " + getDamage() + " using sprite " + getSprite());
    }
}

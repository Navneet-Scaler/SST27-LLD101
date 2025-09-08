package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character wrapped) {
        super(wrapped);
    }

    @Override
    public String getSprite() {
        return "golden_" + wrapped.getSprite();
    }

    @Override
    public int getSpeed() {
        return wrapped.getSpeed() + 2; // small speed buff
    }

    @Override
    public int getDamage() {
        return wrapped.getDamage() + 5; // small damage buff
    }

    @Override
    public void move() {
        System.out.println("🌟 Golden Aura Active! 🌟");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("🌟 Golden Aura Active! 🌟");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}

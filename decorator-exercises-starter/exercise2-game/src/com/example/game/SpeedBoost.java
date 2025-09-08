package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int extraSpeed;

    public SpeedBoost(Character wrapped, int extraSpeed) {
        super(wrapped);
        this.extraSpeed = extraSpeed;
    }

    @Override
    public int getSpeed() {
        return wrapped.getSpeed() + extraSpeed;
    }

    @Override
    public void move() {
        System.out.println("Moving at boosted speed " + getSpeed() + " with sprite " + getSprite());
    }
}

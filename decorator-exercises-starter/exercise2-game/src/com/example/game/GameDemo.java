package com.example.game;

public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        // a) Base + SpeedBoost + DamageBoost
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        System.out.println("\n--- Buffed (Speed + Damage) ---");
        buffed.move();
        buffed.attack();

        // b) Add GoldenAura (sprite change + buffs)
        Character shiny = new GoldenAura(buffed);
        System.out.println("\n--- Buffed + GoldenAura ---");
        shiny.move();
        shiny.attack();

        // c) Remove GoldenAura by recomposing
        Character withoutAura = buffed;
        System.out.println("\n--- Buffed Without Aura ---");
        withoutAura.move();
        withoutAura.attack();
    }
}

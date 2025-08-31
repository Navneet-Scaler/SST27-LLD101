package com.example.profiles;

import java.util.Objects;

/**
 * ProfileService now uses Builder and stops mutating after creation.
 */
public class ProfileService {

    // returns an immutable profile
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createFull(String id, String email, String displayName,
                                  String phone, String address,
                                  boolean marketingOptIn, String twitter, String github) {
        return new UserProfile.Builder(id, email)
                .displayName(displayName)
                .phone(phone)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build();
    }

    // no more setters → this method becomes optional utility returning new profile
    public UserProfile updateDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        return new UserProfile.Builder(p.getId(), p.getEmail())
                .phone(p.getPhone())
                .address(p.getAddress())
                .marketingOptIn(p.isMarketingOptIn())
                .twitter(p.getTwitter())
                .github(p.getGithub())
                .displayName(displayName != null && displayName.length() > 100
                        ? displayName.substring(0, 100)
                        : displayName)
                .build();
    }
}

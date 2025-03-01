package me.brandonjja.manhunt.roles;

public enum Role {

    HUNTER("Hunter"),
    RUNNER("Runner"),
    ASSASSIN("Assassin");

    private final String cleanName;

    Role(String cleanName) {
        this.cleanName = cleanName;
    }

    @Override
    public String toString() {
        return cleanName;
    }
}

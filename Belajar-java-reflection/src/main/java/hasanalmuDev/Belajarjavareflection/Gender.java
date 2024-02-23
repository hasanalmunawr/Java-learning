package hasanalmuDev.Belajarjavareflection;

public enum Gender {

    MELE("mele"),
    FEMALE("female");
    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package Main.characters;

public enum TextList {
    INVALID_STATS("Ogiltiga karaktärsvärden"),
    NO_NEGATIVE_DAMAGE("Skada kan inte vara negativ"),
    NO_NEGATIVE_HEALS("Läkningen kan inte vara negativ"),
    DEFENSE_HALVES_DAMAGE("försvarar sig och halverar skadan från %d till %d");

    private final String sweText;
    TextList(String sweText) {this.sweText = sweText;}

    @Override
    public String toString() {return sweText;}

    public String putInBetween(String text) {
        return sweText.replaceAll("PUT", text);}

    public String withDamage(int originalDamage, int reducedDamage) {
        return String.format(sweText, originalDamage, reducedDamage);
    }



}

package Main.characters;

public enum TextList {
    BLANC("blanc");

    private final String sweText;
    TextList(String sweText) {this.sweText = sweText;}

    @Override
    public String toString() {return sweText;}

    public String putInBetween(String text) {
        return sweText.replaceAll("PUT", text);}
}

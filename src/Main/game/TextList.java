package Main.game;

public enum TextList {
    INPUT_YOUR_NAME("(OBS: Namn kan inte vara blanka/\"Datorn\")\nVad är ditt namn?\nNamn: "),
    CPU_NAME("Datorn");

    private final String sweText;

    TextList(String sweText) {
        this.sweText = sweText;
    }

    @Override
    public String toString() {return sweText;}
}

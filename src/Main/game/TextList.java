package Main.game;

public enum TextList {
    INPUT_YOUR_NAME("(OBS: Namn kan inte vara blanka/\"Datorn\")\nVad är ditt namn?\nNamn: "),
    CPU_NAME("Datorn"),
    CHOOSE_FIGHTER("~~~~Välj en fighter~~~~"),
    FIGHT_STARTS("FIGHT BÖRJAS!"),
    PLAYERS_TURN(" börjar sin tur!"),
    WON(" vinner!"),
    HUMAN_SELECT_MOVE("1: Attack | 2: PUT\nVälj nummer: "),
    UNKNOWN_MOVE("Okänd move...\n"),
    HUMAN_PICK_FIGHTER("1: Bågskytte | 2: Magiker | 3: Krigare\nVälj nummer: "),
    UNKNOWN_FIGHTER("Okänd fighter...\n");

    private final String sweText;
    TextList(String sweText) {this.sweText = sweText;}

    @Override
    public String toString() {return sweText;}

    public String putInBetween(String text) {
        return sweText.replaceAll("PUT", text);}
}

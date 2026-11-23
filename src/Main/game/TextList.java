package Main.game;

public enum TextList {
    INPUT_YOUR_NAME("(OBS: Namn kan inte vara blanka/\"Datorn\")\nVad är ditt namn?\nNamn: "),
    CPU_NAME("Datorn"),
    CHOOSE_FIGHTER("~~~~Välj en fighter~~~~"),
    FIGHT_STARTS("FIGHT BÖRJAS!"),
    PLAYERS_TURN(" börjar sin tur!"),
    WON(" vinner!"),
    HUMAN_SELECT_MOVE("1: Attack | 2: SPLIT\nVälj nummer: "),
    UNKNOWN_MOVE("Okänd move...\n"),
    HUMAN_PICK_FIGHTER("1: Archer | 2: Mage | 3: Warrior\nVälj nummer: "),
    UNKNOWN_FIGHTER("Okänd fighter...\n");

    private final String sweText;
    TextList(String sweText) {this.sweText = sweText;}

    @Override
    public String toString() {return sweText;}
    public String[] split() {return sweText.split("SPLIT");}
}

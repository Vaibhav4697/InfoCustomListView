package info.android.custom.listview;

public class Avengers {

    private String name;
    private String team;
    private Integer image;

    public Avengers(String name, String team, Integer image) {
        this.name = name;
        this.team = team;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Integer getImage() {
        return image;
    }
}

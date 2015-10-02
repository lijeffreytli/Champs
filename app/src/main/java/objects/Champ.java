package objects;

/**
 * Created by jeffreyli on 10/1/15.
 */
public class Champ {

    private String championName;

    public Champ(String name) {
        this.championName = name;
    }

    public String getName() {
        return championName;
    }

    public void setName(String championName) {
        this.championName = championName;
    }
}

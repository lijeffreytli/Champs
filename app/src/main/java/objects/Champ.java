package objects;
import java.io.Serializable;

/**
 * Created by jeffreyli on 10/1/15.
 */
public class Champ implements Serializable{

    private String championName;

    private int championAttack;
    private int championDefense;
    private int championDifficulty;
    private int championMagic;
    private int championNumberOfSkins;
    private int championMovementSpeed;
    private double championMagicResist;
    private double championArmor;
    private double championAttackDamage;
    private double championHealthRegen;
    private double championHealth;
    private double championAttackSpeed;

    public Champ(String name) {
        this.championName = name;
    }

    public String getName() {
        return championName;
    }
    public void setName(String championName) {
        this.championName = championName;
    }

    public int getChampionAttack() {
        return championAttack;
    }
    public void setChampionAttack(int championAttack){
        this.championAttack = championAttack;
    }

    public int getChampionDefense(){
        return championDefense;
    }
    public void setChampionDefense(int championDefense){
        this.championDefense = championDefense;
    }

    public int getChampionDifficulty(){
        return championDifficulty;
    }
    public void setChampionDifficulty(int championDifficulty){
        this.championDifficulty = championDifficulty;
    }

    public int getChampionMagic(){
        return championMagic;
    }
    public void setChampionMagic(int championMagic){
        this.championMagic = championMagic;
    }

    public int getChampionNumberOfSkins(){
        return this.championNumberOfSkins;
    }
    public void setChampionNumberOfSkins(int championNumberOfSkins){
        this.championNumberOfSkins = championNumberOfSkins;
    }


}

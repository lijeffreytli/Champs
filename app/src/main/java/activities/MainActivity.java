package activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.lijeffreytli.champs.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapters.ChampsListAdapter;
import objects.Champ;


import com.cloudinary.Cloudinary;

public class MainActivity extends ActionBarActivity {
    public final static String CHAMP_OBJECT = "CHAMP_OBJECT";

    private Context context;
    private List<String> champsNameList;
    private List<String> champsTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setChampsNameList();
        setChampsTitleList();

        // Integrate with Cloudinary API and set up requirements. Currently unused.
        // Uncomment for pushing data to cloudinary.
//        Map config = new HashMap();
//        config.put("cloud_name", "champs");
//        config.put("api_key", "523795429227931");
//        config.put("api_secret", "0BQVFAL9MUNEd3eoPpnHDSXUKQ4");
//        Cloudinary cloudinary = new Cloudinary(config);

        context = this;
        ListView championsListView = (ListView)findViewById(R.id.champs_list);

        final List<Champ> champsList = new ArrayList<Champ>();
        for (String championName : champsNameList){
            Champ champ = new Champ(championName);
            champsList.add(champ);
        }

        ChampsListAdapter champsListAdapter = new ChampsListAdapter(this, champsList, champsNameList, champsTitleList);
        championsListView.setAdapter(champsListAdapter);

        championsListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, ChampActivity.class);

                Champ champ = champsList.get(position);

                intent.putExtra(CHAMP_OBJECT, champ);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Desc: Set the name of the champion.
     *
     * Note: These are currently hard coded because I realized that the API has spelling mistakes.
     * Not sure what's worse... hard coding or having spelling mistakes, lol.
     * */
    public void setChampsNameList(){
        champsNameList = new ArrayList<String>();

        champsNameList.add("Aatrox");
        champsNameList.add("Ahri");
        champsNameList.add("Akali");
        champsNameList.add("Alistar");
        champsNameList.add("Amumu");
        champsNameList.add("Anivia");
        champsNameList.add("Annie");
        champsNameList.add("Ashe");
        champsNameList.add("Azir");
        champsNameList.add("Bard");
        champsNameList.add("Blitzcrank");
        champsNameList.add("Brand");
        champsNameList.add("Braum");
        champsNameList.add("Caitlyn");
        champsNameList.add("Cassiopeia");
        champsNameList.add("Chogath");
        champsNameList.add("Corki");
        champsNameList.add("Darius");
        champsNameList.add("Diana");
        champsNameList.add("Draven");
        champsNameList.add("DrMundo");
        champsNameList.add("Ekko");
        champsNameList.add("Elise");
        champsNameList.add("Evelynn");
        champsNameList.add("Ezreal");
        champsNameList.add("FiddleSticks");
        champsNameList.add("Fiora");
        champsNameList.add("Fizz");
        champsNameList.add("Galio");
        champsNameList.add("Gangplank");
        champsNameList.add("Garen");
        champsNameList.add("Gnar");
        champsNameList.add("Gragas");
        champsNameList.add("Graves");
        champsNameList.add("Hecarim");
        champsNameList.add("Heimerdinger");
        champsNameList.add("Irelia");
        champsNameList.add("Janna");
        champsNameList.add("JarvanIV");
        champsNameList.add("Jax");
        champsNameList.add("Jayce");
        champsNameList.add("Jinx");
        champsNameList.add("Kalista");
        champsNameList.add("Karma");
        champsNameList.add("Karthus");
        champsNameList.add("Kassadin");
        champsNameList.add("Katarina");
        champsNameList.add("Kayle");
        champsNameList.add("Kennen");
        champsNameList.add("Khazix");
        champsNameList.add("Kindred");
        champsNameList.add("KogMaw");
        champsNameList.add("Leblanc");
        champsNameList.add("LeeSin");
        champsNameList.add("Leona");
        champsNameList.add("Lissandra");
        champsNameList.add("Lucian");
        champsNameList.add("Lulu");
        champsNameList.add("Lux");
        champsNameList.add("Malphite");
        champsNameList.add("Malzahar");
        champsNameList.add("Maokai");
        champsNameList.add("MasterYi");
        champsNameList.add("MissFortune");
        champsNameList.add("MonkeyKing");
        champsNameList.add("Mordekaiser");
        champsNameList.add("Morgana");
        champsNameList.add("Nami");
        champsNameList.add("Nasus");
        champsNameList.add("Nautilus");
        champsNameList.add("Nidalee");
        champsNameList.add("Nocturne");
        champsNameList.add("Nunu");
        champsNameList.add("Olaf");
        champsNameList.add("Orianna");
        champsNameList.add("Pantheon");
        champsNameList.add("Poppy");
        champsNameList.add("Quinn");
        champsNameList.add("Rammus");
        champsNameList.add("RekSai");
        champsNameList.add("Renekton");
        champsNameList.add("Rengar");
        champsNameList.add("Riven");
        champsNameList.add("Rumble");
        champsNameList.add("Ryze");
        champsNameList.add("Sejuani");
        champsNameList.add("Shaco");
        champsNameList.add("Shen");
        champsNameList.add("Shyvana");
        champsNameList.add("Singed");
        champsNameList.add("Sion");
        champsNameList.add("Sivir");
        champsNameList.add("Skarner");
        champsNameList.add("Sona");
        champsNameList.add("Soraka");
        champsNameList.add("Swain");
        champsNameList.add("Syndra");
        champsNameList.add("TahmKench");
        champsNameList.add("Talon");
        champsNameList.add("Taric");
        champsNameList.add("Teemo");
        champsNameList.add("Thresh");
        champsNameList.add("Tristana");
        champsNameList.add("Trundle");
        champsNameList.add("Tryndamere");
        champsNameList.add("TwistedFate");
        champsNameList.add("Twitch");
        champsNameList.add("Udyr");
        champsNameList.add("Urgot");
        champsNameList.add("Varus");
        champsNameList.add("Vayne");
        champsNameList.add("Veigar");
        champsNameList.add("Velkoz");
        champsNameList.add("Vi");
        champsNameList.add("Viktor");
        champsNameList.add("Vladimir");
        champsNameList.add("Volibear");
        champsNameList.add("Warwick");
        champsNameList.add("Xerath");
        champsNameList.add("XinZhao");
        champsNameList.add("Yasuo");
        champsNameList.add("Yorick");
        champsNameList.add("Zac");
        champsNameList.add("Zed");
        champsNameList.add("Ziggs");
        champsNameList.add("Zilean");
        champsNameList.add("Zyra");
    }

    /**
     * Desc: Set the title of the champion.
     *
     * Note: These are currently hard coded because I realized that the API has spelling mistakes.
     * Not sure what's worse... hard coding or having spelling mistakes, lol.
     * */
    public void setChampsTitleList() {
        champsTitleList = new ArrayList<String>();

        champsTitleList.add("\"the Darkin Blade\"");
        champsTitleList.add("\"the Nine-Tailed Fox\"");
        champsTitleList.add("\"the Fist of Shadow\"");
        champsTitleList.add("\"the Minotaur\"");
        champsTitleList.add("\"the Sad Mummy\"");
        champsTitleList.add("\"the Cryophoenix\"");
        champsTitleList.add("\"the Dark Child\"");
        champsTitleList.add("\"the Frost Archer\"");
        champsTitleList.add("\"the Emperor of the Sands\"");
        champsTitleList.add("\"the Wandering Caretaker\"");
        champsTitleList.add("\"the Great Steam Golem\"");
        champsTitleList.add("\"the Burning Vengeance\"");
        champsTitleList.add("\"the Heart of the Freljord\"");
        champsTitleList.add("\"the Sheriff of Piltover\"");
        champsTitleList.add("\"the Serpent's Embrace\"");
        champsTitleList.add("\"the Terror of the Void\"");
        champsTitleList.add("\"the Daring Bombardier\"");
        champsTitleList.add("\"the Hand of Noxus\"");
        champsTitleList.add("\"Scorn of the Moon\"");
        champsTitleList.add("\"the Glorious Executioner\"");
        champsTitleList.add("\"the Madman of Zaun\"");
        champsTitleList.add("\"the Boy Who Shattered Time\"");
        champsTitleList.add("\"the Spider Queen\"");
        champsTitleList.add("\"the Widowmaker\"");
        champsTitleList.add("\"the Prodigal Explorer\"");
        champsTitleList.add("\"the Harbinger of Doom\"");
        champsTitleList.add("\"the Grand Duelist\"");
        champsTitleList.add("\"the Tidal Trickster\"");
        champsTitleList.add("\"the Sentinel's Sorrow\"");
        champsTitleList.add("\"the Saltwater Scourge\"");
        champsTitleList.add("\"the Might of Demacia\"");
        champsTitleList.add("\"the Missing Link\"");
        champsTitleList.add("\"the Rabble Rouser\"");
        champsTitleList.add("\"the Outlaw\"");
        champsTitleList.add("\"the Shadow of War\"");
        champsTitleList.add("\"the Revered Inventor\"");
        champsTitleList.add("\"the Will of the Blades\"");
        champsTitleList.add("\"the Storm's Fury\"");
        champsTitleList.add("\"the Exemplar of Demacia\"");
        champsTitleList.add("\"Grandmaster at Arms\"");
        champsTitleList.add("\"the Defender of Tomorrow\"");
        champsTitleList.add("\"the Loose Cannon\"");
        champsTitleList.add("\"the Spear of Vengeance\"");
        champsTitleList.add("\"the Enlightened One\"");
        champsTitleList.add("\"the Deathsinger\"");
        champsTitleList.add("\"the Void Walker\"");
        champsTitleList.add("\"the Sinister Blade\"");
        champsTitleList.add("\"the Judicator\"");
        champsTitleList.add("\"the Heart of the Tempest\"");
        champsTitleList.add("\"the Voidreaver\"");
        champsTitleList.add("\"the Eternal Hunters\"");
        champsTitleList.add("\"the Mouth of the Abyss\"");
        champsTitleList.add("\"the Deceiver\"");
        champsTitleList.add("\"the Blind Monk\"");
        champsTitleList.add("\"the Radiant Dawn\"");
        champsTitleList.add("\"the Ice Witch\"");
        champsTitleList.add("\"the Purifier\"");
        champsTitleList.add("\"the Fae Sorceress\"");
        champsTitleList.add("\"the Lady of Luminosity\"");
        champsTitleList.add("\"Shard of the Monolith\"");
        champsTitleList.add("\"the Prophet of the Void\"");
        champsTitleList.add("\"the Twisted Treant\"");
        champsTitleList.add("\"the Wuju Bladesman\"");
        champsTitleList.add("\"the Bounty Hunter\"");
        champsTitleList.add("\"the Monkey King\"");
        champsTitleList.add("\"the Master of Metal\"");
        champsTitleList.add("\"Fallen Angel\"");
        champsTitleList.add("\"the Tidecaller\"");
        champsTitleList.add("\"the Curator of the Sands\"");
        champsTitleList.add("\"the Titan of the Depths\"");
        champsTitleList.add("\"the Bestial Huntress\"");
        champsTitleList.add("\"the Eternal Nightmare\"");
        champsTitleList.add("\"the Yeti Rider\"");
        champsTitleList.add("\"the Berserker\"");
        champsTitleList.add("\"the Lady of Clockwork\"");
        champsTitleList.add("\"the Artisan of War\"");
        champsTitleList.add("\"the Iron Ambassador\"");
        champsTitleList.add("\"Demacia's Wings\"");
        champsTitleList.add("\"the Amordillo\"");
        champsTitleList.add("\"the Void Burrower\"");
        champsTitleList.add("\"the Butcher of the Sands\"");
        champsTitleList.add("\"the Pridestalker\"");
        champsTitleList.add("\"the Exile\"");
        champsTitleList.add("\"the Mechanized Menace\"");
        champsTitleList.add("\"the Rogue Mage\"");
        champsTitleList.add("\"the Winter's Wrath\"");
        champsTitleList.add("\"the Demon Jester\"");
        champsTitleList.add("\"Eye of Twilight\"");
        champsTitleList.add("\"the Half-Dragon\"");
        champsTitleList.add("\"the Mad Chemist\"");
        champsTitleList.add("\"the Undead Juggernaut\"");
        champsTitleList.add("\"the Battle Mistress\"");
        champsTitleList.add("\"the Crystal Vanguard\"");
        champsTitleList.add("\"Maven of the Strings\"");
        champsTitleList.add("\"the Starchild\"");
        champsTitleList.add("\"the Master Tactician\"");
        champsTitleList.add("\"the Dark Sovereign\"");
        champsTitleList.add("\"the River King\"");
        champsTitleList.add("\"the Blade's Shadow\"");
        champsTitleList.add("\"the Gem Knight\"");
        champsTitleList.add("\"the Swift Scout\"");
        champsTitleList.add("\"the Chain Warden\"");
        champsTitleList.add("\"the Yordle Gunner\"");
        champsTitleList.add("\"the Troll King\"");
        champsTitleList.add("\"the Barbarian King\"");
        champsTitleList.add("\"the Card Master\"");
        champsTitleList.add("\"the Plague Rat\"");
        champsTitleList.add("\"the Spirit Walker\"");
        champsTitleList.add("\"the Headsman's Pride\"");
        champsTitleList.add("\"the Arrow of Retribution\"");
        champsTitleList.add("\"the Night Hunter\"");
        champsTitleList.add("\"the Tiny Master of Evil\"");
        champsTitleList.add("\"the Eye of the Void\"");
        champsTitleList.add("\"the Piltover Enforcer\"");
        champsTitleList.add("\"the Machine Herald\"");
        champsTitleList.add("\"the Crimson Reaper\"");
        champsTitleList.add("\"the Thunder's Roar\"");
        champsTitleList.add("\"the Blood Hunter\"");
        champsTitleList.add("\"the Magus Ascendant\"");
        champsTitleList.add("\"the Seneschal of Demacia\"");
        champsTitleList.add("\"the Unforgiven\"");
        champsTitleList.add("\"the Gravedigger\"");
        champsTitleList.add("\"the Secret Weapon\"");
        champsTitleList.add("\"the Master of Shadows\"");
        champsTitleList.add("\"the Hexplosives Expert\"");
        champsTitleList.add("\"the Chronokeeper\"");
        champsTitleList.add("\"Rise of the Thorns\"");
    }
}

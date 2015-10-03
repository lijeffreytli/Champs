package activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
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
    private ListView championsListView;
    private List<String> champsNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setChampsNameList();

        // Integrate with Cloudinary API and set up requirements
        Map config = new HashMap();
        config.put("cloud_name", "champs");
        config.put("api_key", "523795429227931");
        config.put("api_secret", "0BQVFAL9MUNEd3eoPpnHDSXUKQ4");
        Cloudinary cloudinary = new Cloudinary(config);

        context = this;
        championsListView = (ListView)findViewById(R.id.champs_list);

        final List<Champ> champsList = new ArrayList<Champ>();
        for (String championName : champsNameList){
            Champ champ = new Champ(championName);

            champsList.add(champ);
        }

        ChampsListAdapter champsListAdapter = new ChampsListAdapter(this, champsList, champsNameList);
        championsListView.setAdapter(champsListAdapter);

        championsListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, ChampionActivity.class);

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
}

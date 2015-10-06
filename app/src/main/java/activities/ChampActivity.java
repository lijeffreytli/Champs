package activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.lijeffreytli.champs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import adapters.SpellsListAdapter;
import objects.Champ;

public class ChampActivity extends ActionBarActivity {
    private Context context;
    private Champ champ;
    private List<String> champSpellsImageNameList;
    private List<String> champSpellsTitleList;
    private List<String> champSpellsDescList;
    private String passiveSpellImageName;
    private View mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mLoadingView = findViewById(R.id.loading_spinner);

        champSpellsTitleList = new ArrayList<String>();
        champSpellsDescList = new ArrayList<String>();
        champSpellsImageNameList = new ArrayList<String>();

        Firebase.setAndroidContext(this);
        context = getApplicationContext();

        // Get the intent containing the champ's name passed from the MainActivity
        Intent intent = getIntent();
        champ = (Champ) intent.getSerializableExtra(MainActivity.CHAMP_OBJECT);
        setTitle(champ.getName());

        TextView textViewName = (TextView)findViewById(R.id.detail_champ_name);
        textViewName.setText(champ.getName());
        textViewName.setTextColor(Color.parseColor("#F5FBE1"));

        // Query data from Firebase and set the adapters
        QueryData operation = new QueryData();
        operation.execute("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champion, menu);
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
     * Desc: Make requests from Cloudinary url. Use Picasso to update and load the
     * champion skins into the associated image views.
     * */
    public void setChampionSkins(int numberOfSkins)  {
        int displayedSkins = 0;

        for (int i = 0; i <= 16; i++){
            ImageView imageViewSkin = getImageViewSkin(i);

            if (displayedSkins < numberOfSkins) {
                String champSkinIndex = champ.getName() + "_" + String.valueOf(i);
                String urlToImage = "http://res.cloudinary.com/champs/image/upload/" + champSkinIndex + ".png";

                Picasso.with(context).load(urlToImage).error(R.drawable.image_not_available).fit().centerCrop().into(imageViewSkin);
                imageViewSkin.setVisibility(View.VISIBLE);

                displayedSkins++;
            } else {
                imageViewSkin.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Todo: This is currently hard coded in to retrieve the current image view.
     * In the future, we'll want to remove this and use a ViewPage instead.
     *
     * The value of 16 image views is used because we know that we'll never have
     * to surpass 16 possible images
     * */
    public ImageView getImageViewSkin(int index){
        ImageView imageViewSkin = null;

        switch (index) {
            case 0:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin0);
                break;
            case 1:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin1);
                break;
            case 2:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin2);
                break;
            case 3:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin3);
                break;
            case 4:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin4);
                break;
            case 5:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin5);
                break;
            case 6:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin6);
                break;
            case 7:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin7);
                break;
            case 8:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin8);
                break;
            case 9:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin9);
                break;
            case 10:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin10);
                break;
            case 11:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin11);
                break;
            case 12:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin12);
                break;
            case 13:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin13);
                break;
            case 14:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin14);
                break;
            case 15:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin15);
                break;
            case 16:
                imageViewSkin = (ImageView)findViewById(R.id.champ_skin16);
                break;
        }
        return imageViewSkin;
    }

    private void fadeAnimation(){
        /* Animate the loading view to 0% opacity. After the animation ends,
           set its visibility to GONE as an optimization step (it won't
           participate in layout passes, etc.) */
        mLoadingView.animate()
                .alpha(0f)
                .scaleX(0f)
                .scaleY(0f)
                .setDuration(250)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * Desc: Make a query to the firebase and retrieve all of the champ spells associated
     * with the current champ.
     * */
    private void getChampSpells(){
        Firebase champSpellBase = new Firebase("https://champions.firebaseio.com/data/" + champ.getName() + "/spells");

        champSpellBase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    for (DataSnapshot data : child.getChildren()) {
                        if (data.getKey().equals("description")) {
                            champSpellsDescList.add(data.getValue().toString());
                            Log.e("getChampSpells", data.getValue().toString());
                        }
                        if (data.getKey().equals("name")) {
                            champSpellsTitleList.add(data.getValue().toString());
                            Log.e("getChampSpells", data.getValue().toString());
                        }
                        if (data.getKey().equals("image")) {
                            for (DataSnapshot imageData : data.getChildren()) {
                                if (imageData.getKey().equals("full")){
                                    champSpellsImageNameList.add(imageData.getValue().toString());
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    /**
     * Desc: Make a query to the firebase and retrieve the passive champ spell associated
     * with the current champ. Requires separate query because it's a different node in the
     * data base
     * */
    private void getChampPassiveSpell(){
        Firebase passiveSpellBase = new Firebase("https://champions.firebaseio.com/data/" + champ.getName() + "/passive");

        passiveSpellBase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    if (child.getKey().equals("description")){
                        champSpellsDescList.add(child.getValue().toString());
                    }
                    if (child.getKey().equals("name")){
                        champSpellsTitleList.add(child.getValue().toString());
                    }

                    if (child.getKey().equals("image")){
                        for (DataSnapshot data: child.getChildren()){
                            if (data.getKey().equals("full")){
                                passiveSpellImageName = data.getValue().toString();
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    /**
     * Desc: Make a query to the firebase and retrieve the number of skins associated
     * with the current champ.
     * */
    private void getChampNumberSkins(){
        Firebase championBase = new Firebase("https://champions.firebaseio.com/data/" + champ.getName());
        // Get the number of skins for each champion
        championBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child: snapshot.getChildren()) {
                    if (child.getKey().equals("numberofskins")){
                        champ.setChampionNumberOfSkins(Integer.parseInt(child.getValue().toString()));
                        setChampionSkins(champ.getChampionNumberOfSkins());
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    private class QueryData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            getChampNumberSkins();
            getChampPassiveSpell();
            getChampSpells();

            // Make sure that we've obtained the data set we want/need before
            // exiting.
            while(true){
                if (champSpellsDescList.size() > 4){
                    break;
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            ListView spellsListView = (ListView)findViewById(R.id.spells_list);
            SpellsListAdapter champsListAdapter = new SpellsListAdapter(ChampActivity.this, champSpellsTitleList, champSpellsDescList, champSpellsImageNameList, passiveSpellImageName);
            spellsListView.setAdapter(champsListAdapter);

            fadeAnimation();
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}

package activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.lijeffreytli.champs.R;
import com.squareup.picasso.Picasso;

import objects.Champ;

public class ChampionActivity extends ActionBarActivity {

    private Firebase championBase;
    private Context context;
    private Champ champ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        context = getApplicationContext();

        Intent intent = getIntent();
        champ = (Champ) intent.getSerializableExtra(MainActivity.CHAMP_OBJECT);

        setTitle(champ.getName());

        championBase = new Firebase("https://champions.firebaseio.com/data/" + champ.getName());

        // Attach an listener to read the data at our posts reference
        championBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child: snapshot.getChildren()) {
                    Log.e("POOP", child.getKey());
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

        TextView textViewName = (TextView)findViewById(R.id.detail_champ_name);
        textViewName.setText(champ.getName());
        textViewName.setTextColor(Color.parseColor("#F5FBE1"));
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

    public void setChampionSkins(int numberOfSkins)  {
        int displayedSkins = 0;

        Log.e("POOP", String.valueOf(numberOfSkins));

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
}

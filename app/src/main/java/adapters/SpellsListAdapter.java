package adapters;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lijeffreytli.champs.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jeffreyli on 10/1/15.
 */
public class SpellsListAdapter extends BaseAdapter {

    private Context context;
    private List<String> champsSpellDescriptionList;
    private List<String> champsSpellList;
    private List<String> champSpellsImageNameList;
    private String passiveSpellImageName;

    public SpellsListAdapter(Context context, List<String> champsSpellList, List<String> champsSpellDescriptionList, List<String> champSpellImageNameList, String passiveSpellImageName) {
        this.champsSpellList = champsSpellList;
        this.champsSpellDescriptionList = champsSpellDescriptionList;
        this.passiveSpellImageName = passiveSpellImageName;
        this.champSpellsImageNameList = champSpellImageNameList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return champsSpellList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position,View view,ViewGroup parent) {
        View rowView = view;
        if(rowView == null)
            rowView = ((Activity)context).getLayoutInflater().inflate(R.layout.spell_list_item, null);

        String spellTitle = champsSpellList.get(position);
        String spellDescription = champsSpellDescriptionList.get(position);

        TextView textViewName = (TextView)rowView.findViewById(R.id.champ_spell_title);
        textViewName.setText(spellTitle);
        textViewName.setTextColor(Color.parseColor("#F5FBE1"));

        TextView textViewTitle = (TextView)rowView.findViewById(R.id.champ_spell_description);
        textViewTitle.setText(spellDescription);
        textViewTitle.setTextColor(Color.parseColor("#F5FBE1"));

        ImageView spellIconImageView = (ImageView)rowView.findViewById(R.id.champ_image_spell);


        if (position == 0){
            Picasso.with(context).load("http://res.cloudinary.com/champs/image/upload/" + passiveSpellImageName).into(spellIconImageView);
        } else {
            String spellImageName = champSpellsImageNameList.get(position-1);
            Picasso.with(context).load("http://res.cloudinary.com/champs/image/upload/" + spellImageName).into(spellIconImageView);
        }

        return rowView;
    };

}

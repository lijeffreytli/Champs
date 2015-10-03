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

import objects.Champ;

/**
 * Created by jeffreyli on 10/1/15.
 */
public class ChampsListAdapter extends BaseAdapter {

    private Context context;
    private List<Champ> champsList;
    private List<String> champsNameList;

    public ChampsListAdapter(Context context, List<Champ> champsList, List<String> champsNameList) {
        this.champsList = champsList;
        this.champsNameList = champsNameList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return champsList.size();
    }

    @Override
    public Object getItem(int i) {
        return champsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position,View view,ViewGroup parent) {
        View rowView = view;
        if(rowView == null)
            rowView = ((Activity)context).getLayoutInflater().inflate(R.layout.champ_list_item, null);

        ImageView champIconImageView = (ImageView)rowView.findViewById(R.id.champ_icon);

        String champName = champsNameList.get(position);

        TextView textViewName = (TextView)rowView.findViewById(R.id.champ_name);
        textViewName.setText(champName);
        textViewName.setTextColor(Color.parseColor("#F5FBE1"));

        Picasso.with(context).load("http://res.cloudinary.com/champs/image/upload/" + champName + ".png").into(champIconImageView);

        return rowView;
    };

}

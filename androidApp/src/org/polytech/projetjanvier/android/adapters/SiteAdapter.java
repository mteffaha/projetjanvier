package org.polytech.projetjanvier.android.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.polytech.projetjanvier.android.R;
import org.polytech.projetjanvier.android.entities.Site;

import java.util.List;

/**
 * Created by teffaha on 2/3/14.
 */
public class SiteAdapter extends ArrayAdapter<Site> {
    private final Context context;
    private final List<Site> sites;
    private Typeface leagueGothic;

    public SiteAdapter(Context context, int resource, List<Site> objects) {
        super(context, resource, objects);
        this.context = context;
        this.sites = objects;
        leagueGothic = Typeface.createFromAsset(context.getAssets(), "fonts/leaguegothic.otf");
    }


    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.site_element, parent, false);
        TextView tvTitle = (TextView)rowView.findViewById(R.id.siteTitle);
        TextView tvID = (TextView)rowView.findViewById(R.id.siteid);

        Typeface opensans = Typeface.createFromAsset(context.getAssets(),"fonts/opensans.ttf");
        tvTitle.setTypeface(opensans);
        tvTitle.setAllCaps(true);
        tvTitle.setText(sites.get(position).getTitle());

        TextView tvDescrpition = (TextView)rowView.findViewById(R.id.sitedescription);
        tvDescrpition.setText(sites.get(position).getDescription());

        tvID.setTypeface(opensans);
        tvID.setAllCaps(true);
        tvID.setText(""+sites.get(position).getId());

        return rowView;
    }
}



package org.polytech.projetjanvier.android.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.polytech.projetjanvier.android.R;
import org.polytech.projetjanvier.android.entities.Station;

import java.util.List;

/**
 * Created by teffaha on 1/28/14.
 */
public class StationAdapter extends ArrayAdapter<Station> {
    private final Context context;
    private final List<Station> stations;
    private Typeface leagueGothic;

    public StationAdapter(Context context, int resource, List<Station> objects) {
        super(context, resource, objects);
        this.context = context;
        this.stations = objects;
        leagueGothic = Typeface.createFromAsset(context.getAssets(), "fonts/leaguegothic.otf");
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.stationelement, parent, false);
        TextView stationTitle = (TextView) rowView.findViewById(R.id.stationtitle);
        stationTitle.setText("Station "+stations.get(position).getId());
        stationTitle.setTypeface(leagueGothic);
        return rowView;
    }
}

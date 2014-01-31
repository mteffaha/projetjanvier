package org.polytech.projetjanvier.android.adapters;

    import android.content.Context;
    import android.graphics.Typeface;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;
    import org.polytech.projetjanvier.android.R;
    import org.polytech.projetjanvier.android.SensorComponent;
    import org.polytech.projetjanvier.android.entities.Sensor;
    import org.polytech.projetjanvier.android.entities.Station;

    import java.util.List;

    /**
     * Created by teffaha on 1/28/14.
     */
    public class SensorAdapter extends ArrayAdapter<Sensor> {
        private final Context context;
        private final List<Sensor> sensors;
        private Typeface leagueGothic;

        public SensorAdapter(Context context, int resource, List<Sensor> objects) {
            super(context, resource, objects);
            this.context = context;
            this.sensors = objects;
            leagueGothic = Typeface.createFromAsset(context.getAssets(), "fonts/leaguegothic.otf");
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.sensor, parent, false);
            SensorComponent sc = (SensorComponent)rowView.findViewById(R.id.sensorC);
            Sensor s = sensors.get(position);
            s.setListener(sc);
            s.synchronizeValues();
            return rowView;
        }
    }



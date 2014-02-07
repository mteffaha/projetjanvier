package org.polytech.projetjanvier.android;

import org.polytech.projetjanvier.android.entities.Sensor;

import java.util.List;

/**
 * Created by teffaha on 2/7/14.
 */
public interface SensorFetcherCallback {
    void onSensorsFetched(List<Sensor> sensors);
}

package aplicacionesmoviles.avanzado.todosalau.revisarsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private ListView sensorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorListView = findViewById(R.id.sensorListView);
        Button showSensorButton = findViewById(R.id.showSensorButton);

        // Obtener el SensorManager del sistema
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        showSensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la lista de sensores disponibles
                List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

                // Construir una lista de nombres de sensores
                List<String> sensorNames = new ArrayList<>();
                for (Sensor sensor : sensorList) {
                    sensorNames.add(sensor.getName());
                }

                // Crear un ArrayAdapter para el ListView
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, sensorNames);

                // Establecer el adaptador para el ListView
                sensorListView.setAdapter(adapter);
            }
        });
    }
}
package devandroid.diogoferreira.appgaseta.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.diogoferreira.appgaseta.R;

public class GasetaActivity  extends AppCompatActivity {
    Button calcular;
    Button clear;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gaseta_activity);
    }
}

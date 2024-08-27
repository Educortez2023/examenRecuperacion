package ec.com.electrica;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterConsumptionActivity extends AppCompatActivity {

    private EditText etMonth, etValue;
    private Button btnRegisterConsumption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_consumption);

        etMonth = findViewById(R.id.etMonth);
        etValue = findViewById(R.id.etValue);
        btnRegisterConsumption = findViewById(R.id.btnRegisterConsumption);

        btnRegisterConsumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String month = etMonth.getText().toString().trim();
                String value = etValue.getText().toString().trim();

                if (!month.isEmpty() && !value.isEmpty()) {
                    // Aquí podrías agregar la lógica de registro del consumo.
                    Toast.makeText(RegisterConsumptionActivity.this, "Consumo registrado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterConsumptionActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package ec.com.electrica;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConsumptionDetailActivity extends AppCompatActivity {

    private TextView tvDetailMonth, tvDetailValue, tvDetailStatus;
    private Button btnPay;
    private Consumption consumption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption_detail);

        tvDetailMonth = findViewById(R.id.tvDetailMonth);
        tvDetailValue = findViewById(R.id.tvDetailValue);
        tvDetailStatus = findViewById(R.id.tvDetailStatus);
        btnPay = findViewById(R.id.btnPay);

        consumption = (Consumption) getIntent().getSerializableExtra("consumption");

        if (consumption != null) {
            tvDetailMonth.setText(consumption.getMonth());
            tvDetailValue.setText(String.valueOf(consumption.getValue()));
            tvDetailStatus.setText(consumption.getStatus());
        }

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (consumption != null && !consumption.getStatus().equals("Pagado")) {
                    consumption.setStatus("Pagado");
                    tvDetailStatus.setText("Pagado");
                    Toast.makeText(ConsumptionDetailActivity.this, "Pago realizado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ConsumptionDetailActivity.this, "Este consumo ya está pagado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

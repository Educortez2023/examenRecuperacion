package ec.com.electrica;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ListConsumptionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ConsumptionAdapter adapter;
    private List<Consumption> consumptionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consumption);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear datos de ejemplo
        consumptionList = new ArrayList<>();
        consumptionList.add(new Consumption("Enero", 100.0, "Pendiente"));
        consumptionList.add(new Consumption("Febrero", 200.0, "Pagado"));
        consumptionList.add(new Consumption("Marzo", 150.0, "Pendiente"));

        adapter = new ConsumptionAdapter(consumptionList, new ConsumptionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Consumption consumption) {
                Intent intent = new Intent(ListConsumptionActivity.this, ConsumptionDetailActivity.class);
                intent.putExtra("consumption", consumption);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}

package ec.com.electrica;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ConsumptionAdapter extends RecyclerView.Adapter<ConsumptionAdapter.ConsumptionViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Consumption consumption);
    }

    private List<Consumption> consumptionList;
    private OnItemClickListener listener;

    public ConsumptionAdapter(List<Consumption> consumptionList, OnItemClickListener listener) {
        this.consumptionList = consumptionList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ConsumptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_consumption, parent, false);
        return new ConsumptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsumptionViewHolder holder, int position) {
        Consumption consumption = consumptionList.get(position);
        holder.bind(consumption, listener);
    }

    @Override
    public int getItemCount() {
        return consumptionList.size();
    }

    public static class ConsumptionViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMonth, tvValue, tvStatus;

        public ConsumptionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonth = itemView.findViewById(R.id.tvMonth);
            tvValue = itemView.findViewById(R.id.tvValue);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }

        public void bind(final Consumption consumption, final OnItemClickListener listener) {
            tvMonth.setText(consumption.getMonth());
            tvValue.setText(String.valueOf(consumption.getValue()));
            tvStatus.setText(consumption.getStatus());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(consumption);
                }
            });
        }
    }
}

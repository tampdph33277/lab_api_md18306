package tampdph33277.fpoly.lab1_api_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHoder> {
    List<City> list;
    Context context;

    public Adapter(List<City> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemview,parent,false);
        return new ViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHoder holder, int position) {
        holder.textViewCityName.setText("Tên thành phố: "+list.get(position).getTextViewCityName());
        holder.textViewStateCity.setText("Tình thành: "+list.get(position).getTextViewStateCity());
        holder.textViewCountryCity.setText("Quốc gia: "+list.get(position).getTextViewCountryCity());
        holder.textViewPopulation.setText("Dân số: "+list.get(position).getTextViewPopulation());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView textViewCityName , textViewStateCity ,textViewCountryCity , textViewPopulation ;


        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            textViewCityName = (TextView) itemView.findViewById(R.id.textViewCityName);
            textViewStateCity =(TextView) itemView.findViewById(R.id.textViewStateCity);
            textViewCountryCity =(TextView) itemView.findViewById(R.id.textViewCountryCity);
            textViewPopulation = (TextView) itemView.findViewById(R.id.textViewPopulation);

        }
    }
}

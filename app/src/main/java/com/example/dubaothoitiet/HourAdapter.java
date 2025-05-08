package com.example.dubaothoitiet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dubaothoitiet.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourHolder> {

    private Activity activity;
    private List<Wheather> listWheather;

    public HourAdapter(Activity activity, List<Wheather> listWheather) {
        this.activity = activity;
        this.listWheather = listWheather;
    }
    public static class HourHolder extends RecyclerView.ViewHolder {
        private TextView tvTime;
        private ImageView icon;
        private TextView tvTem;

        public HourHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            icon = itemView.findViewById(R.id.icon);
            tvTem = itemView.findViewById(R.id.tvTem);
        }
    }

    @Override
    public HourHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.item_hour, parent, false);
        HourAdapter.HourHolder holder = new HourAdapter.HourHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HourHolder holder, int position) {
        Wheather wheather = listWheather.get(position);

        holder.tvTime.setText(convertTime(wheather.getDateTime()));
        holder.tvTem.setText(String.format("%.1f°", wheather.getTemperature().getValue()));

        String url = "";
        if (wheather.getWeatherIcon() < 10) {
            url = "https://developer.accuweather.com/sites/default/files/0" + wheather.getWeatherIcon() + "-s.png";
        } else {
            url = "https://developer.accuweather.com/sites/default/files/" + wheather.getWeatherIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return listWheather.size();
    }



    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("h a");
        return outFormat.format(date);
    }
}
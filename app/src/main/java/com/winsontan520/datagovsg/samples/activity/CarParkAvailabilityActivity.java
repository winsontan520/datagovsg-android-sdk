package com.winsontan520.datagovsg.samples.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.winsontan520.datagovsg.DataGovSg;
import com.winsontan520.datagovsg.model.CarparkData;
import com.winsontan520.datagovsg.model.DataWrapper;
import com.winsontan520.datagovsg.samples.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarParkAvailabilityActivity extends BaseActivity {

    private static final String TAG = "CarParkAvailability";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // YYYY-MM-DD[T]HH:mm:ss (SGT) E.g. 2016-12-12T09:45:00

        DataGovSg.requestCarparkAvailability(new Callback<DataWrapper>() {

            @Override
            public void onResponse(Call<DataWrapper> call, Response<DataWrapper> response) {
                updateUI(response);
            }

            @Override
            public void onFailure(Call<DataWrapper> call, Throwable t) {
                Log.e(TAG, "onFailure" + t);
            }
        });
    }

    private void updateUI(Response<DataWrapper> response) {
        if(response.code() != 200){
            Toast.makeText(this, "Error response.code() = " + response.code(), Toast.LENGTH_LONG).show();
            return;
        }

        DataWrapper wrapper = response.body();

        List<CarparkData> datas = wrapper.getItems().get(0).getCarparkData();
        Log.d(TAG, "datas size = " + datas.size());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CarParkAvailabilityActivity.CarparkAvailabilityAdapter(datas));
    }

    class CarparkAvailabilityAdapter extends RecyclerView.Adapter<CarParkAvailabilityActivity.CarparkAvailabilityAdapter.ViewHolder> {
        private List<CarparkData> datas;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvData;

            ViewHolder(View v) {
                super(v);
                tvData = (TextView) v.findViewById(R.id.carpark_data);
            }
        }

        CarparkAvailabilityAdapter(List<CarparkData> datas) {
            this.datas = datas;
        }

        @Override
        public CarParkAvailabilityActivity.CarparkAvailabilityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carpark_availability_item, parent, false);
            return new CarParkAvailabilityActivity.CarparkAvailabilityAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CarParkAvailabilityActivity.CarparkAvailabilityAdapter.ViewHolder holder, int position) {
            CarparkData carparkData = this.datas.get(position);
            holder.tvData.setText(carparkData.toString());
        }

        @Override
        public int getItemCount() {
            return this.datas.size();
        }
    }
}

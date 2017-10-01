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
import com.winsontan520.datagovsg.model.DataWrapper;
import com.winsontan520.datagovsg.samples.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaxiAvailabilityActivity extends BaseActivity {
    private static final String TAG = "TaxiAvailability";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        DataGovSg.requestTaxiAvailability(new Callback<DataWrapper>() {

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
        if (response.code() != 200) {
            Toast.makeText(this, "Error response.code() = " + response.code(), Toast.LENGTH_LONG).show();
            return;
        }

        DataWrapper wrapper = response.body();

        // Don't ask me why retrieve data like this, ask the fellow who return json response
        List<List<Double>> data = wrapper.getFeatures().get(0).getGeometry().getCoordinates();
        Log.d(TAG, "data size = " + data.size());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleDataAdapter(data));
    }

    class SimpleDataAdapter extends RecyclerView.Adapter<SimpleDataAdapter.ViewHolder> {
        private List<List<Double>> data;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvData;

            ViewHolder(View v) {
                super(v);
                tvData = (TextView) v.findViewById(R.id.text_view);
            }
        }

        SimpleDataAdapter(List<List<Double>> data) {
            this.data = data;
        }

        @Override
        public SimpleDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false);
            return new SimpleDataAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SimpleDataAdapter.ViewHolder holder, int position) {
            List<Double> data = this.data.get(position);
            holder.tvData.setText(data.toString());
        }

        @Override
        public int getItemCount() {
            return this.data.size();
        }
    }
}

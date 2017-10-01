package com.winsontan520.datagovsg.samples.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.winsontan520.datagovsg.DataGovSg;
import com.winsontan520.datagovsg.model.Camera;
import com.winsontan520.datagovsg.model.DataWrapper;
import com.winsontan520.datagovsg.samples.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrafficImagesActivity extends BaseActivity {

    private static final String TAG = "TrafficImagesActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        DataGovSg.requestTrafficImages(new Callback<DataWrapper>() {

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

        // Don't ask me why retrieve data like this, ask the fellow who return json response
        List<Camera> cameras = wrapper.getItems().get(0).getCameras();
        Log.d(TAG, "cameras size = " + cameras.size());

        for (Camera camera : cameras) {
            Log.d(TAG, "camera " + camera);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrafficCameraAdapter(cameras));
    }

    class TrafficCameraAdapter extends RecyclerView.Adapter<TrafficCameraAdapter.ViewHolder> {
        private List<Camera> mCameras;

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView cameraId;
            TextView latitude;
            TextView longitude;

            ViewHolder(View v) {
                super(v);
                image = (ImageView) v.findViewById(R.id.image);
                cameraId = (TextView) v.findViewById(R.id.camera_id);
                latitude = (TextView) v.findViewById(R.id.latitude);
                longitude = (TextView) v.findViewById(R.id.longitude);
            }
        }

        TrafficCameraAdapter(List<Camera> cameras) {
            mCameras = cameras;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.traffic_images_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Camera camera = mCameras.get(position);

            holder.cameraId.setText(getString(R.string.traffic_camera_id, camera.getCameraId()));
            holder.latitude.setText(getString(R.string.traffic_camera_latitude, String.valueOf(camera.getLocation().getLatitude())));
            holder.longitude.setText(getString(R.string.traffic_camera_longitude, String.valueOf(camera.getLocation().getLongitude())));
            Glide.with(TrafficImagesActivity.this)
                    .load(camera.getImage())
                    .placeholder(R.drawable.image_placeholder)
                    .centerCrop()
                    .into(holder.image);
        }

        @Override
        public int getItemCount() {
            return mCameras.size();
        }
    }
}

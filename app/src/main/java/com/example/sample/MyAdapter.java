package com.example.sample;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sample.Modules.RecyclerViewClickListener;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final RecyclerViewClickListener mListener;
    private List<Driver> listData;

    public MyAdapter(List<Driver> listData, RecyclerViewClickListener listener) {
        this.listData = listData;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_driverlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Driver ld = listData.get(position);
        holder.bind(ld, mListener,position);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  txtname, txtsource, txtdestination, txtspace, txtdate;
        private Button btnCall, btnRequest;

        public ViewHolder(View itemView) {
            super(itemView);
            txtname = (TextView) itemView.findViewById(R.id.name);
            txtsource = (TextView) itemView.findViewById(R.id.source);
            txtdestination = (TextView) itemView.findViewById(R.id.destination);
            txtspace = (TextView) itemView.findViewById(R.id.quantity);
            txtdate = (TextView) itemView.findViewById(R.id.date);
            btnCall = (Button) itemView.findViewById(R.id.button_call);
            btnRequest = (Button) itemView.findViewById(R.id.button_req);
        }

        public void bind(Driver ld, final RecyclerViewClickListener mListener, final int position) {
            txtname.setText(ld.getName());
            txtsource.setText(ld.getSource());
            txtdestination.setText(ld.getDestination());
            txtspace.setText(ld.getSpace());
            txtdate.setText(ld.getDate());
            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onCall(position);
                }
            });
            btnRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(position);


                }
            });
        }
    }
}

package com.tutorials.hp.mysqlrecyclerswiperefresh.m_UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorials.hp.mysqlrecyclerswiperefresh.R;
import com.tutorials.hp.mysqlrecyclerswiperefresh.m_DataObject.Spacecraft;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Spacecraft s=spacecrafts.get(position);

        holder.nameTxt.setText(s.getName());
        PicassoClient.downloadImage(c,s.getImageUrl(),holder.img);

    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}

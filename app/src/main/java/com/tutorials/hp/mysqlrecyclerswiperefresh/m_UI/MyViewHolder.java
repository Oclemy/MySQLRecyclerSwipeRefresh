package com.tutorials.hp.mysqlrecyclerswiperefresh.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.mysqlrecyclerswiperefresh.R;

/**
 * Created by Oclemy on 6/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameTxt;
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img= (ImageView) itemView.findViewById(R.id.spacecraftImage);

    }
}

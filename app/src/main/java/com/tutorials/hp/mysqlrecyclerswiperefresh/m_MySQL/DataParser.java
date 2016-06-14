package com.tutorials.hp.mysqlrecyclerswiperefresh.m_MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tutorials.hp.mysqlrecyclerswiperefresh.m_DataObject.Spacecraft;
import com.tutorials.hp.mysqlrecyclerswiperefresh.m_UI.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class DataParser extends AsyncTask<Void,Void,Boolean> {
    Context c;
    String jsonData;
    RecyclerView rv;
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

    public DataParser(Context c, String jsonData, RecyclerView rv, SwipeRefreshLayout swipeRefreshLayout) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        swipeRefreshLayout.setRefreshing(false);

        if(isParsed)
        {
            //bind
            rv.setAdapter(new CustomAdapter(c,spacecrafts));
        }
        else {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            spacecrafts.clear();
            Spacecraft spacecraft;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("name");
                String imageUrl=jo.getString("imageurl");

                spacecraft=new Spacecraft();

                spacecraft.setId(id);
                spacecraft.setName(name);
                spacecraft.setImageUrl(imageUrl);

                spacecrafts.add(spacecraft);

            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}














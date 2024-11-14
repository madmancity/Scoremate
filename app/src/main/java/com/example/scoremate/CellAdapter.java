package com.example.scoremate;


import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// The adapter class which
// extends RecyclerView Adapter
public class CellAdapter extends RecyclerView.Adapter<CellAdapter.CellViewHolder> {

    // List with String type
    private ArrayList<AtBat> cells;

    public CellAdapter(ArrayList<AtBat> icells) {
        cells = icells;
    }

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public class CellViewHolder
            extends RecyclerView.ViewHolder {

        // Text View
        TextView hittext;
        TextView moundtext;
        TextView inno;
        ImageView first;
        ImageView second;
        ImageView third;
        ImageView home;
        CheckBox b1;
        CheckBox b2;
        CheckBox b3;
        CheckBox s1;
        CheckBox s2;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public CellViewHolder(View view)
        {
            super(view);

            // initialise TextView with id
            hittext = (TextView)view.findViewById(R.id.hittext);
            moundtext = (TextView)view.findViewById(R.id.moundtext);
            inno = (TextView)view.findViewById(R.id.inno);
            first = (ImageView)view.findViewById(R.id.cellfirst);
            second = (ImageView)view.findViewById(R.id.cellsecond);
            third = (ImageView)view.findViewById(R.id.cellthird);
            home = (ImageView)view.findViewById(R.id.cellhome);
            b1 = (CheckBox)view.findViewById(R.id.b1);
            b2 = (CheckBox)view.findViewById(R.id.b2);
            b3 = (CheckBox)view.findViewById(R.id.b3);
            s1 = (CheckBox)view.findViewById(R.id.s1);
            s2 = (CheckBox)view.findViewById(R.id.s2);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type


    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    @Override
    public CellAdapter.CellViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        // Inflate item.xml using LayoutInflator
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cell, parent, false);

        // return itemView
        return new CellViewHolder(itemView);
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
    @Override
    public void onBindViewHolder(final CellViewHolder holder,
                                 final int position)
    {

        int balls = (cells.get(position).getBalls());
        int strikes = (cells.get(position).getStrikes());
        System.out.println(strikes);
        int base = (cells.get(position).getBasereached());
        String hstatus = (cells.get(position).getHstatus());
        String mstatus = (cells.get(position).getMstatus());;
        System.out.println(hstatus);
        switch(strikes){
            case 0:
                holder.s1.setChecked(false);
                holder.s2.setChecked(false);
                break;
            case 1:
                holder.s1.setChecked(true);
                holder.s2.setChecked(false);
                break;
            case 2:
                holder.s1.setChecked(true);
                holder.s2.setChecked(true);
                break;
            case 3:
                holder.s1.setChecked(true);
                holder.s2.setChecked(true);
                break;
            default:
                holder.s1.setChecked(false);
                holder.s2.setChecked(true);

        }
        switch(base){
            case 0:
                holder.first.setVisibility(View.INVISIBLE);
                holder.second.setVisibility(View.INVISIBLE);
                holder.third.setVisibility(View.INVISIBLE);
                holder.home.setVisibility(View.INVISIBLE);
                break;
            case 1:
                holder.first.setVisibility(View.VISIBLE);
                holder.second.setVisibility(View.INVISIBLE);
                holder.third.setVisibility(View.INVISIBLE);
                holder.home.setVisibility(View.INVISIBLE);
                break;
            case 2:
                holder.first.setVisibility(View.VISIBLE);
                holder.second.setVisibility(View.VISIBLE);
                holder.third.setVisibility(View.INVISIBLE);
                holder.home.setVisibility(View.INVISIBLE);
                break;
            case 3:
                holder.first.setVisibility(View.VISIBLE);
                holder.second.setVisibility(View.VISIBLE);
                holder.third.setVisibility(View.VISIBLE);
                holder.home.setVisibility(View.INVISIBLE);
                break;
            case 4:
                holder.first.setVisibility(View.VISIBLE);
                holder.second.setVisibility(View.VISIBLE);
                holder.third.setVisibility(View.VISIBLE);
                holder.home.setVisibility(View.VISIBLE);
                break;
        }
        switch(balls){
            case 0:
                holder.b1.setChecked(false);
                holder.b2.setChecked(false);
                holder.b3.setChecked(false);
                break;
            case 1:
                holder.b1.setChecked(true);
                holder.b2.setChecked(false);
                holder.b3.setChecked(false);
                break;
            case 2:
                holder.b1.setChecked(true);
                holder.b2.setChecked(true);
                holder.b3.setChecked(false);
                break;
            case 3:
                holder.b1.setChecked(true);
                holder.b2.setChecked(true);
                holder.b3.setChecked(true);
                break;
            case 4:
                holder.b1.setChecked(true);
                holder.b2.setChecked(true);
                holder.b3.setChecked(true);
                break;
            default:
                holder.b1.setChecked(false);
                holder.b2.setChecked(false);
                holder.b3.setChecked(false);
                break;

        }

        holder.hittext.setText(hstatus);
        holder.moundtext.setText(mstatus);


    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.

}
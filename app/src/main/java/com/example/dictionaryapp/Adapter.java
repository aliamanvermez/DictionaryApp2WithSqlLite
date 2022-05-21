package com.example.dictionaryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Kelimeler>kelimelerList;

    public Adapter(Context mContext, List<Kelimeler> kelimelerList) {
        this.mContext = mContext;
        this.kelimelerList = kelimelerList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kelimeler kelime = kelimelerList.get(position);
        holder.textViewEnglish.setText(kelime.getIngilizce());
        holder.textViewTurkish.setText(kelime.getTurkce());

        holder.kelime_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,DetayActivity.class);

                intent.putExtra("nesne",kelime);

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kelimelerList.size();
    }

    public  class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private TextView textViewEnglish;
        private TextView textViewTurkish;
        private CardView kelime_card;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            textViewTurkish = itemView.findViewById(R.id.textViewTurkish);
            kelime_card = itemView.findViewById(R.id.kelime_card);

        }
    }



}






















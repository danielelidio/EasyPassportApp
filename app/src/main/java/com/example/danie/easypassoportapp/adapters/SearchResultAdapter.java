package com.example.danie.easypassoportapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.danie.easypassoportapp.R;
import com.example.danie.easypassoportapp.models.SearchResultItem;
import com.example.danie.easypassoportapp.models.SearchResultsModel;

/**
 * Created by danie on 14/06/2016.
 */
public class SearchResultAdapter extends BaseAdapter {
    SearchResultsModel tips = null;
    Activity _activity = null;
    private LayoutInflater mInflater = null;

    public SearchResultAdapter(Context context, SearchResultsModel tips) {
        this.tips = tips;

        this.mInflater = ((Activity)context).getLayoutInflater();
    }

    @Override
    public int getCount() {
        return this.tips.getSize();
    }

    @Override
    public Object getItem(int position) {
        return this.tips.getResult(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //infla o layout para podermos pegar as views
        View view = (convertView != null) ? convertView : this.mInflater.inflate(R.layout.layout_search_result_item, null);

        //cria um item de suporte para não precisarmos sempre
        //inflar as mesmas informacoes
        TextView textNumber = ((TextView) view.findViewById(R.id.textNumber));
        TextView textTitle = ((TextView) view.findViewById(R.id.textTitle));
        TextView textDescription = ((TextView) view.findViewById(R.id.textDescription));

        //pega os dados da lista
        //e define os valores nos itens.
        SearchResultItem tip = this.tips.getResult(position);
        textNumber.setText(tip.getNrFormatted());
        textTitle.setText(tip.getTitle());
        textDescription.setText(tip.getShortDescription());

        //retorna a view com as informações
        return view;
    }
}

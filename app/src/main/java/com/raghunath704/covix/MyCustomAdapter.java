package com.raghunath704.covix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<CounteryModel> {

    private  Context context;
    private List<CounteryModel> counteryModelList;
    private List<CounteryModel> counteryModelListFiltered;
    public MyCustomAdapter(Context context, List<CounteryModel> counteryModelList) {
        super(context, R.layout.list_custom_item,counteryModelList);

        this.context=context;
        this.counteryModelList=counteryModelList;
        this.counteryModelListFiltered=counteryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName=view.findViewById(R.id.tvCountryName);
        ImageView imageView=view.findViewById(R.id.imageFlag);


        tvCountryName.setText(counteryModelListFiltered.get(position).getCountry());
        Glide.with(context).load(counteryModelListFiltered.get(position).getFlag()).into(imageView);


        return view;
    }

    @Override
    public int getCount() {
        return counteryModelListFiltered.size();
    }

    @Nullable
    @Override
    public CounteryModel getItem(int position) {
        return counteryModelListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = counteryModelList.size();
                    filterResults.values = counteryModelList;
                } else {
                    List<CounteryModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (CounteryModel itemsModel : counteryModelList) {
                        if (itemsModel.getCountry().toLowerCase().contains(searchStr)) {
                            resultsModel.add(itemsModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }
                }
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                counteryModelListFiltered=(List<CounteryModel>) results.values;
                AffectedCountries.counteryModelList=(List<CounteryModel>) results.values;
                notifyDataSetChanged();
            }

        };
        return filter;

    }
}

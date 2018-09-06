package in.semicolonindia.vollypostdemoexample2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.semicolonindia.vollypostdemoexample2.ItemDetails;
import in.semicolonindia.vollypostdemoexample2.R;

/*
import in.semicolonindia.vollypostdemoexample2.R;
import in.semicolonindia.vollypostdemoexample2.ItemDetails;
*/

/**
 * Created by MPAYAL-PC on 9/19/2017.
 */
@SuppressWarnings("ALL")
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<ItemDetails> itemDetailsList;

    Context context;

    public RecyclerAdapter(Context context, List<ItemDetails> itemDetailsList) {
        this.context = context;
        this.itemDetailsList= itemDetailsList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, null);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_Id.setText(itemDetailsList.get(position).getNotice_id());
        holder.tv_title.setText(itemDetailsList.get(position).getNotice_title());
        holder.tv_date.setText(itemDetailsList.get(position).getDate());
        holder.tv_Description.setText(itemDetailsList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {

        return itemDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_Id, tv_title, tv_date, tv_Description;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_Id = (TextView) itemView.findViewById(R.id.txt_id);
            tv_title = (TextView) itemView.findViewById(R.id.txt_title);
            tv_date = (TextView) itemView.findViewById(R.id.txt_date);
            tv_Description = (TextView) itemView.findViewById(R.id.txt_description);
        }
    }
}

package gunveer.codes.machinetask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static gunveer.codes.machinetask.Fetcher.dataFetcheds;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.MyViewHolder> {


    Context context;

    public RecViewAdapter(ArrayList<DataFetched> dataFetcheds, Context context) {
        //this.dataFetcheds = dataFetcheds;
        this.context = context;
    }

    public static ArrayList<DataFetched> getdataFetcheds() {
        return dataFetcheds;
    }

    @NonNull
    @Override
    public RecViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feched_data_layout, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecViewAdapter.MyViewHolder holder, int position) {

        holder.tv_id.setText(Integer.toString(dataFetcheds.get(position).getId()));
        holder.tv_contact.setText(dataFetcheds.get(position).getContact());
        holder.tv_mem_num.setText(dataFetcheds.get(position).getMembership_number());
        holder.tv_list_year.setText(dataFetcheds.get(position).getList_year());
        holder.tv_fullName.setText(dataFetcheds.get(position).getFull_name());
        holder.tv_email.setText(dataFetcheds.get(position).getEmail_id());
        holder.tv_address.setText(dataFetcheds.get(position).getAddress());
        holder.tv_dataType.setText(dataFetcheds.get(position).getData_type());
        holder.tv_designation.setText(dataFetcheds.get(position).getDesignation());
        holder.imageView.setImageDrawable(null);
        Glide.with(context).load(dataFetcheds.get(position).getProfile_pic_url()).into(holder.imageView);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsScreen.class);

                intent.putExtra("details_id", dataFetcheds.get(position).getId());
                intent.putExtra("details_full_name", dataFetcheds.get(position).getFull_name());
                intent.putExtra("details_contact", dataFetcheds.get(position).getContact());
                intent.putExtra("details_email", dataFetcheds.get(position).getEmail_id());
                intent.putExtra("details_mem_num", dataFetcheds.get(position).getMembership_number());
                intent.putExtra("details_address", dataFetcheds.get(position).getAddress());
                intent.putExtra("details_list_year", dataFetcheds.get(position).getList_year());
                intent.putExtra("details_data_type", dataFetcheds.get(position).getData_type());
                intent.putExtra("details_designation", dataFetcheds.get(position).getDesignation());
                intent.putExtra("details_imageView", dataFetcheds.get(position).getProfile_pic_url());


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        if(dataFetcheds == null){
            return 0;
        }else{
            return dataFetcheds.size();
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_id, tv_contact, tv_mem_num, tv_list_year, tv_fullName,
        tv_email, tv_address, tv_dataType, tv_designation;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_contact = itemView.findViewById(R.id.tv_contact);
            tv_mem_num = itemView.findViewById(R.id.tv_mem_num);
            tv_list_year = itemView.findViewById(R.id.tv_list_year);
            tv_fullName = itemView.findViewById(R.id.tv_fullName);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_dataType = itemView.findViewById(R.id.tv_dataType);
            tv_designation = itemView.findViewById(R.id.tv_designation);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}

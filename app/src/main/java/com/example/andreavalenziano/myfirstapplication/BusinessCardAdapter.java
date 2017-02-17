package com.example.andreavalenziano.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by amine on 15/02/17.
 */

public class BusinessCardAdapter extends RecyclerView.Adapter<BusinessCardAdapter.BusinessCardVH> {


    private static BusinessCardAdapter instance=new BusinessCardAdapter();
    private ArrayList<BusinessCard> dataSet = new ArrayList<>();

    public static BusinessCardAdapter getInstance(){
        return instance;
    }


    public void addBusinessCard(BusinessCard bc){

        dataSet.add(0,bc);
        notifyItemInserted(0);
    }

    public void setDataSet (ArrayList<BusinessCard> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void changeBusinessCard(BusinessCard bc){
        dataSet.set(bc.getId()-1,bc);
        notifyDataSetChanged();
    }

    public void changeName(String name, int id){
        dataSet.get(id).setName(name);
        notifyDataSetChanged();
    }

    @Override
    public BusinessCardAdapter.BusinessCardVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_business_card,parent,false);
        return new BusinessCardVH(view);
    }

    @Override
    public void onBindViewHolder(BusinessCardAdapter.BusinessCardVH holder, int position) {

        BusinessCard businessCard = dataSet.get(position);
        holder.nameTv.setText(businessCard.getName());
        holder.emailTv.setText(businessCard.getEmail());
        holder.phoneNumberTv.setText(businessCard.getPhoneNumber());
        holder.courseTv.setText(businessCard.getCourse());
        holder.addressTv.setText(businessCard.getAddress());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }





    public class BusinessCardVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nameTv, phoneNumberTv,emailTv, courseTv, addressTv;
        Button goBtn, callBtn, sendEmailBtn, infoBtn;

        public BusinessCardVH(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.name);
            phoneNumberTv = (TextView) itemView.findViewById(R.id.tel);
            emailTv = (TextView)itemView.findViewById(R.id.email);
            courseTv = (TextView)itemView.findViewById(R.id.corso);
            addressTv = (TextView)itemView.findViewById(R.id.pos);
            infoBtn = (Button) itemView.findViewById(R.id.info_btn);
            goBtn = (Button) itemView.findViewById(R.id.go_btn);
            callBtn = (Button) itemView.findViewById(R.id.call_btn);
            sendEmailBtn = (Button) itemView.findViewById(R.id.send_email_btn);
            infoBtn.setOnClickListener(this);
            goBtn.setOnClickListener(this);
            callBtn.setOnClickListener(this);
            sendEmailBtn.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            System.out.println(view.getId());
            if (view.getId() == R.id.go_btn) {
                System.out.println("go");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("geo:0,0?q=" + dataSet.get(getAdapterPosition()).getAddress());
                intent.setData(uri);
                view.getContext().startActivity(intent);
            } else if (view.getId() == R.id.call_btn) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("tel:" + dataSet.get(getAdapterPosition()).getPhoneNumber());
                intent.setData(uri);
                view.getContext().startActivity(intent);

            } else if (view.getId() == R.id.send_email_btn) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, dataSet.get(getAdapterPosition()).getEmail());
                view.getContext().startActivity(Intent.createChooser(intent, "@string/send_email"));


            }else if(view.getId()==R.id.info_btn){
                Intent intent=new Intent(view.getContext(),InfoActivity.class);
                System.out.println("info");
                ContactActivity.showSnackBar(dataSet.get(getAdapterPosition()).getName());
                intent.putExtra(ContactActivity.USER_NAME,nameTv.getText());
                intent.putExtra(ContactActivity.ID,String.valueOf(getAdapterPosition()));
                ContactActivity context=(ContactActivity) view.getContext();
                context.startActivityForResult(intent,1);
            }

        }


    }

}
package pc.dd.vegetables_simple.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import pc.dd.vegetables_simple.Activitys.FullDescriptionAct;
import pc.dd.vegetables_simple.R;

/**
 * Created by User on 12.12.2016.
 */

public class AdapterForSearchResult extends BaseAdapter {

    private ArrayList mName;
    private ArrayList mDescription;
    private ArrayList mPrice;
    private ArrayList mUrlImage;
    private Activity mContext;
    private ImageView imageView = null;
    private TextView name = null;
    private  GridView.LayoutParams params = null;
    //HashMap<Integer,Boolean> chekClickedCategory = new HashMap<Integer,Boolean>();

    public AdapterForSearchResult( ArrayList name1,ArrayList UrlImage,ArrayList detail_description,ArrayList price,  Activity context ) {
        mUrlImage = UrlImage;
        mName= name1;
        mContext = context;
        mDescription = detail_description;
        mPrice = price;
    }

    public int getCount() {
        return mName.size();
    }

    public Object getItem(int position) {
        return mName.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int id, View view, ViewGroup viewGroup) {
        //display metrics
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int width = metrics.widthPixels / 2;
        int height = metrics.heightPixels / 4;

        imageView = new ImageView(mContext); //add image

        params= new GridView.LayoutParams(width, height); //params for grid view

        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(0,0,0,0);
        imageView.setTransitionName("photo");

        //layout for cool view
        RelativeLayout line = new RelativeLayout(mContext);
        line.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height/6));
        line.setBackgroundColor(mContext.getResources().getColor(R.color.black));
        line.setPadding(0,0,0,5);
        line.setGravity(Gravity.TOP);
        line.setAlpha(0.5f);

        //name of object
        name = new TextView(mContext);
        name.setText(mName.get(id).toString());
        name.setEllipsize(TextUtils.TruncateAt.END);
        name.setGravity(Gravity.BOTTOM);
        name.setTextColor(mContext.getResources().getColor(R.color.white));
        name.setPadding(6,6,6,6);
        name.setMaxLines(1);

        //added view
        CardView cardView = new CardView(mContext);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        cardView.setForegroundGravity(Gravity.BOTTOM);
        cardView.setElevation(5);
        cardView.addView(imageView);

        line.addView(name);
        cardView.addView(line);

        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(params);
        layout.setGravity(Gravity.BOTTOM);
        layout.setPadding(10,10,10,10);
        layout.addView(cardView);

    Picasso.with(mContext)
            .load(mUrlImage.get(id).toString())
    .placeholder(R.drawable.ic_crop_original_white_24dp_4x)
    .error(R.drawable.ic_errorl_white_24dp_4x)
    .into(imageView);
// if we clicked then go to new activity discription
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDescriptionActivity(v,mName.get(id).toString(),mDescription.get(id).toString(),mPrice.get(id).toString(),mUrlImage.get(id).toString());
            }
        });

    return layout;

    }
    private void goToDescriptionActivity(View imageView,String name,String description, String price, String p_url){

        Intent i = new Intent(mContext,FullDescriptionAct.class);//from where

        i.setAction(i.ACTION_VIEW);

        imageView.buildDrawingCache();
        Bitmap image= imageView.getDrawingCache();
       // image.recycle();

        Bundle extras = new Bundle();
        extras.putParcelable("photo", image); //ложим изображение
        extras.putString("name",name);
        extras.putString("description",description);
        extras.putString("price",price);
        extras.putString("photo_url",p_url);
        extras.putBoolean("added_btn",true);
        i.putExtras(extras);

      //  imageView.setDrawingCacheEnabled(false);

       mContext.startActivity(i,
               ActivityOptions.makeSceneTransitionAnimation(
                       mContext,
                        imageView //наше фото
                        ,
                       imageView.getTransitionName() // transition name
                ).toBundle());

    }


}
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
 * Created by User on 15.12.2016.
 */

public class AdapterForAddedResult extends BaseAdapter {

    private ArrayList mName;
    private ArrayList mDescription;
    private ArrayList mUrlImage;
    private Activity mContext;
    private ImageView imageView = null;
    private TextView name = null;
    private  GridView.LayoutParams params = null;
    int width = 0;
    int height = 0;
    //HashMap<Integer,Boolean> chekClickedCategory = new HashMap<Integer,Boolean>();

    public AdapterForAddedResult( ArrayList name1,ArrayList UrlImage,ArrayList detail_description,ArrayList price,  Activity context ) {
        mUrlImage = UrlImage;
        mName= name1;
        mContext = context;
        mDescription = detail_description;

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
        //get display size
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels / 3;


        imageView = new ImageView(mContext);//set new image
        params = new GridView.LayoutParams(width, height); //params for grid view
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setTransitionName("photo");

        //layout for cool view
        RelativeLayout line = new RelativeLayout(mContext);
        line.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height/5));
        line.setBackgroundColor(mContext.getResources().getColor(R.color.black));
        line.setPadding(0,0,0,8);
        line.setGravity(Gravity.CENTER_VERTICAL);
        line.setAlpha(0.7f);

        //name of object
        name = new TextView(mContext);
        name.setText(mName.get(id).toString());
        name.setEllipsize(TextUtils.TruncateAt.END);
        name.setGravity(Gravity.BOTTOM);
        name.setTextColor(mContext.getResources().getColor(R.color.white));
        name.setPadding(8, 8, 8, 8);
        name.setMaxLines(1);

        //added view
        CardView cardView = new CardView(mContext);
        cardView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        cardView.setForegroundGravity(Gravity.BOTTOM);
        cardView.setElevation(6);
        cardView.addView(imageView);

        line.addView(name);
        cardView.addView(line);

        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(params);
        layout.setGravity(Gravity.BOTTOM);
        layout.setPadding(14, 12, 14, 12);
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
                goToDescriptionActivity(v,mName.get(id).toString(),mDescription.get(id).toString(),"0",mUrlImage.get(id).toString());
            }
        });

        return layout;
    }

    private void goToDescriptionActivity(View imageView,String name,String description, String price, String p_url){

        Intent i = new Intent(mContext,FullDescriptionAct.class);//from where

        i.setAction(i.ACTION_VIEW);

        imageView.setDrawingCacheEnabled(true);

        // Without it the view will have a dimension of 0,0 and the bitmap will be null
        imageView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        imageView.layout(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());

        imageView.buildDrawingCache(true);
        Bitmap b = Bitmap.createBitmap(imageView.getDrawingCache()); //can be error
        imageView.setDrawingCacheEnabled(false); // clear drawing cache

//        imageView.buildDrawingCache(true); //imageView.setDrawingCacheEnabled(false);
//        Bitmap image= imageView.getDrawingCache();
//        imageView.destroyDrawingCache();// -> not works

        Bitmap scaledBitmap =  scaleDown(b, 400, true , width,height); // convert -> image size must be <1mb
        Bundle extras = new Bundle();
        extras.putParcelable("photo", scaledBitmap); //ложим айди
        extras.putString("name",name);
        extras.putString("description",description);
        extras.putString("price","0");
        extras.putString("photo_url",p_url);
        extras.putBoolean("added_btn",false);
        i.putExtras(extras);
       // mContext.startActivity(i);
        mContext.startActivity(i,
                ActivityOptions.makeSceneTransitionAnimation(
                        mContext,
                        imageView //наше фото
                        ,
                        imageView.getTransitionName() // transition name
                ).toBundle());

    }
    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter, int width_s, int height_s) {
        float ratio = Math.min(
                (float) maxImageSize / width_s,
                (float) maxImageSize / height_s);
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }



}
package pc.dd.vegetables_simple.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import pc.dd.vegetables_simple.R;

/**
 * Created by User on 11.12.2016.
 */

public class AdapterForTags  extends BaseAdapter {
    private Context mview;
    private ArrayList list;
    public static ArrayList category_for_search = new ArrayList();
    HashMap<Integer,Boolean> chekClickedCategory = new HashMap<Integer,Boolean>();

    public AdapterForTags(Context c, ArrayList list2) {
        mview = c;
        list= list2;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return createOneCategory(mview, (String) list.get(i),i*10);
    }

    private View createOneCategory(final Context v, String category, final int id){
        //add checked if clicked
        chekClickedCategory.put(id,false);

        //add layout
        final LinearLayout temp = new LinearLayout(v);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(1,8,1,2);
       // temp.setLayoutParams(layoutParams);

        // add card
        CardView cardView = new CardView(v);
        cardView.setLayoutParams(layoutParams);
        cardView.setElevation(2);
        cardView.setPreventCornerOverlap(false);
        cardView.setUseCompatPadding(true);
        cardView.setRadius(6);
        cardView.setPadding(0,6,0,6);

        //layout settings
        ColorDrawable cd = new ColorDrawable(ContextCompat.getColor(v, R.color.colorAccent)); // color layout //background
        temp.setBackground(cd);
        temp.setPadding(10,8,10,8);
        temp.setGravity(Gravity.CENTER);

        //add text
        final TextView mCategory = new TextView(v);
        mCategory .setText(category);
        mCategory .setId(id*100); // R.id settings
        mCategory .setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mCategory.setTextColor(ContextCompat.getColor(v, R.color.white));
        mCategory.setPadding(14,0,0,0); // text from left

        //add circle
        ImageView circle = new ImageView(v);
        circle.setScaleType(ImageView.ScaleType.CENTER);
        circle.setImageResource(R.drawable.little_circle); // driwing before
        circle.setPadding(0,0,0,0);
        circle.setMinimumHeight(12);
        circle.setMinimumWidth(12);

        //add text to layout
        temp.addView(circle);
        temp.addView(mCategory);
        cardView.addView(temp);

        //if clicked
        cardView.setClickable(true);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                // layout view , root view for context, hashmap for checked, id element(key)
               categoryClick(temp,v,chekClickedCategory.get(id),id,mCategory.getText().toString());
            }
        });
        //add to main layout
        return cardView;
    }
    public void categoryClick(LinearLayout colorLayout, Context root, Boolean cheked,int id,String category_name){
        ColorDrawable cd;
        chekClickedCategory.remove(id);//remove position
        if(!cheked) {
            chekClickedCategory.put(id,true); //add position again
            cd = new ColorDrawable(ContextCompat.getColor(root, R.color.colorClickedCategory));
            category_for_search.add(category_name); //add category for search
        }
        else{
            chekClickedCategory.put(id,false); //add
            cd = new ColorDrawable(ContextCompat.getColor(root, R.color.colorAccent));
            category_for_search.remove(category_name); // add category for search
        }
        colorLayout.setBackground(cd); // set like we clicked

    }
}
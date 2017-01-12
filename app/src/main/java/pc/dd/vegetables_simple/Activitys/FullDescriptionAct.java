package pc.dd.vegetables_simple.Activitys;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import pc.dd.vegetables_simple.*;
import pc.dd.vegetables_simple.R;

/**
 * Created by User on 14.12.2016.
 */

public class FullDescriptionAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription);

        //initializing
        ImageView imageDescriptionAct = (ImageView) findViewById(R.id.image_description_act);
        TextView nameTextView = (TextView)findViewById(R.id.name_of_content_discription);
        TextView descriptionTextView = (TextView)findViewById(R.id.full_description_descAct);
        TextView priceTextView = (TextView)findViewById(R.id.price_text_description);
        LinearLayout btnaddLayout = (LinearLayout) findViewById(R.id.btn_add_layout);
        final ImageView addImageView = (ImageView) findViewById(R.id.add_imageView_description);

        //action bar back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get image from back activity
        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("photo");
        final String name = extras.getString("name");
        String price = extras.getString("price");
        final String description = extras.getString("description");
        final String photo_url = extras.getString("photo_url");
        final Boolean add_btn = extras.getBoolean("added_btn");

        //if add_btn false then not show add btn
        if (!add_btn)
        {btnaddLayout.setVisibility(View.GONE);}

        //get params to image1
        DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels /2;

        //set layout params
        imageDescriptionAct.setLayoutParams(new LinearLayout.LayoutParams(width,height));
        imageDescriptionAct.setImageBitmap(bmp);
        nameTextView.setText(name);
        descriptionTextView.setText(description);
        priceTextView.setText(price+" $");



        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSingleton.getInstance(FullDescriptionAct.this.getApplicationContext()).addDatatoDatabase(photo_url,name,description,FullDescriptionAct.this);//ad description to act
            }
        });
    }
    public void addImageViewClick(String photo_url,String name,String description,Context c){



    }
    @Override
    public boolean onSupportNavigateUp(){
       // finish();// if finish no back response -> then error -> call after onActivityResult
        onBackPressed();
        return true;
    }
}

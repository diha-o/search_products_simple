package pc.dd.vegetables_simple.Fragments;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import pc.dd.vegetables_simple.Activitys.MainAct;
import pc.dd.vegetables_simple.Adapters.AdapterForAddedResult;
import pc.dd.vegetables_simple.DBHelper;
import pc.dd.vegetables_simple.R;

/**
 * Created by User on 14.12.2016.
 */

public class SavedProductsInMainAct extends Fragment {
    private ArrayList aName = new ArrayList();
    private ArrayList aUrl = new ArrayList();
    private ArrayList aDescription = new ArrayList();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.saved_products_in_main_act,container,false);
        GridView gridView = (GridView)  rootView.findViewById(R.id.savedproducts_gridview);
        gridView.setNumColumns(1);
        gridView.setColumnWidth(GridView.AUTO_FIT);
        //get database saved file
        try {
           DBHelper helper = new DBHelper(rootView.getContext());
            SQLiteDatabase database = helper.getWritableDatabase();
            Cursor c = database.query("di", null, null, null, null, null, null);
            if (c.moveToFirst()) {

                // определяем номера столбцов по имени в выборке
                int nameColIndex = c.getColumnIndex("name");
                int urlColIndex = c.getColumnIndex("photo_url");
                int descriptionColIndex = c.getColumnIndex("description");

                do {
                    aName.add(c.getString(nameColIndex));
                    aDescription.add(c.getString(descriptionColIndex));
                    aUrl.add(c.getString(urlColIndex));
                    //textView.setText(c.getString(nameColIndex));
                } while (c.moveToNext());

                //adapter
                gridView.setAdapter(new AdapterForAddedResult(aName,aUrl,aDescription,null,(MainAct)getActivity()));

            } else
                Toast.makeText(rootView.getContext(),"Can't load added products list",Toast.LENGTH_LONG).show();
            c.close(); // close basa

        }catch(Exception e){e.printStackTrace();}

        return rootView;
    }
}

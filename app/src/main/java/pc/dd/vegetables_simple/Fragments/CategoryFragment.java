package pc.dd.vegetables_simple.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.gson.Gson;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import JsonFormatted.Category.CategoryJsonParser;
import JsonFormatted.Category.JsonCategoryParsed;
import pc.dd.vegetables_simple.Adapters.AdapterForTags;
import pc.dd.vegetables_simple.AsyncTaskForCategory;
import pc.dd.vegetables_simple.AsyncTaskForSearch;
import pc.dd.vegetables_simple.InterfaceForCategory;
import pc.dd.vegetables_simple.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 15.12.2016.
 */
public class CategoryFragment extends Fragment {

    private String KEY = "l6pdqjuf7hdf97h1yvzadfce";
    //get retrofit builder
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://openapi.etsy.com/v2/taxonomy/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    InterfaceForCategory categoryParsed = retrofit.create(InterfaceForCategory.class);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this fragment across configuration changes.
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(
                R.layout.search_fragment, container, false);

        //initializing
        ImageView search_icon = (ImageView) rootView.findViewById(R.id.search_icon);
        EditText editText = (EditText) rootView.findViewById(R.id.search) ;
        ImageView refreshCategory_icon = (ImageView) rootView.findViewById(R.id.refresh_category_icon);
        //
        //set search action btn
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search_newAct(rootView);
                    return true;
                }
                return false;
            }
        });

        search_icon.setAlpha(85);
        search_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_newAct(rootView);
            }
        });

        editText.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP); // without line in edit text
        final GridView layoutCategory = (GridView)rootView.findViewById(R.id.categoryView);
        layoutCategory.setNumColumns(GridView.AUTO_FIT);

        //change to retrofit
      /*  new AsyncTaskForCategory().execute(layoutCategory,rootView);
        refreshCategory_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().rotation(360).setDuration(700).start(); //animation if clicked
                new AsyncTaskForCategory().execute(layoutCategory,rootView);
            }
        });*/
        //change to retrofit from now
            categoryParsed.getData(KEY).enqueue(new Callback<CategoryJsonParser>() {
            @Override
            public void onResponse(Call<CategoryJsonParser> call, Response<CategoryJsonParser> response) {
               try {
                   List<JsonCategoryParsed> jsonList = response.body().getResults();

                   //all response to category
                   ArrayList templist = new ArrayList();
                   for (int i = 0; i != jsonList.size(); i++)
                       templist.add(jsonList.get(i).getCategoryName());

                   makeListofCategory(templist, CategoryFragment.this.getContext(), layoutCategory);

                   Log.d("Success \n\n\n", response.message());
                   Toast.makeText(CategoryFragment.this.getContext(),"Load Category Success", Toast.LENGTH_SHORT).show();

               } catch (Exception e){
                   Toast.makeText(CategoryFragment.this.getContext(),"Load Category Error", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<CategoryJsonParser> call, Throwable t) {
                Log.d("Error \n\n\n", t.getMessage());
            }
        });


        //
        return rootView;
    }
    public void makeListofCategory(ArrayList list, Context context ,GridView layoutCategory){
        AdapterForTags adapterForTags = new AdapterForTags(context,list);
        layoutCategory.setAdapter(adapterForTags);
    }
    public void search_newAct(View v){
        EditText editText = (EditText) v.findViewById(R.id.search);
        //check
        if ((editText.getText().toString().equals(""))||(AdapterForTags.category_for_search.size()==0)){
            Toast.makeText(v.getContext(),"Please write something and pik more that 1 category before search.",Toast.LENGTH_SHORT).show();
        }else {
            ProgressDialog mProgressDialog = new ProgressDialog(v.getContext());
            mProgressDialog.setMessage("In process..");
            mProgressDialog .setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            //start new act
            new AsyncTaskForSearch(editText.getText().toString()).execute(v,editText);
        }
    }


}

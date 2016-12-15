package pc.dd.vegetables_simple.Activitys;

import android.support.v4.widget.SwipeRefreshLayout;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import JsonFormatted.Search.Result;
import JsonFormatted.Search.SearchJsonParsed;
import pc.dd.vegetables_simple.Adapters.AdapterForSearchResult;
import pc.dd.vegetables_simple.R;

/**
 * Created by User on 12.12.2016.
 */

public class SearchViewProducts extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SearchJsonParsed mSearchJsonParsed;
    private String SearchResult;
    public String searchString;
    private  GridView gridView;
    private  SwipeRefreshLayout mSwipeRefreshLayout;
    // data
    ArrayList mName = new ArrayList();
    ArrayList mUrlImage = new ArrayList();
    ArrayList descriprion = new ArrayList();
    ArrayList price = new ArrayList();
    //
    public SearchJsonParsed getmSearchJsonParsed(String o)
    {   //parsing data
        Gson gson = new Gson();
        SearchJsonParsed gsonObj = new SearchJsonParsed();
        try{
            String jsonOutput = o;
            gsonObj = gson.fromJson(jsonOutput, SearchJsonParsed.class);

        } catch (Exception e){
            e.printStackTrace();
        }
        return gsonObj;
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        //get data
        Intent i = getIntent();
        if (i!=null) {
            SearchResult = i.getStringExtra("SString");
            searchString = i.getStringExtra("S");
        }

        //action bar back icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get data
        mSearchJsonParsed = getmSearchJsonParsed(SearchResult);
        List<Result> results = mSearchJsonParsed.getResults();
        try{
        for (int j = 0; j!=results.size();j++) {
            mName.add(results.get(j).getTitle());
            mUrlImage.add(results.get(j).getImages().get(0).getUrl570xN());
            descriprion.add(results.get(j).getDescription());
            price.add(results.get(j).getPrice());
        }}
        catch (Exception e) {e.printStackTrace();}

        //set grid wiew
        gridView = (GridView) findViewById(R.id.GridViewSearchResult);
        gridView.setNumColumns(2); //number of colums
        gridView.setColumnWidth(GridView.AUTO_FIT);

        //set swipe refresh
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout) ;
        mSwipeRefreshLayout.setOnRefreshListener(this);
        try{
        mSwipeRefreshLayout.setColorScheme(getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorClickedCategory),
                getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorPrimary));} catch (Exception e){e.printStackTrace();}

        // set adapter
        gridView.setAdapter(new AdapterForSearchResult(mName,mUrlImage,descriprion,price,SearchViewProducts.this));
    }
    @Override
    public boolean onSupportNavigateUp(){
        Intent i = new Intent(this,MainAct.class);
        startActivity(i);
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        onSupportNavigateUp();
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);

        // 3 seconds wait
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    gridView.deferNotifyDataSetChanged();
                    gridView.setAdapter(new AdapterForSearchResult(mName,mUrlImage,descriprion,price,SearchViewProducts.this));
                } catch (Exception e) {e.printStackTrace(); Toast.makeText(SearchViewProducts.this, "Error refresh", Toast.LENGTH_SHORT).show();}
                mSwipeRefreshLayout.setRefreshing(false);
                // when we refresh
                Toast.makeText(SearchViewProducts.this, "Refreshed", Toast.LENGTH_SHORT).show();
            }
        }, 3000);
    }
}

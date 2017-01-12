package pc.dd.vegetables_simple;

import android.os.AsyncTask;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import JsonFormatted.Category.CategoryJsonParser;
import JsonFormatted.Category.JsonCategoryParsed;
import pc.dd.vegetables_simple.Adapters.AdapterForTags;

public class AsyncTaskForCategory extends AsyncTask<View, Integer, Object>
{
    private static final String URL_CATEGORY = "https://openapi.etsy.com/v2/taxonomy/categories?api_key=l6pdqjuf7hdf97h1yvzadfce";
    private String mResponse = null;
    private View rootView  = null;
    private GridView rootLayout = null;
    @Override
    protected Object doInBackground(View... v) {

        //get old view
        rootLayout = (GridView) v[0];
        rootView = v[1];

        //do get response
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(URL_CATEGORY);

        HttpResponse response;
        try {
            response = client.execute(request);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            mResponse= convertStreamToString(is); // get string
        } catch (IOException e) {
            e.getMessage().toString();
            e.printStackTrace();

        }
        return mResponse; // return our string
    }
    @Override
    protected void onPostExecute(Object o) {
        //get list of objects
        //parsing string to normal list
        Gson gson = new Gson();
        try {
        String jsonOutput = o.toString();
        CategoryJsonParser gsonObj = gson.fromJson(jsonOutput, CategoryJsonParser.class);
        List<JsonCategoryParsed> jsonList = gsonObj.getResults();

        //all response to category
        ArrayList templist = new ArrayList();
        for (int i = 0; i!=jsonList.size();i++)
            templist.add(jsonList.get(i).getCategoryName());
        //Type listType = new TypeToken<List<CategoryJsonParser>>(){}.getType();
       //List<CategoryJsonParser> posts = (List<CategoryJsonParser>)gson.fromJson(jsonOutput,listType);
        makeListofCategory(templist);
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(rootView.getContext(),"Can't load category",Toast.LENGTH_SHORT).show();
        }
    }
    public void makeListofCategory(ArrayList list){
       // AdapterForTags adapterForTags = new AdapterForTags(rootLayout,list);
       // rootLayout.setAdapter(adapterForTags);
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append((line + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

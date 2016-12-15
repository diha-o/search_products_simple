package pc.dd.vegetables_simple;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pc.dd.vegetables_simple.Activitys.SearchViewProducts;
import pc.dd.vegetables_simple.Adapters.AdapterForTags;

public class AsyncTaskForSearch extends AsyncTask<View, Integer, Object>
{
    private static String URL_MAIN= "https://openapi.etsy.com/v2/listings/active?api_key=l6pdqjuf7hdf97h1yvzadfce&category="; //url + сложный ключь
    private String mResponse = null;
    private View rootView;
    private String s2;
    public AsyncTaskForSearch(String s){
        s2=s;
    }
    @Override
    protected Object doInBackground(View... v) {
        //get root view
        rootView = v[0];
        try {
           if(AdapterForTags.category_for_search.size()>0) //if category !=0
            for (int i = 0; i!= AdapterForTags.category_for_search.size(); i++)
        {
            URL_MAIN += AdapterForTags.category_for_search.get(i).toString();
            if((AdapterForTags.category_for_search.size()-1) != i){
                URL_MAIN+= "&";
            }else {URL_MAIN+= s2+"&includes=Images:1:0";} // нужно было добавить "=Images:1:0" то бы получить изображения
        }

        //do get response
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(URL_MAIN);
        HttpResponse response;

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
        //clear
        AdapterForTags.category_for_search.clear();

        //start new act
        Intent i = new Intent(rootView.getContext(),SearchViewProducts.class)
                .putExtra("SString",o.toString()).putExtra("S", s2);// SString -> строка которую мы получили в результате, s-> строка которую мы вводили в поиск(она не используеться пока что)
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        rootView.getContext().startActivity(i);

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

package pc.dd.vegetables_simple.Fragments;

import android.app.ProgressDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import pc.dd.vegetables_simple.Adapters.AdapterForTags;
import pc.dd.vegetables_simple.AsyncTaskForCategory;
import pc.dd.vegetables_simple.AsyncTaskForSearch;
import pc.dd.vegetables_simple.R;

/**
 * Created by User on 15.12.2016.
 */
public class CategoryFragment extends Fragment {


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

        new AsyncTaskForCategory().execute(layoutCategory,rootView);
        refreshCategory_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().rotation(360).setDuration(700).start(); //animation if clicked
                new AsyncTaskForCategory().execute(layoutCategory,rootView);
            }
        });
        return rootView;
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

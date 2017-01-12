package pc.dd.vegetables_simple;

import java.util.List;
import java.util.Objects;

import JsonFormatted.Category.CategoryJsonParser;
import JsonFormatted.Category.JsonCategoryParsed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by User on 11.01.2017.
 */

public interface InterfaceForCategory {
    @GET("categories?")
    Call<CategoryJsonParser> getData(@Query("api_key") String api_key); // categories?api_key=l6pdqjuf7hdf97h1yvzadfce
}

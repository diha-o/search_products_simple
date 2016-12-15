package JsonFormatted.Category;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CategoryJsonParser {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("pagination")
    private Pagination mPagination;
    @SerializedName("params")
    private Object mParams;
    @SerializedName("results")
    private List<JsonCategoryParsed> mResults;
    @SerializedName("type")
    private String mType;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Pagination getPagination() {
        return mPagination;
    }

    public void setPagination(Pagination pagination) {
        mPagination = pagination;
    }

    public Object getParams() {
        return mParams;
    }

    public void setParams(Object params) {
        mParams = params;
    }

    public List<JsonCategoryParsed> getResults() {
        return mResults;
    }

    public void setResults(List<JsonCategoryParsed> results) {
        mResults = results;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}

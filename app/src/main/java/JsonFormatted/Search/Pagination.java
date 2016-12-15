
package JsonFormatted.Search;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Pagination {

    @SerializedName("effective_limit")
    private Long mEffectiveLimit;
    @SerializedName("effective_offset")
    private Long mEffectiveOffset;
    @SerializedName("effective_page")
    private Long mEffectivePage;
    @SerializedName("next_offset")
    private Long mNextOffset;
    @SerializedName("next_page")
    private Long mNextPage;

    public Long getEffectiveLimit() {
        return mEffectiveLimit;
    }

    public void setEffectiveLimit(Long effective_limit) {
        mEffectiveLimit = effective_limit;
    }

    public Long getEffectiveOffset() {
        return mEffectiveOffset;
    }

    public void setEffectiveOffset(Long effective_offset) {
        mEffectiveOffset = effective_offset;
    }

    public Long getEffectivePage() {
        return mEffectivePage;
    }

    public void setEffectivePage(Long effective_page) {
        mEffectivePage = effective_page;
    }

    public Long getNextOffset() {
        return mNextOffset;
    }

    public void setNextOffset(Long next_offset) {
        mNextOffset = next_offset;
    }

    public Long getNextPage() {
        return mNextPage;
    }

    public void setNextPage(Long next_page) {
        mNextPage = next_page;
    }

}

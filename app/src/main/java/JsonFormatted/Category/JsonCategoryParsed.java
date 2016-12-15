package JsonFormatted.Category;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class JsonCategoryParsed {

    @SerializedName("category_id")
    private Long mCategoryId;
    @SerializedName("category_name")
    private String mCategoryName;
    @SerializedName("long_name")
    private String mLongName;
    @SerializedName("meta_description")
    private String mMetaDescription;
    @SerializedName("meta_keywords")
    private String mMetaKeywords;
    @SerializedName("meta_title")
    private String mMetaTitle;
    @SerializedName("name")
    private String mName;
    @SerializedName("num_children")
    private Long mNumChildren;
    @SerializedName("page_description")
    private String mPageDescription;
    @SerializedName("page_title")
    private String mPageTitle;
    @SerializedName("short_name")
    private String mShortName;

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long category_id) {
        mCategoryId = category_id;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String category_name) {
        mCategoryName = category_name;
    }

    public String getLongName() {
        return mLongName;
    }

    public void setLongName(String long_name) {
        mLongName = long_name;
    }

    public String getMetaDescription() {
        return mMetaDescription;
    }

    public void setMetaDescription(String meta_description) {
        mMetaDescription = meta_description;
    }

    public String getMetaKeywords() {
        return mMetaKeywords;
    }

    public void setMetaKeywords(String meta_keywords) {
        mMetaKeywords = meta_keywords;
    }

    public String getMetaTitle() {
        return mMetaTitle;
    }

    public void setMetaTitle(String meta_title) {
        mMetaTitle = meta_title;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getNumChildren() {
        return mNumChildren;
    }

    public void setNumChildren(Long num_children) {
        mNumChildren = num_children;
    }

    public String getPageDescription() {
        return mPageDescription;
    }

    public void setPageDescription(String page_description) {
        mPageDescription = page_description;
    }

    public String getPageTitle() {
        return mPageTitle;
    }

    public void setPageTitle(String page_title) {
        mPageTitle = page_title;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String short_name) {
        mShortName = short_name;
    }

}


package JsonFormatted.Search;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("category_id")
    private Long mCategoryId;
    @SerializedName("category_path")
    private List<String> mCategoryPath;
    @SerializedName("category_path_ids")
    private List<Long> mCategoryPathIds;
    @SerializedName("creation_tsz")
    private Long mCreationTsz;
    @SerializedName("currency_code")
    private String mCurrencyCode;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("ending_tsz")
    private Long mEndingTsz;
    @SerializedName("featured_rank")
    private Object mFeaturedRank;
    @SerializedName("file_data")
    private String mFileData;
    @SerializedName("has_variations")
    private Boolean mHasVariations;
    @SerializedName("Images")
    private List<Image> mImages;
    @SerializedName("is_customizable")
    private Boolean mIsCustomizable;
    @SerializedName("is_digital")
    private Boolean mIsDigital;
    @SerializedName("is_private")
    private Boolean mIsPrivate;
    @SerializedName("is_supply")
    private String mIsSupply;
    @SerializedName("item_dimensions_unit")
    private String mItemDimensionsUnit;
    @SerializedName("item_height")
    private Object mItemHeight;
    @SerializedName("item_length")
    private Object mItemLength;
    @SerializedName("item_weight")
    private Object mItemWeight;
    @SerializedName("item_weight_units")
    private Object mItemWeightUnits;
    @SerializedName("item_width")
    private Object mItemWidth;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("last_modified_tsz")
    private Long mLastModifiedTsz;
    @SerializedName("listing_id")
    private Long mListingId;
    @SerializedName("materials")
    private List<String> mMaterials;
    @SerializedName("non_taxable")
    private Boolean mNonTaxable;
    @SerializedName("num_favorers")
    private Long mNumFavorers;
    @SerializedName("occasion")
    private Object mOccasion;
    @SerializedName("original_creation_tsz")
    private Long mOriginalCreationTsz;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("processing_max")
    private Long mProcessingMax;
    @SerializedName("processing_min")
    private Long mProcessingMin;
    @SerializedName("quantity")
    private Long mQuantity;
    @SerializedName("recipient")
    private Object mRecipient;
    @SerializedName("shipping_template_id")
    private Long mShippingTemplateId;
    @SerializedName("shop_section_id")
    private Long mShopSectionId;
    @SerializedName("state")
    private String mState;
    @SerializedName("state_tsz")
    private Long mStateTsz;
    @SerializedName("style")
    private Object mStyle;
    @SerializedName("tags")
    private List<String> mTags;
    @SerializedName("taxonomy_id")
    private Long mTaxonomyId;
    @SerializedName("taxonomy_path")
    private List<String> mTaxonomyPath;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("used_manufacturer")
    private Boolean mUsedManufacturer;
    @SerializedName("user_id")
    private Long mUserId;
    @SerializedName("views")
    private Long mViews;
    @SerializedName("when_made")
    private String mWhenMade;
    @SerializedName("who_made")
    private String mWhoMade;

    public Long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(Long category_id) {
        mCategoryId = category_id;
    }

    public List<String> getCategoryPath() {
        return mCategoryPath;
    }

    public void setCategoryPath(List<String> category_path) {
        mCategoryPath = category_path;
    }

    public List<Long> getCategoryPathIds() {
        return mCategoryPathIds;
    }

    public void setCategoryPathIds(List<Long> category_path_ids) {
        mCategoryPathIds = category_path_ids;
    }

    public Long getCreationTsz() {
        return mCreationTsz;
    }

    public void setCreationTsz(Long creation_tsz) {
        mCreationTsz = creation_tsz;
    }

    public String getCurrencyCode() {
        return mCurrencyCode;
    }

    public void setCurrencyCode(String currency_code) {
        mCurrencyCode = currency_code;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getEndingTsz() {
        return mEndingTsz;
    }

    public void setEndingTsz(Long ending_tsz) {
        mEndingTsz = ending_tsz;
    }

    public Object getFeaturedRank() {
        return mFeaturedRank;
    }

    public void setFeaturedRank(Object featured_rank) {
        mFeaturedRank = featured_rank;
    }

    public String getFileData() {
        return mFileData;
    }

    public void setFileData(String file_data) {
        mFileData = file_data;
    }

    public Boolean getHasVariations() {
        return mHasVariations;
    }

    public void setHasVariations(Boolean has_variations) {
        mHasVariations = has_variations;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public Boolean getIsCustomizable() {
        return mIsCustomizable;
    }

    public void setIsCustomizable(Boolean is_customizable) {
        mIsCustomizable = is_customizable;
    }

    public Boolean getIsDigital() {
        return mIsDigital;
    }

    public void setIsDigital(Boolean is_digital) {
        mIsDigital = is_digital;
    }

    public Boolean getIsPrivate() {
        return mIsPrivate;
    }

    public void setIsPrivate(Boolean is_private) {
        mIsPrivate = is_private;
    }

    public String getIsSupply() {
        return mIsSupply;
    }

    public void setIsSupply(String is_supply) {
        mIsSupply = is_supply;
    }

    public String getItemDimensionsUnit() {
        return mItemDimensionsUnit;
    }

    public void setItemDimensionsUnit(String item_dimensions_unit) {
        mItemDimensionsUnit = item_dimensions_unit;
    }

    public Object getItemHeight() {
        return mItemHeight;
    }

    public void setItemHeight(Object item_height) {
        mItemHeight = item_height;
    }

    public Object getItemLength() {
        return mItemLength;
    }

    public void setItemLength(Object item_length) {
        mItemLength = item_length;
    }

    public Object getItemWeight() {
        return mItemWeight;
    }

    public void setItemWeight(Object item_weight) {
        mItemWeight = item_weight;
    }

    public Object getItemWeightUnits() {
        return mItemWeightUnits;
    }

    public void setItemWeightUnits(Object item_weight_units) {
        mItemWeightUnits = item_weight_units;
    }

    public Object getItemWidth() {
        return mItemWidth;
    }

    public void setItemWidth(Object item_width) {
        mItemWidth = item_width;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public Long getLastModifiedTsz() {
        return mLastModifiedTsz;
    }

    public void setLastModifiedTsz(Long last_modified_tsz) {
        mLastModifiedTsz = last_modified_tsz;
    }

    public Long getListingId() {
        return mListingId;
    }

    public void setListingId(Long listing_id) {
        mListingId = listing_id;
    }

    public List<String> getMaterials() {
        return mMaterials;
    }

    public void setMaterials(List<String> materials) {
        mMaterials = materials;
    }

    public Boolean getNonTaxable() {
        return mNonTaxable;
    }

    public void setNonTaxable(Boolean non_taxable) {
        mNonTaxable = non_taxable;
    }

    public Long getNumFavorers() {
        return mNumFavorers;
    }

    public void setNumFavorers(Long num_favorers) {
        mNumFavorers = num_favorers;
    }

    public Object getOccasion() {
        return mOccasion;
    }

    public void setOccasion(Object occasion) {
        mOccasion = occasion;
    }

    public Long getOriginalCreationTsz() {
        return mOriginalCreationTsz;
    }

    public void setOriginalCreationTsz(Long original_creation_tsz) {
        mOriginalCreationTsz = original_creation_tsz;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public Long getProcessingMax() {
        return mProcessingMax;
    }

    public void setProcessingMax(Long processing_max) {
        mProcessingMax = processing_max;
    }

    public Long getProcessingMin() {
        return mProcessingMin;
    }

    public void setProcessingMin(Long processing_min) {
        mProcessingMin = processing_min;
    }

    public Long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Long quantity) {
        mQuantity = quantity;
    }

    public Object getRecipient() {
        return mRecipient;
    }

    public void setRecipient(Object recipient) {
        mRecipient = recipient;
    }

    public Long getShippingTemplateId() {
        return mShippingTemplateId;
    }

    public void setShippingTemplateId(Long shipping_template_id) {
        mShippingTemplateId = shipping_template_id;
    }

    public Long getShopSectionId() {
        return mShopSectionId;
    }

    public void setShopSectionId(Long shop_section_id) {
        mShopSectionId = shop_section_id;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Long getStateTsz() {
        return mStateTsz;
    }

    public void setStateTsz(Long state_tsz) {
        mStateTsz = state_tsz;
    }

    public Object getStyle() {
        return mStyle;
    }

    public void setStyle(Object style) {
        mStyle = style;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

    public Long getTaxonomyId() {
        return mTaxonomyId;
    }

    public void setTaxonomyId(Long taxonomy_id) {
        mTaxonomyId = taxonomy_id;
    }

    public List<String> getTaxonomyPath() {
        return mTaxonomyPath;
    }

    public void setTaxonomyPath(List<String> taxonomy_path) {
        mTaxonomyPath = taxonomy_path;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Boolean getUsedManufacturer() {
        return mUsedManufacturer;
    }

    public void setUsedManufacturer(Boolean used_manufacturer) {
        mUsedManufacturer = used_manufacturer;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long user_id) {
        mUserId = user_id;
    }

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

    public String getWhenMade() {
        return mWhenMade;
    }

    public void setWhenMade(String when_made) {
        mWhenMade = when_made;
    }

    public String getWhoMade() {
        return mWhoMade;
    }

    public void setWhoMade(String who_made) {
        mWhoMade = who_made;
    }

}

package com.ctrlshift.core.bean.stat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Objects;

import com.ctrlshift.core.bean.DbColumn;
import com.ctrlshift.core.bean.DbTable;
import com.ctrlshift.core.json.JsonField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DbTable(name="campaign_item_main_stats_temp")
public class CampaignItemMainStat implements StatTime, CampaignExtID, BasicMetrics {

    private static final DecimalFormat df = new DecimalFormat("#0.000000");
    
    /**
     *  unique ID for this item
     **/
    @JsonProperty("id")
    private Integer ID;

    /**
     *  the campaign item this stat belongs to
     **/
    @JsonProperty("campaign_item_id")
    private Integer campaignItemID;

    /**
     *  External ID of the campaign	
     **/
    @JsonProperty("campaign_item_ext_id")
    private Long campaignExtId;

    /**
     *  name of the campaign	
     **/
    @JsonProperty("campaign_item_name")
    private String campaignName;

    /**
     *  the hour this stat applies to
     **/
    @JsonField(required=true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty("time")
    private LocalDateTime time;

    /**
     *  the resource the stat applies to	
     **/
    @JsonProperty("creative_id")
    private Integer creativeID;

    /**
     *  External ID of the creative
     **/
    @JsonProperty("creative_ext_id")
    private Long creativeExtID;

    /**
     *  name of the creative
     **/
    @JsonProperty("creative_name")
    private String creativeName;

    /**
     *  size of the creative
     **/
    @JsonField(maxLength=7)
    @JsonProperty("creative_size")
    private String creativeSize;

    /**
     *  the country the stat applies to
     **/
    @JsonField(maxLength=2)
    @JsonProperty("country_code")
    private String countryCode;

    /**
     *  Indicates exchange for which this stats is obtained	
     **/
    @JsonField(required=true)
    @JsonProperty("ext_service_id")
    private Short extService;

    /**
     *  the number of impressions,
     **/
    @JsonProperty("impressions")
    private Integer impressions;

    /**
     *  the number of clicks,
     **/
    @JsonProperty("clicks")
    private Integer clicks;

    /**
     *  the conversions on impressions
     **/
    @JsonProperty("post_view_conversions")
    private Short postViewConversions;

    /**
     *  the conversions on clicks
     **/
    @JsonProperty("post_click_conversions")
    private Short postClickConversions;

    @JsonProperty("views")
    private Integer views;

    @JsonField(maxLength=6,decimalLength=2)
    @JsonProperty("viewed_minutes")
    private BigDecimal viewedMinutes;

    @JsonProperty("quarter_completions")
    private Integer quarterCompletions;

    @JsonProperty("half_completions")
    @DbColumn(name = "half_quarter_completions")
    private Integer halfCompletions;

    @JsonProperty("three_quarter_completions")
    private Integer threeQuarterCompletions;

    @JsonProperty("full_completions")
    private Integer fullCompletions;

    @JsonProperty("facebook_fan_clicks")
    private Integer facebookFanClicks;

    @JsonProperty("facebook_shares")
    private Integer facebookShares;

    @JsonProperty("twitter_shares")
    private Integer twitterShares;

    @JsonProperty("companion_impressions")
    private Integer companionImpressions;

    @JsonProperty("companion_clicks")
    private Integer companionClicks;

    @JsonProperty("impression_conversions")
    private Short impressionConversions;

    @JsonField(maxLength=6,decimalLength=6)
    @JsonProperty("media_cost")
    private BigDecimal mediaCost;

    @JsonField(maxLength=4,decimalLength=6)
    @JsonProperty("data_cost")
    private BigDecimal dataCost;

    @JsonField(maxLength=4,decimalLength=6)
    @JsonProperty("other_cost")
    private BigDecimal otherCost;

    @JsonField(maxLength=4,decimalLength=6)
    @JsonProperty("pmp_fee")
    private BigDecimal pmpFee;
    
    @JsonProperty("totalRevenue")
    private BigDecimal totalRevenue;

    /**
     *  additional metrics
     **/
    @DbColumn(type = DbColumn.SqlType.JSONB)
    @JsonProperty("additional_metrics")
    private Object additionalMetrics;
    
    /**
     * currency retrieved from stats
     */
    @JsonProperty("currency_code")
    private String currency;

    //Impression Frequency Stats
    
    @JsonProperty("viewable_impressions")
    private int viewableImpressions;
    
    @JsonProperty("unique_users")
    private int uniqueUsers;
    
    public CampaignItemMainStat() {
    }

    @Override
    public int hashCode()
    {
        return ID;
    }

    @Override
    public boolean equals(Object o)
    {
        return o!=null && ((CampaignItemMainStat)o).ID==this.ID;
    }
    
    @Override
    public void setOtherMetrics(BasicMetrics anotherMetrics) {
        CampaignItemMainStat anotherMetric = (CampaignItemMainStat) anotherMetrics;
        this.views = anotherMetric.getViews();
        this.viewedMinutes = anotherMetric.getViewedMinutes();
        this.quarterCompletions = anotherMetric.getQuarterCompletions();
        this.halfCompletions = anotherMetric.getHalfCompletions();
        this.threeQuarterCompletions = anotherMetric.getThreeQuarterCompletions();
        this.fullCompletions = anotherMetric.getFullCompletions();
        this.facebookFanClicks = anotherMetric.getFacebookFanClicks();
        this.facebookShares = anotherMetric.getFacebookShares();
        this.twitterShares = anotherMetric.getTwitterShares();
        this.companionImpressions = anotherMetric.getCompanionImpressions();
        this.companionClicks = anotherMetric.getCompanionClicks();
        this.impressionConversions = anotherMetric.getImpressionConversions();
        this.dataCost = anotherMetric.getDataCost();
        this.otherCost = anotherMetric.getOtherCost();
        this.pmpFee = anotherMetric.getPmpFee();
        this.additionalMetrics = anotherMetric.getAdditionalMetrics();
    }
    
    @Override
    public boolean compareOtherMetricsTo(BasicMetrics anotherMetrics) {
        CampaignItemMainStat anotherMetric = (CampaignItemMainStat) anotherMetrics;
        
        String oldViewedMinutes = getViewedMinutes()==null?null:df.format(getViewedMinutes());
        String newViewedMinutes = anotherMetric.getViewedMinutes()==null?null:df.format(anotherMetric.getViewedMinutes());
        
        String oldDataCost = getDataCost()==null?null:df.format(getDataCost());
        String newDataCost = anotherMetric.getDataCost()==null?null:df.format(anotherMetric.getDataCost());
        
        String oldOtherCost = getOtherCost()==null?null:df.format(getOtherCost());
        String newOtherCost = anotherMetric.getOtherCost()==null?null:df.format(anotherMetric.getOtherCost());
        
        String oldPmpFee = getPmpFee()==null?null:df.format(getPmpFee());
        String newPmpFee = anotherMetric.getPmpFee()==null?null:df.format(anotherMetric.getPmpFee());
                
        return Objects.equals(getViews(), anotherMetric.getViews())
                && Objects.equals(oldViewedMinutes, newViewedMinutes)
                && Objects.equals(getQuarterCompletions(), anotherMetric.getQuarterCompletions())
                && Objects.equals(getHalfCompletions(), anotherMetric.getHalfCompletions())
                && Objects.equals(getThreeQuarterCompletions(), anotherMetric.getThreeQuarterCompletions())
                && Objects.equals(getFullCompletions(), anotherMetric.getFullCompletions())
                && Objects.equals(getFacebookFanClicks(), anotherMetric.getFacebookFanClicks())
                && Objects.equals(getFacebookShares(), anotherMetric.getFacebookShares())
                && Objects.equals(getTwitterShares(), anotherMetric.getTwitterShares())
                && Objects.equals(getCompanionImpressions(), anotherMetric.getCompanionImpressions())
                && Objects.equals(getCompanionClicks(), anotherMetric.getCompanionClicks())
                && Objects.equals(getImpressionConversions(), anotherMetric.getImpressionConversions())
                && Objects.equals(oldDataCost, newDataCost)
                && Objects.equals(oldOtherCost, newOtherCost)
                && Objects.equals(oldPmpFee, newPmpFee)
                && Objects.equals(getAdditionalMetrics(), anotherMetric.getAdditionalMetrics());
    }
}

package com.ctrlshift.batch.ext.tubemogul;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TubeMogulResponse {
    @JsonProperty("items")
    private Item[] items;

    @JsonProperty("paging")
    private TubeMogulPagingResponse paging;

    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        @JsonProperty("@uri")
        private String uri;
        
        @JsonProperty("@type")
        private String placement;
        
        @JsonProperty("api_version")
        private String apiVersion;

        @JsonProperty("campaign_id")
        private String campaignId;
        
        @JsonProperty("campaign_key")
        private String campaignKey;
        
        @JsonProperty("package_id")
        private String packageId;
        
        @JsonProperty("package_name")
        private String packageName;
        
        @JsonProperty("is_managed")
        private String isManaged;

        @JsonProperty("ad_template")
        private String adTemplate;
        
        @JsonProperty("ad_template_human_name")
        private String adTemplateHumanName;
        
        @JsonProperty("placement_type")
        private String placementType;
        
        @JsonProperty("campaign_name")
        private String campaignName;

        @JsonProperty("advertiser_id")
        private String advertiserId;
        
        @JsonProperty("advertiser_name")
        private String advertiserName;
        
        @JsonProperty("placement_id")
        private String placementId;
        
        @JsonProperty("placement_name")
        private String placementName;
        
        @JsonProperty("budget_cap")
        private BudgetCap budgetCap;
        
        @JsonProperty("primary_goal")
        private PrimaryGoal primaryGoal;
        
        @JsonProperty("optimization_goal")
        private OptimizationGoal optimizationGoal;
        
        @JsonProperty("pacing_strategy")
        private String pacingStrategy;
        
        @JsonProperty("pace_on")
        private String paceOn;
        
        @JsonProperty("max_bid")
        private String maxBid;
        
        @JsonProperty("start_time")
        private String startTime;
        
        @JsonProperty("end_time")
        private String endTime;
        
        @JsonProperty("frequency_cap")
        private String frequencyCap;
        
        @JsonProperty("frequency_cap_interval")
        private String frequencyCapInterval;
        
        @JsonProperty("frequency_cap_interval_multiplier")
        private int frequencyCapIntervalMultiplier;
        
        @JsonProperty("created")
        private String created;
        
        @JsonProperty("targeting")
        private Targeting targeting;

        @JsonProperty("runLevel")
        private String runLevel;
        
        @JsonProperty("private_feeds_only")
        private String privateFeedsOnly;
        
        @JsonProperty("is_zero_level")
        private String isZeroLevel;
        
        @JsonProperty("is_custom_ad_scheduling_enabled")
        private String isCustomAdSchedulingEnabled;
        
        @JsonProperty("survey_exposed")
        private String surveyExposed;
        
        @JsonProperty("ad_id")
        private String adId;
        
        @JsonProperty("ad_name")
        private String adName;
        
        @JsonProperty("ad_type")
        private String adType;
       
        @JsonProperty("country_code")
        private String countryCode;
        
        @JsonProperty("country")
        private String country;
        
        @JsonProperty("stats")
        private Statistic stats;
        
        @JsonProperty("status")
        private String status;
        
        @JsonProperty("site_id")
        private int siteId;
        
        @JsonProperty("site_name")
        private String siteName;
        
        @JsonProperty("segment_name")
        private String segmentName;
        
        @JsonProperty("os_name")
        private String osName;
        
        @JsonProperty("browser_name")
        private String browserName;
        
    }

    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BudgetCap {
        @JsonProperty("metric")
        private String metric;
        
        @JsonProperty("interval")
        private String interval;
        
        @JsonProperty("amount")
        private BigDecimal amount;
        
        @JsonProperty("enforce_as_cap")
        private String enforceAsCap;
        
        @JsonProperty("opt_metric")
        private String optMetric;
    }
    
    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PrimaryGoal {
        @JsonProperty("metric")
        private String metric;
        
        @JsonProperty("interval")
        private String interval;
        
        @JsonProperty("amount")
        private BigDecimal amount;
        
        @JsonProperty("enforce_as_cap")
        private String enforceAsCap;
        
        @JsonProperty("opt_metric")
        private String optMetric;
    }
    
    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OptimizationGoal {
        @JsonProperty("metric")
        private String metric;
        
        @JsonProperty("interval")
        private String interval;
        
        @JsonProperty("amount")
        private BigDecimal amount;
        
        @JsonProperty("enforce_as_cap")
        private String enforceAsCap;
        
        @JsonProperty("opt_metric")
        private String optMetric;
    }
    
    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Statistic {
        @JsonProperty("start_day")
        private String startDay;

        @JsonProperty("end_day")
        private String endDay;

        @JsonProperty("buckets")
        private Bucket[] buckets;
    }

    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bucket {
        @JsonProperty("range")
        private String range;

        @JsonProperty("data")
        private Data data;
    }

    
    @Setter
    @Getter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("impressions")
        private int impressions;

        @JsonProperty("views")
        private int views;

        @JsonProperty("completions25")
        private int quarterCompletions;

        @JsonProperty("completions50")
        private int halfCompletions;

        @JsonProperty("completions75")
        private int threeQuarterCompletions;

        @JsonProperty("completions100")
        private int fullCompletions;

        @JsonProperty("video_and_overlay_clicks")
        private int clicks;

        @JsonProperty("facebook_fan_page_clicks")
        private int facebookFanClicks;

        @JsonProperty("shares_facebook")
        private int facebookShares;

        @JsonProperty("shares_twitter")
        private int twitterShares;

        @JsonProperty("companion_impressions")
        private int companionImpressions;

        @JsonProperty("companion_click_throughs")
        private int companionClicks;

        @JsonProperty("conversions_impressions")
        private int impressionConversions;

        @JsonProperty("conversions_view")
        private int postViewConversions;

        @JsonProperty("conversions_click_through")
        private int postClickConversions;
        
        @JsonProperty("viewed_minutes")
        private String viewedMinutes;

        @JsonProperty("media_spend_total")
        private String mediaCost;

        @JsonProperty("data_spend_total")
        private String dataCost;

        @JsonProperty("other_spend_total") 
        private String otherCost;

        @JsonProperty("total_click_throughs")
        private int adClicks;
        
        @JsonProperty("billable_total_fees")
        private String billableTotalfees;
        
        @JsonProperty("viewable_impressions")
        private int viewableImpressions;
        
        @JsonProperty("play_rate")
        private int playRate;
        
        @JsonProperty("playtime_per_view")
        private int playtimePerView;
        
        @JsonProperty("pct_viewed_avg")
        private int pctViewedAvg;
        
        @JsonProperty("pct_completions25")
        private int pctCompletions25;
        
        @JsonProperty("pct_completions50")
        private int pctCompletions50;
        
        @JsonProperty("pct_completions75")
        private int pctCompletions75;
        
        @JsonProperty("pct_completions100")
        private int pctCompletions100;
        
        @JsonProperty("engagements")
        private int engagements;
        
        @JsonProperty("viewability_instrumented_impressions")
        private int viewabilityInstrumentedImpressions;
        
        @JsonProperty("viewability_unmeasurable_iframe")
        private int viewabilityUnmeasurableIframe;
        
        @JsonProperty("viewability_unmeasurable_other")
        private int viewabilityUnmeasurableOther;
        
        @JsonProperty("viewable_impression_rate")
        private short viewableImpressionRate;
        
        @JsonProperty("viewable_pct_impressions")
        private int viewablePctImpressions;
        
        @JsonProperty("viewable_views")
        private int viewableViews;
        
        @JsonProperty("viewable_complete25")
        private int viewableComplete25;
        
        @JsonProperty("viewable_complete50")
        private int viewableComplete50;
        
        @JsonProperty("viewable_complete75")
        private int viewableComplete75;
        
        @JsonProperty("viewable_complete100")
        private int viewableComplete100;
        
        @JsonProperty("viewable_pct_complete25")
        private int viewablePctComplete25;
        
        @JsonProperty("viewable_pct_complete50")
        private int viewablePctComplete50;
        
        @JsonProperty("viewable_pct_complete75")
        private int viewablePctComplete75;
        
        @JsonProperty("viewable_pct_complete100")
        private int viewablePctComplete100;
        
        @JsonProperty("not_viewable_impressions")
        private int notViewableImpressions;
        
        @JsonProperty("not_viewable_pct_impressions")
        private int notViewablePctImpressions;
        
        @JsonProperty("facebook_page_likes")
        private int facebookPageLikes;
        
        @JsonProperty("facebook_post_comments")
        private int facebookPostComments;
        
        @JsonProperty("facebook_post_likes")
        private int facebookPostLikes;
        
        @JsonProperty("facebook_post_shares")
        private int facebookPostShares;
        
        @JsonProperty("viewable_measurable_impressions")
        private int viewableMeasurableImpressions;
        
        @JsonProperty("viewable_measurable_rate")
        private short viewableMeasurableRate;
        
        @JsonProperty("viewable_unmeasurable_impressions")
        private int viewableUnmeasurableImpressions;
        
        @JsonProperty("viewable_unmeasurable_rate_total")
        private int viewableUnmeasurableRateTotal;
        
        @JsonProperty("viewable_unmeasurable_rate_not_supported")
        private int viewableUnmeasurableRateNotSupported;
        
        @JsonProperty("viewable_unmeasurable_rate_other")
        private int viewableUnmeasurableRateOther;
        
        @JsonProperty("viewable_unmeasurable_rate_iframe")
        private int viewableUnmeasurableRateIframe;
        
        @JsonProperty("survey_starts")
        private int surveyStarts;
        
        @JsonProperty("survey_completions")
        private int surveyCompletions;
        
        @JsonProperty("total_fees")
        private String totalFees;
        
        @JsonProperty("unique_users")
        private int uniqueUsers;
        
    }

    @Getter
    @Setter
    @JsonInclude(Include.NON_EMPTY)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class TubeMogulPagingResponse {
        @JsonProperty("num_items") 
        private int noOfItems;
        
        @JsonProperty("has_more_items") 
        private boolean hasMoreItems;
        
        @JsonProperty("next_page_uri") 
        private String nextPageUri;
    }
    
    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Targeting {
        @JsonProperty("sites")
        private String sites;
        
        @JsonProperty("geos")
        private String geos;
        
        @JsonProperty("devices")
        private String devices;
        
        @JsonProperty("topics")
        private String topics;
        
        @JsonProperty("isps")
        private String isps;
        
        @JsonProperty("vendors")
        private String vendors;
        
        @JsonProperty("segment")
        private String segment;
        
        @JsonProperty("dayparts")
        private String dayparts;
        
        @JsonProperty("site_tiers")
        private String siteTiers;
        
        @JsonProperty("site_categories")
        private String siteCategories;
        
        @JsonProperty("feeds")
        private String feeds;
        
        @JsonProperty("inventory_sources")
        private String inventorySources;
        
        @JsonProperty("experimental")
        private Experimental experimental;
        
        @JsonProperty("recency")
        private String recency;
        
        @JsonProperty("demographic")
        private String demographic;
        
        @JsonProperty("connection_types")
        private String connectionTypes;
        
        @JsonProperty("experimental_sets")
        private String experimentalSets;
        
        @JsonProperty("tracking")
        private String tracking;
        
        @JsonProperty("forecasting")
        private String forecasting;
        
        @JsonProperty("unscreened_sites")
        private String unscreenedSites;
        
        @JsonProperty("include_mobile_app")
        private String includeMobileApp;
        
        @JsonProperty("traffic_types")
        private String trafficTypes;
    }
    
    @Getter
    @Setter
    @JsonInclude(Include.NON_EMPTY)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Experimental {        
        @JsonProperty("track_mobile_installs") 
        private String trackMobileInstalls;
    }
    
    @JsonProperty("advertiser_id")
    private String advertiserId;
}

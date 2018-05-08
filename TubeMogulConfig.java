package com.ctrlshift.batch.ext.tubemogul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TubeMogulConfig {
    public static final String SUCCESS = "OK";
    public static final int MAX_RETRY_COUNT = 3;

    @Value("${tubemogul.baseurl}")
    private String baseUrl;

    public String baseUrl() {
        return baseUrl;
    }

    public String reportUrl() {
        return this.baseUrl.concat("v1/reporting/");
    }

    public String tokenUrl() {
        return baseUrl().concat("oauth/token");
    }
    
    public String traffickingUrl() {
        return baseUrl().concat("v3/trafficking/");
    }
    
    public String advertisersUrl() {
        return traffickingUrl().concat("advertisers");
    }
    
    public String campaignsUrl() {
        return traffickingUrl().concat("campaigns");
    }
    
    public String advertisersUrl(String advertiserId) {
        return String.format(traffickingUrl().concat("advertisers/%1$s"), advertiserId);
    }
    
    public String placementsUrl(String campaignId) {
        return String.format(traffickingUrl().concat("campaigns/%1$s/placements"), campaignId);
    }
    
    public String placementAdsStatsUrl(String placementId) {
        return String.format(baseUrl().concat("v2/reporting/placements/%1$s/ads"), placementId);
    }
    
    public String adsReportUrl(String adsId) {
        return String.format(reportUrl().concat("ads/%1$s"),adsId);
    }
    
    public String placementSitesStatsUrl(String placementId) {
        return String.format(baseUrl().concat("v2/reporting/placements/%1$s/sites"), placementId);
    }
    
    public String campaignsReportUrl() {
        return reportUrl().concat("campaigns");
    }
    
    public String placementGeoStatstUrl(String placementId) {
        return String.format(reportUrl().concat("placements/%1$s/geos/countries"),placementId);
    }
    
    public String placementSegmentsStatstUrl(String placementId) {
        return String.format(reportUrl().concat("placements/%1$s/segments"),placementId);
    }
    
    public String placementOsStatsUrl(String placementId) {
    	return String.format(baseUrl().concat("v1/reporting/placements/%1$s/os"), placementId);
    }
    
    public String placementBrowserStatUrl(String placementId) {
        return String.format(baseUrl().concat("v1/reporting/placements/%1$s/browsers"),placementId);         
    }
    public String placementImpressionFrequenciesStatUrl(String placementId) {
        return String.format(baseUrl().concat("v1/reporting/placements/%1$s/frequencies/viewable_impressions"),placementId);         
    }
}

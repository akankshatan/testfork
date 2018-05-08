package com.ctrlshift.batch.ext.tubemogul;

import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import okhttp3.HttpUrl;

@Component
public class TubeMogulReportsApi {
    private static final Logger log = LoggerFactory.getLogger(TubeMogulReportsApi.class);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String NULL_REQUEST = "request can't be null";
    private final TubeMogulConfig config;
    private final TubeMogulProxy proxy;

    @Autowired
    public TubeMogulReportsApi(TubeMogulConfig config, TubeMogulProxy proxy) {
        this.config = config;
        this.proxy = proxy;
    }
    
    public TubeMogulResponse placementAdStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementAdsStatsUrl(request.getPlacementId()); 
        return process(session, request,finalUrl);
    }
    
    public TubeMogulResponse placementSiteStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementSitesStatsUrl(request.getPlacementId()); 
        return process(session, request, finalUrl);
    }

    public TubeMogulResponse placementGeoStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementGeoStatstUrl(request.getPlacementId());
        return process(session, request, finalUrl);
    }
    
    public TubeMogulResponse placementSegmentStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementSegmentsStatstUrl(request.getPlacementId());
        return process(session, request, finalUrl);
    }
    
    public TubeMogulResponse placementOsStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementOsStatsUrl(request.getPlacementId());
        return process(session, request, finalUrl);
    }
    
    public TubeMogulResponse placementBrowserStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementBrowserStatUrl(request.getPlacementId());
        return process(session, request, finalUrl);
    }
    
    public TubeMogulResponse placementImpressionFrequenciesStats(TubeMogulSession session, TubeMogulRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(NULL_REQUEST);
        }
        String finalUrl = config.placementImpressionFrequenciesStatUrl(request.getPlacementId());
        return process(session, request, finalUrl);
    }
    

    private TubeMogulResponse process(TubeMogulSession session, TubeMogulRequest request , String finalUrl) {
        if (request.getStartDay() == null || request.getEndDay() == null) {
            throw new IllegalArgumentException("TubeMogulReportsRequest or startDate or endDate can not be null");
        }

        log.debug("trying to get TubeMogul reports");

        HttpUrl url = HttpUrl.parse(finalUrl).newBuilder()
                                .addQueryParameter("limit", String.valueOf(request.getLimit()))
                                .addQueryParameter("offset", String.valueOf(request.getOffset()))
                                .addQueryParameter("start_day", request.getStartDay().format(DATE_FORMAT))
                                .addQueryParameter("end_day", request.getEndDay().format(DATE_FORMAT))
                                .addQueryParameter("timezone", "Asia/Singapore").build();

        return proxy.send(session, url);
    }
}

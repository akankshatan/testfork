package com.ctrlshift.batch.cron;

import com.ctrlshift.batch.cron.adwords.AdWordsAdStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsAudienceStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsCategoryStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsDeviceStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsDomainStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsExtResourcesSync;
import com.ctrlshift.batch.cron.adwords.AdWordsGeoStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsValidateAdStatsLoader;
import com.ctrlshift.batch.cron.adwords.AdWordsVideoExtResourcesSync;
import com.ctrlshift.batch.cron.adwords.AdWordsVideoStatsLoader;
import com.ctrlshift.batch.cron.adz.CampaignTracker;
import com.ctrlshift.batch.cron.adz.DeleteClickTrackingMacro;
import com.ctrlshift.batch.cron.adz.EmailStatsLoader;
import com.ctrlshift.batch.cron.adz.MediaPlanStatsLoader;
import com.ctrlshift.batch.cron.adz.NetworkSync;
import com.ctrlshift.batch.cron.adz.ReportScheduler;
import com.ctrlshift.batch.cron.applift.AppLiftAppPerformanceSync;
import com.ctrlshift.batch.cron.applift.AppLiftDeviceStatsLoader;
import com.ctrlshift.batch.cron.applift.AppLiftExchangesSync;
import com.ctrlshift.batch.cron.applift.AppLiftMainStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusCampaignPlacementAnalyticsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusContentCategoriesSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusConversionStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusCreativeAuditFeesSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusCreativeAuditStatusSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusDataCostsSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusDealsSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusDeviceStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusDmaSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusDomainStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusGeoStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusInventorySync;
import com.ctrlshift.batch.cron.appnexus.AppNexusMembersSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusPixelLastFiredSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusPostalCodeSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusSegmentLoadsSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusSegmentStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusSegmentsSync;
import com.ctrlshift.batch.cron.appnexus.AppNexusStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusValidateDomainStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusValidateStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppNexusVideoStatsLoader;
import com.ctrlshift.batch.cron.appnexus.AppnexusCampaignSellerStatsLoader;
import com.ctrlshift.batch.cron.ctag.SuperTagTemplateSync;
import com.ctrlshift.batch.cron.dbm.DbmDeviceStatsLoader;
import com.ctrlshift.batch.cron.dbm.DbmDomainStatsLoader;
import com.ctrlshift.batch.cron.dbm.DbmExtResourcesSync;
import com.ctrlshift.batch.cron.dbm.DbmMainStatsLoader;
import com.ctrlshift.batch.cron.dbm.DbmTrueviewStatsLoader;
import com.ctrlshift.batch.cron.dbm.DbmVideoExtResourcesSync;
import com.ctrlshift.batch.cron.fbm.FBMCreativeAuditStatusSync;
import com.ctrlshift.batch.cron.fbm.FbmDeviceStatsLoader;
import com.ctrlshift.batch.cron.fbm.FbmExtResourcesSync;
import com.ctrlshift.batch.cron.fbm.FbmMainStatsLoader;
import com.ctrlshift.batch.cron.fbm.FbmSocialStatsLoader;
import com.ctrlshift.batch.cron.googleanalytics.GoogleAnalyticsStatsLoader;
import com.ctrlshift.batch.cron.ipinyou.IPinYouExtResourcesSync;
import com.ctrlshift.batch.cron.ipinyou.IPinYouMainStatsLoader;
import com.ctrlshift.batch.cron.mediamath.MediaMathAudienceSegmentsSync;
import com.ctrlshift.batch.cron.mediamath.MediaMathContextualSegmentSync;
import com.ctrlshift.batch.cron.mediamath.MediaMathCreativeAuditStatusSync;
import com.ctrlshift.batch.cron.mediamath.MediaMathDealsSync;
import com.ctrlshift.batch.cron.mediamath.MediaMathDeviceStatsLoader;
import com.ctrlshift.batch.cron.mediamath.MediaMathDomainStatsLoader;
import com.ctrlshift.batch.cron.mediamath.MediaMathEventPixelLoadSync;
import com.ctrlshift.batch.cron.mediamath.MediaMathExchangeStatsLoader;
import com.ctrlshift.batch.cron.mediamath.MediaMathGeoStatsLoader;
import com.ctrlshift.batch.cron.mediamath.MediaMathMainStatsLoader;
import com.ctrlshift.batch.cron.mediamath.MediaMathSupplySourceSync;
import com.ctrlshift.batch.cron.sizmek.SizmekMainStatsGenerator;
import com.ctrlshift.batch.cron.sizmek.SizmekMainStatsLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulBrowserStatsLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulDomainVideoStatsLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulExtResourcesSync;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulGeoStatsLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulImpressionFreqStatsLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulOSStatsLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulSegmentStatLoader;
import com.ctrlshift.batch.cron.tubemogul.TubeMogulVideoStatsLoader;
import com.ctrlshift.batch.ext.appnexus.AppnexusDirectInventorySync;
import com.ctrlshift.core.notify.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.inject.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class BatchRegistry {
    private static final Logger log = LoggerFactory.getLogger(BatchRegistry.class);

    private ApplicationContext appContext;
    private Provider<DefaultTrigger> defaultTriggerProvider;

    private Map<String, Entry> registry = new HashMap<>();

    @Autowired
    public BatchRegistry(ApplicationContext appContext, Provider<DefaultTrigger> defaultTriggerProvider) {
        this.appContext = appContext;
        this.defaultTriggerProvider = defaultTriggerProvider;
    }

    private void register() {
        register(MediaPlanStatsLoader.class, "adz.mediaplan.stats", Arrays.asList(Group.ADZ, Group.STATS));
        register(CampaignTracker.class, "adz.campaignItems", Arrays.asList(Group.ADZ));
        register(AppNexusPixelLastFiredSync.class, "appnexus.pixel.lastfired", Arrays.asList(Group.APPNEXUS));
        register(AppLiftMainStatsLoader.class, "applift.mainstats", Arrays.asList(Group.APPLIFT, Group.MAIN, Group.STATS));
        register(AppLiftDeviceStatsLoader.class, "applift.devicestats", Arrays.asList(Group.APPLIFT, Group.DEVICE, Group.STATS));
        register(AppLiftAppPerformanceSync.class,"applift.appstats", Arrays.asList(Group.APPLIFT, Group.STATS));
        register(AppLiftExchangesSync.class, "applift.exchanges", Arrays.asList(Group.APPLIFT));
        register(FbmMainStatsLoader.class, "fbm.mainstats", Arrays.asList(Group.FBM, Group.MAIN, Group.STATS));
        register(FbmDeviceStatsLoader.class, "fbm.devicestats", Arrays.asList(Group.FBM, Group.DEVICE, Group.STATS));
        register(FbmSocialStatsLoader.class, "fbm.socialstats", Arrays.asList(Group.FBM, Group.SOCIAL, Group.STATS));
        register(FbmExtResourcesSync.class, "fbm.extresources", Arrays.asList(Group.FBM, Group.EXTRESOURCES));
        register(FBMCreativeAuditStatusSync.class, "fbm.creativeauditstatus", Arrays.asList(Group.FBM));
        register(AdWordsExtResourcesSync.class, "adwords.extresources", Arrays.asList(Group.ADWORDS, Group.EXTRESOURCES));
        register(DbmExtResourcesSync.class, "dbm.extresources", Arrays.asList(Group.DBM, Group.EXTRESOURCES));
        register(DbmMainStatsLoader.class, "dbm.mainstats", Arrays.asList(Group.DBM, Group.MAIN, Group.STATS));
        register(DbmDomainStatsLoader.class, "dbm.domainstats", Arrays.asList(Group.DBM, Group.DOMAIN, Group.STATS));
        register(DbmDeviceStatsLoader.class, "dbm.devicestats", Arrays.asList(Group.DBM, Group.DEVICE, Group.STATS));
        register(DbmVideoExtResourcesSync.class, "dbm.videoextresources", Arrays.asList(Group.DBM, Group.EXTRESOURCES));
        register(DbmTrueviewStatsLoader.class, "dbm.trueviewstats", Arrays.asList(Group.DBM, Group.VIDEO, Group.STATS));
        register(AdWordsVideoStatsLoader.class, "adwords.videostats", Arrays.asList(Group.ADWORDS, Group.VIDEO, Group.STATS));
        register(AdWordsVideoExtResourcesSync.class, "adwords.videoextresources", Arrays.asList(Group.ADWORDS, Group.EXTRESOURCES));
        register(AdWordsAdStatsLoader.class, "adwords.adstats", Arrays.asList(Group.ADWORDS, Group.MAIN, Group.STATS));
        register(AdWordsGeoStatsLoader.class, "adwords.geostats", Arrays.asList(Group.ADWORDS, Group.GEO, Group.STATS));
        register(AdWordsDomainStatsLoader.class, "adwords.domainstats", Arrays.asList(Group.ADWORDS, Group.DOMAIN, Group.STATS));
        register(AdWordsDeviceStatsLoader.class, "adwords.devicestats", Arrays.asList(Group.ADWORDS, Group.DEVICE, Group.STATS));
        register(AdWordsCategoryStatsLoader.class, "adwords.categorystats", Arrays.asList(Group.ADWORDS, Group.CATEGORY, Group.STATS));
        register(AppNexusDealsSync.class, "appnexus.deals", Arrays.asList(Group.APPNEXUS));
        register(AppNexusDataCostsSync.class, "appnexus.data.costs", Arrays.asList(Group.APPNEXUS));
        register(AppNexusSegmentsSync.class, "appnexus.segments", Arrays.asList(Group.APPNEXUS));
        register(AdWordsValidateAdStatsLoader.class, "adwords.validate.adstats", Arrays.asList(Group.ADWORDS, Group.VALIDATION));
        register(ReportScheduler.class, "adz.reportscheduler", Arrays.asList(Group.ADZ));
        register(DeleteClickTrackingMacro.class, "adz.deleteclicktrackingmacro", Arrays.asList(Group.ADZ));
        register(EmailStatsLoader.class, "adz.email.stats", Arrays.asList(Group.ADZ, Group.STATS));
        register(AppNexusContentCategoriesSync.class, "appnexus.contentcategories", Arrays.asList(Group.APPNEXUS));
        register(NetworkSync.class, "adz.networksync", Arrays.asList(Group.ADZ));
        register(AppNexusConversionStatsLoader.class, "appnexus.conversionstats", Arrays.asList(Group.APPNEXUS, Group.STATS));
        register(AppNexusDeviceStatsLoader.class, "appnexus.devicestats", Arrays.asList(Group.APPNEXUS, Group.STATS, Group.DEVICE));
        register(AppnexusCampaignSellerStatsLoader.class,"appnexus.sellerstats",Arrays.asList(Group.APPNEXUS, Group.STATS));
        register(AppNexusStatsLoader.class, "appnexus.stats", Arrays.asList(Group.APPNEXUS, Group.STATS));
        register(AppNexusSegmentLoadsSync.class, "appnexus.segmentloads", Arrays.asList(Group.APPNEXUS));
        register(AppNexusSegmentStatsLoader.class, "appnexus.segmentstats", Arrays.asList(Group.APPNEXUS, Group.SEGMENT, Group.STATS));
        register(AppNexusValidateStatsLoader.class, "appnexus.validate.stats", Arrays.asList(Group.APPNEXUS, Group.VALIDATION, Group.STATS));
        register(AppNexusCreativeAuditStatusSync.class, "appnexus.creativeauditstatus", Arrays.asList(Group.APPNEXUS));
        register(AppNexusCreativeAuditFeesSync.class, "appnexus.creativeauditfees", Arrays.asList(Group.APPNEXUS));
        register(AppNexusGeoStatsLoader.class, "appnexus.geostats", Arrays.asList(Group.APPNEXUS, Group.GEO, Group.STATS));
        register(AppNexusDomainStatsLoader.class, "appnexus.domainstats", Arrays.asList(Group.APPNEXUS, Group.DOMAIN, Group.STATS));
        register(AppNexusValidateDomainStatsLoader.class, "appnexus.validate.domainstats", Arrays.asList(Group.APPNEXUS, Group.VALIDATION, Group.DOMAIN, Group.STATS));
        register(TubeMogulExtResourcesSync.class, "tubemogul.extresources", Arrays.asList(Group.TUBEMOGUL, Group.EXTRESOURCES));
        register(MediaMathGeoStatsLoader.class, "mediamath.geostats", Arrays.asList(Group.MEDIAMATH, Group.GEO, Group.STATS));
        register(MediaMathMainStatsLoader.class, "mediamath.mainstats", Arrays.asList(Group.MEDIAMATH, Group.MAIN, Group.STATS));
        register(MediaMathDomainStatsLoader.class, "mediamath.domainstats", Arrays.asList(Group.MEDIAMATH, Group.DOMAIN, Group.STATS));
        register(AppNexusVideoStatsLoader.class, "appnexus.videostats", Arrays.asList(Group.APPNEXUS, Group.VIDEO, Group.STATS));
        register(TubeMogulVideoStatsLoader.class, "tubemogul.videostats", Arrays.asList(Group.TUBEMOGUL, Group.VIDEO, Group.STATS));
        register(SizmekMainStatsGenerator.class, "sizmek.mainstats.generator", Arrays.asList(Group.SIZMEK, Group.MAIN, Group.STATS));
        register(SizmekMainStatsLoader.class, "sizmek.mainstats", Arrays.asList(Group.SIZMEK, Group.MAIN, Group.STATS));
        register(TubeMogulDomainVideoStatsLoader.class, "tubemogul.domainstats", Arrays.asList(Group.TUBEMOGUL, Group.DOMAIN, Group.STATS));
        register(MediaMathAudienceSegmentsSync.class, "mediamath.audiencesegments", Arrays.asList(Group.MEDIAMATH));
        register(MediaMathContextualSegmentSync.class, "mediamath.contextualsegments", Arrays.asList(Group.MEDIAMATH));
        register(MediaMathCreativeAuditStatusSync.class, "mediamath.creativeauditstatus", Arrays.asList(Group.MEDIAMATH));
        register(AppNexusInventorySync.class, "appnexus.inventory", Arrays.asList(Group.APPNEXUS));
        register(MediaMathSupplySourceSync.class,"mediamath.supplysource",Arrays.asList(Group.MEDIAMATH));
        register(AppNexusMembersSync.class,"appnexus.member",Arrays.asList(Group.APPNEXUS));
        register(TubeMogulGeoStatsLoader.class, "tubemogul.geostats", Arrays.asList(Group.TUBEMOGUL, Group.GEO, Group.STATS));
        register(TubeMogulSegmentStatLoader.class, "tubemogul.segmentstats", Arrays.asList(Group.TUBEMOGUL, Group.SEGMENT, Group.STATS));
        register(TubeMogulOSStatsLoader.class, "tubemogul.osstats", Arrays.asList(Group.TUBEMOGUL, Group.DEVICE, Group.STATS));
        register(TubeMogulBrowserStatsLoader.class, "tubemogul.browserstats", Arrays.asList(Group.TUBEMOGUL, Group.BROWSER, Group.STATS));
        register(MediaMathEventPixelLoadSync.class, "mediamath.eventpixel", Arrays.asList(Group.MEDIAMATH));
        register(AppNexusCampaignPlacementAnalyticsLoader.class, "appnexus.campaign.placement.analytics", Arrays.asList(Group.APPNEXUS, Group.STATS));
        register(IPinYouMainStatsLoader.class, "ipinyou.mainstats", Arrays.asList(Group.IPINYOU, Group.MAIN, Group.STATS));
        register(AppnexusDirectInventorySync.class, "appnexus.directinventory", Arrays.asList(Group.APPNEXUS));
        register(IPinYouExtResourcesSync.class, "ipinyou.extresources", Arrays.asList(Group.IPINYOU, Group.EXTRESOURCES));
        register(AppNexusDmaSync.class, "appnexus.dma", Arrays.asList(Group.APPNEXUS));
        register(SuperTagTemplateSync.class, "containertag.supertag", Arrays.asList(Group.CONTAINER_TAG));
        register(AppNexusPostalCodeSync.class, "appnexus.postal.codes", Arrays.asList(Group.APPNEXUS));
        register(MediaMathDealsSync.class, "mediamath.deals", Arrays.asList(Group.MEDIAMATH));
        register(MediaMathExchangeStatsLoader.class, "mediamath.exchangestats", Arrays.asList(Group.MEDIAMATH, Group.EXCHANGE, Group.STATS));
        register(AdWordsAudienceStatsLoader.class, "adwords.audiencestats", Arrays.asList(Group.ADWORDS, Group.SEGMENT, Group.STATS));
        register(GoogleAnalyticsStatsLoader.class, "googleanalytics.stats", Arrays.asList(Group.GOOGLEANALYTICS));
        register(MediaMathDeviceStatsLoader.class, "mediamath.devicestats", Arrays.asList(Group.MEDIAMATH, Group.DEVICE, Group.STATS));
        register(TubeMogulImpressionFreqStatsLoader.class, "tubemogul.frequencyimpression", Arrays.asList(Group.TUBEMOGUL, Group.FREQUENCY, Group.STATS));
        
    }

    private void register(Class<? extends Job> clazz, String jobName, List<Group> groups) {
        Environment env = appContext.getEnvironment();
        String initialDelay = env.getProperty(jobName + ".delay");
        String interval = env.getProperty(jobName + ".interval");

        if (initialDelay == null || interval == null) {
            throw new BatchException("initialDelay and/or interval can't be null. jobName: " + jobName);
        }

        DefaultTrigger trigger = defaultTriggerProvider.get();
        trigger.setInitialDelay(initialDelay);
        trigger.setInterval(interval);

        Job job = appContext.getBean(clazz);
        Entry entry = new Entry(jobName, job, trigger, groups);
        registry.put(jobName, entry);

        log.info("Registered Job [{}], with jobName [{}], delay [{}] and interval [{}]", job, jobName, initialDelay, interval);
    }

    Entry getBatchJob(String jobName) {
        if (registry.isEmpty()) {
            register();
        }

        return this.registry.get(jobName);
    }

    List<Entry> listBatchJobs(List<Group> groups) {
        if (groups == null || groups.isEmpty())
            throw new IllegalArgumentException("Requires at least a group");

        return getRegistry().stream().filter(entry -> entry.groups.containsAll(groups)).collect(Collectors.toList());
    }

    Collection<Entry> getRegistry() {
        if (registry.isEmpty()) {
            register();
        }

        return Collections.unmodifiableCollection(this.registry.values());
    }

    public static final class Entry {
        private Job job;
        private DefaultTrigger trigger;
        private String name;
        private Set<Group> groups;

        public Entry(String name, Job job, DefaultTrigger trigger, List<Group> groups) {
            this.name = name;
            this.job = job;
            this.trigger = trigger;
            this.groups = new HashSet<>(groups);
        }

        public Job job() {
            return job;
        }

        DefaultTrigger trigger() {
            return trigger;
        }

        public String name() {
            return name;
        }
    }
}

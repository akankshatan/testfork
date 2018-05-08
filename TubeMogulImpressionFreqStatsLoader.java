package com.ctrlshift.batch.cron.tubemogul;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctrlshift.batch.cron.JobContext;
import com.ctrlshift.batch.ext.common.exception.InvalidReportDataException;
import com.ctrlshift.batch.ext.tubemogul.TubeMogulReportsApi;
import com.ctrlshift.batch.ext.tubemogul.TubeMogulRequest;
import com.ctrlshift.batch.ext.tubemogul.TubeMogulResponse;
import com.ctrlshift.batch.ext.tubemogul.TubeMogulResponse.Data;
import com.ctrlshift.batch.ext.tubemogul.TubeMogulResponse.Item;
import com.ctrlshift.batch.ext.tubemogul.TubeMogulSession;
import com.ctrlshift.core.bean.ExtMetaData;
import com.ctrlshift.core.bean.stat.CampaignItemMainStat;
import com.ctrlshift.core.constants.ExtService;
import com.ctrlshift.core.constants.ExtType;
import com.ctrlshift.core.service.JdbcExtMetaDataService;
import com.ctrlshift.core.service.stat.JdbcCampaignItemImpressionFreqStatService;

@Component 
public class TubeMogulImpressionFreqStatsLoader extends TubeMogulAbstractStatsLoader<CampaignItemMainStat>
{
	private final TubeMogulReportsApi reportsApi;
    
    private final JdbcExtMetaDataService metaDataService;
    
    private final JdbcCampaignItemImpressionFreqStatService FrequencyStatService;
   
    @Autowired
    public TubeMogulImpressionFreqStatsLoader(TubeMogulReportsApi reportsApi,
            JdbcExtMetaDataService metaDataService,
            JdbcCampaignItemImpressionFreqStatService FrequenciesStatService) {
        this.reportsApi = reportsApi;
        this.metaDataService = metaDataService;
        this.FrequencyStatService = FrequenciesStatService;
    }
    
	

	@Override
	protected void postProcess(JobContext context,List<CampaignItemMainStat> stats)
	{
		Long campaignExtId = stats.get(0).getCampaignExtId(); 
		ExtMetaData metaCampaign= metaDataService.getByExtKey(ExtService.TUBEMOGUL, ExtType.CAMPAIGN,
                campaignExtId.toString());
		if(metaCampaign != null)
			FrequencyStatService.updateCampaignIDs(ExtService.TUBEMOGUL, metaCampaign.getResourceID(), campaignExtId);
	}
	
	
	@Override
	protected TubeMogulResponse call(TubeMogulSession session, TubeMogulRequest request) {
		return reportsApi.placementImpressionFrequenciesStats(session, request);
	}

	
	@Override
	protected CampaignItemMainStat map(Item report, String campaignId, String campaignName)
			throws InvalidReportDataException {
		Data data= report.getStats().getBuckets()[0].getData();
		if(data==null)
		{
			throw new InvalidReportDataException();
		}
		
		CampaignItemMainStat stat=new CampaignItemMainStat();
		
		LocalDate date = ISO_DATE_FORMAT.parse(report.getStats().getStartDay(), LocalDate::from);
        stat.setTime(date.atStartOfDay(ZoneId.systemDefault()).toLocalDateTime());
        stat.setCampaignExtId(Long.valueOf(campaignId));
        stat.setCampaignName(campaignName);
        stat.setExtService(ExtService.TUBEMOGUL.ID);
        stat.setUniqueUsers(data.getUniqueUsers());
		stat.setViewableImpressions(data.getViewableImpressions());
		
		return stat;
	}

	@Override
	protected void populateDB(List<CampaignItemMainStat> stats) {
		FrequencyStatService.upsertBatch(stats);	
	}

	
}

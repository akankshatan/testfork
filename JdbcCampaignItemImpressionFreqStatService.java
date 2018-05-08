package com.ctrlshift.core.service.stat;
import org.springframework.stereotype.Component;
import com.ctrlshift.core.bean.stat.CampaignItemMainStat;
import com.ctrlshift.core.constants.ExtService;
import com.ctrlshift.core.service.jdbc.core.AbstractJdbcService;

@Component
public class JdbcCampaignItemImpressionFreqStatService extends AbstractJdbcService<CampaignItemMainStat>
implements StatsLoaderService<CampaignItemMainStat>{

	public void updateCampaignIDs(ExtService extService, int campaignItemID, Long campaignExtId) {
		jdbcTemplate.update("UPDATE campaign_item_main_stats" + " SET campaign_item_id = ?" +
		" WHERE ext_service = ?" + " AND campaign_ext_id = ?" + " AND campaign_item_id IS NULL" , campaignItemID, extService.ID, campaignExtId);
	}
	
	
	@Override
    public String getUpsertSql() {
        return getInsertSql() + " ON CONFLICT (campaign_ext_id,ext_service,viewable_impressions) DO UPDATE SET "
        		+ "impressions=excluded.impressions , clicks=excluded.clicks, post_view_conversions=excluded.post_view_conversions, "
        		+ "post_click_conversions=excluded.post_click_conversions, views=excluded.views, viewed_minutes=excluded.viewed_minutes, "
        		+ "quarter_completions=excluded.quarter_completions, half_quarter_completions=excluded.half_quarter_completions, "
        		+ "three_quarter_completions=excluded.three_quarter_completions, full_completions=excluded.full_completions, "
        		+ "facebook_fan_clicks=excluded.facebook_fan_clicks, facebook_shares=excluded.facebook_shares,"
        		+ "viewable_impressions=excluded.viewable_impressions, unique_users=excluded.unique_users,"
        		+ "twitter_shares=excluded.twitter_shares, companion_impressions=excluded.companion_impressions, "
        		+ "companion_clicks=excluded.companion_clicks, impression_conversions=excluded.impression_conversions,"
        		+ "media_cost=excluded.media_cost, data_cost=excluded.data_cost, other_cost=excluded.other_cost, pmp_fee=excluded.pmp_fee"
        		+ " WHERE a.impressions!=excluded.impressions OR a.clicks!=excluded.clicks OR a.post_view_conversions!=excluded.post_view_conversions OR "
                + "a.post_click_conversions!=excluded.post_click_conversions OR a.views!=excluded.views OR a.viewed_minutes!=excluded.viewed_minutes OR "
                + "a.quarter_completions!=excluded.quarter_completions OR a.half_quarter_completions!=excluded.half_quarter_completions OR "
                + "a.three_quarter_completions!=excluded.three_quarter_completions OR a.full_completions!=excluded.full_completions OR "
                + "a.facebook_fan_clicks!=excluded.facebook_fan_clicks OR a.facebook_shares!=excluded.facebook_shares OR "
                + "a.twitter_shares!=excluded.twitter_shares OR a.companion_impressions!=excluded.companion_impressions OR "
                + "a.companion_clicks!=excluded.companion_clicks OR a.impression_conversions!=excluded.impression_conversions OR "
                + "a.viewable_impressions!=excluded.viewable_impressions OR a.unique_users!=excluded.unique_users OR "
                + "a.media_cost!=excluded.media_cost OR a.data_cost!=excluded.data_cost OR a.other_cost!=excluded.other_cost OR a.pmp_fee!=excluded.pmp_fee ;";
    }
}

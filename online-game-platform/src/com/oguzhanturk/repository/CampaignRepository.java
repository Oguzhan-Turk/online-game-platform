package com.oguzhanturk.repository;

import java.util.ArrayList;
import java.util.List;

import static com.oguzhanturk.db.OnMemoryDatabase.CAMPAIGNS;
import com.oguzhanturk.entity.Campaign;
import com.oguzhanturk.util.Utils;

public class CampaignRepository implements CrudRepository<Campaign> {

	@Override
	public Campaign save(Campaign campaign) {
		return CAMPAIGNS.put(Utils.generateIdFor(campaign), campaign);
	}

	@Override
	public Campaign findById(int id) {

		return CAMPAIGNS.get(id);
	}

	@Override
	public boolean update(int idOfCampaignWillBeUpdated, Campaign newCampaign) {

		if (newCampaign.getId() != 0) {
			return false;
		}
		newCampaign.setId(idOfCampaignWillBeUpdated);
		return CAMPAIGNS.replace(idOfCampaignWillBeUpdated, findById(idOfCampaignWillBeUpdated), newCampaign);
	}

	@Override
	public Campaign delete(int id) {
		return CAMPAIGNS.remove(id);
	}

	@Override
	public List<Campaign> findAll() {
		List<Campaign> campaigns = new ArrayList<Campaign>(CAMPAIGNS.values());
		return campaigns;
	}

}

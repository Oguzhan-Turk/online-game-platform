package com.oguzhanturk.service;

import java.util.List;
import java.util.Objects;

import com.oguzhanturk.entity.sale.Campaign;
import com.oguzhanturk.repository.CampaignRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

public class CampaignService {

	private final CampaignRepository repository;
	private static final Logger LOGGER = new FileLogger(CampaignService.class);

	public CampaignService(CampaignRepository repository) {
		this.repository = repository;
	}

	public Campaign addCampaign(Campaign campaign) {
		if (isValidCampaign(campaign)) {
			LOGGER.log("addCampaign -> " + campaign.getName() + " added");
			return repository.save(campaign);
		}
		return null;
	}

	public Campaign findCampaignById(int id) {
		return repository.findById(id);
	}

	public boolean updateCampaign(int id, Campaign newCampaign) {
		if (!isValidCampaign(newCampaign)) {
			return false;
		}
		Campaign campaignWillBeUpdated = findCampaignById(id);
		boolean update = repository.update(id, newCampaign);
		if (update) {
			LOGGER.log("updateCampaign -> " + campaignWillBeUpdated.getName() + " updated to " + newCampaign.getName());
		} else {
			LOGGER.log("updateCampaign -> Campaign with id = " + id + " not found");
		}
		return update;
	}

	public Campaign deleteCampaign(int id) {
		Campaign campaignWillBeDeleted = repository.delete(id);
		if (Objects.isNull(campaignWillBeDeleted)) {
			LOGGER.log("deleteCampaign -> Campaign with id = " + id + " not found");
		} else {
			LOGGER.log("deleteCampaign -> " + campaignWillBeDeleted.getName() + " deleted");
		}
		return campaignWillBeDeleted;
	}

	public List<Campaign> findAll() {
		return repository.findAll();
	}

	private boolean isValidCampaign(Campaign campaign) {
		return campaign.getDiscountPercentage() < 100 && campaign.getDiscountPercentage() > 0;
	}
}

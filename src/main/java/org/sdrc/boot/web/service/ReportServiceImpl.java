package org.sdrc.boot.web.service;

import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{

	@Override
	public String createReport(Integer reporttypeId, Integer districtId, Integer stateId) {
		return "hi";
	}

}

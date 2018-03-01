package org.sdrc.boot.web.controller;

import org.sdrc.boot.web.core.Authorize;
import org.sdrc.boot.web.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Authorize(feature="authfeature",permission="authpermission")
	@GetMapping("getReportFile")
	@ResponseBody public String createReporForRawData(@RequestParam(value = "reporttypeId", required = true) Integer reporttypeId,
			@RequestParam(value = "stateId", required = false) Integer stateId,
			@RequestParam(value = "districtId", required = false) Integer districtId) throws Exception {

		return reportService.createReport(reporttypeId, districtId, stateId);
	}
}

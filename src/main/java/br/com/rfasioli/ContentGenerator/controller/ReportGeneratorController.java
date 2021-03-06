package br.com.rfasioli.ContentGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rfasioli.ContentGenerator.service.ReportGeneratorService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/reportgenerator", produces="application/json")
public class ReportGeneratorController {
	
	@Autowired
	private transient ReportGeneratorService rptGenSvc;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public String generate(@RequestBody String request) {
		String response = rptGenSvc.generateReport(request);
		return response;
	}
	
	@RequestMapping(path = "pdf", method = RequestMethod.POST)
	public byte[] generatePdf(@RequestBody String request) {
		byte[] response = rptGenSvc.generatePdfReport(request);
		return response;
	}

	public ReportGeneratorController() {
		super();
	}
}

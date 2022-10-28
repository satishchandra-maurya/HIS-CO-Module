package in.satish.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.satish.service.CoService;

@RestController
public class CoRestController {

	@Autowired
	private CoService coService;
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception{
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		response.setHeader(headerKey, headerValue);
		coService.generatePdf(response);
		
	}
}

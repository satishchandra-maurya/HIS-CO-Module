package in.satish.service;

import javax.servlet.http.HttpServletResponse;

public interface CoService {

	public void generatePdf(HttpServletResponse response) throws Exception;
}

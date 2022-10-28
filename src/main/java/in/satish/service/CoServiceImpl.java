package in.satish.service;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import in.satish.entity.ElgibilityDetermination;
import in.satish.repo.CoTriggersRepo;
import in.satish.repo.ElgibilityDeterminationRepo;

@Service
public class CoServiceImpl implements CoService{

	@Autowired
	private ElgibilityDeterminationRepo edr;
	
	@Autowired
	private CoTriggersRepo coTriggersRepo;
	
	
	@Override
	public void generatePdf(HttpServletResponse response) throws Exception {
		//fetching all record from the table
		List<ElgibilityDetermination> findAll = edr.findAll();
		
		
		//Document document = new Document();
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font titleFont = new Font(Font.TIMES_ROMAN, 24, Font.BOLD, Color.blue);
		Paragraph title = new Paragraph("Citizen Details for the Plan Selection.." +titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(20.0f);
		title.setSpacingAfter(25.0f);
		
		document.add(title);
		
		Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.blue);
		PdfPTable table = new PdfPTable(7); // No of columns
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {2.5f, 3.5f, 2.5f, 1.5f, 1.5f,2.5f,1.5f});
		table.setSpacingBefore(10);
		
		table.addCell(new Phrase("CITIZEN NAME", tableHead));
		table.addCell(new Phrase("PLAN NAME", tableHead));
		table.addCell(new Phrase("PLAN STATUS", tableHead));
		table.addCell(new Phrase("PLAN START DATE", tableHead));
		table.addCell(new Phrase("PLAN END DATE", tableHead));
		table.addCell(new Phrase("BENEFIT AMOUNT", tableHead));
		table.addCell(new Phrase("DENIAL REASON", tableHead));
		
		for(ElgibilityDetermination entity:findAll){
			table.addCell(entity.getHolderName());
			table.addCell(entity.getPlanName());
			table.addCell(entity.getPlanStatus());
			table.addCell(entity.getPlanStartDate().toString());
			table.addCell(entity.getPlanEndDate().toString());
			table.addCell(entity.getBenefitAmt().toString());
			table.addCell(entity.getDenialReason());
		}
		
		
		document.add(table);
		document.close();
	}
		
}

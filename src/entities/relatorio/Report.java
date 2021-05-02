package entities.relatorio;

import java.io.InputStream;
import java.util.List;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

	public void gerarRelatorio(List<Composer> emp) throws JRException {
	
		InputStream fonte = Report.class.getResourceAsStream("/report/Blank_A4.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report,null,new JRBeanCollectionDataSource(emp));
		JasperViewer.viewReport(print,false);
		JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\Usuário\\Documents\\FolhaPagamento.pdf");
		
	}
	
}

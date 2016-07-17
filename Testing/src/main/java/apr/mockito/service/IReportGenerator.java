package apr.mockito.service;

import apr.mockito.model.ReportEntity;

public interface IReportGenerator {
	
	 /**
	  * Generate report.
	  * @param report Report entity.
	  */
	  void generateReport(ReportEntity report);

}

package apr.learning.pattern.structural.proxy.protection;

public class Employee implements Staff{

	private ReportGeneratorProxy reportGenerator;
	
	@Override
	public void setReportGenerator(ReportGeneratorProxy reportGenerator){
		this.reportGenerator = reportGenerator;
	}
	
	@Override
	public boolean isOwner() {
		return false;
	}
	
	public String generateDailyReport(){
		try {
			return reportGenerator.generateDailyReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}

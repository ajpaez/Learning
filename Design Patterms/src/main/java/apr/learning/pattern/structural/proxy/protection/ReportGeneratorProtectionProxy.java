package apr.learning.pattern.structural.proxy.protection;

import java.rmi.Naming;

import apr.learning.pattern.structural.proxy.protection.remoteproxy.ReportGenerator;

public class ReportGeneratorProtectionProxy implements ReportGeneratorProxy{

	ReportGenerator reportGenerator;
	Staff staff;
	
	public ReportGeneratorProtectionProxy(Staff staff){
		this.staff = staff;
	}

	@Override
	public String generateDailyReport() {
		if(staff.isOwner()){
			ReportGenerator reportGenerator = null;
			try {
				reportGenerator = (ReportGenerator)Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
				return reportGenerator.generateDailyReport();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
		else{
			return "Not Authorized to view report.";
		}
	}
}

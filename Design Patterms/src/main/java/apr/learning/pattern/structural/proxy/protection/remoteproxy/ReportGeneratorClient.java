package apr.learning.pattern.structural.proxy.protection.remoteproxy;

import java.rmi.Naming;

public class ReportGeneratorClient {

	public static void main(String[] args) {
		new ReportGeneratorClient().generateReport();
	}
	
	public void generateReport(){
		try {
			ReportGenerator reportGenerator = (ReportGenerator)Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
			System.out.println(reportGenerator.generateDailyReport());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

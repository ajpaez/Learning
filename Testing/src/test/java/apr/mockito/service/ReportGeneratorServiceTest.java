package apr.mockito.service;

import java.util.Calendar;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import apr.mockito.model.ReportEntity;

/**
 * ArgumentCaptor es una clase usada para capturar los valores de los 
 * argumentos usados por los objetos mocks.
 * Se recomienda usar ArgumentCaptor con verification, pero no con stubbing.
 * ArgumentCaptor esta relacionado con comparadores de argumentos personalizados.
 * Esta tecnica se usa para asegurarse de los argumentos que se le pasan a los mocks.
 * 
 *  
 * @author Antonio
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReportGeneratorServiceTest {

	@InjectMocks
	private ReportGeneratorService reportGeneratorService;
	@Mock
	private IReportGenerator reportGenerator;
	@Captor
	private ArgumentCaptor<ReportEntity> reportCaptor;

	@Mock
	Stack<String> stack;
	@Captor
	private ArgumentCaptor<String> argumentCaptor;
	

	@SuppressWarnings("deprecation")
	@Test
	public void reportGenerator_ArgumentCaptor_Test() {
		Calendar startDate = Calendar.getInstance();
		startDate.set(2016, 11, 25);
		Calendar endDate = Calendar.getInstance();
		endDate.set(9999, 12, 31);
		String reportContent = "Report Content";
		reportGeneratorService.generateReport(startDate.getTime(), endDate.getTime(), reportContent.getBytes());

		Mockito.verify(reportGenerator).generateReport(reportCaptor.capture());

		ReportEntity report = reportCaptor.getValue();

		Assert.assertEquals(116, report.getStartDate().getYear());
		Assert.assertEquals(11, report.getStartDate().getMonth());
		Assert.assertEquals(25, report.getStartDate().getDate());

		Assert.assertEquals(8100, report.getEndDate().getYear());
		Assert.assertEquals(0, report.getEndDate().getMonth());
		Assert.assertEquals(31, report.getEndDate().getDate());

		Assert.assertEquals("Report Content", new String(report.getContent()));
	}
	
	@Test
	public void argumentCaptorAllValuesTest_OK() {
		
		stack.add("Java Code Geeks");
		stack.add("Mockito");
		Mockito.verify(stack, Mockito.times(2)).add(argumentCaptor.capture());
		List<String> values = argumentCaptor.getAllValues();
		Assert.assertEquals("Java Code Geeks", values.get(0));
		Assert.assertEquals("Mockito", values.get(1));
		
	}

}

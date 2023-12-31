package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportHandler
{
	private static ExtentReports extent;

	public ExtentReports getInstance()
	{
		if (extent == null)
		{
			createInstance("test-output/ExtentReport/ExtentReport.html");
		}
		return extent;
	}

	private static ExtentReports createInstance(String fileName)
	{
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		return extent;
	}
}

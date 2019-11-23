
 package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFactory;


public class Report {

	private String reportContent;
	private ReportBody body;
	private ReportFooter footer;
	private ReportHeader header;
	

	
	
	/**
	 * @param factory
	 */
	public Report(ReportFactory factory) {

		this.setBody(factory.createBody());
		this.setFooter(factory.createFooter());
		this.setHeader(factory.createHeader());

	}

	public void setBody(ReportBody body) {
		this.body = body;

	}

	
	public void setFooter(ReportFooter footer) {
		this.footer = footer;

	}

	
	public void setHeader(ReportHeader header) {
		this.header = header;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}


	public String getReportContent() {
		return reportContent;
	}


	public ReportBody getBody() {
		return body;
	}


	public ReportFooter getFooter() {
		return footer;
	}


	public ReportHeader getHeader() {
		return header;
	}

	
}
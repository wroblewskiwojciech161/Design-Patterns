package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLFactory;
import org.junit.Test;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.Report;

import static org.junit.Assert.*;

/**
 * @author jpereira
 * 
 */

public class ReportTest {

	private ReportFactory factory;
	private Report report;

	@Test
	public void testCreateJSONReport() {

		factory = new JSONFactory();
		report = new Report(factory);
		assertEquals("JSON", report.getBody().getType());
		assertEquals("JSON", report.getHeader().getType());
		assertEquals("JSON", report.getFooter().getType());

	}

	@Test
	public void testCreateXMLReport() {

		factory = new XMLFactory();
		report = new Report(factory);
		assertEquals("XML", report.getBody().getType());
		assertEquals("XML", report.getHeader().getType());
		assertEquals("XML", report.getFooter().getType());

	}

}
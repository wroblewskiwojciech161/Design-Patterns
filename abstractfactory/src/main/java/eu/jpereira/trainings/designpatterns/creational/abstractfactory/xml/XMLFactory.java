package eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public class XMLFactory implements ReportFactory {
    @Override
    public ReportBody createBody() {
        return new XMLReportBody();
    }

    @Override
    public ReportFooter createFooter() {
        return new XMLReportFooter();
    }

    @Override
    public ReportHeader createHeader() {
        return new XMLReportHeader();
    }
}
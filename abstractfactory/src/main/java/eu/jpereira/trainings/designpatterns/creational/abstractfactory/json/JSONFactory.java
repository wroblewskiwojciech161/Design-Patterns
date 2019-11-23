package eu.jpereira.trainings.designpatterns.creational.abstractfactory.json;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;

public class JSONFactory implements ReportFactory {
    @Override
    public ReportBody createBody() {
        return new JSONReportBody();
    }

    @Override
    public ReportFooter createFooter() {
        return new JSONReportFooter();
    }

    @Override
    public ReportHeader createHeader() {
        return new JSONReportHeader();
    }
}
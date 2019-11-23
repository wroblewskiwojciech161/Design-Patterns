package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators.HTMLReportGenerator;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators.JSONReportGenerator;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators.PDFReportGenerator;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators.XMLReportGenerator;

public class ReportFactory {
    ReportGenerator reportGenerator;

    public Report getReport(ReportData data, String type){
        reportGenerator = null;

        if (type.equals("JSON")) {
            reportGenerator = new JSONReportGenerator();
        } else if (type.equals("XML")) {
            reportGenerator = new XMLReportGenerator();
        } else if (type.equals("HTML")) {
            reportGenerator = new HTMLReportGenerator();
        } else if (type.equals("PDF")) {
            reportGenerator = new PDFReportGenerator();
        }
        if (reportGenerator != null) {
            reportGenerator.generateReport(data);
        }

        return reportGenerator.generateReport(data);
    }
}
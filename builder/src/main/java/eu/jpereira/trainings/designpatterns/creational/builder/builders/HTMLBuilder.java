package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.HTMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;
import java.util.List;

public class HTMLBuilder extends HTMLReportBody implements ReportBuilder {

    private HTMLReportBody reportBody = new HTMLReportBody();

    @Override
    public ReportBuilder setCustomerName(String customerName) {
        reportBody.putContent("<span class=\"customerName\">");
        reportBody.putContent(customerName);
        reportBody.putContent("</span><span class=\"customerPhone\">");
        return this;
    }

    @Override
    public ReportBuilder setCustomerPhone(String phoneNumber) {
        reportBody.putContent(phoneNumber);
        reportBody.putContent("</span>");
        return this;
    }

    @Override
    public ReportBuilder setItems(List<SoldItem> soldItems) {
        reportBody.putContent("<items>");

        Iterator<SoldItem> it = soldItems.iterator();
        while ( it.hasNext() ) {
            SoldItem soldEntry= it.next();
            reportBody.putContent("<item><name>");
            reportBody.putContent(soldEntry.getName());
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(soldEntry.getQuantity());
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(soldEntry.getUnitPrice());
            reportBody.putContent("</price></item>");
        }
        reportBody.putContent("</items>");
        return this;
    }

    @Override
    public ReportBody getReportBody() {
        return reportBody;
    }
}
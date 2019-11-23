package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;
import java.util.List;

public class JSONBuilder extends JSONReportBody implements ReportBuilder {

    private JSONReportBody reportBody = new JSONReportBody();


    @Override
    public ReportBuilder setCustomerName(String customerName) {
        reportBody.addContent("sale:{customer:{");
        reportBody.addContent("name:\"");
        reportBody.addContent(customerName);
        return this;
    }

    @Override
    public ReportBuilder setCustomerPhone(String phoneNumber) {
        reportBody.addContent("\",phone:\"");
        reportBody.addContent(phoneNumber);
        reportBody.addContent("\"}");
        return this;
    }

    @Override
    public ReportBuilder setItems(List<SoldItem> soldItems) {
        //add array of items
        reportBody.addContent(",items:[");
        Iterator<SoldItem> it = soldItems.iterator();
        while ( it.hasNext() ) {
            SoldItem item = it.next();
            reportBody.addContent("{name:\"");
            reportBody.addContent(item.getName());
            reportBody.addContent("\",quantity:");
            reportBody.addContent(String.valueOf(item.getQuantity()));
            reportBody.addContent(",price:");
            reportBody.addContent(String.valueOf(item.getUnitPrice()));
            reportBody.addContent("}");
            if ( it.hasNext() ) {
                reportBody.addContent(",");
            }

        }
        reportBody.addContent("]}");
        return this;
    }

    @Override
    public ReportBody getReportBody() {
        return reportBody;
    }
}
package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.List;

public interface ReportBuilder {
    ReportBuilder setCustomerName(String customerName);
    ReportBuilder setCustomerPhone(String phoneNumber);
    ReportBuilder setItems(List<SoldItem> soldItems);
    ReportBody getReportBody();
}
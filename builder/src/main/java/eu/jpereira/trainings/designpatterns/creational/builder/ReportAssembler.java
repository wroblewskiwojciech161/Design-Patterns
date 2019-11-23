package eu.jpereira.trainings.designpatterns.creational.builder;


import java.util.List;

import eu.jpereira.trainings.designpatterns.creational.builder.builders.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;


/**
 * @author jpereira
 * 
 */
public class ReportAssembler {

	private SaleEntry saleEntry;
	private Report report;
	private String name;
	private String phoneNumber;
	private List<SoldItem> soldItems;


	public void setSaleEntry(SaleEntry saleEntry) {
		this.saleEntry = saleEntry;

	}

	/**
	 * @param reportBuilder
	 * @return
	 */
	public Report getReport(ReportBuilder reportBuilder) {
			report = new Report();

			name = saleEntry.getCustomer().getName();
			phoneNumber = saleEntry.getCustomer().getPhone();
			soldItems = saleEntry.getSoldItems();

			reportBuilder.setCustomerName(name).
					setCustomerPhone(phoneNumber).
					setItems(soldItems);

			report.setReportBody(reportBuilder.getReportBody());


			return report;
	}

}
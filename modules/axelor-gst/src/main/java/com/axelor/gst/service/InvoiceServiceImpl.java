package com.axelor.gst.service;

import java.math.BigDecimal;
import java.util.List;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;

public class InvoiceServiceImpl implements InvoiceService{

	@Override
	public Invoice calculateInvoice(Invoice invoice) {
		List<InvoiceLine> invoiceItemsList = invoice.getInvoiceItemsList();
		BigDecimal netAmount=BigDecimal.ZERO;
		BigDecimal netIgst=BigDecimal.ZERO;
		BigDecimal netCgst=BigDecimal.ZERO;
		BigDecimal netSgst=BigDecimal.ZERO;
		BigDecimal grossAmount=BigDecimal.ZERO;
		
		
		for(InvoiceLine invoiceLine:invoiceItemsList) {
			netAmount = netAmount.add(invoiceLine.getNetAmount());
			netIgst = netIgst.add(invoiceLine.getIgst());
			netCgst = netCgst.add(invoiceLine.getCgst());
			netSgst = netSgst.add(invoiceLine.getSgst());
			grossAmount = grossAmount.add(invoiceLine.getGrossAmount());	
			
		}
		invoice.setNetAmount(netAmount);
		invoice.setNetIGST(netIgst);
		invoice.setNetCGST(netSgst);
		invoice.setNetSGST(netSgst);
		invoice.setGrossAmount(grossAmount);
		return invoice;
	}
}

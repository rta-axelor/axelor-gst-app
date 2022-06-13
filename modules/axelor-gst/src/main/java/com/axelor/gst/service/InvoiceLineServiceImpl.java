package com.axelor.gst.service;

import java.math.BigDecimal;


import com.axelor.gst.db.InvoiceLine;

public class InvoiceLineServiceImpl implements InvoiceLineService{

	@Override
	public InvoiceLine calculateNetAmount(InvoiceLine invoiceline) {
			BigDecimal netAmount = invoiceline.getPrice().multiply(new BigDecimal(invoiceline.getQty()));
			invoiceline.setNetAmount(netAmount);
			return invoiceline;
		
	}

	@Override
	public InvoiceLine calculateIgst(InvoiceLine invoiceline) {
		BigDecimal igst = invoiceline.getNetAmount().multiply(invoiceline.getGstRate()).divide(new BigDecimal(100));
		invoiceline.setIgst(igst);
		return invoiceline;
	}

	@Override
	public InvoiceLine calculateSgst(InvoiceLine invoiceline) {
	
		BigDecimal sgst = invoiceline.getNetAmount().multiply(invoiceline.getGstRate()).divide(new BigDecimal(2) );
		invoiceline.setSgst(sgst);
		return invoiceline;
	}

	@Override
	public InvoiceLine calculateCgst(InvoiceLine invoiceline) {
		BigDecimal cgst = invoiceline.getNetAmount().multiply(invoiceline.getGstRate()).divide(new BigDecimal(2) );
		invoiceline.setCgst(cgst);
		return invoiceline;
	}

	@Override
	public InvoiceLine calculateGrossAmount(InvoiceLine invoiceline) {
		BigDecimal gross = invoiceline.getNetAmount().add(invoiceline.getIgst()).add(invoiceline.getCgst());
		invoiceline.setGrossAmount(gross);
		return invoiceline;	
	
	}
	

}

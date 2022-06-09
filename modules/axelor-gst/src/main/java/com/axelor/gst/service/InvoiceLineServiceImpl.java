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

}

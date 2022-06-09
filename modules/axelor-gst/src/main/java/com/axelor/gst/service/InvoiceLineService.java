package com.axelor.gst.service;

import com.axelor.gst.db.InvoiceLine;

public interface InvoiceLineService {
	
	public InvoiceLine calculateNetAmount(InvoiceLine invoiceline);
	
	
}

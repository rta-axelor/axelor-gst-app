package com.axelor.gst.web;

import com.axelor.gst.db.Invoice;


import com.axelor.gst.service.InvoiceService;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class InvoiceController {
	
	public void calculateInvoiceMethod(ActionRequest request, ActionResponse response) {
		
		Invoice invoice = request.getContext().asType(Invoice.class);
		invoice = Beans.get(InvoiceService.class).calculateInvoice(invoice);
		response.setValue("netAmount", invoice.getNetAmount());
		response.setValue("netIGST", invoice.getNetIGST());
		response.setValue("netCGST", invoice.getNetCGST());
		response.setValue("netSGST", invoice.getNetSGST());
		response.setValue("grossAmount", invoice.getGrossAmount());
		
		
	}

}

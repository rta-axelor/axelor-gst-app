package com.axelor.gst.web;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.service.InvoiceLineService;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class InvoiceLineController {
	
	public void calculateNetAmountMethod(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();
		
		InvoiceLine invoiceline = context.asType(InvoiceLine.class);
		Invoice invoice = request.getContext().getParentContext().asType(Invoice.class);
		if(invoice.getCompany().getAddress().getState() != null) {
			if(invoice.getCompany().getAddress().getState() != invoice.getInvoiceAddress().getState()) {
				Beans.get(InvoiceLineService.class).calculateIgst(invoiceline);
				response.setValue("igst", invoiceline.getIgst());
			}else {
				Beans.get(InvoiceLineService.class).calculateSgst(invoiceline);
				response.setValue("sgst", invoiceline.getSgst());
		
				Beans.get(InvoiceLineService.class).calculateCgst(invoiceline);
				response.setValue("cgst", invoiceline.getCgst());
				}
		}
		
	
		
		Beans.get(InvoiceLineService.class).calculateNetAmount(invoiceline);
		
		
		Beans.get(InvoiceLineService.class).calculateGrossAmount(invoiceline);
		
		response.setValue("netAmount", invoiceline.getNetAmount());
		
		
		
		response.setValue("gross", invoiceline.getGrossAmount());
		
	}

}

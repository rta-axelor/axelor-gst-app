package com.axelor.gst.web;

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
		
		
		Beans.get(InvoiceLineService.class).calculateNetAmount(invoiceline);
		Beans.get(InvoiceLineService.class).calculateIgst(invoiceline);
		Beans.get(InvoiceLineService.class).calculateSgst(invoiceline);
		Beans.get(InvoiceLineService.class).calculateCgst(invoiceline);
		Beans.get(InvoiceLineService.class).calculateGrossAmount(invoiceline);
		
		response.setValue("netAmount", invoiceline.getNetAmount());
		response.setValue("igst", invoiceline.getIgst());
		response.setValue("sgst", invoiceline.getSgst());
		response.setValue("cgst", invoiceline.getCgst());
		response.setValue("gross", invoiceline.getGrossAmount());
		
	}

}

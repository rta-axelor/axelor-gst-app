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
		
		response.setValue("netAmount", invoiceline.getNetAmount());
	}

}

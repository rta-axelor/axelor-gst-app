package com.axelor.gst.web;


import java.util.List;

import com.axelor.gst.db.Address;
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

	/*
	 * public void filterInvoiceAddress(ActionRequest req , ActionResponse res) {
	 * List<Long> addressList =
	 * req.getContext().asType(Invoice.class).getParty().getAddressList().stream().
	 * map(i->i.getId()).collect(Collectors.toList()); String listStr =
	 * org.apache.commons.lang.StringUtils.join(addressList, ",");
	 * res.setAttr("invoiceAddress", "domain" ,"self.id IN"+ "("+listStr+")"); }
	 */
	public void setShippingAdd(ActionRequest req, ActionResponse res) {
		Invoice invoiceClass = req.getContext().asType(Invoice.class);
		Boolean isTrue =invoiceClass.getSameAsInvoicingAddress();
		Address invoiceAddress = invoiceClass.getInvoiceAddress();

		List<Address> addresses = invoiceClass.getParty().getAddressList();

		if (isTrue) {
			res.setValue("shippingAddress", invoiceAddress);
			res.setAttr("shippingAddress", "hidden", true);
		} else {
			for (Address a : addresses) {
				if (a.getTypeSelect().toString().equals("1")) {
					res.setValue("shippingAddress", a);
					break;
				} else if (a.getTypeSelect().toString().equals("3")) {
					res.setValue("shippingAddress", a);
					break;
				}
			}
			res.setAttr("shippingAddress", "hidden", false);
		}

	}
	}

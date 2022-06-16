package com.axelor.gst.module;

import com.axelor.app.AxelorModule;


import com.axelor.gst.service.InvoiceLineService;
import com.axelor.gst.service.InvoiceLineServiceImpl;
import com.axelor.gst.service.InvoiceService;
import com.axelor.gst.service.InvoiceServiceImpl;
import com.axelor.gst.service.SequenceService;
import com.axelor.gst.service.SequenceServiceImpl;

public class AxelorGstModule extends AxelorModule{

	@Override
	protected void configure() {
		bind(InvoiceLineService.class).to(InvoiceLineServiceImpl.class);
		
		bind(InvoiceService.class).to(InvoiceServiceImpl.class);
		
		bind(SequenceService.class).to(SequenceServiceImpl.class);
	}
}

package com.axelor.gst.web;
import com.axelor.gst.db.Sequence;

import com.axelor.gst.service.SequenceService;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;


public class SequenceController {
	
	public void findSequence(ActionRequest request, ActionResponse response) {
		
		Sequence sequence = request.getContext().asType(Sequence.class);
		sequence=Beans.get(SequenceService.class).setNextNumber(sequence);
		response.setValue("nextNumber", sequence.getNextNumber());
		
		
		
	}
}

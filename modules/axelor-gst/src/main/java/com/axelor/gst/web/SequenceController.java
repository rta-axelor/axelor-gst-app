package com.axelor.gst.web;
import com.axelor.gst.db.Sequence;
import com.axelor.gst.service.SequenceService;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class SequenceController {
	
	public void SequenceMethod(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();
		Sequence sequence = context.asType(Sequence.class);
		
		Beans.get(SequenceService.class).findSequence(sequence);
		response.setValue("nextNumber", sequence.getNextNumber());
		
	}
}

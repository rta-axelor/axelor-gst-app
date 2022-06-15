package com.axelor.gst.service;

import com.axelor.gst.db.Sequence;

public class SequenceServiceImpl implements SequenceService {

	@Override
	public Sequence findSequence(Sequence sequence) {
		
		String nextNumber = sequence.getPrefix().concat(sequence.getSuffix());
		sequence.setNextNumber(nextNumber);
		return sequence;
	}

}

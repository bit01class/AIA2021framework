package com.bit.action;

import java.util.logging.Logger;

import com.opensymphony.xwork2.Action;

public class IndexAction implements Action {
	Logger log=Logger.getLogger(this.getClass().getName());

	@Override
	public String execute() throws Exception {
		log.info("IndexAction...");
		return Action.SUCCESS;
	}

}

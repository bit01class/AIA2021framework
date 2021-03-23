package com.bit.core;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	String execute(HttpServletRequest req);
}

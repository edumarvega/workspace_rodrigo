package ar.com.templateit.cds.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class AccessDeniedAction extends ActionSupport {

	private static final long serialVersionUID = -7853806950904274074L;

	public String execute() {
		return "success";
	}
}

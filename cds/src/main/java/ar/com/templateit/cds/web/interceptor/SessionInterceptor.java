package ar.com.templateit.cds.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor{
	private static final long serialVersionUID = 4400749669148279973L;
	private static final String SESSION_EXPIRED = "sessionExpired";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> sessionAtributes = invocation.getInvocationContext().getSession();
		if(sessionAtributes == null || sessionAtributes.get("usuario")==null){
			return SESSION_EXPIRED;
		}
		else{
			if(!(sessionAtributes.get("usuario").toString().equals(null))){
				return invocation.invoke();
			}
			else{
				return SESSION_EXPIRED;
			}
		}
		
	}

}

package common.exception;
@SuppressWarnings("all")
public class ServiceException extends Throwable {
	private static final long serialVersionUID = 1L;

	public ServiceException(){
		super();
	}
	
	public ServiceException(String msg){
		super(msg);
	}
	
	public ServiceException(String msg,Throwable t){
		super(msg, t); 
	}
	
	
}

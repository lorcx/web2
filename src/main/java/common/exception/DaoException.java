package common.exception;

@SuppressWarnings("all")
public class DaoException extends Throwable {
	private static final long serialVersionUID = 1L;

	public DaoException(){
		super();
	}
	
	public DaoException(String msg){
		super(msg);
	}
	
	public DaoException(String msg,Throwable t){
		super(msg, t); 
	}
	
	
}

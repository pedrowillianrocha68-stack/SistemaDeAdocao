package exception;

public class AnimalIndisponivelException extends RuntimeException {
	
    private static final long serialVersionUID = 1l;	
	public AnimalIndisponivelException(String msg) {
		super(msg);
	}

}

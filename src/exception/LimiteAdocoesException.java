package exception;

public class LimiteAdocoesException extends RuntimeException{
	
	private static final long serialVersionUID = 1l;
	
	public LimiteAdocoesException(String msg) {
		super(msg);
	}
}

package exception;
public class TooManyRecordsException extends Exception {

	
  private String message = null;
  
  public TooManyRecordsException(){
	  super();
  }
  
  public TooManyRecordsException(String message) {  
	  super(message);
	  this.message = message;
  }
  
  public TooManyRecordsException(Throwable cause){
	  super(cause);
  }
  
  @Override
  public String toString(){
	  return message;
  }
  
  @Override
  public String getMessage(){
	  return message;
  }
}
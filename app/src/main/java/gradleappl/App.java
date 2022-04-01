package gradleappl;

import java.io.File;
import java.io.IOException;

/** public class <b>App</b> represents
 *  application which might be 
 *  run only on one instance. */
public class App {
	/** Constant <b>CODE</CODE> which should be returned 
	 * when the other instance of application run.*/
	public static final int CODE = 42;
	
	public static final String CHECK_THE_RIGHTS_MESSAGE = "Unable to create or delete temporary file.";

	/** Static void to start the application.*/
    public static void main(String[] args) {
    	final String dir = System.getProperty("user.dir");
    	final String pidFileName = dir +"/applicationIsRunning.temp";
	    File f = new File(pidFileName);
	    
	    if (!f.exists()) {
	    	try {
	    		f.createNewFile();
	    		f.deleteOnExit(); 
				Thread.currentThread().join();
			} catch (SecurityException x) {
	    		throw new SecurityException(CHECK_THE_RIGHTS_MESSAGE, x);
	    	} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } else {
	    	 System.exit(CODE);
	    }
    }
}

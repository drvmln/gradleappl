package gradleappl;

import java.io.File;
import java.io.IOException;

/** public class App represents
 *  application which might be 
 *  run only on one instance. */
public class App {
	/** Constant which should be returned when the other instance of application run.*/
	public static final int CODE = 42;
	
	/** Static void to start the application.*/
    public static void main(String[] args) {
    	final String dir = System.getProperty("user.dir");
    	System.out.println("dir: " + dir);
    	final String pidFileName = dir +"/ThisFileShowsThatAppRun.temp";
	    File f = new File(pidFileName);
	    
	    if (!f.exists()) {
	    	f.deleteOnExit();    
	    	try {
				f.createNewFile();
				Thread.currentThread().join();
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

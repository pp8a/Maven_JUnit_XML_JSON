import java.util.logging.Level;
import java.util.logging.Logger;

public class SuffixingApp {
	private static final Logger LOGGER = Logger.getLogger(SuffixingApp.class.getName());

	public static void main(String[] args) {
		
		if(args.length != 1) {
			LOGGER.severe("Usage: java -jar suffixing.jar <config-file>");
			return;
		}
		
		String configFile = args[0];
		SuffixingProcessor processor = new SuffixingProcessor();
		
		try {
			processor.processConfig(configFile);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error processing config file", e);
		}
		

	}

}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuffixingProcessor {
	
	private static final Logger LOGGER = Logger.getLogger(SuffixingProcessor.class.getName());
	
	String mode;
	String suffix;
	List<String> files;		
	
	public void processConfig(String configFile) {
		Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(configFile)) {
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found: " + e.getMessage(), e);
            return;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading properties: " + e.getMessage(), e);
            return;
        }
		
		mode = properties.getProperty("mode");
		suffix = properties.getProperty("suffix");
		String filesString = properties.getProperty("files");
		
		// Validate mode
        if (!isValidMode(mode)) {
        	LOGGER.severe("Mode is not recognized: " + mode);
            return;
        }

     // Validate suffix
        if (suffix == null || suffix.trim().isEmpty()) {
        	LOGGER.severe("No suffix is configured");
            return;
        }

        // Validate files
        if (filesString == null || filesString.trim().isEmpty()) {
        	LOGGER.warning("No files are configured to be copied/moved");
            return;
        }
		
        files = List.of(filesString.split(":"));
        
        for (String filePath : files) {
            Path sourcePath = Path.of(filePath);
            if (Files.notExists(sourcePath)) {
                LOGGER.log(Level.SEVERE, "No such file: " + sourcePath.toString().replace("\\", "/"));
                continue;
            }

            String destinationPath = addSuffixToFileName(filePath, suffix);

            try {
                Path destination = Path.of(destinationPath);
                if (mode.equalsIgnoreCase("copy")) {
                    Files.copy(sourcePath, destination, StandardCopyOption.REPLACE_EXISTING);
                    LOGGER.info(filePath + " -> " + destinationPath.replace("\\", "/"));
                } else if (mode.equalsIgnoreCase("move")) {
                    Files.move(sourcePath, destination, StandardCopyOption.REPLACE_EXISTING);
                    LOGGER.info(filePath + " => " + destinationPath.replace("\\", "/"));
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error while processing file: " + e.getMessage(), e);
            }
        }
	}
	
	private static boolean isValidMode(String mode) {
        return mode != null && (mode.equalsIgnoreCase("copy") || mode.equalsIgnoreCase("move"));
    }
	
	private static String addSuffixToFileName(String filePath, String suffix) {
		int  indexDot = filePath.lastIndexOf(".");
		if(indexDot != -1) {			
			return filePath.substring(0, indexDot) + suffix + filePath.substring(indexDot);
		}else {
			return filePath + suffix;
		}
	}

}

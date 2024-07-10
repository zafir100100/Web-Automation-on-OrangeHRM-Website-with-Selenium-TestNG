package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import models.ApplicationConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AppConfigLoader {
    @Getter
    private static ApplicationConfiguration config;

    /**
     * Static method to load the AppConfig from a JSON file.
     * This method can be called to refresh the configuration if necessary.
     */
    public static void loadConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
//            copyConfig(".env.local.zafir.device1.json");
            config = mapper.readValue(new File("src/test/java/configs/.env.json"), ApplicationConfiguration.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    /**
     * Performs the daring deed of copying any specified env configuration to the .env.json.
     * @param sourceEnv the name of the sorcerer's stone... I mean, the source environment file.
     */
    public static void copyConfig(String sourceEnv) {
        try {
            Files.copy(
                    Paths.get("src/test/java/configs/" + sourceEnv),
                    Paths.get("src/test/java/configs/.env.json"),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Like a thief in the night, the deed is done! " + sourceEnv + " has taken over .env.json!");
        } catch (IOException e) {
            System.err.println("Alas, the operation faltered. Here's why: " + e.getMessage());
            throw new RuntimeException("Failed to replace the configuration, thus halting the gears of progress", e);
        }
    }

    // Static block to initialize the configuration at class load time
    static {
        loadConfig();
    }
}

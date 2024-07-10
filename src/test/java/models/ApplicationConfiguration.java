package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationConfiguration {
    @JsonProperty("username")
    private String adminUserName;

    @JsonProperty("password")
    private String adminPassword;
}
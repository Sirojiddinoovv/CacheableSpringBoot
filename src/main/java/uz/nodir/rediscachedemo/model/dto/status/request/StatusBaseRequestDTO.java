package uz.nodir.rediscachedemo.model.dto.status.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusBaseRequestDTO {

    @Min(1)
    @NotNull
    @JsonProperty("code")
    private Integer code = 0;


    @NotBlank
    @JsonProperty("description")
    private String description;

}

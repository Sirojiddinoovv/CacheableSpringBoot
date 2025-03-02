package uz.nodir.rediscachedemo.model.dto.core.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData<R> {

    @JsonProperty("status_code")
    @JsonAlias({"status_code", "Status_code", "STATUS_CODE"})
    private Integer statusCode;

    @JsonProperty("is_success")
    @JsonAlias({"is_success", "Is_success", "IS_SUCCESS"})
    private Boolean isSuccess;

    @JsonProperty("result")
    @JsonAlias({"result", "Result", "RESULT"})
    private R result;

    @JsonProperty("error")
    @JsonAlias({"error", "Error", "ERROR"})
    private CoreResult error;

    public ResultData(R result) {
        this.statusCode = 0;
        this.isSuccess = true;
        this.result = result;
    }
}

package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Fault
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T16:50:17.044-03:00[America/Sao_Paulo]")
public class Fault   {
  @JsonProperty("code")
  private ErrorCodeEnum code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("details")
  private List<String> details = null;

  public Fault code(ErrorCodeEnum code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")
    public ErrorCodeEnum getCode() {
    return code;
  }

  public void setCode(ErrorCodeEnum code) {
    this.code = code;
  }

  public Fault message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error description
   * @return message
  **/
  @ApiModelProperty(example = "Internal Server Error", value = "Error description")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Fault details(List<String> details) {
    this.details = details;
    return this;
  }

  public Fault addDetailsItem(String detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Error detailed description
   * @return details
  **/
  @ApiModelProperty(example = "[Internal Server Error - An error has ocurred calling partner API.]", value = "Error detailed description")
  
    public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fault fault = (Fault) o;
    return Objects.equals(this.code, fault.code) &&
        Objects.equals(this.message, fault.message) &&
        Objects.equals(this.details, fault.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fault {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
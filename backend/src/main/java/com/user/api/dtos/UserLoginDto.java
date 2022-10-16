package com.user.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLoginDto {


  @NotBlank(message = "email can't be blank")
  @Email(message = "invalid format")
  private String email;
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}

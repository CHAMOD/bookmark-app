package com.user.api.dtos;

public class UserDto {

  public UserDto(final String name, final String mobileNo, final String email) {
    this.name = name;
    this.mobileNo = mobileNo;
    this.email = email;
  }

  private String name;

  private String mobileNo;

  private String email;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(final String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }
}

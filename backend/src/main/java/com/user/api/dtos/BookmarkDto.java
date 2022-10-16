package com.user.api.dtos;

public class BookmarkDto {

  private int bookmarkId;
  private String name;
  private String url;
  private String description;

  public int getBookmarkId() {
    return bookmarkId;
  }

  public void setBookmarkId(final int bookmarkId) {
    this.bookmarkId = bookmarkId;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }
}

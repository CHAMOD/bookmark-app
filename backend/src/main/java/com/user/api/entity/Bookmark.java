package com.user.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "bookmark")
public class Bookmark {
  private long id;
  private String name;
  private String url;
  private String description;
  private int status;
  private Timestamp expiryDate;
  private int featured;
  private String userId;
  private String image;
  private Timestamp createdAt;

  public Bookmark() {
  }

  public Bookmark(final long id,
                  final String name,
                  final String url,
                  final String description,
                  final int status,
                  final Timestamp expiry_date,
                  final int featured,
                  final String user_id,
                  final String image,
                  final Timestamp created_at) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.description = description;
    this.status = status;
    this.expiryDate = expiry_date;
    this.featured = featured;
    this.userId = user_id;
    this.image = image;
    this.createdAt = created_at;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "url", nullable = false)
  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  @Size(max = 1000)
  @Column(name = "description", nullable = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  @Column(name = "status", nullable = false)
  public int getStatus() {
    return status;
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  @Column(name = "expiry_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  public Timestamp getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(final Timestamp expiry_date) {
    this.expiryDate = expiry_date;
  }

  @Column(name = "featured")
  public int getFeatured() {
    return featured;
  }

  public void setFeatured(final int featured) {
    this.featured = featured;
  }

  @Column(name = "user_id")
  public String getUserId() {
    return userId;
  }

  public void setUserId(final String user_id) {
    this.userId = user_id;
  }

  @Column(name = "image")
  public String getImage() {
    return image;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  @Column(name = "created_at")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final Timestamp created_at) {
    this.createdAt = created_at;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Bookmark bookmark = (Bookmark) o;
    return id == bookmark.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

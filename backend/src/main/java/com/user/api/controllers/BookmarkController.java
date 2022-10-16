package com.user.api.controllers;

import com.user.api.dtos.BookmarkDto;
import com.user.api.entity.Bookmark;
import com.user.api.exceptions.ResourceNotFoundException;
import com.user.api.services.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/bookmarks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookmarkController {

  @Autowired
  BookmarkService bookmarkService;


  @GetMapping("/")
  public List<Bookmark> getBookmarks() {
    return bookmarkService.getBookmarks();
  }

  @GetMapping("/extractAllBookmarks")
  public ResponseEntity<String> extractAllBookmarks() {

    bookmarkService.extractAllBookmarks();
    return ResponseEntity.ok().body("succuss");
  }

  @PutMapping("/")
  public Bookmark updateBookmark(@RequestBody BookmarkDto bookmarkDto) throws ResourceNotFoundException {
    return bookmarkService.updateBookmark(bookmarkDto);
  }

  @GetMapping("/delete/{bookmarkId}")
  public ResponseEntity<String> deleteBookmarks(@PathVariable(value = "bookmarkId") final Long bookmarkId) throws ResourceNotFoundException {
    bookmarkService.deleteBookmark(bookmarkId);
    return ResponseEntity.ok().body("deleted");
  }

}

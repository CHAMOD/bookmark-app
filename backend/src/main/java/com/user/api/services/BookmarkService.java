package com.user.api.services;


import com.user.api.dtos.BookmarkDto;
import com.user.api.entity.Bookmark;
import com.user.api.exceptions.ResourceNotFoundException;
import com.user.api.repositories.BookmarkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {

  private static final Logger logger = LoggerFactory.getLogger(BookmarkService.class);

  @Autowired
  private BookmarkRepository bookmarkRepository;


  private RestTemplate restTemplate = new RestTemplate();

  public List<Bookmark> extractAllBookmarks() {
    bookmarkRepository.deleteAll();
    List<Bookmark> bookmarkList = new ArrayList<>();
    Bookmark[] result = restTemplate.getForObject("http://demo.dreamsquadgroup.com/test/index.json", Bookmark[].class);
    for (int i = 0; i < result.length; i++) {

      bookmarkList.add(result[i]);

    }
    logger.info("imported data successfully");

    return bookmarkRepository.saveAll(bookmarkList);
  }

  public List<Bookmark> getBookmarks() {
    return bookmarkRepository.findAll();
  }

  public Bookmark updateBookmark(BookmarkDto userDto) throws ResourceNotFoundException {
    Optional<Bookmark> bookmark = Optional.ofNullable(bookmarkRepository.findById(Long.valueOf(userDto.getBookmarkId()))
                                                        .orElseThrow(() -> new ResourceNotFoundException("bookmark is not found for id : " + userDto.getBookmarkId())));

    bookmark.get().setName(userDto.getName());
    bookmark.get().setUrl(userDto.getUrl());
    bookmark.get().setDescription(userDto.getDescription());

    return bookmarkRepository.save(bookmark.get());
  }

  public boolean deleteBookmark(final Long bookmarkId) throws ResourceNotFoundException {

    Optional<Bookmark> bookmark = Optional.ofNullable(bookmarkRepository.findById(Long.valueOf(bookmarkId)))
      .orElseThrow(() -> new ResourceNotFoundException("bookmark is not found for id : " + bookmarkId));

    bookmarkRepository.deleteById(bookmark.get().getId());
    return true;
  }


}

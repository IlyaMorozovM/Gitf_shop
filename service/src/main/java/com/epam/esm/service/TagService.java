package com.epam.esm.service;

import com.epam.esm.model.Tag;
import com.epam.esm.service.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TagService {

    Tag getTag(String name) throws ServiceException;
    Tag getTag(int id) throws ServiceException;
    List<Tag> getAllTags() throws ServiceException;
    Tag addTag(Tag tag) throws ServiceException;
    void deleteTag(int tagId) throws ServiceException;
}

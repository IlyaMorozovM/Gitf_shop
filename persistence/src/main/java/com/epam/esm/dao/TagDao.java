package com.epam.esm.dao;


import com.epam.esm.dao.exception.PersistenceException;
import com.epam.esm.model.Tag;
import java.util.List;

public interface TagDao {

    Tag getTag(String name);
    Tag getTag(int id);
    List<Tag> getAllTags();

    int addTag(Tag tag) throws PersistenceException;
    boolean deleteTag(int tagId);
}

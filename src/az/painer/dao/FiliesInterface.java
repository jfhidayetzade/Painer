package az.painer.dao;

import az.painer.model.Filies;

import java.util.List;

public interface FiliesInterface {


    public boolean addFile(String key, String file_path) throws Exception;
    public String findAllPath(String key) throws Exception;
}

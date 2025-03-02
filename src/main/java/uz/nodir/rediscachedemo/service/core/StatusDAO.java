package uz.nodir.rediscachedemo.service.core;

import uz.nodir.rediscachedemo.entity.Status;

import java.util.List;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */
public interface StatusDAO {
    Status save(Status status);

    List<Status> getAll();

    void delete(Long id);

    void cacheEvict();
}

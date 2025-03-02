package uz.nodir.rediscachedemo.service.core.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.nodir.rediscachedemo.entity.Status;
import uz.nodir.rediscachedemo.repository.StatusRepository;
import uz.nodir.rediscachedemo.service.core.StatusDAO;

import java.util.List;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class StatusDAOImpl implements StatusDAO {
    private final StatusRepository repository;
    private final static String CACHE_NAME = "status";


    @Override
    @Transactional
    @CacheEvict(value = CACHE_NAME, allEntries = true)
    public Status save(Status status) {
        log.info("Save status entity: {}", status);
        return repository.save(status);
    }

    /**
     * if you don't explicitly set the key parameter in a method with @Cacheable, Spring will generate the key itself based on the method parameters. This means that:

     * It will be impossible to delete (@CacheEvict) or update (@CachePut) data in the cache using an explicit key (key in the annotation),
     * since you don't know which key was generated automatically. Since you have value = CACHE_NAME, the key in Redis will be: CACHE_NAME::SimpleKey.EMPTY
     */

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_NAME, sync = true)
    public List<Status> getAll() {
        log.info("Get all statuses List");
        return repository.findAll();
    }

    @Override
    @CacheEvict(value = CACHE_NAME, allEntries = true)
    @Transactional
    public void delete(Long id) {
        log.info("Delete Status with id: {}", id);
        repository.deleteById(id);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, allEntries = true)
    public void cacheEvict() {
        log.info("Statuses cache evicting...");
    }

}

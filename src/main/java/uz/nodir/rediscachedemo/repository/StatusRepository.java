package uz.nodir.rediscachedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nodir.rediscachedemo.entity.Status;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}

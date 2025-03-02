package uz.nodir.rediscachedemo.service.business.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.nodir.rediscachedemo.entity.Status;
import uz.nodir.rediscachedemo.model.dto.core.response.CoreResult;
import uz.nodir.rediscachedemo.model.dto.core.response.ResultData;
import uz.nodir.rediscachedemo.model.dto.status.request.StatusBaseRequestDTO;
import uz.nodir.rediscachedemo.model.dto.status.response.StatusBaseResponseDTO;
import uz.nodir.rediscachedemo.service.business.StatusService;
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
public class StatusServiceImpl implements StatusService {
    private final StatusDAO dao;

    @Override
    public ResultData<StatusBaseResponseDTO> create(StatusBaseRequestDTO requestDTO) {
        log.info("Received command to create status with request dto: {}", requestDTO);

        var entity = dao.save(
                new Status(
                        requestDTO.getCode(),
                        requestDTO.getDescription()
                )
        );

        var response = new ResultData<>(
                new StatusBaseResponseDTO(
                        entity.getId(),
                        entity.getCode(),
                        entity.getDescription()
                )
        );

        log.info("Finished command to create status with response dto: {}", response);

        return response;
    }

    @Override
    public ResultData<StatusBaseResponseDTO> update(Long id, @NonNull StatusBaseRequestDTO requestDTO) {
        log.info("Received command to update status by id: {} with request dto: {} ", id, requestDTO);
        var status = getStatusById(id);

        log.info("Updating from: {} to: {}", status, requestDTO);
        status.setCode(requestDTO.getCode());
        status.setDescription(requestDTO.getDescription());

        var savedStatus = dao.save(status);

        var response = new ResultData<>(
                new StatusBaseResponseDTO(
                        savedStatus.getId(),
                        savedStatus.getCode(),
                        savedStatus.getDescription()
                ));

        log.info("Finished command to update status with response dto: {}", response);
        return response;
    }

    private Status getStatusById(Long id) {
        var statusOptional = dao.getAll()
                .stream()
                .filter(z -> z.getId().equals(id))
                .findFirst();

        if (statusOptional.isEmpty())
            throw new EntityNotFoundException("Status with id: %d not found in database!".formatted(id));

        return statusOptional.get();
    }

    @Override
    public ResultData<StatusBaseResponseDTO> findById(Long id) {
        log.info("Received command to find status by id: {}", id);
        var status = getStatusById(id);

        var response = new ResultData<>(
                new StatusBaseResponseDTO(
                        status.getId(),
                        status.getCode(),
                        status.getDescription()
                ));

        log.info("Finished command to find status with response dto: {}", response);
        return response;
    }

    @Override
    public ResultData<StatusBaseResponseDTO> deleteById(Long id) {
        log.info("Received command to delete status by id: {}", id);

        var status = getStatusById(id);

        dao.delete(id);

        var response = new ResultData<>(
                new StatusBaseResponseDTO(
                        status.getId(),
                        status.getCode(),
                        status.getDescription()
                )
        );

        log.info("Finished command to delete status with response dto: {}", response);
        return response;
    }

    @Override
    public ResultData<CoreResult> evictCache() {
        log.info("Received command to evict cache");
        dao.cacheEvict();
        return new ResultData<>(
                new CoreResult(
                        0, "SUCCESS"
                )
        );
    }

    @Override
    public ResultData<List<StatusBaseResponseDTO>> findAll() {
        log.info("Received command to find all statuses");

        var response = new ResultData<>(
                dao.getAll()
                        .stream()
                        .map(z -> new StatusBaseResponseDTO(
                                z.getId(),
                                z.getCode(),
                                z.getDescription()))
                        .toList()
        );

        log.info("Finished command to find all statuses with size: {}", response.getResult().size());
        return response;
    }
}

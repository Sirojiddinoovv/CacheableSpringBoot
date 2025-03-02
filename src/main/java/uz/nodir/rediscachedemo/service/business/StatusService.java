package uz.nodir.rediscachedemo.service.business;

import lombok.NonNull;
import uz.nodir.rediscachedemo.model.dto.core.response.CoreResult;
import uz.nodir.rediscachedemo.model.dto.core.response.ResultData;
import uz.nodir.rediscachedemo.model.dto.status.request.StatusBaseRequestDTO;
import uz.nodir.rediscachedemo.model.dto.status.response.StatusBaseResponseDTO;

import java.util.List;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */
public interface StatusService {

    ResultData<StatusBaseResponseDTO> create(StatusBaseRequestDTO requestDTO);

    ResultData<StatusBaseResponseDTO> update(Long id, @NonNull StatusBaseRequestDTO requestDTO);

    ResultData<StatusBaseResponseDTO> findById(Long id);

    ResultData<StatusBaseResponseDTO> deleteById(Long id);

    ResultData<CoreResult> evictCache();

    ResultData<List<StatusBaseResponseDTO>> findAll();
}

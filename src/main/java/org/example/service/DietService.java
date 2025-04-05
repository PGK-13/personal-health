package org.example.service;

import org.example.pojo.dto.DietAddDTO;
import org.example.pojo.dto.DietDTO;
import org.example.pojo.result.Result;

/**
 * @param
 * @author zklee
 * @return
 * @date 2025/3/31
 */
public interface DietService {
    Result pageQuery(DietDTO dietDTO);

    Result add(DietAddDTO dietAddDTO);
}

package com.example.sourcebase.service;

import com.example.sourcebase.domain.dto.reqdto.ItemReqDTO;
import com.example.sourcebase.domain.dto.resdto.ItemResDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IItemService {
    ItemResDTO findById(Long id);
    ItemResDTO add(ItemReqDTO resDTO);
    boolean update(Long id, ItemReqDTO reqDTO);
    boolean deletedById(Long id);
    Page<List<ItemResDTO>> findAllWithSearch(String search, Pageable pageable);
//    List<ListResDto> getAllByCategoryId(Long id);
}

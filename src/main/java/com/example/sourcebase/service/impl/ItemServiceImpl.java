package com.example.sourcebase.service.impl;

import com.example.sourcebase.domain.Criteria;
import com.example.sourcebase.domain.dto.reqdto.ItemReqDTO;
import com.example.sourcebase.domain.dto.resdto.ItemResDTO;
import com.example.sourcebase.mapper.ItemMapper;
import com.example.sourcebase.repository.IItemRepository;
import com.example.sourcebase.service.IItemService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ItemServiceImpl implements IItemService {

    IItemRepository itemRepository;
    ItemMapper itemMapper = ItemMapper.INSTANCE;

    @Override
    public ItemResDTO findById(Long id) {
        Criteria criteria = itemRepository.findById(id).orElse(null);
        return itemMapper.toResDTO(criteria);
    }

    @Override
    public ItemResDTO add(ItemReqDTO itemReqDTO) {
        return null;
    }

    @Override
    public boolean update(Long id, ItemReqDTO reqDTO) {
        return false;
    }

    @Override
    public boolean deletedById(Long id) {
        return false;
    }

    @Override
    public Page<List<ItemResDTO>> findAllWithSearch(String search, Pageable pageable) {
        return null;
    }
}

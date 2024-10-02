package com.example.sourcebase.mapper;

import com.example.sourcebase.domain.Criteria;
import com.example.sourcebase.domain.dto.reqdto.ItemReqDTO;
import com.example.sourcebase.domain.dto.resdto.ItemResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    Criteria reqDtoToItem(ItemReqDTO reqDTO);
    ItemResDTO toResDTO(Criteria criteria);
}

package com.example.sourcebase.controller;

import com.example.sourcebase.domain.dto.reqdto.ItemReqDTO;
import com.example.sourcebase.service.IItemService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ItemRestController {
    IItemService itemService;
    @GetMapping("/{id}")
    //ResponseData<?>
    //not found -> 404
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @PostMapping
    //refactor Dto -> DTO
    public ResponseEntity<?> createItem(@RequestBody ItemReqDTO reqDTO) {
        return ResponseEntity.ok(itemService.add(reqDTO));
    }
}

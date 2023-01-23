package com.example.holaserver.Item;

import com.example.holaserver.Common.response.ResponseTemplate;
import com.example.holaserver.Item.DTO.ItemSaveBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/{storeId}/items")
    public ResponseTemplate<Map<String, Object>> itemSave(
            @RequestBody ItemSaveBody[] itemSaveBodies,
            @PathVariable Long storeId
        ) {
            return new ResponseTemplate<>(itemService.saveItems(
                storeId,
                itemSaveBodies,
                true
        ), "상품 정보 저장 성공");
    }

    @PostMapping("/{storeId}/items/temporary-save")
    public ResponseTemplate<Map<String, Object>> itemSaveByTemporarySave(
            @RequestBody ItemSaveBody[] itemSaveBodies,
            @PathVariable Long storeId
    ) {
        return new ResponseTemplate<>(itemService.saveItems(
                storeId,
                itemSaveBodies,
                false
        ), "상품 정보 임시저장 성공");
    }
}

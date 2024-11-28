package com.example.restapi.controller;

import com.example.restapi.model.BorderInfo;
import com.example.restapi.service.BorderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/border_info")
public class BorderInfoController {

    @Autowired
    private BorderInfoService borderInfoService;

    @GetMapping("/{key_word}")
    public ResponseEntity<BorderInfo> getBorderInfoById(@PathVariable String key_word) {
        return borderInfoService.getBorderInfoById(key_word)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BorderInfo createBorderInfo(@RequestBody BorderInfo borderInfo) {
        return borderInfoService.createBorderInfo(borderInfo);
    }

    @PutMapping("/{key_word}")
    public ResponseEntity<BorderInfo> updateBorderInfo(@PathVariable String key_word, @RequestBody BorderInfo borderInfo) {
        try {
            BorderInfo updatedBorderInfo = borderInfoService.updateBorderInfo(key_word, borderInfo);
            return ResponseEntity.ok(updatedBorderInfo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{key_word}")
    public ResponseEntity<Void> deleteBorderInfo(@PathVariable String key_word) {
        try {
            borderInfoService.deleteBorderInfo(key_word);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
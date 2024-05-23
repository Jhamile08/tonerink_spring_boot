package com.riwi.tonerink.api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.tonerink.api.dto.request.ProductRequest;
import com.riwi.tonerink.api.dto.response.ProductResponse;
import com.riwi.tonerink.infrastructure.abstract_service.IProductService;
import com.riwi.tonerink.util.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/product")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {
        private final IProductService iProductService ;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
            if (Objects.isNull(sortType)) sortType = SortType.NONE;
        return ResponseEntity.ok(this.iProductService.getAll(page - 1, size, sortType));
    }
    @PostMapping
    public ResponseEntity<ProductResponse> insert(
            @Validated @RequestBody ProductRequest request) {
        return ResponseEntity.ok(this.iProductService.create(request));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> update(
            @Validated @RequestBody ProductRequest request,
            @PathVariable Integer id) {
        return ResponseEntity.ok(this.iProductService.update(request, id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.iProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

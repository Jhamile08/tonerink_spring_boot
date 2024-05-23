package com.riwi.tonerink.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.tonerink.api.dto.request.ProductRequest;
import com.riwi.tonerink.api.dto.response.ProductResponse;
import com.riwi.tonerink.domain.entities.Product;
import com.riwi.tonerink.domain.repositories.ProductRepository;
import com.riwi.tonerink.infrastructure.abstract_service.IProductService;
import com.riwi.tonerink.util.enums.SortType;
import com.riwi.tonerink.util.enums.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    
    @Autowired
    private final ProductRepository productRepository;
    
    @Override
    public ProductResponse create(ProductRequest request) {
         Product product = this.requestToEntity(request);
        return this.entityToResp(this.productRepository.save(product));
    }

    @Override
    public ProductResponse get(Integer id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public ProductResponse update(ProductRequest request, Integer id) {
        Product product = this.find(id);
        product = this.requestToEntity(request);

        product.setId(id);
        product.setTypeProduct(request.getTypeProduct());
        product.setBrandProduct(request.getBrandProduct());
        product.setQualityProduct(request.getQualityProduct());
        product.setImgProduct(request.getImgProduct());
        product.setNameProduct(request.getNameProduct());
        product.setPerformanceProduct(request.getPerformanceProduct());
        product.setCompatibilityProduct(request.getCompatibilityProduct());
        product.setPriceProduct(request.getPriceProduct());
       
        return this.entityToResp(this.productRepository.save(product));

    }

    @Override
    public void delete(Integer id) {
        this.productRepository.delete(this.find(id));
    }

    @Override
    public Page<ProductResponse> getAll(int page, int size, SortType sortType) {
                if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.productRepository.findAll(pagination)
                .map(this::entityToResp);
    }
    private Product requestToEntity(ProductRequest request) {
        Product product = new Product();
        product.setTypeProduct(request.getTypeProduct());
        product.setBrandProduct(request.getBrandProduct());
        product.setQualityProduct(request.getQualityProduct());
        product.setImgProduct(request.getImgProduct());
        product.setNameProduct(request.getNameProduct());
        product.setPerformanceProduct(request.getPerformanceProduct());
        product.setCompatibilityProduct(request.getCompatibilityProduct());
        product.setPriceProduct(request.getPriceProduct());
        return product;
    }

    private ProductResponse entityToResp(Product entity) {
        ProductResponse resp = new ProductResponse();
        resp.setId(entity.getId());
        resp.setTypeProduct(entity.getTypeProduct());
        resp.setBrandProduct(entity.getBrandProduct());
        resp.setQualityProduct(entity.getQualityProduct());
        resp.setImgProduct(entity.getImgProduct());
        resp.setNameProduct(entity.getNameProduct());
        resp.setPerformanceProduct(entity.getPerformanceProduct());
        resp.setCompatibilityProduct(entity.getCompatibilityProduct());
        resp.setPriceProduct(entity.getPriceProduct());
        return resp;
    }
        private Product find(Integer id) {
        return this.productRepository.findById(id)
        .orElseThrow(()-> new BadRequestException("No hay preguntas con el id suministrado"));
    }

}

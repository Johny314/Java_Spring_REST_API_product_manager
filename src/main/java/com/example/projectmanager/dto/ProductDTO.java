package com.example.projectmanager.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Short amount;
    private Long category_id;
}

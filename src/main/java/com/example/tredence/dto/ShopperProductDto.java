package com.example.tredence.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShopperProductDto {


   private String shopperId;
  private   List<Shelf> shelf;
}

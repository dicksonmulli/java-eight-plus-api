package com.study.javaeightplusapi.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int quantity;
    private String name;
    private int price;
    private double qualityStandard;
}

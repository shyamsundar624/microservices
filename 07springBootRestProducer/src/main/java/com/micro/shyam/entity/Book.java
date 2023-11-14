package com.micro.shyam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
private Integer bId;
private String bname;
private String bauth;
private Double bcost;

}

package com.example.apisync.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseDto {
    protected Long id;
    protected Date createDate;
}
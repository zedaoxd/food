package com.food.controller.exception;

import lombok.Data;

import java.util.Date;

@Data
public class DefaultException {

    private Integer status;
    private String error;
    private String path;
    private Date timestamp;
    private String message;
}

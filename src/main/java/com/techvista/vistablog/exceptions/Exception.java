package com.techvista.vistablog.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class Exception {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


}

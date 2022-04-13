package com.fcamara.technicalshare.technicalshare.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class SystemValidationException {

    private String field;
    private String message;

}

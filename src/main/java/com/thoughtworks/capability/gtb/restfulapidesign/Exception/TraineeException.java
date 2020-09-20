package com.thoughtworks.capability.gtb.restfulapidesign.Exception;

import org.springframework.http.HttpStatus;

public class TraineeException extends BasicException {
    public TraineeException(int id) {
        super(HttpStatus.NOT_FOUND, "未找到ID为 " + id + " 的学员");
    }
}

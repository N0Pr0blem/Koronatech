package com.task.validator;

public interface Validator <O,I>{
    O validate(I i);
}

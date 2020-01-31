package com.example.demo.dto;

public interface Convert<S,T> {
    T convert(S s, T t);
    T convert(S s);
}

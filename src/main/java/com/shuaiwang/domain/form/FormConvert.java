package com.shuaiwang.domain.form;

public interface FormConvert<S, T> {
    T convert(S s);
}

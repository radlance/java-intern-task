package com.radlance.javainterntask.mappers;

public interface Mapper<I, O> {
    O map(I object);

    default I unmap(O object) {
        return null;
    }
}

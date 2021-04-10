package com.shumile.druid_demo.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionB {
    @Transactional
    void testB();

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void testNotSupported();
}

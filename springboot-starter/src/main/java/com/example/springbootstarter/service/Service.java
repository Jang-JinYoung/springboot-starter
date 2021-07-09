package com.example.springbootstarter.service;

import com.example.springbootstarter.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
public class Service {

    @Autowired
    Mapper mapper;
}

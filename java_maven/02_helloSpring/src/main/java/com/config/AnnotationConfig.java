package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.model.Engine;

@Configuration
@ComponentScan(basePackages= {"com.component","com.model"})//可以掃描多個package
public class AnnotationConfig {

}
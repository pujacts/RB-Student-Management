package com.rak.studentmanagement.config;

import com.rak.fee.service.configure.FeeClientConfiguration;
import com.rak.fee.service.configure.FeeCollectionProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({FeeClientConfiguration.class, FeeCollectionProperties.class})
public class PackageConfiguration { }

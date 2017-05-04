package com.master.config;

import com.master.MagnetoApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Mr.Cheng on 2017/4/26 0026.\
 * for war, run server error if not
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MagnetoApplication.class);
    }
}

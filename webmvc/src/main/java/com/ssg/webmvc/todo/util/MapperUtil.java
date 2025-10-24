package com.ssg.webmvc.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;


// 객체를 복사하기 위한 ENUM 클래스
public enum MapperUtil {

    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true) // 객체를 복사 해야하므로 두 객체를 비교하기 위한 Matching Enable
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE) //
                .setMatchingStrategy(MatchingStrategies.STRICT); //
    }

    public ModelMapper get() {
        return modelMapper;
    }


}

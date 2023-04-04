package me.example.training.spring.domain.convert;

import me.example.training.spring.domain.dto.ComDTO;
import me.example.training.spring.domain.query.ComQuery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhoujialiang9
 * @date 2023/3/20 17:57
 **/
@Mapper
public interface ComConvert {
    ComConvert INSTANCE = Mappers.getMapper(ComConvert.class);

    ComDTO convert2ComDTO(ComQuery comQuery);
}

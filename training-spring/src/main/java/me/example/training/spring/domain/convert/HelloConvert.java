package me.example.training.spring.domain.convert;

import me.example.training.spring.domain.dto.ComDTO;
import me.example.training.spring.domain.query.ComQuery;
import me.example.training.spring.domain.vo.HelloVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhoujialiang9
 * @date 2023/7/21 16:05
 **/
@Mapper
public interface HelloConvert {
    HelloConvert INSTANCE = Mappers.getMapper(HelloConvert.class);

    HelloVO convert2HelloVO(ComQuery comQuery);
}

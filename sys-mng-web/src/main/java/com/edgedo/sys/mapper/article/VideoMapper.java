package com.edgedo.sys.mapper.article;


import com.edgedo.sys.entity.article.Video;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {


    List<Video>  getVideoes();


}

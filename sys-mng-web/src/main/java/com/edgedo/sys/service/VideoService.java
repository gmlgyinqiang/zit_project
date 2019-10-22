package com.edgedo.sys.service;


import com.edgedo.sys.entity.article.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
   // private VideoMapper videoMapper;

    public List<Video>  getVideoes(){
      //  List<Video> list=videoMapper.getVideoes();
        List list=new ArrayList();
        return list;
    }
}


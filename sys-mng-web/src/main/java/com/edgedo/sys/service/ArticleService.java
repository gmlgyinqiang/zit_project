package com.edgedo.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.sys.entity.article.Article;
import com.edgedo.sys.mapper.article.ArticleMapper;
import com.edgedo.sys.queryvo.ArticleQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    /**
     * 首页文章列表
     * @return
     */
    public List<Article> selectArticles(){
        List<Article> list=articleMapper.selectArticles();
        return list;
    }
    /**
     * 点击查看详情
     * @param id
     * @return
     */
    public Article getArticleById(Integer id) {
        Article article=articleMapper.getArticleById(id);
        return article;
    }
    /**
     * 添加
     * @param article
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public String insertArticle(Article article) {
        article.setCreateTime(new Date());
        article.setState(1);
        articleMapper.insertArticle(article);
        return "";
    }
    /**
     * 删除
     * @param id
     */
    public void deleteArticleById(Integer id) {
        articleMapper.deleteArticle(id);
    }
    /**
     * 修改
     * @param article
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public String updateArticleById(Article article) {
        article.setUpdateTime(new Date());
        Integer i=articleMapper.updateArticle(article);
       // System.out.println("i======"+i);
        return  "";
    }
    /**
     * 后台列表
     * @param article
     * @return
     */
    public List<Article> getArticles(Article article){
        List<Article> list = articleMapper.getArticles(article);
        return list;
    }
    public void articleList(ArticleQuery articleQuery){
       //List<Article> articleMapper.getArticles(articleQuery);
        List list= articleMapper.listPage(articleQuery);
        //List list = mapper.listPage(query);
        if(list.size()==0){
            articleQuery.getQueryObj().setContent(articleQuery.getQueryObj().getContent());
            articleQuery.getQueryObj().setContent(null);
            List list2 = articleMapper.listPage(articleQuery);
            articleQuery.setList(list2);
        }else{
            articleQuery.setList(list);
        }

    }
    public void list(ArticleQuery query){
        List list = articleMapper.listPage(query);
        query.setList(list);
    }
    public Integer count(Article article) {
        return articleMapper.getCount(article);
    }


    /**
     * Integer page,Integer limit,String title
     * @return
     * @ModelAttribute ArticleQuery articleQuery
     * @param title
     * @param limit
     * @param page
     */
    @Pass
    @RequestMapping("getArticles.jsn")
    @ResponseBody
    public JSONObject getArticles(String title, Integer limit, Integer page) {
        ModelAndView modelAndView=new ModelAndView();
        JSONObject js=new JSONObject();
        Integer before=limit*(page-1);
        Integer after=page*limit;
        Article article=new Article();
        article.setPageIndex(before);
        if(!StringUtils.isEmpty(title)){
            article.setTitle(title);
        }
        article.setPageSize(after);
        List<Article> articles = getArticles(article);
        Integer count = count(article);
        js.put("code",0);
        js.put("msg","");
        js.put("data",articles);
        js.put("count",count);
         System.out.println("数据"+js);
        //articleService.articleList(articleQuery);
        return js;
        /*buildResponse(modelAndView,articleQuery);
        return modelAndView;*/
        }
}


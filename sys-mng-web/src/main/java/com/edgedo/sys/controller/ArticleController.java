package com.edgedo.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.FileUtil;
import com.edgedo.common.util.oss.AliyunCloudStorageService;
import com.edgedo.sys.entity.article.Article;
import com.edgedo.sys.entity.article.Video;
import com.edgedo.sys.service.ArticleService;
import com.edgedo.sys.service.VideoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;


@RequestMapping("/articles")
@Controller
public class ArticleController extends BaseController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private AliyunCloudStorageService aliyunCloudStorageService;

	@Autowired
	private VideoService videoService;

	private Logger logger=Logger.getLogger(ArticleController.class);

	public static String endpoint = "oss-cn-beijing.aliyuncs.com";
	public static String accessKeyId = "LTAIuqiMJLCCRRdH";
	public static String accessKeySecret = "ComhSAx9liiYNW69brUVi2eq3u7SNX";
	public static String bucketName = "scale";
	private Object JsonResult;



	@RequestMapping(value="/getVideos",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject getVideos(){
		JSONObject js=new JSONObject();
		List<Video> list=videoService.getVideoes();
		if(list.size()==0){
			js.put("code",9901);
			js.put("msg","结果集为空");
		}
		if(list.size()!=0){
			js.put("code",0);
			js.put("msg","成功");
			js.put("data",list);
		}
		return js;
	}


	/**
	 * 首页
	 * @return
	 */
	@Pass
	@RequestMapping("/selectArticles.jsn")
	@ResponseBody
	public JSONObject selectArticles() {
		JSONObject js=new JSONObject();
		List<Article> articles=articleService.selectArticles();
		try {
			if (articles.size()==0) {
				js.put("code", 9901);
				js.put("msg","结果集为空");
			}
			if(articles.size()!=0){
				js.put("code", 0);
				js.put("msg","获得成功");
				js.put("data",articles);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e);
			js.put("code",1);
			js.put("msg","数据操作失败");
		}
		return js;
	}
	/**
	 * 详情
	 * @param id 文章id
	 * @return
	 */
	@Pass
	@RequestMapping("getArticleById.jsn")
	@ResponseBody
	public JSONObject h(Integer id) {
		JSONObject js=new JSONObject();
		if (id==null) {
			js.put("code",403);
			js.put("msg","所传参数不能为空");
			return js;
		}
		try {
			if (id!=null) {
				Article article = articleService.getArticleById(id);
				if (article==null) {
					js.put("code",9901);
					js.put("msg","查询结果为空");
					return js;
				}
				else if(article!=null){
					js.put("code",0);
					js.put("msg","获得成功");
					js.put("data",article);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e);
			js.put("code",1);
			js.put("msg","数据操作失败");
		}
		return js;
	}
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@PostMapping("deleteArticleById.jsn")
	public JSONObject de(String ids) {
		JSONObject js=new JSONObject();
		if (ids==null) {
			js.put("code",403);
			js.put("msg","传入参数不能为空");
			return js;
		}
		try {
			if (ids!=null) {
				//分割
				String[] split = ids.split(",");
				for (String id : split) {
					articleService.deleteArticleById(Integer.parseInt(id));
				}
				js.put("code",0);
				js.put("msg","删除成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e);
			js.put("code",1);
			js.put("msg","数据操作失败");
		}
		return js;
	}

	@PostMapping("/upload.jsn")
	public JSONObject fileUpload(MultipartFile cover) {
		JSONObject js=new JSONObject();
		String imageurl = "";
		String imagename = "";
		UploadController demo=new UploadController();
		try {
			String fileName = cover.getOriginalFilename();
			imagename = "images/" + UUID.randomUUID() + ".jpg";
			imageurl = demo.uploadFile(imagename, cover);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("error");
			js.put("code",1);
			return js;
		}
		js.put("code",0);
		js.put("data",imageurl);
		return js;
	}


	/**
	 * 添加
	 * @RequestParam(value="cover1") MultipartFile  cover
	 */
	@Pass
	@PostMapping("/insertArticle.jsn")
	public JSONObject insertArticle(Article article) throws FileNotFoundException {
		JSONObject js=new JSONObject();
			/*if (article.getContent()==null) {
				js.put("code",403);
				js.put("msg","传入参数不能为空");
				return  js;
			}*/
		if(article.getImgBase64Str1()!=null){
			byte[] bytes = FileUtil.generateImageFromBase64Str(article.getImgBase64Str1());
			String  imageSuffix = FileUtil.getImageSuffix(article.getImgBase64Str1());
			try {
				if(bytes.length>0){
					String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
					article.setSmallImgurl(imgUrl);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//大图
			/*if(article.getImgBase64Str2()!=null){
				byte[] bytes = FileUtil.generateImageFromBase64Str(article.getImgBase64Str2());
				String  imageSuffix = FileUtil.getImageSuffix(article.getImgBase64Str2());
				try {
					if(bytes.length>0){
						String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
						article.setBigImgurl(imgUrl);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//插图
			if(article.getImgBase64Str3()!=null){
				byte[] bytes = FileUtil.generateImageFromBase64Str(article.getImgBase64Str3());
				String  imageSuffix = FileUtil.getImageSuffix(article.getImgBase64Str3());
				try {
					if(bytes.length>0){
						String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
						article.setInsertImgurl(imgUrl);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			/*if(errMsg!=null && !errMsg.equals("")){
					buildErrorResponse(view, errMsg);
				}else{
					buildResponse(view);
				}*/
		ModelAndView view=new ModelAndView();
		//System.out.println("进入添加");
		String content=article.getContent();
		UploadController demo=new UploadController();
		//String fileName = cover.getOriginalFilename();
		// String imagename = "images/" + UUID.randomUUID() + ".jpg";
		//System.out.println("方法前");
		//String imageurl = demo.uploadFile(imagename, cover);
		//article.setSmallImgurl(imageurl);
		String errMsg=articleService.insertArticle(article);
		//System.out.println("后台方法   1111111111111111111111111111111111111111");
		js.put("data",content);
		js.put("msg","添加成功");
		js.put("code",0);

		return js;
	}

	/**
	 * 修改
	 * @param article
	 * Article article, HttpServletResponse response, HttpServletRequest request
	 * @return
	 */
	@PostMapping("updateArticle.jsn")
	public JSONObject update(Article article) {
		JSONObject js=new JSONObject();
		//System.out.println("进入修改方法");
		//小图
		if(article.getImgBase64Str1()!=null){
			byte[] bytes = FileUtil.generateImageFromBase64Str(article.getImgBase64Str1());
			String  imageSuffix = FileUtil.getImageSuffix(article.getImgBase64Str1());
			try {
				if(bytes.length>0){
					String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
					article.setSmallImgurl(imgUrl);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//大图
		/*if(article.getImgBase64Str2()!=null){
			byte[] bytes = FileUtil.generateImageFromBase64Str(article.getImgBase64Str2());
			String  imageSuffix = FileUtil.getImageSuffix(article.getImgBase64Str2());
			try {
				if(bytes.length>0){
					String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
					article.setBigImgurl(imgUrl);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//插图
		if(article.getImgBase64Str3()!=null){
			byte[] bytes = FileUtil.generateImageFromBase64Str(article.getImgBase64Str3());
			String  imageSuffix = FileUtil.getImageSuffix(article.getImgBase64Str3());
			try {
				if(bytes.length>0){
					String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
					article.setInsertImgurl(imgUrl);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		if(article.getId()==null){
			js.put("code",403);
			js.put("msg","id不能为空");
		}
		ModelAndView view=new ModelAndView();
		try {
			if(article.getId()!=null){
				String errMsg=articleService.updateArticleById(article);
				//if(errMsg!=null && !errMsg.equals("")){
				buildErrorResponse(view, errMsg);
				js.put("code",0);
				js.put("msg","修改成功");
				js.put("data",article);
				return  js;
				/*}else{
					buildResponse(view);
				}*/
			}
		}catch (Exception e){
			logger.debug(e);
			js.put("code",1);
			js.put("msg","数据操作失败");
		}
		/*ModelAndView view=new ModelAndView();
		String errMsg=articleService.updateArticleById(article);
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(view, errMsg);
		}else{
			buildResponse(view);
		}*/
		return js;
	}

	/**
	 * Integer page,Integer limit,String title
	 * @return
	 * @ModelAttribute ArticleQuery articleQuery
	 */
	@Pass
	@RequestMapping("getArticles.jsn")
	@ResponseBody
	public  JSONObject getArticles(String title,Integer limit,Integer page) {
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
		List<Article> articles = articleService.getArticles(article);
		Integer count = articleService.count(article);
		js.put("code",0);
		js.put("msg","");
		js.put("data",articles);
		js.put("count",count);
		//System.out.println("数据"+js);
		//articleService.articleList(articleQuery);
		return js;
		/*buildResponse(modelAndView,articleQuery);
		return modelAndView;*/
	}
}

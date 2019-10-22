package test.code;
import java.io.File;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.util.StringHelper;


public class ExtCodeGen {
	
	public static void main(String[] args) throws Exception {
		String tableName = "bigdata_car_data_total";
		if(args!=null && args.length>0 && args[0]!=null){
			tableName = args[0];
		}else{
			System.out.println("=====================请输入要生成表名==================");
			return ;
		}		
		//包名也输入
		String packageName = "";
		if(args.length>1 && args[1]!=null){
			packageName = args[1];
		}else{
			System.out.println("=====================请输入包名==================");
			return ;
		}
		
		
		String className =StringHelper.underlineToCamel(tableName);
		
		
		String configFile = "config/jdbc-config.xml";
		
		GeneratorProperties.PROPERTIES_FILE_NAMES[0] = configFile;
		GeneratorProperties.reload();
		GeneratorProperties.setProperty("tableName", tableName);
		GeneratorProperties.setProperty("basepackage", packageName);
		String classLowerCase = className.toLowerCase();
		GeneratorProperties.setProperty("classLowerCase", classLowerCase);
		
		GeneratorProperties.setProperty("urlprefix", "/admin/" + className);
		String path = ExtCodeGen.class.getProtectionDomain().getCodeSource().getLocation().getFile();
    	File jarFile = new File(path);
    	File parent = jarFile.getParentFile().getParentFile().getParentFile();//tdp-plant/tdp-sys-service/code-gen
    	String outRoot =  parent.getAbsolutePath();
    	GeneratorProperties.setProperty("outRoot",outRoot);
    	GeneratorProperties.setProperty("java_typemapping.java.sql.Timestamp","java.util.Date");
    	GeneratorProperties.setProperty("java_typemapping.java.sql.Date","java.util.Date");
    	GeneratorProperties.setProperty("java_typemapping.java.sql.Time","java.util.Date");
    	GeneratorProperties.setProperty("java_typemapping.java.lang.Byte","Integer");
    	GeneratorProperties.setProperty("java_typemapping.java.lang.Short","Integer");
    	GeneratorProperties.setProperty("java_typemapping.java.math.BigDecimal","java.math.BigDecimal");
    	GeneratorProperties.setProperty("java_typemapping.java.sql.Clob","String");
		GeneratorFacade g = new GeneratorFacade();
		g.generateByTable(tableName);	//通过数据库表生成文件,template为模板的根目录  表名+模板名称
		
	}
	
}


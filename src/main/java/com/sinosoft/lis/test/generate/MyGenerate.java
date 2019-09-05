package com.sinosoft.lis.test.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MyGenerate {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String basePath = "D:/entity";
        gc.setOutputDir(basePath+"/src/main/java");
        gc.setAuthor("cxq");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(GlobalConfig gc,String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                String t = fieldType.toLowerCase();
                if(t.contains("date")){
                    return DbColumnType.DATE;
                }else{
                    return (DbColumnType) super.processTypeConvert(gc,fieldType);
                }
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("sinosoft");
        dsc.setUrl("jdbc:mysql://192.168.44.129:3306/lis?useUnicode=true&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sinosoft.lis");//父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setModuleName("test");//父包模块名
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return basePath+"/src/main/java/com/sinosoft/lis/" + pc.getModuleName()
                        + "/mapper/xml/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.sinosoft.lis.test.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        //是否生成false:@Controller还是true:@RestController
        strategy.setRestControllerStyle(true);
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(false);
        // 公共父类
        strategy.setSuperControllerClass("com.sinosoft.lis.test.common.BaseController");
        // 写于父类中的公共字段
        String[] superCols = new String[]{"makeOperator","makeDate","makeTime","modifyOperator","modifyDate","modifyTime"};
        strategy.setSuperEntityColumns(superCols);
        String[] tables = new String[]{"user_login_log","user_info"};
        strategy.setInclude(tables);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }



    /**
     * 控制包生成的路径与是否覆盖生成
     * @param gc // 全局配置
     * @param pc 包配置
     * @param model model名
     * @param tabName 表名
     * @param isCover 是否覆盖生成代码
     * @return TemplateConfig
     */
    private static TemplateConfig getTemplateConfig(GlobalConfig gc,  PackageConfig pc, String model, String tabName, boolean isCover) {
        TemplateConfig tc = new TemplateConfig();
        String entity = BaseUtils.getName(tabName,"_");
        String path = model + "/src/main/java/" +replace( pc.getParent());
        if (!isCover) {
            if ("ssm-mapper".equals(model)) {
                String mapperPath =path + "/" + replace(pc.getMapper()) + "/" + gc.getMapperName().replace("%s",entity) + ".java";
                if (isExists(mapperPath)) {
                    tc.setMapper(null);
                    log.info(gc.getMapperName().replace("%s",entity) + ".java 文件已存在");
                }
                String mapperXmlPath =path + "/" + replace(pc.getXml()) + "/" + gc.getXmlName().replace("%s",entity) + ".xml";
                if (isExists(mapperXmlPath)) {
                    tc.setXml(null);
                    log.info(gc.getXmlName().replace("%s",entity) + ".xml 文件已存在");
                }
                tc.setController(null);
                tc.setEntity(null);
                tc.setService(null);
                tc.setServiceImpl(null);
            } else if ("ssm-model".equals(model)) {
                String modelPath = path + "/" + replace(pc.getEntity()) + "/" + entity + ".java";
                if (isExists(modelPath)) {
                    tc.setEntity(null);
                    log.info(entity + ".java 文件已存在");
                }
                tc.setController(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setMapper(null);
                tc.setXml(null);
            }  else if ("ssm-service".equals(model)) {
                String servicePath = path + "/" +replace(pc.getService()) + "/" +  gc.getServiceName().replace("%s",entity) + ".java";
                if (isExists(servicePath)) {
                    tc.setService(null);
                    log.info(gc.getServiceName().replace("%s",entity) + ".java 文件已存在");
                }
                String serviceImplPath = path + "/" +replace(pc.getServiceImpl()) + "/" +  gc.getServiceImplName().replace("%s",entity) + ".java";
                if (isExists(serviceImplPath)) {
                    tc.setServiceImpl(null);
                    log.info(gc.getServiceImplName().replace("%s",entity) + ".java 文件已存在");
                }
                tc.setController(null);
                tc.setMapper(null);
                tc.setXml(null);
                tc.setEntity(null);
            } else if ("ssm-web".equals(model)) {
                String controllerPath = path + "/" +replace(pc.getController()) + "/" + gc.getControllerName().replace("%s",entity) + ".java";;
                if (isExists(controllerPath)) {
                    tc.setController(null);
                    log.info(gc.getControllerName().replace("%s",entity) + ".java 文件已存在");
                }
                tc.setMapper(null);
                tc.setXml(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setEntity(null);
            }
        } else {
            if ("ssm-mapper".equals(model)) {
                tc.setController(null);
                tc.setEntity(null);
                tc.setService(null);
                tc.setServiceImpl(null);
            } else if ("ssm-model".equals(model)) {
                tc.setController(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setMapper(null);
                tc.setXml(null);
            }  else if ("ssm-service".equals(model)) {
                tc.setController(null);
                tc.setMapper(null);
                tc.setXml(null);
                tc.setEntity(null);
            } else if ("ssm-web".equals(model)) {
                tc.setMapper(null);
                tc.setXml(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setEntity(null);
            }
        }
        return tc;
    }

    /**
     * 判断文件是否存在
     * @param path 路径
     * @return
     */
    private static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 将点替换为斜杠
     * @param name
     * @return
     */
    private static String replace(String name) {
        return name.replace(".","/");
    }

}
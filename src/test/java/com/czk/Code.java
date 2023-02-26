package com.czk;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Code {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///testone";
        String username = "root";
        String password = "12345678";
        String moduleName = "sys";
        String mapperLocation = "C:\\Users\\33291\\Desktop\\java\\business2\\src\\main\\resources\\mapper\\" + moduleName;
        String tables = "shopping,user,product,bigpicture";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\33291\\Desktop\\java\\business2\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.czk") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                           ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

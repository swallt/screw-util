package pers.zhousx.screwutil.init;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import pers.zhousx.screwutil.config.ConfigProp;

import javax.sql.DataSource;


@Component
public class InitRunner implements ApplicationRunner, Ordered {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ConfigProp configProp;

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        documentGeneration();
        //执行完自动关闭
        configurableApplicationContext.close();
    }

    private void documentGeneration() {
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir(configProp.getFileDir())
                //是否打开目录
                .openOutputDir(true)
                //文件类型
                .fileType(getTypeByName(configProp.getFileType()))
                //生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //文件名称
                .fileName(configProp.getFilename())
                .build();

        ProcessConfig processConfig = ProcessConfig.builder()
                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
                //根据名称指定表生成
                .designatedTableName(configProp.getDesignatedTableNameList())
                //根据表前缀生成
                .designatedTablePrefix(configProp.getDesignatedPrefixList())
                //根据表后缀生成
                .designatedTableSuffix(configProp.getDesignatedSuffixList())
                .ignoreTableName(configProp.getIgnoreTableNameList())
                .ignoreTablePrefix(configProp.getIgnorePrefixList())
                .ignoreTableSuffix(configProp.getIgnoreSuffixList())
                .build();

        Configuration configuration = Configuration.builder()
                .version(configProp.getVersion())
                .description(configProp.getDescription())
                .dataSource(dataSource)
                .engineConfig(engineConfig)
                .produceConfig(processConfig)
                .build();

        new DocumentationExecute(configuration).execute();
    }

    private EngineFileType getTypeByName(String name) {
        switch (name) {
            case "html" :
                return EngineFileType.HTML;
            case "word" :
                return EngineFileType.WORD;
            default:
                return EngineFileType.MD;
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

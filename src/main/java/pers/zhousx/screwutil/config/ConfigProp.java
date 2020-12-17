package pers.zhousx.screwutil.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
//@ConfigurationProperties(prefix = "config")
@PropertySource(value = "config.properties",encoding = "UTF-8")
public class ConfigProp {

    @Value("${config.filedir}")
    private String fileDir;
    @Value("${config.fileType:'md'}")
    private String fileType;
    @Value("${config.filename:'数据库文档'}")
    private String filename;
    @Value("${config.ignoreTableNames}")
    private String ignoreTableNames;
    private List<String> ignoreTableNameList;
    @Value("${config.ignorePrefixs}")
    private String ignorePrefixs;
    private List<String> ignorePrefixList;
    @Value("${config.ignoreSuffixs}")
    private String ignoreSuffixs;
    private List<String> ignoreSuffixList;
    @Value("${config.designatedTableNames}")
    private String designatedTableNames;
    private List<String> designatedTableNameList;
    @Value("${config.designatedPrefixs}")
    private String designatedPrefixs;
    private List<String> designatedPrefixList;
    @Value("${config.designatedSuffixs}")
    private String designatedSuffixs;
    private List<String> designatedSuffixList;
    @Value("${config.version:'1.0.0'}")
    private String version;
    @Value("${config.description:'数据库设计文档'}")
    private String description;

    @PostConstruct
    private void dealDefault() {
        if (StringUtils.hasText(ignoreTableNames)) {
            ignoreTableNameList = Arrays.asList(ignoreTableNames.split(","));
        }
        if (StringUtils.hasText(ignorePrefixs)) {
            ignorePrefixList = Arrays.asList(ignorePrefixs.split(","));
        }
        if (StringUtils.hasText(ignoreSuffixs)) {
            ignoreSuffixList = Arrays.asList(ignoreSuffixs.split(","));
        }
        if (StringUtils.hasText(designatedTableNames)) {
            designatedTableNameList =  Arrays.asList(designatedTableNames.split(","));
        }
        if (StringUtils.hasText(designatedPrefixs)) {
            designatedPrefixList =  Arrays.asList(designatedPrefixs.split(","));
        }
        if (StringUtils.hasText(designatedSuffixs)) {
            designatedSuffixList =  Arrays.asList(designatedSuffixs.split(","));
        }
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIgnoreTableNames() {
        return ignoreTableNames;
    }

    public void setIgnoreTableNames(String ignoreTableNames) {
        this.ignoreTableNames = ignoreTableNames;
    }

    public List<String> getIgnoreTableNameList() {
        return ignoreTableNameList;
    }

    public void setIgnoreTableNameList(List<String> ignoreTableNameList) {
        this.ignoreTableNameList = ignoreTableNameList;
    }

    public String getIgnorePrefixs() {
        return ignorePrefixs;
    }

    public void setIgnorePrefixs(String ignorePrefixs) {
        this.ignorePrefixs = ignorePrefixs;
    }

    public List<String> getIgnorePrefixList() {
        return ignorePrefixList;
    }

    public void setIgnorePrefixList(List<String> ignorePrefixList) {
        this.ignorePrefixList = ignorePrefixList;
    }

    public String getIgnoreSuffixs() {
        return ignoreSuffixs;
    }

    public void setIgnoreSuffixs(String ignoreSuffixs) {
        this.ignoreSuffixs = ignoreSuffixs;
    }

    public List<String> getIgnoreSuffixList() {
        return ignoreSuffixList;
    }

    public void setIgnoreSuffixList(List<String> ignoreSuffixList) {
        this.ignoreSuffixList = ignoreSuffixList;
    }

    public String getDesignatedTableNames() {
        return designatedTableNames;
    }

    public void setDesignatedTableNames(String designatedTableNames) {
        this.designatedTableNames = designatedTableNames;
    }

    public List<String> getDesignatedTableNameList() {
        return designatedTableNameList;
    }

    public void setDesignatedTableNameList(List<String> designatedTableNameList) {
        this.designatedTableNameList = designatedTableNameList;
    }

    public String getDesignatedPrefixs() {
        return designatedPrefixs;
    }

    public void setDesignatedPrefixs(String designatedPrefixs) {
        this.designatedPrefixs = designatedPrefixs;
    }

    public List<String> getDesignatedPrefixList() {
        return designatedPrefixList;
    }

    public void setDesignatedPrefixList(List<String> designatedPrefixList) {
        this.designatedPrefixList = designatedPrefixList;
    }

    public String getDesignatedSuffixs() {
        return designatedSuffixs;
    }

    public void setDesignatedSuffixs(String designatedSuffixs) {
        this.designatedSuffixs = designatedSuffixs;
    }

    public List<String> getDesignatedSuffixList() {
        return designatedSuffixList;
    }

    public void setDesignatedSuffixList(List<String> designatedSuffixList) {
        this.designatedSuffixList = designatedSuffixList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

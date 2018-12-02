package example.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader    读取当前类的信息
     * @param metadataReaderFactory     获取其他类的信息
     * @return
     * @throws IOException
     */

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //  获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //  获取正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //  获取当前类资源（路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("--->"+className);
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}

package example.Condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    //1>.返回值，就是导入到容器中的组件全类名
    //2>.AnnotationMetadata当前import注解的所有注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{
                "example.bean.Blue",
                "example.bean.Yellow"
        };
    }
}

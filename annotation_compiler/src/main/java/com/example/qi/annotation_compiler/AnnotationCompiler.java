//package com.example.qi.annotation_compiler;
//
//import com.example.qi.annotation.BinderView;
//import com.google.auto.service.AutoService;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.Filer;
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.Processor;
//import javax.annotation.processing.RoundEnvironment;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.TypeElement;
//import javax.lang.model.element.VariableElement;
//import javax.lang.model.type.TypeMirror;
//import javax.tools.JavaFileObject;
//
///*
// *注解处理器
// * 可以在java文件编译成class文件之前去做想要的操作
// * */
//@AutoService(Processor.class) // 注册注解处理器
//public class AnnotationCompiler extends AbstractProcessor {
//    // 1、定义一个用于生成文件的对象
//    Filer filer;
//
//    /*
//     *  filer 初始化
//     * */
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnvironment) {
//        super.init(processingEnvironment);
//        filer = processingEnvironment.getFiler();
//    }
//
//    // 2、需要确定处理所有模块中哪些注解
//    @Override
//    public Set<String> getSupportedAnnotationTypes() { // 填入所有注解的名字即可
//        HashSet<String> set = new HashSet<>();
//        set.add(BinderView.class.getName());
////        set.add(Override.class.getName()); // 若想处理此注解，也可以添加进去
//        return set;
//    }
//
//    // 3、支持JDK的版本
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return SourceVersion.latestSupported();
//    }
//
//    /*
//     *  实现 IBinder的实现类
//     * */
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//        /*
//         *  类元素 TypeElement
//         *  可执行元素  ExecutableElement
//         *  变量元素 VariableElement
//         *
//         *  以上全都继承 Element
//         * */
//
//        // 得到所有模块中 添加了 bindview 注解的元素的集合
//        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(BinderView.class);
//        // 定义一个map来分类所有元素
//        HashMap<String, List<VariableElement>> hashMap = new HashMap<>();
//        // 分类存入map中
//        for (Element element : elementsAnnotatedWith) {
//            VariableElement variableElement = (VariableElement) element;
//            // 通过element得到包裹他的上一层对象，（如果这个元素是activity中的变量，那得到的就是activity）
//            String className = variableElement.getEnclosingElement().getSimpleName().toString();
//            List<VariableElement> elementList = hashMap.get(className);
//            if (elementList == null) { // 说明是第一次得到这个activity的 被注解的元素的集合
//                elementList = new ArrayList<>();
//                hashMap.put(className, elementList);
//            }
//            elementList.add(variableElement);
//        }
//
//        // 开始生成 ibinder实现类
//        if (hashMap.size() > 0) {
//            // 开始写入文件
//            Writer writer = null;
//            // 每个activity都要生成一个对应的文件
//            Iterator<String> iterator = hashMap.keySet().iterator();
//            while (iterator.hasNext()) { // 有activity时
//                String activityName = iterator.next();
//                List<VariableElement> variableElements = hashMap.get(activityName);
//
//                // 获取包名
//                Element enclosingElement = variableElements.get(0).getEnclosingElement();
//                String packageName = processingEnv.getElementUtils().getPackageOf(enclosingElement).toString();
//
//                // 生成文件
//                try {
//                    // 执行完此行，就能生成 包名+activity_ViewBinding 文件
//                    JavaFileObject sourceFile = filer.createSourceFile(packageName + "." + activityName + "_ViewBinding");
//                    writer = sourceFile.openWriter();
//
//                    //        package com.example.dn_butterknife;
//                    writer.write("package " + packageName + ";\n");
//                    //        import com.example.dn_butterknife.IBinder;
//                    writer.write("import " + packageName + ".IBinder;\n");
//                    //        public class MainActivity_ViewBinding implements IBinder<com.example.dn_butterknife.MainActivity>{
//                    writer.write("public class " + activityName + "_ViewBinding implements IBinder<"
//                            + packageName + "." + activityName + ">{\n");
//                    //            @Override
//                    writer.write("@Override\n");
//                    //            public void bind(com.example.dn_butterknife.MainActivity target) {
//                    writer.write("public void bind(" + packageName + "." + activityName + " target){\n");
//                    // target.tvText=(android.widget.TextView)target.findViewById(2131165325);
//                    for (VariableElement variableElement : variableElements) {
//                        //获取控件的名字
//                        String variableName = variableElement.getSimpleName().toString();
//                        //获取ID
//                        int id = variableElement.getAnnotation(BinderView.class).value();
//                        //获取控件的类型
//                        TypeMirror typeMirror = variableElement.asType();
//                        writer.write("target." + variableName + "=(" + typeMirror + ")target.findViewById(" + id + ");\n");
//
//                    }
//                    writer.write("\n}}");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    if (writer != null){
//                        try {
//                            writer.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//
//            }
//
//        }
//        return true;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

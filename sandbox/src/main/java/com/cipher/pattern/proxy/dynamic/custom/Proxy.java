package com.cipher.pattern.proxy.dynamic.custom;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 自定义代理类
 * Created by cipher on 2017/9/6.
 */
public class Proxy {

    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String handlerPackage = InvocationHandler.class.getPackage().getName();
        String packageName = infce.getPackage().getName();
        String methodStr = "";
        for (Method m : infce.getMethods()) {
            methodStr += "public void " + m.getName() + "() {\n" +
                    "try{\n" +
                    "Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");\n" +
                    "h.invoke(this,md);\n" +
                    "} catch(Throwable t){t.printStackTrace();}\n" +
                    "}\n";
        }
        String str = "package " + packageName + ";\n" +
                "import java.lang.reflect.Method;\n" +
                "import " + handlerPackage + ".InvocationHandler;\n" +
                "public class $Proxy0 implements " + infce.getName() + " {\n" +
                "   private InvocationHandler h;\n" +
                "   public $Proxy0(InvocationHandler h) {\n" +
                "       this.h = h;\n" +
                "   }\n" +
                methodStr + "\n" +
                "}\n";
        // 产生代理类的 java 文件
        String packagePath = packageName.replaceAll("\\.", "\\" + File.separator);
        String filename = System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes" + File.separator + packagePath + File.separator + "$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str, "utf-8");
        // 编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 文件管理者
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        // 获取文件
        Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(filename);
        // 编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, javaFileObjects);
        // 进行编译
        task.call();
        manager.close();
        // load 到内存中
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class c = loader.loadClass(packageName + ".$Proxy0");
        // 根据构造器创建对象
        Constructor constructor = c.getConstructor(InvocationHandler.class);
        return constructor.newInstance(h);
    }

}

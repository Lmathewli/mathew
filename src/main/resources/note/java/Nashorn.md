 ` 为何要用java实现javascript
    1. 成熟的GC
    2. 成熟的JIT编译器
    3. 多线程支持
    4. 丰富的标准库和第三方库
   总得来说，充分利用了java平台的已有资源。



 `  当我们把传递对象hash到方法中，在Java端就能访问这些属性：MyJavaClass.fun3({foo: 'bar', bar: 'foo'}); //--> Object:[foo, bar]
    ScriptObjectMirror 是一个Java对象表示javaScript对象 scriptObjectMirror.callMember('xxx'): 调用成员方法

 ` 类型数组： 原始javascript数组是无类型的， 但是Nashorn可以用： 
    ``` var IntArray = Java.type("int[]");
        var array = new IntArray(5);
        array[0] = 5;
        array[1] = 'hehe'; // --> 转化为 array[1] = 0; 字符串会自动转换为int

        try {
            array[5] = 0;
        } catch (e) {
            pritn(e.message); //-->Array index out of range: 5
        }
 
 ` 遍历集合元素 ：ECMAScript 5.1 中缺少 Java 8 Lambda 表达式中的紧缩箭头的语法，但我们可以在接受 Lambda 表达式的地方使用函数来替代。
    ``` var list2 = new java.util.ArrayList();
        list2.add("ddd2");
        list2.add("aaa2");
        list2.add("bbb1");
        list2.add("aaa1");
        list2.add("bbb3");
        list2.add("ccc");
        list2.add("bbb2");
        list2.add("ddd1");

        list2
            .stream()
            .filter(function(el) {
                return el.startsWith("aaa");
            })
            .sorted()
            .forEach(function(el) {
                print(el);
            });
            // aaa1, aaa2
 

 ` 扩展类: Java 的类型可以简单的通过 Java.extend  进行扩展
    ``` var Runnable = Java.type('java.lang.Runnable');
        var Printer = Java.extend(Runnable, {
            run: function() {
                print('printed from a separate thread');
            }
        });

        var Thread = Java.type('java.lang.Thread');
        new Thread(new Printer()).start();

        new Thread(function() {
            print('printed from another thread');
        }).start();

        // printed from a separate thread
        // printed from another thread


 ` 参数重载: 方法和函数可以使用点符号或方括号来进行调用。   



 ` Java Beans：我们不需要常规的用 getter 或者 setter 来访问类成员属性，可直接用属性名简单访问 Java Bean 中的属性。
    ``` var Date = Java.type('java.util.Date');
        var date = new Date();
        date.year += 1900;
        print(date.year);



 ` 属性绑定: 来自不同对象的属性绑定在一起
    ``` var o1 = {};   
        var 02 = {foo : 'bar'};   
        Object.bindProperties(o1, o2);   
        print(o1.foo); //--> bar   
        o1.foo = 'BAM';   
        print(o2.foo); //--> BAM   



 ` Import的范围
    ``` var imports = new JavaImporter(java.io, java.lang);
        with(imports) {
            var file = new File(_FILE);

        }



 ` 数组转换
    有些包可以直接使用而不必利用Java.type或者JavaImporter引入, 如 java.util:
    ``` var list = new java.util.Array();
        list.add("s1");
        list.add("s2");

    将java list转换为javaScript的数组：
    1. ``` var jsArray = Java.from(list);
       print(jsArray); //--> s1,s2
       print(Object.prototype.toString.call(jsArray)); //--> [object Array]
    2. ``` var javaArray = Java.to([3, 5,7,11], "int[]");

    ` 调用父类函数
    ``` class SuperRunner implements Runnable { //--> java
            @Override
            public void run() {
                System.out.print("super run");
            }
        }

        var SuperRunner = Java.type("xxx.SuperRunner");
        var Runner = Java.extend(SuperRunner);
        var runner = new Runner() {
            run: function() {
                Java.super(runner).run();
                print("on my run");
            }
        }


` 加载其他的脚本直接使用: 记住脚本的加载可能会因为变量名的重叠导致代码出问题。
    load('http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js');
    我们可以通过将加载的脚本文件放置到一个新的全局上下文来解决这个问题：
    loadWithNewGlobal('script.js')


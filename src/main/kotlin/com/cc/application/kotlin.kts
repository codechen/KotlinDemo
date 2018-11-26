import java.io.File

// KotlinScript: 运行时首先编译成一个kotlin类，然后通过kotlinc进行类加载，脚本代码会编译到类的构造方法中，所以在进行类加载时会执行对应的脚本代码

println("Hello")

File("hello2.txt").readText().let(::println)
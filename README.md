# 基于 Android Gradle 3.0+ 的组件化方案（单入口）

### 背景
Android 项目组件化的好处有很多，特别是对于一个大型的项目，组件化后的项目能够加速编译、快速测试，也便于维护。目前已有现成的组件化方案，如：
1. [https://github.com/luckybilly/CC](https://github.com/luckybilly/CC)
2. [https://juejin.im/post/5b255f6ce51d45588f2d1f89](https://juejin.im/post/5b255f6ce51d45588f2d1f89)

方案1是把一个 module 在 library 和 application 直接进行切换，容易导致如Manifest冲突、R文件冲突等混乱问题；而且会有多余的插件掺杂在里面，会加长编译时间的同时插件特殊的语法也导致了学习成本的增加。

方案2会生成多个壳，使得项目结构层级加深，同时也会产生过多的 module，使得寻找麻烦，同时也增加了 gradle config 的时间。

基于此，同时结合 Android Gradle 3.0+ 的新特性，这里提出了`单入口`的组件化方案，该方案层级扁平、module 少、配置灵活；同时基于官方 Gradle 插件，兼容性好；并且无任何 AOP 对 class 进行处理，能有效减少编译时间。

### 原理

#### 1. 项目拆分：

主要分为功能拆分也业务拆分。业务拆分以界面为主，相关界面分到一起，以 `app-xxx `为 module；功能拆分以 `lib-xxx` 为 module；`main-entry` 为入口 module，不包含任何多余代码，只负责启动时的跳转，以及对子 module 依赖的配置。

#### 2. 关键代码：

    android {
        ...
        
        flavorDimensions("app")
        productFlavors {
            home {
             dimension "app"
            }
            play {
             dimension "app"
            }
            real {
             dimension "app"
            }
            settings {
             dimension "app"
            }
        }
    }
     
     configurations {
        homeImplementation{}
        playImplementation{}
        realImplementation{}
        settingsImplementation{}
    }
     
     dependencies {
        ...
     
        implementation project(':app-base')
        realImplementation project(':app-home')
        realImplementation project(':app-play')
        realImplementation project(':app-settings')
        
        homeImplementation project(':app-home')
        playImplementation project(':app-play')
        settingsImplementation project(':app-settings')
    }

这样，就能利用 Android Gradle 3.0+ 的特性，使得在编译某个 app-module 时，不会有其它的 app-xxx 参与进来，如：`./gradlew assemblePlayDebug`

#### 3. 其它问题：
- 不同 module 之间的 activity 如何跳转？  
  实现 PipeLine 接口。
- 各 module 如何得到 Application 级别的初始化代码的地方？  
  继承 Application，并添加到 AndroidManifest.xml 中。


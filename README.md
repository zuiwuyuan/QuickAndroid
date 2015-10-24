# QuickAndroid
Android快速开发框架

项目介绍：

    QuickAndroid是一个免费的开源的、简易的Android开发框架，其开发宗旨是简单、快速的进行Android应用程序的开发。
    
    它对AsyncHttpClientt框架进行了二次封装，可以快速的进行网络请求回调处理。而且，项目还集成了Fastjson，当网络数据时通过json格式传输时，可以更加快速高效的进行数据的解析操作。
    项目还二次封装了了universal-image-loader框架，用于处理图片的下载缓存，有效的防治oom的发生。
    
    在数据的缓存处理上，同时提供了数据库相关和本地文件缓存相关的方法，可以根据需求，选择到底使用哪一种方式存取数据。
    
    当然，项目还集成了ButterKnife，它是一个专注于Android系统的View注入框架，让你从此从这些烦人臃肿的代码中解脱出来。再也不用些写findViewById，或者是是setOnClickListener这样的代码啦。
    
    除此之外，ViewPagerHelper工具类可以帮助更简单的实现View组件的滑动，android-log可以帮助进行日志打印查看等。。。


1. HTTP框架: AsyncHttpClient

    对AsyncHttpClient进行了二次封装，即HttpUtil.java类，在网络请求时，可直接通过该类发送get/post请求。

2. JSON解析: FastJson解析

    FastJson是效率最快的Json解析库，项目封装了FastJson工具类FastJsonUtil.java，可通过其直接进行json的解析。

3. 图片加载缓存框架:universal-image-loader

    众所周知的图片加载缓存框架，效率高，效果好，使用简单，项目封装了imageLoader工具类ImageLoaderUtil.java，可以直接使用其进行图片缓存。

4. 数据库框架: ORMLite（保存数据量大，不常更新的数据，比如题库、车站名，地名等等）

    对ORMLite数据库框架进行了二次封装，可以更加方便的进行数据库相关的操作，其中db.DatabaseHelper.java是数据库帮助类,db.dao.XxxDao.java是数据库操作实现类（Model）。

5. 数据本地缓存: Reservoir（保存数据量小，可能会及时更新、删除的数据，比如用户信息、true/false等）

    Reservoir是一个简单的Android函数库，可以在磁盘上使用“键/值”对轻松地序列化并持久化对象。说白了，使用Reservoir，你可以把java对象进行序列化，并把它存储到磁盘上。当然，当你想从磁盘上查找到你保存的数据时，同样需要时用Reservoir。

6. ButterKnife:

    ButterKnife是一个专注于Android系统的View注入框架，让你从此从这些烦人臃肿的代码中解脱出来。

7. ViewPager工具类

   对ViewPager进行了封装，通过它，可以更加方便的进行ViewPager的使用:
    构造方法： public ViewPagerHelper(boolean isAuto, ViewPager viewPager, List<View> views, LinearLayout indicatorParents,
                              int selectDrawableRes, int unselectDrawableRes)
    参数：
        boolean isAuto :    是否自动环播放ViewPager的内容
        ViewPager viewPager:    页面中的ViewPager组件
        List<View> views:   要循环滚动的组件集合
        LinearLayout indicatorParents:  一般显示ViewPager底部的圆点的容器组件
        int selectDrawableRes: 圆点被选中时图标的id
        int unselectDrawableRes: 圆点未选中时图标的id
    示例：
        new ViewPagerHelper(false, mViewPager, views, viewPoints, R.mipmap.page_indicator_unfocused,R.mipmap.page_indicator_focused);

8. Log日志管理:

    android-log 是一个基于android.util.Log 类的扩展日志库，主要是添加一些功能方便调试。

    主要支持特性如下：

    1、全局启用/关闭日志

    2、设置全局标签和局部标签

    3、支持将日志写入本地文件

    4、支持Maven，Gradle等
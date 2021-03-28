# music-application
##慕课网学习
### https://www.imooc.com/learn/1104

1. 样式文件：res/values/styles.xml
2. 颜色文件：res/values/colors.xml
3. 主题文件：res/values/themes.xml
4. 布局文件：res/layout/
5. 尺寸文件：res/values/dimens.xml
6. 自定义属性：res/values/attrs.xml
7. 字符串：res/values/strings.xml


### 自定义布局控件
1. 继承布局控件
2. 自定义布局配置文件
3. 重写构造方法，使用自定义属性进行初始化
4. 通过LayoutInflater.from(context).inflate(R.layout.input_view, this, false)获取自定义view资源文件
5. 将自定义attributes与控件属性绑定
6. 使用addView() 添加自定义view

### drawable文件，res/drawable/
1. 使用selector可以设置不同状态下的样式
2. 使用shape自定义形状

### 动画文件animation res/anim/
1. open enter
2. open exit
3. close enter
4. close exit

### 任务和返回栈 task栈
任务是指执行特定作业时与用户交互的一系列activity，这些activity按照打开的顺序排列在堆栈（返回栈）中
1. Intent.FLAG_ACTIVITY_CLEAR_TASK：清除当前task栈的activity
2. Intent.FLAG_ACTIVITY_NEW_TASK：创建一个新的Task栈
3. 会造成过渡动画问题，使用((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);重写动画效果
4. 必须在startActivity调用之后使用

### android 9.0以上播放失败
原因：API级别28或更高级别手机，在http请求时（非Https请求）会有错误提示，并且请求不到数据。
android:usesCleartextTraffic="true"


## 原生 JS + Servlet 博客管理项目

![MyBlog（博客管理系统）](https://yupeng-tuchuang.oss-cn-shenzhen.aliyuncs.com/MyBlog%EF%BC%88%E5%8D%9A%E5%AE%A2%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F%EF%BC%89.png)

### 一、路径配置
#### 1.上传图片是在本地保存，

图片保存路径：默认路径：`D:\study\software\eclipse\workspace\MyBlog\WebContent\picture`

需要到`LoginServlet和UploadServlet`中配置

记住是项目的路径，而不是工作路径，工作路径上服务器重新启动会干掉图片

#### 2.配置resposity仓库暂时存放缓存
本地创建文件夹（`uploadtemp`）
默认路径：`D:\study\software\eclipse\workspace\MyBlog\uploadtemp`
需要到`UploadServlet`中配置

配置图片效果加载路径：`changeLikeColor`中:

```js
var ImgURL = "`http://v4wgp6.natappfree.cc/MyBlog/img/8.png`";//根据域名来改，本地的话不用
var ImgURL2 = "`http://localhost:8888/MyBlog/img/8.png`";
```

需要到`friendblog.jsp`和`myblog.jsp`中配置

以及`getJSON`配置`url`:"`/MyBlog/Servlet/QueryAllRemarksByBlogidServlet`"

### 二、修订：

1、2点配置转移至util包下`RouteUtil`中配置的属性“`FILE_SPACE`”,图片路径是该路径加上相对路径	

var `ImgURL2`已删除不用，`ImgURL`现已改为 `img/8.png`

对本地服务或者远程服务部署都适用，为了协调不同操作系统部署的文件路径问题，默认部署在用户主目录下，在windows操作系统默认为`C:\Users\Administrator\webapps\`，
部署服务时，应更改tomcat两个虚拟路径，`myblog_data`和`MyBlog`，分别对应绝对路径`${user.home}/myblog_data`和`${user.home}/MyBlog`

为了加快图片加载，推荐在webapps目录下新建文件夹`uploadtemp`

注意：项目名不要随意改动，可以更改虚拟访问项目名，即`conf/server.xml`中`host`节点下的`path`属性值
<html>
    <head>
        <meta charset="UTF-8">
        <title>油画列表</title>
        <link rel="stylesheet" href="../../../css/index.css">
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    </head>

    <body>
        <header>
            <div class="container">
                    <nav>
                            <a href="#" >分类一</a>
                    </nav>
                    <nav>
                        <a href="#" >分类</a>
                    </nav>
                    <nav>
                        <a href="#">登录</a>
                        <a href="#" onclick="alert('功能暂未开放');">注册</a>
                    </nav>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>油画</h1>
                    <p>油画列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>分类</th>
                        <th>价格</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                        <th>描述</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody>
                            <tr>
                                <td>无名女郎</td>
                                <td>分类一</td>
                                <td>￥<fmt:formatNumber type="currency" pattern="#,#00.00#" value="5800"/></td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="20171207"/></td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="20171207"/></td>
                                <td>描述一</td>
                                <td><a href="#">编辑</a></td>
                                <td><a href="#">删除</a>
                            </tr>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="#"><button>新建</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>
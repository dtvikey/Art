<html>
<head>
    <meta charset="UTF-8">
    <title>编辑</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                慕课网油画管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, admin!</h1>
        <p>请小心的编辑油画记录</p>
    </div>
    <div class="page-header">
        <h3><small>编辑</small></h3>
    </div>
    <form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="name" class="form-control" id="name" value="无名女郎">
                <input type="hidden" name="id" class="form-control" id="id" value="001">
            </div>
        </div>
        <div class="form-group">
            <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
            <select id="categoryId" name="categoryId" class="col-sm-2 form-control" style="width: auto">
                    <option id="${item.id}" value="${item.id}">$分类一</option>
            </select>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">价格 ：</label>
            <div class="col-sm-8">
                <input name="price" type="number" class="form-control" id="price" value="5800">
            </div>
        </div>
        <div class="form-group">
            <label for="smallImg" class="col-sm-2 control-label">图片 ：</label>
            <div class="col-sm-8">
                <input id="smallImg" name="smallImg" class="file-loading"
                       type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"
                       data-show-preview="true" value="">
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">描述 ：</label>
            <div class="col-sm-8">
                <input name="description" type="text" class="form-control" id="description" value="#">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>

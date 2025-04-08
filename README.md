# 中文
向`KubeJS`的`JsonIO`里面添加了<br>
- `writeAndCreateDirectories` - 在写json文件的时候创建其所属的文件夹
- `findJsonInDirectory` - 可以查询一个目录下面的所有json文件的路径
<br>

添加了`JSIO`<br>
- `getAllowSuffix` - 查询允许操作的文件后缀名
- `read` - 读取一个文件返回`List<String>`
- `exists` - 检测一个文件是否存在
- `write` - 写入一个文件,并创建其所属的文件夹
- `delete` - 删除文件
- `findJSInDirectory` - 可以查询一个目录下面的所有js文件的路径

# English
Added the following to `KubeJS`'s `JsonIO`:<br>

- `writeAndCreateDirectories` - Creates parent directories when writing a JSON file<br>
- `findJsonInDirectory` - Can be used to find paths of all JSON files in a directory<br>

Added JSIO:<br>

- `getAllowSuffix` - Check allowed file suffixes for operations<br>
- `read` - Read a file and return a `List<String>`<br>
- `exists` - Check if a file exists<br>
- `write` - Write to a file and create parent directories<br>
- `delete` - Delete a file<br>
- `findJSInDirectory` - Can be used to find paths of all JS files in a directory
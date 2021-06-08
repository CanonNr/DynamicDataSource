# 最终效果
在配置了两个数据源和AOP后,会根据aop的配置分别读取两个不同的数据源


# 请求一
`http://127.0.0.1:10001/2` 
```json
[
    {
        "id": 1,
        "name": "小米手机",
        "num": 22,
        "status": "1",
        "pid": 1
    }
]
```
# 请求二
`http://127.0.0.1:10001/1`
```json
[
    {
        "id": 1,
        "name": "大米手机",
        "num": 22,
        "status": "1",
        "pid": 1
    }
]
```

> 可以看到一个是大米手机一个是小米手机
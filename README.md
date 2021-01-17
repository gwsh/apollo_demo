## apollo demo


## VM opention 添加如下

``` shell 
    -Denv=DEV -Dapollo.configService=http://120.27.241.99:8080
```

## 多环境切换

Program argument 添加如下


```shell script
   dev环境：   --spring.profiles.active=dev
```
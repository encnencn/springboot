在使用@ApiModelProperty注解在字段上时，如果字段的类型为Long或是int类型，那么程序启动后，访问swagger-ui.html的页面，程序会报错

java.lang.NumberFormatException: For input string: ""

在swagger的官方文档中介绍是一个bug；可以忽略这个错误，如果看着不爽，可以调整日志的级别

# application.yml
logging:
  level:
    io.swagger.models.parameters.AbstractSerializableParameter: error




# application.properties
logging.level.io.swagger.models.parameters.AbstractSerializableParameter=error


it is ok.

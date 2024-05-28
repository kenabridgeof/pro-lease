Knife4j 注解说明
    @Schema 注解用于描述作为接口参数或者返回值的实体类的数据结构。
    @Tag 注解用于对接口进行分类，相同`Tag`的接口会放在同一个菜单。
    @Operation 用于对接口进行描述。
    @Parameter 用于对HTTP请求参数进行描述

MybatisPlus 常见方法
    ① eq 构建查询条件 用于设置单个字段的相等条件
          LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
          lambdaQueryWrapper.eq(User::getName, "老王");

          SELECT * FROM user WHERE name = '老王'

    ② gt 设置单个字段的大于条件

    ③ lt 设置单个字段的小于条件

    ④ between 设置单个字段的区间条件

    ⑤ like 设置单个字段的模糊查询条件
          lambdaQueryWrapper.like(User::getName, "王");

          SELECT * FROM user WHERE name LIKE '%王%'

    ⑥ isNull 设置单个字段的为NULL条件
          lambdaQueryWrapper.isNull(User::getName);

          SELECT * FROM user WHERE name IS NULL

    ⑦ in 设置单个字段的IN条件
          lambdaQueryWrapper.in(User::getAge, Arrays.asList(1, 2, 3));

          SELECT * FROM user WHERE age IN (1, 2, 3)

    ⑧ groupBy 设置GROUP BY条件
          lambdaQueryWrapper.groupBy(User::getId, User::getName);

          SELECT * FROM user GROUP BY id, name

    ⑨ orderBy 设置ORDER BY条件
            lambdaQueryWrapper.orderByAsc(User::getId, User::getName);

            SELECT * FROM user ORDER BY id ASC, name ASC

    ⑩ set 设置更新字段
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set(User::getName, "老王");

            UPDATE user SET name = '老王'
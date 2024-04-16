import org.apache.ibatis.annotations.Select;

public class LeetcodeSql {
    @Select("select product_id from Products where low_fats = 'Y' and recyclable = 'Y';")
    public void sql1757() {
        //单表多条件等值查询
    }

    @Select("select name from Customer where ifnull(referee_id,0) !=2;")
    public void sql584() {
        //单表不等值查询 注意null
    }

    @Select("select name, population, area from World where area >= 3000000 or population >= 25000000")
    public void sql595() {
        //单表范围查询
    }

    @Select("select distinct viewer_id as id from Views where author_id= viewer_id order by id;")
    public void sql1148() {
        //单表字段值之间的等值查询+排序+去重
        //distinct 和 group by 去重的区别
        //@Select("select viewer_id as id from Views where author_id= viewer_id group by id order by id ;")

    }

    @Select("select tweet_id from Tweets where length(content)>15;")
    public void sql1683() {
        //单表查询 字段长度
    }

    @Select("select unique_id, name from Employees as A left join  EmployeeUNI as B on A.id=B.id;")
    public void sql1378() {
        //左连接 (左表作为主体,右表中没有的自动填充null）

    }

    @Select("select P.product_name,S.year,S.price from Sales S left join Product P on S.product_id = P.product_id;")
    public void sql1068() {
        //左连接
    }
    @Select("select a.customer_id, count(a.customer_id)as count_no_trans from Visits a left join Transactions b on a.visit_id =b.visit_id where transaction_id is null group by a.customer_id ;")
    public void sql1581() {
        //左连接+group by +聚类函数
    }

}

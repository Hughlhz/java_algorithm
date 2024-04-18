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

    @Select("select a.id from Weather a  join Weather b on datediff(a.recordDate,b.recordDate)=1 and a.Temperature>b.Temperature;")
    public void sql197() {
        //考察自连接，和普通连接没有区别，连接时条件用datediff() and xxxx;
    }

    @Select("select a.machine_id as machine_id, round(avg(b.timestamp-a.timestamp),3) as processing_time from Activity a join Activity b on a.machine_id=b.machine_id and a.process_id= b.process_id and a.activity_type=\"start\" and b.activity_type=\"end\" group by a.machine_id;")
    public void sql1661() {
        //考察自连接和group by 、聚类函数以及round方法
    }

    @Select("select e.name,b.bonus from Employee e left join Bonus b on e.empId=b.empId where ifnull(b.bonus,0)<1000;")
    public void sql577() {
        //普通左连接
    }

    @Select("select A.student_id,A.student_name,A.subject_name,ifnull(B.attended_exams,0) attended_exams from (select * from Subjects, Students) A left join (select *,count(student_id) as attended_exams from Examinations group by student_id,subject_name) B on A.student_id=B.student_id and A.subject_name=B.subject_name order by A.student_id,A.subject_name;")
    public void sql1280() {
        //笛卡尔积和full join
    }
}
